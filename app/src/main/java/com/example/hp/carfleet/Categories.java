package com.example.hp.carfleet;

public class Categories {

    enum category
    {
        Economy,
        Compact,
        Standard,
        Intermediate,
        Fullsize,
        Premium,
        Luxury,
        Mini,
        Special
    }

    enum type
    {
        Wagon,
        PassengerVan,
        Limousine,
        Sport,
        Convertible,
        Special,
        PickUp,
        TwoWheeled,
        Monospace,
        Crossover
    }

    enum transmission
    {
        Automatic,
        Manual
    }

    enum fuel
    {
        AirConditioning,
        NoAirConditioning,
        Hybrid,
        Ethanol
    }


    private String Id;
    private category Category;
    private type Type;
    private transmission Transmission;
    private fuel Fuel;
    private int PlaceNumber;

    public Categories() {
    }

    public Categories(String id, category category, type type, transmission transmission, fuel fuel, int placeNumber) {
        Id = id;
        Category = category;
        Type = type;
        Transmission = transmission;
        Fuel = fuel;
        PlaceNumber = placeNumber;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public category getCategory() {
        return Category;
    }

    public void setCategory(category category) {
        Category = category;
    }

    public type getType() {
        return Type;
    }

    public void setType(type type) {
        Type = type;
    }

    public transmission getTransmission() {
        return Transmission;
    }

    public void setTransmission(transmission transmission) {
        Transmission = transmission;
    }

    public fuel getFuel() {
        return Fuel;
    }

    public void setFuel(fuel fuel) {
        Fuel = fuel;
    }

    public int getPlaceNumber() {
        return PlaceNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        PlaceNumber = placeNumber;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "Id='" + Id + '\'' +
                ", Category=" + Category +
                ", Type=" + Type +
                ", Transmission=" + Transmission +
                ", Fuel=" + Fuel +
                ", PlaceNumber=" + PlaceNumber +
                '}';
    }
}
