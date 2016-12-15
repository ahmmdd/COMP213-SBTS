package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusRouteJson {

	@XmlElement public Long id;
	@XmlElement public String routeName;
	@XmlElement public String time;

}
