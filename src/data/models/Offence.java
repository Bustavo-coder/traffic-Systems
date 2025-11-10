package data.models;

public enum Offence {
    ONE_WAY(45_000),DRUNK_DRIVING(70_0000),NO_SEAT_BELT(30_000),OVER_SPEEDING(10_000);

    private final int price;
    Offence(int price){
        this.price = price;

    }
}
