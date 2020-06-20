package com.company;

class Car extends Bike {
    private int hp;

    Car(String brandName, int tyres, boolean isElectric, String type, String gearType, int year, int hp) {
        super(brandName, tyres, isElectric, type, gearType, year);

        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String getVehicle() {
        return "Description about car object: " +
                "\n\t Brand name = " + getBrandName() +
                "\n\t Number of tyres = " + getTyres() +
                "\n\t Is electric = " + isElectric() +
                "\n\t Type of vehicle = " + getType() +
                "\n\t Type of derailleur = " + getGearType() +
                "\n\t Production Year = " + getYear() +
                "\n\t Horsepower = " + getHp();
    }
}