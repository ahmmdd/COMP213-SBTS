package school.bus.rest.model.stores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import school.bus.rest.model.BusRoute;

public class BusRoutes {
	static List<BusRoute> busRoutes = new ArrayList<BusRoute>();
	static{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse("2012-12-12 12:13:14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BusRoute br = new BusRoute("T-51","On-time",51.3212,21.2121,date);
		busRoutes.add(br);
	}
	public BusRoutes() {
		// TODO Auto-generated constructor stub
	}
	
	public BusRoute update(BusRoute br)	{
		busRoutes.add(br);
		return br;
	}
	
	public BusRoute retrieve(String routeName){
		for(int i = busRoutes.size()-1;i>=0;i--)
		{
			if(busRoutes.get(i).getRouteName().equals(routeName)){
				return busRoutes.get(i);
			}
		}
		return null;
	}
	
}
