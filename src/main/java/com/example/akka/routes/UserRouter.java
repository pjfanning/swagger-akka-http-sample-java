package com.example.akka.routes;

import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import com.example.akka.entities.ListUsersResponse;
import com.example.akka.entities.Status;
import com.example.akka.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Tag(name = "users")
public class UserRouter extends AllDirectives {

  public Route createRoute() {
    return pathPrefix("users", () -> concat (
        getUser(),
        addUser(),
        updateUser(),
        deleteUser(),
        listUsers()
    ));
  }

  @Path("/{userId}")
  @GET
  @Operation(
      description = "Endpoint to get user by ID",
      method = "GET",
      parameters = {
          @Parameter(name = "userId", in = ParameterIn.PATH)
      },
      responses = {
          @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK",
              content = @Content(schema = @Schema(implementation = User.class),
                  mediaType = MediaType.APPLICATION_JSON))
      }
  )
  public Route getUser() {
    return get(() -> {
      //Real application should return User instance, this is just example
      HttpEntity.Strict entity = HttpEntities
          .create(ContentTypes.APPLICATION_JSON, "Getting user");
      return complete(entity);
    });
  }

  @Path("/")
  @POST
  @Operation(
      description = "Endpoint to add user",
      method = "POST",
      requestBody = @RequestBody(
          description = "The user to add",
          required = true,
          content = @Content(
              schema = @Schema(implementation = User.class),
              mediaType = MediaType.APPLICATION_JSON)),
      responses = {
          @ApiResponse(responseCode = "200", description = "OK",
              content = @Content(schema = @Schema(implementation = User.class),
                  mediaType = MediaType.APPLICATION_JSON))
      }
  )
  public Route addUser() {
    return post(() ->{
        //Real application should return User instance, this is just example
        HttpEntity.Strict entity = HttpEntities
            .create(ContentTypes.APPLICATION_JSON, "Saving user");
        return complete(entity);
      }
    );
  }

  @Path("/{userId}")
  @PUT
  @Operation(
      description = "Endpoint to update user",
      method = "PUT",
      parameters = {
          @Parameter(name = "userId", in = ParameterIn.PATH)
      },
      requestBody = @RequestBody(
          description = "The user to update",
          required = true,
          content = @Content(
              schema = @Schema(implementation = User.class),
              mediaType = MediaType.APPLICATION_JSON)),
      responses = {
          @ApiResponse(responseCode = "200", description = "OK",
              content = @Content(schema = @Schema(implementation = User.class),
                  mediaType = MediaType.APPLICATION_JSON))
      }
  )
  public Route updateUser() {
    return put(() ->{
          //Real application should return User instance, this is just example
          HttpEntity.Strict entity = HttpEntities
              .create(ContentTypes.APPLICATION_JSON, "Updating user");
          return complete(entity);
        }
    );
  }

  @Path("/{userId}")
  @DELETE
  @Operation(
      description = "Endpoint to delete user",
      method = "DELETE",
      parameters = {
          @Parameter(name = "userId", in = ParameterIn.PATH)
      },
      responses = {
          @ApiResponse(responseCode = "200", description = "OK",
              content = @Content(schema = @Schema(implementation = User.class),
                  mediaType = MediaType.APPLICATION_JSON))
      }
  )
  public Route deleteUser() {
    return delete(() ->{
        //Real application should return User instance, this is just example
        HttpEntity.Strict entity = HttpEntities
            .create(ContentTypes.APPLICATION_JSON, "Deleting user");
        return complete(entity);
      }
    );
  }

  @GET
  @Operation(
      description = "Endpoint to get users",
      method = "GET",
      parameters = {
          @Parameter(name = "firstname", in = ParameterIn.QUERY),
          @Parameter(name = "userIds", in = ParameterIn.QUERY, required = true,
              array = @ArraySchema(arraySchema = @Schema(example = "[\"userId1\", \"userId2\"]"))),
          @Parameter(name = "status", in = ParameterIn.QUERY,
              schema = @Schema(implementation = Status.class)),
          @Parameter(name = "pageNumber", in = ParameterIn.QUERY,
              schema = @Schema(type = "integer", minimum = "0")),
          @Parameter(name = "pageSize", in = ParameterIn.QUERY,
              schema = @Schema(type = "integer", minimum = "0")),
      },
      responses = {
          @ApiResponse(responseCode = "200", description = "OK",
              content = @Content(schema = @Schema(implementation = ListUsersResponse.class),
                  mediaType = MediaType.APPLICATION_JSON))
      }
  )
  public Route listUsers() {
    return get(() -> {
        //Real application should return correct response, this is just example for annotations
        HttpEntity.Strict entity = HttpEntities
            .create(ContentTypes.APPLICATION_JSON, "Listing users");
        return complete(entity);
      }
    );
  }
}
