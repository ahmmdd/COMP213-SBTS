package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;

import school.bus.rest.model.TransportCompanyMember;

public class TransportCompanyMembers {

	static Map<Long,TransportCompanyMember> tcMembers = new HashMap<Long,TransportCompanyMember>();
	static{

		TransportCompanyMember c1 = new TransportCompanyMember();
		c1.setId(1L);
		c1.setName("How Lack");
		c1.setLogin("HL");
		c1.setPassword("hlforever123");
		tcMembers.put(1L, c1);
	}

	

	public void addTransportCompanyMember (TransportCompanyMember c)
	{
		tcMembers.put(c.getId(), c);
	}

	public TransportCompanyMember getTransportCompanyMember(Long id)
	{
		
		
		if(tcMembers.containsKey(id))
		{
			return tcMembers.get(id);
		}
		else
		{
			return null;
		}
		
	}
	
	public void updateTransportCompanyMember(TransportCompanyMember c)
	{
		if(tcMembers.containsKey(c.getId()))
		{
			tcMembers.put(c.getId(),c);
		}
	}

	public void removeTransportCompanyMember(TransportCompanyMember c)
	{
		tcMembers.remove(c.getId());
	}

}
