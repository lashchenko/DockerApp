// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Typesafe snapshots
resolvers += "Typesafe Snapshots" at "https://repo.typesafe.com/typesafe/snapshots/"

// for sbt 0.13.x and scala 2.10.x
//addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.8.0")

// for autoplugins
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.0-M4")