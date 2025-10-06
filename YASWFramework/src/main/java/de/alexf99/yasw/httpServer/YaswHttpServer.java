package de.alexf99.yasw.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class YaswHttpServer {
    public static HttpServer server;
    public static void init(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Http Server created on port: " + port);
    }
    public void createContext(String path, HttpHandler code){
        server.createContext(path, code);
        server.setExecutor(null); // creates a default executor
    }
    //With Get
    /*@Override
    public void handle(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }*/

    //With Post
    /*
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        if (requestMethod.equalsIgnoreCase("POST") || requestMethod.equalsIgnoreCase("PUT")) {

            // 1. Auf den Request Body (Anfragekörper) zugreifen
            try (InputStream requestBody = exchange.getRequestBody()) {

                // 2. Den InputStream vollständig als String lesen
                String message = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);

                System.out.println("Nachricht empfangen: " + message);

                // 3. Antwort an den Client senden
                String response = "Nachricht erfolgreich empfangen!";
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        } else {
            // Bei falschen Methoden (z.B. GET)
            String response = "Nur POST/PUT-Anfragen werden hier akzeptiert.";
            exchange.sendResponseHeaders(405, response.length()); // 405 Method Not Allowed
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }*/

}
