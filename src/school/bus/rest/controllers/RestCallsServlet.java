package school.bus.rest.controllers;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import school.bus.rest.jsonmodel.BusRouteJson;
import school.bus.rest.model.BusRoute;
import school.bus.rest.model.BusRoutes;

@Path("/bus-service")
public class RestCallsServlet {

	@Path("retrieve/{routeName}")
	@GET
	@Produces("application/json")
	public Response retrieve(@PathParam("routeName") String routeName) {
		BusRoutes br = new BusRoutes();
		BusRoute bus = br.retrieve(routeName);
		if (bus == null) {
			return Response.status(400).entity("Bus route is not found").build();
		}
		JSONObject jsonObject = new JSONObject();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(bus.getTimeStamp());

		jsonObject.put("routeName", bus.getRouteName());
		jsonObject.put("status", bus.getStatus());
		jsonObject.put("latitude", bus.getLatitude());
		jsonObject.put("longtitude", bus.getLongtitude());
		jsonObject.put("timeStamp", strDate);

		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response update(final BusRouteJson brj) throws ParseException {
		BusRoutes br = new BusRoutes();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dateStamp = dateFormat.parse(brj.timeStamp);
		BusRoute bus = new BusRoute(brj.routeName, brj.status, brj.latitude, brj.longtitude, dateStamp);
		br.update(bus);
		String response = "Data Received: " + brj.routeName + "{" + brj.timeStamp + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Bus REST Service Successfully started";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

}
