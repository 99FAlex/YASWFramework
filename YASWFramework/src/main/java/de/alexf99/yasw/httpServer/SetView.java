package de.alexf99.yasw.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class SetView implements HttpHandler {
    private static final String RESOURCE_ROOT = "";
    private String filename;
    public SetView(String filename) {
        this.filename = filename;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath();
        if (requestPath.equals("/")) {
            requestPath = "/index.html"; // Serve index.html for the root path
        }

        String resourcePath = RESOURCE_ROOT + requestPath;

        // Get the resource from the classpath
        try (InputStream inputStream = getClass().getResourceAsStream(resourcePath)) {
            if (Objects.isNull(inputStream)) {
                sendResponse(exchange, 404, "404 Not Found");
                return;
            }

            byte[] responseBytes = inputStream.readAllBytes();

            // Set Content-Type header (simplified, you'd need a real MIME type resolver)
            String contentType = getContentType(requestPath);
            exchange.getResponseHeaders().set("Content-Type", contentType);

            exchange.sendResponseHeaders(200, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(exchange, 500, "Internal Server Error");
        }
    }

    private void sendResponse(HttpExchange exchange, int status, String message) throws IOException {
        exchange.sendResponseHeaders(status, message.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(message.getBytes());
        }
    }

    // Very simplified MIME type guesser
    private String getContentType(String path) {
        if (path.endsWith(".html")) return "text/html";
        if (path.endsWith(".css")) return "text/css";
        if (path.endsWith(".js")) return "application/javascript";
        if (path.endsWith(".png")) return "image/png";
        // Add more types as needed
        return "text/plain";
    }
}