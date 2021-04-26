package com.example.akka.routes;

import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Tag(name = "admins")
@Path("/admins")
public class AdminRoutes extends AllDirectives {

  public Route createRoute() {
    return concat(
        pathPrefix("users", () -> test()),
        pathPrefix("mlem", () -> reply()
        )
    );
  }

  @Path("/test")
  @GET
  @ApiOperation(value = "test", code = 200, nickname = "test", httpMethod = "GET", response = String.class)
  @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server error") })
  public Route test() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>Receive Password endpoint</h1>");
    return path("test", () ->
        get(() -> complete(entity))
    );
  }

  @Path("/reply")
  @GET
  @ApiOperation(value = "reply", code = 200, nickname = "test", httpMethod = "GET", response = String.class)
  @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server error") })
  public Route reply() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>reply endpoint</h1>");
    return path("reply", () ->
        get(() -> complete(entity))
    );
  }
}
