package com.company;

import java.util.ArrayList;
import java.util.List;

class SearchObjects {
    List<Car> carList = new ArrayList<>();
    List<Bike> bikeList = new ArrayList<>();

    public void getObjects(String value, int id, List<Car> carList, List<Bike> bikeList) {
        switch (id){
            case 0:
                for(Car i: carList){
                    if(i.getBrandName().equals(value))
                        this.carList.add(i);
                }
                for(Bike i: bikeList){
                    if(i.getBrandName().equals(value))
                        this.bikeList.add(i);
                }
                break;
            case 4:
                for(Car i: carList){
                    if(i.getGearType().equals(value))
                        this.carList.add(i);
                }
                for(Bike i: bikeList){
                    if(i.getGearType().equals(value))
                        this.bikeList.add(i);
                }
                break;
        }
    }

    public void getObjects(int value, int id, List<Car> carList, List<Bike> bikeList, String comparisonType) {
        switch (id) {
            case 1:
                for (Car i : carList) {
                    if(getComparison(comparisonType, i.getTyres(), value))
                        this.carList.add(i);
                }
                for (Bike i : bikeList) {
                    if(getComparison(comparisonType, i.getTyres(), value))
                        this.bikeList.add(i);
                }
                break;
            case 5:
                for (Car i : carList) {
                    if(getComparison(comparisonType, i.getYear(), value))
                        this.carList.add(i);
                }
                for (Bike i : bikeList) {
                    if(getComparison(comparisonType, i.getYear(), value))
                        this.bikeList.add(i);
                }
                break;
            case 6:
                for (Car i : carList) {
                    if(getComparison(comparisonType, i.getHp(), value))
                        this.carList.add(i);
                }
                break;
        }
    }

    public void getObjects(boolean value, int id, List<Car> carList, List<Bike> bikeList) {
        switch (id){
            case 2:
                for(Car i: carList){
                    if(i.isElectric() == value)
                        this.carList.add(i);
                }
                for(Bike i: bikeList){
                    if(i.isElectric() == value)
                        this.bikeList.add(i);
                }
                break;
        }
    }

    public void getResult(){
        if(carList.size()>0)
            for(Car i: carList)
                System.out.println(i.getVehicle());
        if(bikeList.size()>0)
            for(Bike i: bikeList)
                System.out.println(i.getVehicle());
        if(carList.size() == 0 && bikeList.size() == 0)
            System.out.println("Objects not found");
    }

    public void resetSearchResult(){
        carList.clear();
        bikeList.clear();
    }

    private boolean getComparison(String comparisonType, int value, int checkValue){
        switch (comparisonType){
            case "==":
                if (value == checkValue)
                    return true;
                break;
            case "!=":
                if (value != checkValue)
                    return true;
                break;
            case "<=":
                if (value <= checkValue)
                    return true;
                break;
            case ">=":
                if (value >= checkValue)
                    return true;
                break;
            case ">":
                if (value > checkValue)
                    return true;
                break;
            case "<":
                if (value < checkValue)
                    return true;
                break;
            default:
                return false;
        }
        return false;
    }

}
