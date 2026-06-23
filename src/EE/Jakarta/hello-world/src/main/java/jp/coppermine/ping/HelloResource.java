package jp.coppermine.ping;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("hello")
@RequestScoped
public class HelloResource {
    
    @GET
    public String getMessage() {
        return "Hello, world";
    }
    
}
