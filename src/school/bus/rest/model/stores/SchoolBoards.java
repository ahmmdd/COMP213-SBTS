package school.bus.rest.model.stores;

import java.util.HashMap;
import java.util.Map;


import school.bus.rest.model.SchoolBoard;

public class SchoolBoards {
	static Map<Long,SchoolBoard> schoolBoardMap = new HashMap<Long,SchoolBoard>();

	public SchoolBoard addSchoolBoard (SchoolBoard p)
	{
		return schoolBoardMap.put(p.getId(), p);
	}

	public SchoolBoard getSchoolBoard(Long id)
	{
		
		
		if(schoolBoardMap.containsKey(id))
		{
			return schoolBoardMap.get(id);
		}
		else
		{
			return null;
		}
	}
	
	public SchoolBoard updateSchoolBoard(SchoolBoard p)
	{
		if(schoolBoardMap.containsKey(p.getId()))
		{
			return schoolBoardMap.put(p.getId(),p);
		}
		return null;
	}

	public SchoolBoard removeSchoolBoard(SchoolBoard p)
	{
		return schoolBoardMap.remove(p.getId());
	}
}
