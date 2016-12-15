package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.BusStop;

public class BusStops {
	static Map<Long, BusStop> busStops = new HashMap<Long, BusStop>();
	
	static{
		BusStop bs = new BusStop();
		bs.setId(1L);
		bs.setLatitude(12.53);
		bs.setLongitude(82.32);
		bs.setStopName("Eglinton Ave and Victoria Park Ave");
		busStops.put(1L, bs);
		bs = new BusStop();
		bs.setId(2L);
		bs.setLatitude(22.12);
		bs.setLongitude(32.12);
		bs.setStopName("Eglinton Ave and Pharmacy Ave");
		busStops.put(2L, bs);
	}
	public BusStops() {
		
	}
	
	public BusStop update(BusStop bs){
		if(!busStops.containsKey(bs.getId())){
			return null;
		}
		busStops.put(bs.getId(), bs);
		return bs;
	}
	
	public BusStop add(BusStop bs){
		if(busStops.containsKey(bs.getId())){
			return null;
		}
		return busStops.put(bs.getId(), bs);
	}
	
	public BusStop get(Long id){
		return busStops.get(id);
	}
	
}
