name := "swagger-akka-http-sample-java"

scalaVersion := "2.13.8"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.6.19"
val akkaHttpVersion = "10.2.9"

Compile / mainClass := Some("com.example.akka.Main")

libraryDependencies ++= Seq(
  "jakarta.ws.rs" % "jakarta.ws.rs-api" % "3.0.0",
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.8.0",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "1.1.3",
  "org.slf4j" % "slf4j-simple" % "1.7.36"
)

