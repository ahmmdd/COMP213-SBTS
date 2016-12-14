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
import school.bus.rest.jsonmodel.ChildJson;
import school.bus.rest.model.Bus;
import school.bus.rest.model.BusRoute;
import school.bus.rest.model.Child;

@Path("/bus-service")
public class RestCallsServlet {

	@Path("bus/get/{id}")
	@GET
	@Produces("application/json")
	public Response getBus(@PathParam("id") Long id) {
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
	public Response putBus(final BusJson bj) throws ParseException {
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
	
	@Path("child/get/{id}")
	@GET
	@Produces("application/json")
	public Response getChild(@PathParam("id") Long id) {
		Childs cs = new Childs();
		Child child = cs.retrieve(id);
		if (child == null) {
			return Response.status(400).entity("Bus is not found").build();
		}
		
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", child.getId());
		jsonObject.put("name", child.getName());

		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/child/put")
	@Consumes("application/json")
	public Response putChild(final ChildJson cj) throws ParseException {
		Childs cs = new Childs();
		
		Child child = new Child();
		child.setId(cj.id);
		child.setName(cj.name);

		cs.put(child);
		String response = "Data Received: " + cj.id + "{" + cj.name + "]";
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
