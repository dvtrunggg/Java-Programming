package Exercice4_18126035;

public class matrix {
	private int soDong;
	private int soCot;
	private int data[][] = new int[soDong][soCot];

	public matrix() {
	}

	public matrix(int soDong, int soCot) {
		this.soDong = soDong;
		this.soCot = soCot;
	}

	public int getSoDong() {
		return soDong;
	}

	public void setSoDong(int soDong) {
		this.soDong = soDong;
	}

	public int getSoCot() {
		return soCot;
	}

	public void setSoCot(int soCot) {
		this.soCot = soCot;
	}

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	public void xuat() {
		for (int i = 0; i < this.soDong; i++) {
			for (int j = 0; j < this.soCot; j++) {
				System.out.print(this.data[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
