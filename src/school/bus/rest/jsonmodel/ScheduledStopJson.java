package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduledStopJson {

	@XmlElement public Long id;
	@XmlElement public Long stopId;
	@XmlElement public String time;

}
