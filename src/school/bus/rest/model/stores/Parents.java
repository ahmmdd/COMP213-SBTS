package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Parent;

public class Parents {
	static Map<Long,Parent> parentMap = new HashMap<Long,Parent>();

	public Parent addParent (Parent p)
	{
		return parentMap.put(p.getId(), p);
	}

	public Parent getParent(Long id) {
		if(parentMap.containsKey(id)) { return parentMap.get(id); }
		else { return null; }
	}
	
	
	public Parent updateParent(Parent p)
	{
		if(parentMap.containsKey(p.getId()))
		{
			return parentMap.put(p.getId(),p);
		}
		else
		{
			return null;
		}
	}

	public Parent removeParent(Parent p)
	{
		return parentMap.remove(p.getId());
	}
}
