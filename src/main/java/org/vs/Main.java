package org.vs;

        import com.google.gson.Gson;
        import org.glassfish.grizzly.http.server.HttpServer;
        import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
        import org.glassfish.jersey.server.ResourceConfig;
        import org.vs.model.RenameMessage;

        import java.io.IOException;
        import java.net.URI;
        import java.util.HashMap;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    private static final String BASE_URI = "http://192.168.2.115:8080/filesystem/";
    public static HashMap map = new HashMap();
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in org.vs package

        final ResourceConfig rc = new ResourceConfig().packages("org.vs");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        map.put("Joshua","192.168.2.105:9090");
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

