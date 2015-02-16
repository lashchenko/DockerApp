
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.docker.DockerPlugin
import sbt.Keys._
import sbt._

import com.typesafe.sbt.packager.Keys._
import com.typesafe.sbt.SbtNativePackager._


object Build extends Build {
  
  lazy val sbtSettings = Seq(
    version := "0.0.7-SNAPSHOT",
    compileOrder in Test := CompileOrder.Mixed,
    crossScalaVersions := Seq(Deps.scalaVersion),
    scalaVersion := Deps.scalaVersion,
    organization := "com.blogspot.lashchenko",

    javacOptions in Compile ++= Seq("-source", "1.7", "-target", "1.7"),

    //    for SBT 0.13.7
    //    updateOptions := updateOptions.value.withCachedResolution(cachedResoluton = true),

    resolvers ++= Seq(
      Resolver.sonatypeRepo("snapshots"),
      "central" at "http://repo1.maven.org/maven2",
      "burtsev" at "http://maven.burtsev.net/",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Oss repository" at "http://oss.sonatype.org/content/repositories/snapshots/"
    )
  )

  lazy val dockerSettings = Seq(
    dockerBaseImage := "dockerfile/java",
    dockerExposedPorts in Docker := Seq(9999)
//    stagingDirectory in Docker := new java.io.File("docker")
  )

  lazy val generalSettings = Seq() ++ sbtSettings ++ dockerSettings

  lazy val generalDeps = Seq(
    libraryDependencies ++=
      Deps.akkaDeps ++
      Deps.typesafeDeps
  )

  lazy val DockerApp = Project(id = "DockerApp", base = file("."))
    .settings(generalSettings: _*)
    .settings(generalDeps: _*)
    .enablePlugins(JavaAppPackaging)
    .enablePlugins(DockerPlugin)
}


