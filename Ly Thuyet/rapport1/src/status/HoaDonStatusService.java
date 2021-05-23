package status;

import java.util.ArrayList;

public class HoaDonStatusService {
	ArrayList<HoaDonStatus> listHDStatus;

	public HoaDonStatusService() {
		listHDStatus = new ArrayList<>();
	}

	public ArrayList<HoaDonStatus> getListHDStatus() {
		return listHDStatus;
	}

	public void setListHDStatus(ArrayList<HoaDonStatus> listHDStatus) {
		this.listHDStatus = listHDStatus;
	}

//search HoaDon Status by using id HoaDon Status from listHDStatus
	public void findByID(int id) {
		// using linear search.

	}

	public void Insert() {
		// insert a HoaDon Status to listHDStatusService
	}

	public void Delete() {
		// Delete a HoaDon Status from listHDStatusService
	}

	public void Update() {
		// Update HoaDon Status information in listHDStatusService
	}

}
