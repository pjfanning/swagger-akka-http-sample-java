package com.example.akka.routes;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class Routes extends AllDirectives {

  public Route createRoute() {
    return concat(
      new UserRouter().createRoute(),
      new GroupRouter().createRoute(),
      new AdminRoutes().createRoute()
    );
  }
}
