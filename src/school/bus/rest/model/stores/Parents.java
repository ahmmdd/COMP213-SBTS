<<<<<<< HEAD
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
=======
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
>>>>>>> d1e18f23bd8f860bed44b54135a9c33535f7a99b
