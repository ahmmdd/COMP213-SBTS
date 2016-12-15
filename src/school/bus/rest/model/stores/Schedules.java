package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Schedule;

public class Schedules {
	static Map<Long, Schedule> schedules = new HashMap<Long, Schedule>();
	
	static{
		
	}
	public Schedules() {
		
	}
	
	public Schedule update(Schedule bs){
		if(!schedules.containsKey(bs.getId())){
			return null;
		}
		schedules.put(bs.getId(), bs);
		return bs;
	}
	
	public Schedule add(Schedule bs){
		if(schedules.containsKey(bs.getId())){
			return null;
		}
		return schedules.put(bs.getId(), bs);
	}
	
	public Schedule get(Long id){
		return schedules.get(id);
	}
	
}
