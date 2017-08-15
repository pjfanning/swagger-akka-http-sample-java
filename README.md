# swagger-akka-http-sample-java

Sample Java-based Akka-HTTP application that exposes its API as Swagger JSON.

This sample uses https://github.com/swagger-akka-http/swagger-akka-http while https://github.com/pjfanning/swagger-akka-http-java does not.

```sbt run```

curl http://localhost:8080/hello

curl http://localhost:8080/api-docs/swagger.json
