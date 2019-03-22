package by.matrosov.restfull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Path("/xml/weather")
public class XmlService {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //http://localhost:8080/java_restfull_webservice_war_exploded/rest/xml/weather/minsk/2019-06-06
    @Path("{location}/{date}")
    @GET
    @Produces("application/xml")
    public String getWeather_XML(@PathParam("location") String location,
                                 @PathParam("date") String dateStr) {
        Date date = null;
        if (dateStr == null || dateStr.length() == 0) {
            date = new Date();
        } else {
            try {
                date = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                date = new Date();
            }
        }
        dateStr = dateFormat.format(date);

        String[] weathers = new String[] { "Hot", "Rain", "Cold" };
        int i = new Random().nextInt(3);
        String weather = weathers[i];

        return "<weather>"//
                + "<date>" + dateStr + "</date>"//
                + "<location>" + location + "</location>"//
                + "<info>" + weather + "</info>"//
                + "</weather>";
    }
}
