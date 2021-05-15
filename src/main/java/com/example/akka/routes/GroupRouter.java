package com.example.akka.routes;

import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  @Produces({MediaType.APPLICATION_JSON})
  @Operation(summary = "reply", description = "reply", responses = {
          @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                  content = {@Content(schema = @Schema(implementation = String.class))}),
          @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  public Route register() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>Register endpoint</h1>");
    return path("register", () ->
        get(() -> complete(entity))
    );
  }
}
