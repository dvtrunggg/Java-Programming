package Exercise5_18126035;

public class car {
    private int coordinate;
    private double velocity;
    private boolean status;

    public int getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public double getVelocity() {
        return this.velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public car(int coordinate, double velocity, boolean status) {
        this.coordinate = coordinate;
        this.velocity = velocity;
        this.status = status;
    }

    public car() {
    }

}
