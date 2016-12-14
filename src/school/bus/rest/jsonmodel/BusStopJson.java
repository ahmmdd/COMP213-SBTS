package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusStopJson {

		@XmlElement public Long id;
		@XmlElement public String stopName;
		@XmlElement public double latitude;
		@XmlElement public double longitude;

}
