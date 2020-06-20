package com.company;

import java.util.List;

class CreateObj {
    private GetValues values = new GetValues();
    private String brandName;
    private int numOfTyres;
    private String vehicleType;
    private String gearType;
    private int productionYear;
    private boolean isElectric;
    private int hp;

    public void createELements(String type){
        brandName = values.getStringValue("Enter brand name");

        numOfTyres = values.getIntValue("Enter number of tyres");

        vehicleType = values.getStringValue("Enter type of vehicle");

        gearType = values.getStringValue("Enter type of " + (type.equals("Bike") ?
                "derailleur (for example 3x7)" : "gearbox (for example manual)"));

        productionYear = values.getIntValue("Enter production year");

        isElectric = values.getBooleanValue("Enter true/false (is electric)");

        if(type.equals("Car"))
            hp = values.getIntValue("Enter horsepower");

        if(brandName.equals("")){
            brandName = null;
        }

        if(vehicleType.equals("")){
            vehicleType = null;
        }

        if(gearType.equals("")){
            gearType = null;
        }
    }

    public void getCar(List<Car> obj){
        obj.add(new Car(brandName, numOfTyres, isElectric, vehicleType, gearType, productionYear, hp));
    }

    public void getBike(List<Bike> obj){
        obj.add(new Bike(brandName, numOfTyres, isElectric, vehicleType, gearType, productionYear));
    }
}
