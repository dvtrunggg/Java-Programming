package status;

import java.util.ArrayList;

public class PhongStatusService {
	ArrayList<PhongStatus> listPhongStatus;

	public PhongStatusService() {
		listPhongStatus = new ArrayList<>();
	}

	{
		listPhongStatus = new ArrayList<>();
	}

	public ArrayList<PhongStatus> getListPhongStatus() {
		return listPhongStatus;
	}

	public void setListPhongStatus(ArrayList<PhongStatus> listPhongStatus) {
		this.listPhongStatus = listPhongStatus;
	}

	// search HoaDon Status by using id HoaDon Status from listPhongStatus
	public void findByID(int id) {
		// using linear search.

	}

	public void Insert() {
		// insert a HoaDon Status to listPhongStatusService
	}

	public void Delete() {
		// Delete a HoaDon Status from listPhongStatusService
	}

	public void Update() {
		// Update HoaDon Status information in listPhongStatusService
	}

}
