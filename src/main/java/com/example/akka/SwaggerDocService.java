package com.example.akka;

import java.util.Collections;
import java.util.Set;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import io.swagger.models.Info;

import com.github.swagger.akka.javadsl.SwaggerGenerator;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

class SwaggerDocService extends AllDirectives {

  SwaggerGenerator generator = new SwaggerGenerator() {
    @Override
    public Set<Class<?>> apiClasses() {
      return Collections.singleton(HttpServerMinimalExample.class);
    }

    @Override
    public Info info() {
      Info info = new Info().description("Simple akka-http application").version("1.0");
      return info;
    }
  };

  Route createRoute() {
    final Route route = route(path(PathMatchers.segment(generator.apiDocsPath()).slash("swagger.json"),
            () -> get(() -> complete(generator.generateSwaggerJson()))));
    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }
}
