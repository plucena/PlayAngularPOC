angular.module('m4mApp.services', ['ngResource'])

  .factory('BookList', function($resource){
    return $resource('http://localhost:9000/Book/webresources/com.percivallucena.book.book', {})
  })
  .value('version', '0.1');