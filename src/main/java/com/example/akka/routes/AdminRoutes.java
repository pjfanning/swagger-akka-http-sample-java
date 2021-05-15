package com.example.akka.routes;

import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  @Produces({MediaType.APPLICATION_JSON})
  @Operation(summary = "test", description = "test", responses = {
                  @ApiResponse(responseCode = "200",
                          content = {@Content(schema = @Schema(implementation = String.class))}),
                  @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  public Route test() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>Receive Password endpoint</h1>");
    return path("test", () ->
        get(() -> complete(entity))
    );
  }

  @Path("/reply")
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  @Operation(summary = "reply", description = "reply", responses = {
          @ApiResponse(responseCode = "200",
                  content = {@Content(schema = @Schema(implementation = String.class))}),
          @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  public Route reply() {
    HttpEntity.Strict entity = HttpEntities
        .create(ContentTypes.TEXT_HTML_UTF8, "<h1>reply endpoint</h1>");
    return path("reply", () ->
        get(() -> complete(entity))
    );
  }
}
