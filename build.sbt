name := "swagger-akka-http-sample-java"

scalaVersion := "2.12.5"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.11"
val akkaHttpVersion = "10.1.1"

libraryDependencies ++= Seq(
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.14.0",
  "io.swagger" % "swagger-jaxrs" % "1.5.18",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "0.3.0",
  "org.slf4j" % "slf4j-simple" % "1.7.25"
)
