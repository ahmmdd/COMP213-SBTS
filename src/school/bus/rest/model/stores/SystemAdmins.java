package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.SystemAdmin;

public class SystemAdmins {

	static Map<Long,SystemAdmin> sysAdmins = new HashMap<Long,SystemAdmin>();
	static{

		SystemAdmin c1 = new SystemAdmin();
		c1.setId(1L);
		c1.setName("sysadmin232");
		c1.setPassword("password66");
		sysAdmins.put(1L, c1);
	}

	

	public void addSystemAdmin (SystemAdmin c)
	{
		sysAdmins.put(c.getId(), c);
	}

	public SystemAdmin getSystemAdmin(Long id)
	{
		
		
		if(sysAdmins.containsKey(id))
		{
			return sysAdmins.get(id);
		}
		else
		{
			return null;
		}
		
	}
	
	public void updateSystemAdmin(SystemAdmin c)
	{
		if(sysAdmins.containsKey(c.getId()))
		{
			sysAdmins.put(c.getId(),c);
		}
	}

	public void removeSystemAdmin(SystemAdmin c)
	{
		sysAdmins.remove(c.getId());
	}

}
