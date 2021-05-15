package com.example.akka;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.example.akka.routes.Routes;
import java.util.concurrent.CompletionStage;

public class Main extends AllDirectives {

  public static void main(String[] args) throws Exception {
// boot up server using the route as defined below
    ActorSystem system = ActorSystem.create("routes");

    final Http http = Http.get(system);
    final ActorMaterializer materializer = ActorMaterializer.create(system);

    // In order to access all directives we need an instance where the routes
    // are define.
    Main app = new Main();

    final Route routes = app.route(new Routes().createRoute(), new SwaggerDocService().createRoute());
    final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = routes.flow(system, materializer);
    final CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow, ConnectHttp
        .toHost("localhost", 12345), materializer);

    System.out.println("Server online at http://localhost:12345/\nPress RETURN to stop...");
    System.in.read(); // let it run until user presses return

    binding.thenCompose(ServerBinding::unbind) // trigger unbinding from the port
        .thenAccept(unbound -> system.terminate()); // and shutdown when done
  }
}
