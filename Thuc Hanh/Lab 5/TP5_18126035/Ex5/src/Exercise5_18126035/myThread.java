package Exercise5_18126035;

public class myThread implements Runnable {
	private int gioiHan;
	private car[] list_car = new car[2];// do, xanh
	private int status;
	private int coor_boss;
	private int status_boss;

	public int getStatus_boss() {
		return this.status_boss;
	}

	public void setStatus_boss(int status_boss) {
		this.status_boss = status_boss;
	}

	public int getCoor_boss() {
		return this.coor_boss;
	}

	public void setCoor_boss(int coor_boss) {
		this.coor_boss = coor_boss;
	}

	public void setStatus(int tmp) {
		this.status = tmp;
	}

	public int getStatus() {
		return this.status;
	}
	// private int y;

	// public int getCoordinate[][]() {
	// return this.coordinate[][];
	// }

	// public void setCoordinate[][](int coordinate[][]) {
	// this.coordinate[][] = coordinate[][];
	// }

	public myThread() {
		this.list_car[0] = new car(0, 10.0, true);// xe do
		this.list_car[1] = new car(this.gioiHan, 10.0, true);// xe do
	}

	// public myThread(int tmp, int x) {
	// this.gioiHan = tmp;
	// this.x = x;
	// //this.y = y;
	// }
	public myThread(int tmp, int coor_boss) {
		this.coor_boss = coor_boss;
		this.gioiHan = tmp;
	}

	public myThread(int tmp) {
		this.gioiHan = tmp;
	}

	public int getGioiHan() {
		return this.gioiHan;
	}

	public void setGioiHan(int gioiHan) {
		this.gioiHan = gioiHan;
	}

	public car[] getList_car() {
		return this.list_car;
	}

	public void setList_car(car[] list_car) {
		this.list_car = list_car;
	}

	@Override
	public void run() {
		if (Thread.currentThread().getName() != "BOSS") {
			this.list_car[0] = new car(0, 10.0, true);// xe do
			this.list_car[1] = new car(this.gioiHan, 10.0, true);// xe xanh

			while (this.getStatus() != 1 && this.getStatus_boss() != 1 && list_car[0].getCoordinate() < this.gioiHan
					&& list_car[1].getCoordinate() > 0) {

				if (this.list_car[0].getCoordinate() == this.coor_boss) {
					System.out.println("Xe do dung BOSS tai " + this.coor_boss);
					this.setStatus_boss(1);
				} else if (this.list_car[1].getCoordinate() == this.coor_boss) {
					System.out.println("Xe xanh dung BOSS tai " + this.coor_boss);
					this.setStatus_boss(1);
				} else {
					System.out.println("Toa do hien tai cua xe do: " + this.list_car[0].getCoordinate());
					System.out.println("Toa do hien tai cua xe xanh: " + this.list_car[1].getCoordinate());
					System.out.println("Boss coor: " + this.coor_boss);
					this.list_car[0].setCoordinate(this.list_car[0].getCoordinate() + 1);
					this.list_car[1].setCoordinate(this.list_car[1].getCoordinate() - 1);
					if (this.list_car[0].getCoordinate() == this.list_car[1].getCoordinate()) {
						this.setStatus(1);
						System.out.println("Hai xe da dung nhau tai toa do: " + this.list_car[0].getCoordinate());
						this.list_car[0].setCoordinate(0);
						this.list_car[1].setCoordinate(this.gioiHan);
					} else {
						this.setStatus(0);
					}
				}

			}
		} else {

		}

	}
}
