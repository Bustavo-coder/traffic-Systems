package trafficSystem.data.models;

public enum Offence {
    ONE_WAY(45_000),DRUNK_DRIVING(70_0000),NO_SEAT_BELT(30_000),OVER_SPEEDING(10_000);

    public final double price;
    Offence(double price){
        this.price = price;
    }

}
