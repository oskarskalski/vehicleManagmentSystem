package com.company;

class Vehicle {
    private String brandName;
    private int tyres;

    Vehicle() {
    }

    Vehicle(String brandName, int tyres) {
        this.brandName = brandName;
        this.tyres = tyres;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getTyres() {
        return tyres;
    }

    public void setTyres(int tyres) {
        this.tyres = tyres;
    }

    public String getVehicle() {
        return "This vehicle has " + tyres + " tyres and it's made by " + brandName;
    }
}