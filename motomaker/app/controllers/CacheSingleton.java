package controllers;

import play.Play;
import play.api.cache.Cache;
import scala.Option;

public class CacheSingleton {
	
	private volatile static CacheSingleton cacheSingletonInstance;
	private static Option<Object> cache;
	
	private CacheSingleton(){}
	
	/**
	 * Thinking about multiple threads comes concurrently!
	 * Since the first thread has already created an instance no other 
	 * thread will enter this loop.All the remaining threads that were 
	 * not lucky to enter the synchronized block along with the first 
	 * thread will be blocked at the first null check. 
	 * This mechanism is called double checked locking and it provides 
	 * significant performance benefit and also it is cost effective solution.
	 * @return cacheSingletonInstance
	 */
	public static CacheSingleton getCacheSingletonInstance(){
		if(null == cacheSingletonInstance){
			synchronized (CacheSingleton.class) {
				if(null == cacheSingletonInstance){
					cacheSingletonInstance = new CacheSingleton();
				}
			}
		}
		return cacheSingletonInstance;
	}
	
	public Object getFromCache(String key){
		
		cache = Cache.get(key, Play.application().getWrappedApplication());
		
		if (cache.nonEmpty()) {
			System.out.println(">>>>>>got it from cache");
			return cache.get();
		}else{
			System.out.println(">>>>>>not in the cache");
			return null;
		}
	}
	
	public void putOnCache(String key, Object obj){
		System.out.println(">>>>>>put on cache");
		Cache.set(key, obj, 60 * 1, Play.application().getWrappedApplication());
				
	}

}
