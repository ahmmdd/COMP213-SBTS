package school.bus.rest.model.stores;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Bus;
import school.bus.rest.model.BusRoute;

public class BusRoutes {
	static Map<Long, BusRoute> busRoutes = new HashMap<Long, BusRoute>();
	
	static{
		BusRoute br = new BusRoute();
		br.setId(1L);
		br.setRouteName("Eglinton East");
		br.setStartTime(new Time(12,0,0));
		busRoutes.put(br.getId(),br);
	}
	public BusRoutes() {
		
	}
	
	public BusRoute update(BusRoute bs){
		if(!busRoutes.containsKey(bs.getId())){
			return null;
		}
		busRoutes.put(bs.getId(), bs);
		return bs;
	}
	
	public BusRoute add(BusRoute bs){
		if(busRoutes.containsKey(bs.getId())){
			return null;
		}
		return busRoutes.put(bs.getId(), bs);
	}
	
	public BusRoute get(Long id){
		return busRoutes.get(id);
	}
	
}
