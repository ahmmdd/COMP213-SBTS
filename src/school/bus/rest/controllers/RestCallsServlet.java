package school.bus.rest.controllers;

import java.io.InputStream;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import school.bus.rest.jsonmodel.BusJson;
import school.bus.rest.model.Bus;
import school.bus.rest.model.BusRoute;

@Path("/bus-service")
public class RestCallsServlet {

	@Path("bus/get/{id}")
	@GET
	@Produces("application/json")
	public Response retrieve(@PathParam("id") Long id) {
		Buses bs = new Buses();
		Bus bus = bs.retrive(id);
		if (bus == null) {
			return Response.status(400).entity("Bus is not found").build();
		}
		
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", bus.getId());
		jsonObject.put("status", bus.getStatus());
		jsonObject.put("latitude", bus.getLatitude());
		jsonObject.put("longtitude", bus.getLongitude());

		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/bus/put")
	@Consumes("application/json")
	public Response update(final BusJson bj) throws ParseException {
		Buses bs = new Buses();
		
		Bus bus = new Bus();
		bus.setId(bj.id);
		bus.setSchedule(bj.status);
		bus.setLatitude(bj.latitude);
		bus.setLongitude(bj.longitude);

		bs.put(bus);
		String response = "Data Received: " + bj.id + "{" + bj.status + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}

	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Bus REST Service Successfully started";
		return Response.status(200).entity(result).build();
	}

}
