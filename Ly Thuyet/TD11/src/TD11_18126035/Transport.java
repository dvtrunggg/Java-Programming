package TD11_18126035;

public class Transport {
	private String cityDestination;
	private String transport;
	private String hours;

	public Transport() {
		this.cityDestination = "";
		this.transport = "";
		this.hours = "";
	}

	public Transport(String cityDestination, String transport, String hours) {
		this.cityDestination = cityDestination;
		this.transport = transport;
		this.hours = hours;
	}

	public Transport(String data) {
		String[] strArray = data.split(":");
		this.cityDestination = strArray[0];
		this.transport = strArray[1];
		this.hours = strArray[2];
	}

	public String toString() {
		String[] strArray = this.cityDestination.split("-");
		String str = "From " + strArray[0] + " to " + strArray[1] + " within " + this.hours + " by " + this.transport;
		return str;
	}

	public String getCityDestination() {
		return cityDestination;
	}

	public void setCityDestination(String cityDestination) {
		this.cityDestination = cityDestination;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}
}
