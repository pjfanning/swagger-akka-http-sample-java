package com.example.akka.routes;

import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/groups")
@Tag(name = "groups")
public class GroupRouter extends AllDirectives {

  public Route createRoute() {
    return
        concat(
            pathPrefix("groups", () -> register()
        )
    );
  }

  @Path("/register")
  @GET
  @ApiOperation(value = "register", code = 200, nickname = "register", httpMethod = "GET", response = String.class)
  @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server error") })
  public Route register() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>Register endpoint</h1>");
    return path("register", () ->
        get(() -> complete(entity))
    );
  }
}
