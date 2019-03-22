package by.matrosov.restfull;

import by.matrosov.restfull.model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/json/person")
public class JsonService {

    //http://localhost:8080/java_restfull_webservice_war_exploded/rest/json/person/get
    @GET
    @Path("/get")
    @Produces("application/json")
    public Person getPersonInJSON() {

        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setAge(10);

        return person;
    }

    //http://localhost:8080/java_restfull_webservice_war_exploded/rest/json/product/post
    //post this
    //{"firstName":"Sergei","lastName":"Sergeev","age":30}
    //out put
    //Person created : Person{firstName='Sergei',lastName='Sergeev', age=30}
    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response createPersonInJSON(Person person) {

        String result = "Person created : " + person;
        return Response.status(201).entity(result).build();
    }
}
