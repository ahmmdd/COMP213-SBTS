package school.bus.rest.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import school.bus.rest.model.Child;
import school.bus.rest.model.Schedule;

@Entity
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;
	

	@Column
	private double Longitude;
	@Column
	private double Latitude;

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	@Enumerated
	private BusStatus status;

	@ManyToOne
	private Schedule schedule;

	@OneToMany
	private Set<Child> ridingChildren = new HashSet<Child>();

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bus)) {
			return false;
		}
		Bus other = (Bus) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Child addChild(Child e){
		if(ridingChildren.add(e)) return e;
		return null;
	}
	
	public Child removeChild(Child e){
		if(ridingChildren.remove(e)) return e;
		return null;
	}
	
	public BusStatus getStatus() {
		return status;
	}

	public void setStatus(BusStatus status) {
		this.status = status;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(final Schedule schedule) {
		this.schedule = schedule;
	}

	public Set<Child> getRidingChildren() {
		return this.ridingChildren;
	}

	public void setRidingChildren(final Set<Child> ridingChildren) {
		this.ridingChildren = ridingChildren;
	}
}