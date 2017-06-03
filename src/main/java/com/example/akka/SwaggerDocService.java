package com.example.akka;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

import com.fasterxml.jackson.core.JsonProcessingException;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.DefaultReaderConfig;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

class SwaggerDocService extends AllDirectives {
  DefaultReaderConfig readerConfig = new DefaultReaderConfig();

  Route createRoute() {
    final Route route = route(path(PathMatchers.segment("api-docs").slash("swagger.json"), () -> get(() -> complete(swaggerJson()))));
    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }

  private String swaggerJson() {
    try {
      final Swagger swaggerConfig = new Swagger();
      final Reader reader = new Reader(swaggerConfig, readerConfig);
      final Swagger swagger = reader.read(HttpServerMinimalExample.class);
      return Json.pretty().writeValueAsString(swagger);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
