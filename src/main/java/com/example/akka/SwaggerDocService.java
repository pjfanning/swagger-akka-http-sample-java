package com.example.akka;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import com.example.akka.routes.GroupRouter;
import com.example.akka.routes.AdminRoutes;
import com.example.akka.routes.UserRouter;
import com.github.swagger.akka.javadsl.Converter;
import com.github.swagger.akka.javadsl.SwaggerGenerator;
import io.swagger.models.Scheme;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SwaggerDocService extends AllDirectives {

  SwaggerGenerator generator = new SwaggerGenerator() {
    @Override
    public Converter converter() {
      return new Converter(this);
    }

    @Override
    public Set<Class<?>> apiClasses() {
      return Set.of(GroupRouter.class, UserRouter.class, AdminRoutes.class);
    }

    @Override
    public String apiDocsPath() {
      return "api-docs";
    }

    @Override
    public String host() {
      return "your-host.com";
    }

    @Override
    public io.swagger.v3.oas.models.info.Info info() {
      var info = new Info();
      info.setTitle("Customer model sync service");
      info.setVersion("v1");
      return info;
    }

    @Override
    public List<String> schemes() {
      return List.of(Scheme.HTTPS.toValue(), Scheme.HTTP.toValue());
    }

    @Override
    public List<SecurityRequirement> security() {
      var securityRequirement = new SecurityRequirement();
      securityRequirement.addList("bearer-jwt");
      return List.of(securityRequirement);
    }

    @Override
    public Map<String, SecurityScheme> securitySchemes() {
      var securityScheme = new SecurityScheme();
      securityScheme.setType(Type.HTTP);
      securityScheme.setScheme("bearer");
      securityScheme.setBearerFormat("JWT");
      securityScheme.setIn(In.HEADER);
      securityScheme.setName("Authorization");
      return Map.of("bearer-jwt", securityScheme);
    }
  };

  Route createRoute() {
    final Route route = route(path(PathMatchers.segment(generator.apiDocsPath()).slash("swagger.json"),
            () -> get(() -> complete(generator.generateSwaggerJson()))));

    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }
}
