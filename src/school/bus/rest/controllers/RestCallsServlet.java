package school.bus.rest.controllers;

import java.io.InputStream;
import java.sql.Time;
import java.text.ParseException;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import school.bus.rest.jsonmodel.BusJson;
import school.bus.rest.jsonmodel.BusRouteJson;
import school.bus.rest.jsonmodel.BusStopJson;
import school.bus.rest.jsonmodel.ChildJson;
import school.bus.rest.jsonmodel.ScheduledStopJson;
import school.bus.rest.model.Bus;
import school.bus.rest.model.BusRoute;
import school.bus.rest.model.BusStop;
import school.bus.rest.model.Child;
import school.bus.rest.model.Schedule;
import school.bus.rest.model.ScheduledStop;
import school.bus.rest.model.stores.BusRoutes;
import school.bus.rest.model.stores.BusStops;
import school.bus.rest.model.stores.Buses;
import school.bus.rest.model.stores.Childs;
import school.bus.rest.model.stores.ScheduledStops;
import school.bus.rest.model.stores.Schedules;

@Path("/bus-service")
public class RestCallsServlet {

	@Path("bus/get/{id}")
	@GET
	@Produces("application/json")
	public Response getBus(@PathParam("id") Long id) {
		Buses bs = new Buses();
		Bus bus = bs.get(id);
		if (bus == null) {
			return Response.status(400).entity("Bus is not found").build();
		}

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("id", bus.getId());
		jsonObject.put("status", bus.getStatus());
		jsonObject.put("latitude", bus.getLatitude());
		jsonObject.put("longitude", bus.getLongitude());

		Set<Child> children = bus.getRidingChildren();
		for (Child c : children) {
			JSONObject child = new JSONObject();
			child.put("id", c.getId());
			child.put("name", c.getName());
			jsonArray.put(child);
		}
		jsonObject.put("children", jsonArray);
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
		bus.setStatus(bj.status);
		bus.setLatitude(bj.latitude);
		bus.setLongitude(bj.longitude);

		bs.add(bus);
		String response = "Data Received: " + bj.id + "[" + bj.status + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@PUT
	@Path("/bus/update")
	@Consumes("application/json")
	public Response updateBus(final BusJson bj) throws ParseException {
		Buses bs = new Buses();

		Bus bus = bs.get(bj.id);
		if (bus == null) {
			return Response.status(400).entity("Bus is not found").build();
		}
		
		bus.setId(bj.id);
		bus.setStatus(bj.status);
		bus.setLatitude(bj.latitude);
		bus.setLongitude(bj.longitude);

		String response = "Data Updated: " + bj.id + "[" + bj.status + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}

	@POST
	@Path("/bus/{busId}/addChild/{childId}")
	public Response putBus(@PathParam("busId") Long busId, @PathParam("childId") Integer childId)
			throws ParseException {
		Buses bs = new Buses();

		Bus bus = bs.get(busId);
		if (bus == null) {
			return Response.status(400).entity("Bus is not found").build();
		}

		Childs cs = new Childs();
		Child child = cs.getChild(childId);
		if (child == null) {
			return Response.status(400).entity("Child is not found").build();
		}

		bus.addChild(child);

		String response = "Bus: " + busId + " updated " + "[Child " + childId + " added]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}

	@Path("child/get/{id}")
	@GET
	@Produces("application/json")
	public Response getChild(@PathParam("id") Integer id) {
		Childs cs = new Childs();
		Child child = cs.getChild(id);

		if (child == null) {
			return Response.status(400).entity("Child is not found").build();
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
	public Response putBus(final ChildJson cj) throws ParseException {
		Childs cs = new Childs();

		Child child = new Child();
		child.setId(cj.id);
		child.setName(cj.name);

		cs.addChild(child);
		String response = "Data Received: " + cj.id + " [" + cj.name + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}

	@Path("bus-stop/get/{id}")
	@GET
	@Produces("application/json")
	public Response getBusStop(@PathParam("id") Long id) {
		BusStops bs = new BusStops();
		BusStop busStop = bs.get(id);

		if (busStop == null) {
			return Response.status(400).entity("Bus Stop is not found").build();
		}

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", busStop.getId());
		jsonObject.put("stopName", busStop.getStopName());
		jsonObject.put("latitude", busStop.getLatitude());
		jsonObject.put("longitude", busStop.getLongitude());

		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/bus-stop/put")
	@Consumes("application/json")
	public Response putBusStop(final BusStopJson bsj) throws ParseException {
		BusStops bs = new BusStops();

		BusStop busStop = new BusStop();

		busStop.setId(bsj.id);
		busStop.setStopName(bsj.stopName);
		busStop.setLatitude(bsj.latitude);
		busStop.setLongitude(bsj.longitude);

		bs.add(busStop);
		String response = "Data Received: " + bsj.id + " [" + bsj.stopName + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@Path("/scheduled-stop/get/{id}")
	@GET
	@Produces("application/json")
	public Response getScheduledStop(@PathParam("id") Long id) {
		ScheduledStops ss = new ScheduledStops();
		ScheduledStop scheduledStop = ss.get(id);
		
		if (scheduledStop == null) {
			return Response.status(400).entity("Scheduled Stop is not found").build();
		}
		
		BusStop busStop = scheduledStop.getStop();
		
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("id", busStop.getId());
		jsonObject.put("stopName", busStop.getStopName());
		jsonObject.put("latitude", busStop.getLatitude());
		jsonObject.put("longitude", busStop.getLongitude());

		JSONObject jsonObject2 = new JSONObject();

		jsonObject2.put("id", scheduledStop.getId());
		jsonObject2.put("time", scheduledStop.getPredictedTime().toString());
		jsonObject2.put("busStop", jsonObject);

		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject2;
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/scheduled-stop/put")
	@Consumes("application/json")
	public Response putBus(final ScheduledStopJson ssj) throws ParseException {
		ScheduledStops ss = new ScheduledStops();

		BusStops busStops = new BusStops();
		BusStop busStop = busStops.get(ssj.stopId);
		if (busStop == null) {
			return Response.status(400).entity("Bus Stop is not found").build();
		}
		Time time = Time.valueOf(ssj.time);
		ScheduledStop scheduledStop = new ScheduledStop(busStop, time);
		scheduledStop.setId(ssj.id);

		ss.add(scheduledStop);
		
		String response = "Data Received: " + ssj.id + " [" + ssj.time + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/schedule/{id}")
	@Consumes("application/json")
	public Response putSchedule(@PathParam("id") Long id) throws ParseException {
		Schedules ss = new Schedules();
		Schedule s = new Schedule();
		s.setId(id);
		ss.add(s);
		
		String response = "Schedule Id Received: " + id;
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/schedule/{scheduleId}/addScheduledStop/{scheduledStopId}")
	public Response putBus(@PathParam("scheduleId") Long scheduleId, @PathParam("scheduledStopId") Long scheduledStopId)
			throws ParseException {
		ScheduledStops ss = new ScheduledStops();
		ScheduledStop s = ss.get(scheduledStopId);
		if (s == null) {
			return Response.status(400).entity("Scheduled Stop is not found").build();
		}

		Schedules scs = new Schedules();
		Schedule sc = scs.get(scheduleId);
		if (sc == null) {
			return Response.status(400).entity("Schedule is not found").build();
		}

		sc.addStop(s);

		String response = "Schedule: " + scheduleId + " updated " + "[Scheduled Stop " + scheduledStopId + " added]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/bus-route/put")
	@Consumes("application/json")
	public Response putBusRoute(final BusRouteJson brj) throws ParseException {
		BusRoutes br = new BusRoutes();
		BusRoute busRoute = new BusRoute();
		
		busRoute.setId(brj.id);
		busRoute.setRouteName(brj.routeName);
		Time startTime = Time.valueOf(brj.time);
		busRoute.setStartTime(startTime);

		br.add(busRoute);
		String response = "Data Received: " + brj.id + "[" + brj.routeName + "]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/bus-route/{busRouteId}/addSchedule/{id}")
	public Response busRouteAddSchedule(@PathParam("busRouteId") Long busRouteId, @PathParam("id") Long id) throws ParseException {
		Schedules scs = new Schedules();
		Schedule sc = scs.get(id);
		if (sc == null) {
			return Response.status(400).entity("Schedule is not found").build();
		}
		
		BusRoutes br = new BusRoutes();
		BusRoute busRoute = br.get(busRouteId);
		
		if (busRoute == null) {
			return Response.status(400).entity("Bus Route is not found").build();
		}
		
		busRoute.setSchedule(sc);

		String response = "Bus Route: " + busRouteId + " updated " + "[Schedule " + id + " added]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/bus-route/{busRouteId}/addBus/{busId}")
	public Response busRouteAddBus(@PathParam("busRouteId") Long busRouteId, @PathParam("busId") Long busId) throws ParseException {
		Buses bs = new Buses();

		Bus bus = bs.get(busId);
		if (bus == null) {
			return Response.status(400).entity("Bus is not found").build();
		}
		
		BusRoutes br = new BusRoutes();
		BusRoute busRoute = br.get(busRouteId);
		
		if (busRoute == null) {
			return Response.status(400).entity("Bus Route is not found").build();
		}
		
		busRoute.addBus(bus);

		String response = "Bus Route: " + busRouteId + " updated " + "[Bus " + busId + " added]";
		System.out.println(response);
		return Response.status(200).entity(response).build();
	}
	
	@Path("bus-route/get/{id}")
	@GET
	@Produces("application/json")
	public Response getBusRoute(@PathParam("id") Long id) {
		BusRoutes br = new BusRoutes();
		BusRoute busRoute = br.get(id);
		if (busRoute == null) {
			return Response.status(400).entity("Bus Route is not found").build();
		}

		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("id", busRoute.getId());
		jsonObject.put("routeName", busRoute.getRouteName());
		jsonObject.put("startTime", busRoute.getStartTime().toString());
		
		JSONArray jsonArray = new JSONArray();
		Set<Bus> buses = busRoute.getBuses();
		for (Bus c : buses) {
			JSONObject bus = new JSONObject();
			bus.put("id", c.getId());
			bus.put("status", c.getStatus());
			bus.put("latitude", c.getLatitude());
			bus.put("longitude", c.getLongitude());
			jsonArray.put(bus);
			JSONArray jsonArray2 = new JSONArray();
			Set<Child> children = c.getRidingChildren();
			for (Child dc : children) {
				JSONObject child = new JSONObject();
				child.put("id", dc.getId());
				child.put("name", dc.getName());
				jsonArray2.put(child);
			}
			bus.put("children",jsonArray2);
		}
		jsonObject.put("buses", jsonArray);
		
		Schedule s = busRoute.getSchedule();
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("id", s.getId());
		
		JSONArray jsonArray3 = new JSONArray();
		Set<ScheduledStop> scheduledStops = s.getScheduledStops();
		for (ScheduledStop scheduledStop : scheduledStops) {
			BusStop busStop = scheduledStop.getStop();
			
			JSONObject jsonObject4 = new JSONObject();

			jsonObject4.put("id", busStop.getId());
			jsonObject4.put("stopName", busStop.getStopName());
			jsonObject4.put("latitude", busStop.getLatitude());
			jsonObject4.put("longitude", busStop.getLongitude());

			JSONObject jsonObject5 = new JSONObject();

			jsonObject5.put("id", scheduledStop.getId());
			jsonObject5.put("time", scheduledStop.getPredictedTime().toString());
			jsonObject5.put("busStop", jsonObject4);
			jsonArray3.put(jsonObject5);

		}
		jsonObject3.put("scheduledStops",jsonArray3);
		jsonObject.put("schedule", jsonObject3);
		
		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Bus REST Service Successfully started";
		return Response.status(200).entity(result).build();
	}

}