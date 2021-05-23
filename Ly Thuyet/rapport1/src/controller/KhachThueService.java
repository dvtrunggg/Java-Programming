package controller;

import java.util.ArrayList;

import entity.KhachThue;

public class KhachThueService {
	private ArrayList<KhachThue> listKhachThue;

	public KhachThueService() {
		listKhachThue = new ArrayList<>();

	}

	public ArrayList<KhachThue> getListKhachThue() {
		return listKhachThue;
	}

	public void setListKhachThue(ArrayList<KhachThue> listKhachThue) {
		this.listKhachThue = listKhachThue;
	}

	// search KhachThue by using id KhachThue from listKhachThue
	public void findByID(int id) {
		// using linear search.

	}

	public void Insert() {
		// insert a KhachThue to KhachThueService (KhachThueService is a list)
	}

	public void Delete() {
		// Delete a KhachThue from KhachThueService (KhachThueService is a list)
	}

	public void Update() {
		// Update KhachThue information in KhachThueService (KhachThueService is a list)
	}
}
