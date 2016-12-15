package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.ScheduledStop;

public class ScheduledStops {
	static Map<Long, ScheduledStop> scheduledStops = new HashMap<Long, ScheduledStop>();
	
	static{
	}
	public ScheduledStops() {
		
	}
	
	public ScheduledStop update(ScheduledStop bs){
		if(!scheduledStops.containsKey(bs.getId())){
			return null;
		}
		scheduledStops.put(bs.getId(), bs);
		return bs;
	}
	
	public ScheduledStop add(ScheduledStop bs){
		if(scheduledStops.containsKey(bs.getId())){
			return null;
		}
		return scheduledStops.put(bs.getId(), bs);
	}
	
	public ScheduledStop get(Long id){
		return scheduledStops.get(id);
	}
	
}
