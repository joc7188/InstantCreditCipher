package com.instantcredit.webapp;

import com.instantcredit.commons.Vocabulary;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/instantCredit/";

    public static HttpServer startServer() {

        final ResourceConfig rc = new ResourceConfig().packages("com.instantcredit");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws Throwable {

        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        Vocabulary.getInstance();
        System.in.read();

        server.stop();
    }
}

