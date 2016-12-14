package school.bus.rest.model.stores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import school.bus.rest.model.BusRoute;
import school.bus.rest.model.BusStop;
import school.bus.rest.model.Location;

public class BusStops {
	static List<BusStop> busStops = new ArrayList<BusStop>();
	
	static{
		
		BusStop bs = new BusStop();
		bs.setLocation(1.0,1.0);
		bs.setStopName("Eglinton Ave and Victoria Park Ave");
		busStops.add(bs);
		bs = new BusStop();
		bs.setLocation(1.0,1.0);
		bs.setStopName("Eglinton Ave and Pharmacy Ave");
		busStops.add(bs);
	}
	public BusStops() {
		// TODO Auto-generated constructor stub
	}
	
	public BusStop update(BusStop bs)	{
		busStops.add(bs);
		return bs;
	}
	
	public BusStop retrieve(String stopName){
		for(int i = busStops.size()-1;i>=0;i--)
		{
			if(busStops.get(i).getStopName().equals(stopName)){
				return busStops.get(i);
			}
		}
		return null;
	}
	
}
