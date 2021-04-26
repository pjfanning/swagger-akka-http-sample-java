name := "swagger-akka-http-sample-java"

scalaVersion := "2.13.5"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.6.14"
val akkaHttpVersion = "10.2.4"

libraryDependencies ++= Seq(
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "1.4.0",
  "io.swagger" % "swagger-jaxrs" % "1.6.2",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "1.1.1",
  "org.slf4j" % "slf4j-simple" % "1.7.25"
)
