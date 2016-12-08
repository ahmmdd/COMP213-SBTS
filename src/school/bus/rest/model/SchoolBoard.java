package school.bus.rest.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import school.bus.rest.model.BusRoute;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import school.bus.rest.model.TransportCompanyMember;

@Entity
public class SchoolBoard extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@OneToMany
	private Set<BusRoute> busRoutes = new HashSet<BusRoute>();

	@OneToMany
	private Set<TransportCompanyMember> transportCompanyMembers = new HashSet<TransportCompanyMember>();

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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof SchoolBoard)) {
			return false;
		}
		SchoolBoard other = (SchoolBoard) obj;
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
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Set<BusRoute> getBusRoutes() {
		return this.busRoutes;
	}

	public void setBusRoutes(final Set<BusRoute> busRoutes) {
		this.busRoutes = busRoutes;
	}

	public Set<TransportCompanyMember> getTransportCompanyMembers() {
		return this.transportCompanyMembers;
	}

	public void setTransportCompanyMembers(
			final Set<TransportCompanyMember> transportCompanyMembers) {
		this.transportCompanyMembers = transportCompanyMembers;
	}
}