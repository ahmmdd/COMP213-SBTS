package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.Child;

public class Childs {

	static Map<Integer,Child> childMap = new HashMap<Integer,Child>();
	static{

		Child c1 = new Child(1,"Poon");
		Child c2 = new Child(2, "Sasuke");
		Child c3 = new Child(3, "Naruto");
		
		childMap.put(1, c1);
		childMap.put(2, c2);
		childMap.put(3, c3);
		
	}

	

	public void addChild (Child c)
	{
		childMap.put(c.getId(), c);
	}

	public Child getChild(Integer id)
	{
		
		
		if(childMap.containsKey(id))
		{
			return childMap.get(id);
		}
		else
		{
			return null;
		}
		
	}
	
	public void updateChild(Child c)
	{
		if(childMap.containsKey(c.getId()))
		{
			childMap.put(c.getId(),c);
		}
	}

	public void removeChild(Child c)
	{
		childMap.remove(c.getId());
	}

}
