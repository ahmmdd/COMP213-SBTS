package school.bus.rest.jsonmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ChildJson {

	@XmlElement public Integer id;
	@XmlElement public String name;

}
