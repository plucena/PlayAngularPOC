import de.johoop.jacoco4sbt._
import JacocoPlugin._

name := """motomaker"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

jacoco.settings

parallelExecution in jacoco.Config := false

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)