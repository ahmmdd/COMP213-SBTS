package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusRouteJson {
	
@XmlElement	public String routeName;
@XmlElement	public String status;
@XmlElement	public double latitude;
@XmlElement	public double longtitude;
@XmlElement	public String timeStamp;

}
