package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Bus;

public class Buses {
	static Map<Long, Bus> buses = new HashMap<Long, Bus>();
	
	static{
		Bus bus = new Bus();
		bus.setId(1L);
		bus.setLatitude(12.2);
		bus.setLongitude(3.25);
		bus.setStatus("On Time");
		Childs ch = new Childs();
		bus.addChild(ch.getChild(1));
		bus.addChild(ch.getChild(3));
		buses.put(bus.getId(), bus);
	}
	public Buses() {
		
	}
	
	public Bus update(Bus bs){
		if(!buses.containsKey(bs.getId())){
			return null;
		}
		buses.put(bs.getId(), bs);
		return bs;
	}
	
	public Bus add(Bus bs){
		if(buses.containsKey(bs.getId())){
			return null;
		}
		return buses.put(bs.getId(), bs);
	}
	
	public Bus get(Long id){
		return buses.get(id);
	}
	
}
