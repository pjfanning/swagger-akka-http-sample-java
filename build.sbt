name := "swagger-akka-http-sample-java"

scalaVersion := "2.13.6"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.6.16"
val akkaHttpVersion = "10.2.6"

Compile / mainClass := Some("com.example.akka.Main")

libraryDependencies ++= Seq(
  "jakarta.xml.bind" % "jakarta.xml.bind-api" % "2.3.2",
  "org.glassfish.jaxb" % "jaxb-runtime" % "2.3.2",
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.5.0",
  "javax.ws.rs" % "javax.ws.rs-api" % "2.1.1",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "1.1.2",
  "org.slf4j" % "slf4j-simple" % "1.7.32"
)

