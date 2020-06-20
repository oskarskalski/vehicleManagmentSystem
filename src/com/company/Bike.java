package com.company;

class Bike extends Vehicle {
    private boolean isElectric;
    private String type;
    private String gearType;
    private int year;

    Bike(String brandName, int tyres, boolean isElectric, String type, String gearType, int year) {
        super(brandName, tyres);

        this.isElectric = isElectric;
        this.type = type;
        this.gearType = gearType;
        this.year = year;
    }

    Bike() {
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getVehicle() {
        return "Description about bike object: " +
                "\n\t Brand name = " + getBrandName() +
                "\n\t Number of tyres = " + getTyres() +
                "\n\t Is electric = " + isElectric() +
                "\n\t Type of vehicle = " + getType() +
                "\n\t Type of derailleur = " + getGearType() +
                "\n\t Production Year = " + getYear();
    }

}