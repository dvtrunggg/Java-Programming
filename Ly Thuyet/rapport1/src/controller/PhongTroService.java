package controller;

import java.util.ArrayList;

import entity.PhongTro;

public class PhongTroService {
	private ArrayList<PhongTro> listPhong;

	public PhongTroService() {
		listPhong = new ArrayList<>();
	}

	public ArrayList<PhongTro> getListPhong() {
		return listPhong;
	}

	public void setListPhong(ArrayList<PhongTro> listPhong) {
		this.listPhong = listPhong;
	}

	// search PhongTro by using id PhongTro from listPhongTro
	public void findByID(int id) {
		// using linear search.

	}

	public void Insert() {
		// insert a PhongTro to PhongTroService (PhongTroService is a list)
	}

	public void Delete() {
		// Delete a PhongTro from PhongTroService (PhongTroService is a list)
	}

	public void Update() {
		// Update PhongTro information in PhongTroService (PhongTroService is a list)
	}
}
