package school.bus.rest.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import school.bus.rest.model.ScheduledStop;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

@Entity
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@OneToMany
	private Set<ScheduledStop> scheduledStops = new HashSet<ScheduledStop>();

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
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Schedule)) {
			return false;
		}
		Schedule other = (Schedule) obj;
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

	public ScheduledStop addStop(ScheduledStop e) {
		if (scheduledStops.add(e))
			return e;
		return null;
	}

	public ScheduledStop removeStop(ScheduledStop e) {
		if (scheduledStops.remove(e))
			return e;
		return null;
	}

	public Set<ScheduledStop> getScheduledStops() {
		return this.scheduledStops;
	}

	public void setScheduledStops(final Set<ScheduledStop> scheduledStops) {
		this.scheduledStops = scheduledStops;
	}
}