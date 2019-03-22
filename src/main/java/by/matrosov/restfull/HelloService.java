package by.matrosov.restfull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloService {

    //http://localhost:8080/java_restfull_webservice_war_exploded/rest/hello/privet
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String message) {

        String output = "Service say : " + message;

        return Response.status(200).entity(output).build();
    }
}
