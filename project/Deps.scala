
import sbt._

object Deps {

  val scalaVersion = "2.10.4"

  lazy val akkaDeps = {
    val akkaVersion = "2.2.3"
    Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
    )
  }

  lazy val typesafeDeps = Seq(
    "com.typesafe" % "config" % "1.2.1"
  )

}