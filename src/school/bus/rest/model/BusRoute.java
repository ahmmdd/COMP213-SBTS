package school.bus.rest.model;

import java.util.Date;

public class BusRoute {
	
	private String routeName;
	private String status;
	private double latitude;
	private double longtitude;
	private Date timeStamp;

	public BusRoute() {
		
	}
	
	public BusRoute(String routeName, String status, double latitude, double longtitude, Date timeStamp) {
		super();
		this.routeName = routeName;
		this.status = status;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.timeStamp = timeStamp;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timestamp) {
		this.timeStamp = timestamp;
	}

	
}
