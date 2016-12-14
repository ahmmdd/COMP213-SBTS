package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusJson {

	@XmlElement public long id;
	@XmlElement public String status;
	@XmlElement	public double latitude;
	@XmlElement	public double longitude;

}
