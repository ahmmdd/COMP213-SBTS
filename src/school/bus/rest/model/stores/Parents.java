package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Parent;

public class Parents {
	static Map<Long,Parent> parentMap = new HashMap<Long,Parent>();

	public void addParent (Parent p)
	{
		parentMap.put(p.getId(), p);
	}

	public Parent getParent(Long id)
	{
		
		
		if(parentMap.containsKey(id))
		{
			return parentMap.get(id);
		}
		else
		{
			return null;
		}
	}
	
	public void updateParent(Parent p)
	{
		if(parentMap.containsKey(p.getId()))
		{
			parentMap.put(p.getId(),p);
		}
	}

	public void removeParent(Parent p)
	{
		parentMap.remove(p.getId());
	}
}
