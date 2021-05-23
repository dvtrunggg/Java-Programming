package controller;

import java.util.ArrayList;

import entity.HoaDon;

public class HoaDonService {
	private ArrayList<HoaDon> listHoaDon;

	public HoaDonService() {
		listHoaDon = new ArrayList<>();
	}

	public ArrayList<HoaDon> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

//search HoaDon by using id HoaDon from listHoaDon
	public void findByID(int id) {
		// using linear search.

	}

	public void Insert() {
		// insert a HoaDon to HoaDonService (HoaDonService is a list)
	}

	public void Delete() {
		// Delete a HoaDon from HoaDonService (HoaDonService is a list)
	}

	public void Update() {
		// Update HoaDon information in HoaDonService (HoaDonService is a list)
	}

}
