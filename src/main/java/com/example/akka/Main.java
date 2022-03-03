package com.example.akka;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import com.example.akka.routes.Routes;

import java.util.concurrent.CompletionStage;

public class Main extends AllDirectives {

  public static void main(String[] args) throws Exception {
    // boot up server using the route as defined below
    ActorSystem system = ActorSystem.create("routes");

    final Http http = Http.get(system);

    // In order to access all directives we need an instance where the routes
    // are defined.
    Main app = new Main();

    final Route routes = app.concat(new Routes().createRoute(), new SwaggerDocService().createRoute());
    final CompletionStage<ServerBinding> binding = http.newServerAt("localhost", 12345)
            .bind(routes);

    System.out.println("Server online at http://localhost:12345/\nPress RETURN to stop...");
    System.in.read(); // let it run until user presses return

    binding.thenCompose(ServerBinding::unbind) // trigger unbinding from the port
        .thenAccept(unbound -> system.terminate()); // and shutdown when done
  }
}
