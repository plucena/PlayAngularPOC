import de.johoop.jacoco4sbt._
import JacocoPlugin._

name := """motomaker"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

jacoco.settings

parallelExecution in jacoco.Config := false

libraryDependencies ++= Seq(
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"), 
  "org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final",  
  javaJdbc,
  jdbc,
  javaEbean,
  cache,
  javaWs,
  anorm,
  ws
)
  
resolvers ++= Seq(
	"Kundera" at "https://oss.sonatype.org/content/repositories/releases",
	"Riptano" at "http://mvn.riptano.com/content/repositories/public",
	"Kundera missing" at "http://kundera.googlecode.com/svn/maven2/maven-missing-resources",
	"Scale 7" at "https://github.com/s7/mvnrepo/raw/master"
)

libraryDependencies ++= Seq(
  "org.webjars" 			%% 	"webjars-play" 				% "2.3.0",
  "org.webjars" 			%	"bootstrap" 				% "3.1.1-1",
  "org.webjars" 			% 	"bootswatch-united"			% "3.1.1",
  "org.webjars" 			% 	"html5shiv" 				% "3.7.0",
  "org.webjars" 			% 	"respond" 					% "1.4.2",
  "com.impetus.client" 		% 	"kundera-cassandra" 		% "2.5"
)
