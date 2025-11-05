package de.alexf99.yasw.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.alexf99.yasw.SystemOutputManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SetView implements HttpHandler {
    private final String defaultFilename;

    public SetView(String defaultFilename) {
        this.defaultFilename = defaultFilename;

        SystemOutputManager.writeHttpManager(false, "=== SetView initialized ===");
        SystemOutputManager.writeHttpManager(false, "Default file: " + defaultFilename);

        // Test if the default file exists
        try (InputStream test = getClass().getResourceAsStream("/" + defaultFilename)) {
            if (test != null) {
                SystemOutputManager.writeHttpManager(false, "Default file found in classpath");
            } else {
                SystemOutputManager.writeHttpManager(true, "Default file NOT found in classpath!");
                SystemOutputManager.writeHttpManager(true, "Looking for: /" + defaultFilename);
            }
        } catch (Exception e) {
            SystemOutputManager.writeHttpManager(false, "Error checking default file: " + e.getMessage());
        }
        SystemOutputManager.writeHttpManager(false, "========================");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath();

        // Remove the context path to get the relative resource path
        String contextPath = exchange.getHttpContext().getPath();
        String relativePath = requestPath.substring(contextPath.length());

        String resourcePath;

        // If empty or just "/", use default filename
        if (relativePath.isEmpty() || relativePath.equals("/")) {
            resourcePath = "/" + defaultFilename;
        } else {
            // For other files, use them as-is (they can have their own folder structure)
            if (!relativePath.startsWith("/")) {
                relativePath = "/" + relativePath;
            }
            resourcePath = relativePath;
        }

        // Debug output
        SystemOutputManager.writeHttpManager(false, "=== Request Debug ===");
        SystemOutputManager.writeHttpManager(false, "Request URI: " + exchange.getRequestURI());
        SystemOutputManager.writeHttpManager(false, "Request Path: " + requestPath);
        SystemOutputManager.writeHttpManager(false, "Context Path: " + contextPath);
        SystemOutputManager.writeHttpManager(false, "Relative Path: " + relativePath);
        SystemOutputManager.writeHttpManager(false, "Loading Resource: " + resourcePath);
        SystemOutputManager.writeHttpManager(false, "===================");

        // Get the resource from the classpath
        try (InputStream inputStream = getClass().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {

                SystemOutputManager.writeHttpManager(true, "Resource not found: " + resourcePath);
                sendResponse(exchange, 404, "404 Not Found: " + resourcePath);
                return;
            }

            byte[] responseBytes = inputStream.readAllBytes();
            SystemOutputManager.writeHttpManager(false, "Successfully loaded " + responseBytes.length + " bytes");

            String contentType = getContentType(resourcePath);
            exchange.getResponseHeaders().set("Content-Type", contentType);

            // Add cache control for static resources
            if (!resourcePath.endsWith(".html")) {
                exchange.getResponseHeaders().set("Cache-Control", "public, max-age=3600");
            }

            exchange.sendResponseHeaders(200, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(exchange, 500, "Internal Server Error: " + e.getMessage());
        }
    }

    private void sendResponse(HttpExchange exchange, int status, String message) throws IOException {
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, messageBytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(messageBytes);
        }
    }

    private String getContentType(String path) {
        if (path.endsWith(".html")) return "text/html; charset=UTF-8";
        if (path.endsWith(".css")) return "text/css; charset=UTF-8";
        if (path.endsWith(".js")) return "application/javascript; charset=UTF-8";
        if (path.endsWith(".png")) return "image/png";
        if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
        if (path.endsWith(".svg")) return "image/svg+xml";
        if (path.endsWith(".ico")) return "image/x-icon";
        if (path.endsWith(".json")) return "application/json; charset=UTF-8";
        return "text/plain; charset=UTF-8";
    }
}