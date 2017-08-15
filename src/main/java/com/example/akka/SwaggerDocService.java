package com.example.akka;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import com.github.swagger.akka.javadsl.SwaggerGenerator;

import java.util.Collections;
import java.util.Set;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

class SwaggerDocService extends AllDirectives {

  Route createRoute() {
    final Route route = route(path(PathMatchers.segment("api-docs").slash("swagger.json"), () -> get(() -> complete(swaggerJson()))));
    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }

  private String swaggerJson() {
    SwaggerGenerator generator = new SwaggerGenerator() {
      @Override
      public Set<Class<?>> apiClasses() {
        return Collections.singleton(HttpServerMinimalExample.class);
      }
    };
    return generator.generateSwaggerJson();
  }
}
