package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int id = -1;

    public static void main(String[] args) {
        GetValues values = new GetValues();
        CreateObj createObj = new CreateObj();
        ReadFile readFile = new ReadFile();
        SaveDataToFile saveDataToFile = new SaveDataToFile();

        List<Bike> bikeObjectsList = new ArrayList<>();
        List<Car> carObjectsList = new ArrayList<>();
        SearchObjects searchObjects = new SearchObjects();

        int type = -1;
        while (type != 0) {
            switch (type) {
                case 1:
                    String fileName = values.getStringValue("Enter full path and file name or -1 to leave");
                    if (fileName.equals("-1"))
                        type = -1;
                    else {
                        readFile.getData(bikeObjectsList, carObjectsList, fileName);
                    }
                    break;
                case 2:
                    for (int i = 0; i < carObjectsList.size(); i++) {
                        System.out.println(i + ". " + carObjectsList.get(i).getVehicle());
                    }
                    for (int i = 0; i < bikeObjectsList.size(); i++) {
                        System.out.println((i + carObjectsList.size()) + ". " + bikeObjectsList.get(i).getVehicle());
                    }

                    type = values.getIntValue("Enter -1 to leave");
                    break;
                case 3:
                    System.out.println("Creating car object");

                    createObj.createELements("Car");
                    createObj.getCar(carObjectsList);

                    type = values.getIntValue("Added! Enter -1 to leave");
                    break;
                case 4:
                    System.out.println("Creating bike object");

                    createObj.createELements("Bike");
                    createObj.getBike(bikeObjectsList);

                    type = values.getIntValue("Added! Enter -1 to leave");
                    break;
                case 5:
                    String saveDataToFileName = values.getStringValue("Enter location where you want to save full informations about objects");
                    try {
                        saveDataToFile.saveData(saveDataToFileName, "", carObjectsList, bikeObjectsList);
                    } catch (IOException e) {
                        System.out.println("The operation has failed");
                    }

                    type = values.getIntValue("Added! Enter -1 to leave");
                    break;
                case 6:
                    String exportDataToFileName = values.getStringValue("Enter path to file or directory where you want to save data");

                    try {
                        saveDataToFile.saveData(exportDataToFileName, "standard", carObjectsList, bikeObjectsList);
                    } catch (IOException e) {
                        System.out.println("The operation has failed");
                    }

                    System.out.println();
                    type = values.getIntValue("Added! Enter -1 to leave");
                    break;
                case 7:
                    if (bikeObjectsList.size() != 0 || carObjectsList.size() != 0) {
                        String objectName; //Car or bike
                        while (type != -1) {
                            if (id == -1)
                                id = values.getIntValue("Enter id of object which you want to edit");


                            if (id < 0 || id >= (bikeObjectsList.size() + carObjectsList.size())) {
                                System.out.println("This element doesn't exist");
                                if (id == -1)
                                    type = -1;
                                else {
                                    type = 7;
                                    id = -1;
                                }
                            } else {
                                if (id >= carObjectsList.size()) {
                                    id -= carObjectsList.size();
                                    objectName = "Bike";
                                } else if (carObjectsList.size() == 0 && bikeObjectsList.size() > 0) {
                                    objectName = "Bike";
                                } else
                                    objectName = "Car";

                                getChooserListOfObjects(objectName, "What do you want to edit now:", "");
                                int num = values.getIntValue("Enter number which element you want to edit");

                                switch (num) {
                                    case 1:
                                        String name = values.getStringValue("Enter brand name");
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setBrandName(name);
                                        else
                                            carObjectsList.get(id).setBrandName(name);
                                        break;
                                    case 2:
                                        int tyres = values.getIntValue("Enter number of tyres");
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setTyres(tyres);
                                        else
                                            carObjectsList.get(id).setTyres(tyres);
                                        break;
                                    case 3:
                                        boolean isElectric = values.getBooleanValue("Enter true/false (is electric?)");
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setElectric(isElectric);
                                        else
                                            carObjectsList.get(id).setElectric(isElectric);
                                        break;
                                    case 4:
                                        String vehicleType = values.getStringValue("Enter type of the vehicle? (for example " +
                                                (objectName.equals("Bike") ? "mountain" : "van") + ")");
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setType(vehicleType);
                                        else
                                            carObjectsList.get(id).setType(vehicleType);
                                        break;
                                    case 5:
                                        String gearType = values.getStringValue("Enter type of " + (objectName.equals("Bike") ?
                                                "derailleur (for example 3x7)" : "gearbox (for example manual)"));
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setGearType(gearType);
                                        else
                                            carObjectsList.get(id).setGearType(gearType);
                                        break;
                                    case 6:
                                        int year = values.getIntValue("Enter production year");
                                        if (objectName.equals("Bike"))
                                            bikeObjectsList.get(id).setYear(year);
                                        else
                                            carObjectsList.get(id).setYear(year);
                                        break;
                                    default:
                                        if (num > 7 || num < 0)
                                            System.out.println("This object doesn't exist");

                                }

                                if (objectName.equals("Car")) {
                                    switch (num) {
                                        case 7:
                                            int hp = values.getIntValue("Enter horsepower");
                                            carObjectsList.get(id).setHp(hp);
                                            break;
                                    }
                                }
                                int finish = values.getIntValue("End of editing. Enter -1 to leave or 7 to edit another object or 0 keep editing the same object");

                                if (finish == -1) {
                                    id = -1;
                                    type = -1;
                                } else if (finish == 0) {
                                    type = 7;
                                } else {
                                    id = -1;
                                    type = 7;
                                }
                            }
                        }
                    } else {
                        System.out.println("There are no objects that you can edit!");
                        type = -1;
                    }
                    break;
                case 8:
                    if (carObjectsList.size() > 0 || bikeObjectsList.size() > 0) {
                        getChooserListOfObjects("Car", "By what element do you want to search?",
                                "(it is only for cars)\n\t8. Reset search\n\t9. Show results");
                        int searchNumber;
                        searchNumber = values.getIntValue("Enter number from list to search");
                        switch (searchNumber) {
                            case 1:
                                String brandName = values.getStringValue("Enter brand name");
                                searchObjects.getObjects(brandName, 0, carObjectsList, bikeObjectsList);
                                break;
                            case 2:
                                int numOfTyres = values.getIntValue("Enter number of tyres");
                                String comparisonType = values.getStringValue("Enter type of comparison(for example >=, ==, <=, !=, <, >)");
                                searchObjects.getObjects(numOfTyres, 1, carObjectsList, bikeObjectsList, comparisonType);
                                break;
                            case 3:
                                boolean isElectric = values.getBooleanValue("Enter true/false (isElectric)");
                                searchObjects.getObjects(isElectric, 2, carObjectsList, bikeObjectsList);
                                break;
                            case 4:
                                String typeOfVehicle = values.getStringValue("Enter type of vehicle");
                                searchObjects.getObjects(typeOfVehicle, 3, carObjectsList, bikeObjectsList);
                                break;
                            case 5:
                                String gearType = values.getStringValue("Enter derailleur/gearBox (for example 3x7 = bike or manual = car");
                                searchObjects.getObjects(gearType, 4, carObjectsList, bikeObjectsList);
                                break;
                            case 6:
                                int year = values.getIntValue("Enter production year");
                                String comparisonType2 = values.getStringValue("Enter type of comparison(for example >=, ==, <=, !=, <, >)");
                                searchObjects.getObjects(year, 5, carObjectsList, bikeObjectsList, comparisonType2);
                                break;
                            case 7:
                                int horsepower = values.getIntValue("Enter horsepower");
                                String comparisonType3 = values.getStringValue("Enter type of comparison(for example >=, ==, <=, !=, <, >)");
                                searchObjects.getObjects(horsepower, 6, carObjectsList, bikeObjectsList, comparisonType3);
                                break;
                            case 8:
                                searchObjects.resetSearchResult();
                                break;
                            case 9:
                                searchObjects.getResult();
                                break;
                        }
                        int exit = values.getIntValue("Enter -1 to leave or other number to go back to the search menu");

                        if (exit == -1)
                            type = -1;
                        else
                            type = 8;

                    } else {
                        System.out.println("There are no objects to search");
                        type = -1;
                    }
                    break;
                case 9:
                    int id = values.getIntValue("Enter id of object which you want delete(id starts from 0) or -1 to leave");
                    if (id == -1) {
                        type = -1;
                    } else if (id < 0 || id >= (bikeObjectsList.size() + carObjectsList.size())) {
                        System.out.println("This object doesn't exist. Try again!");
                        type = 9;
                    } else if (id < carObjectsList.size()) {
                        carObjectsList.remove(id);
                        System.out.println("Removed!");
                        type = -1;
                    } else {
                        bikeObjectsList.remove((id - carObjectsList.size()));
                        System.out.println("Removed!");
                        type = -1;
                    }
                    break;
                case 0:
                    System.out.println("You have ended a program!");
                    System.exit(0);
                    break;
                case -1:
                    getMainScreen();
                    type = values.getIntValue("Enter number");
                    break;
                default:
                    System.out.println("You entered wrong value, try again");
                    type = -1;
                    break;
            }
        }
    }

    private static void getMainScreen() {
        System.out.println("Welcome to vehicle managment system!");

        System.out.println("What do you want to do now");
        System.out.println("\t1. Import data from file");
        System.out.println("\t2. List cars and bikes");
        System.out.println("\t3. Create car object");
        System.out.println("\t4. Create bike object");
        System.out.println("\t5. Save full information to file");
        System.out.println("\t6. Export data to file");
        System.out.println("\t7. Edit object");
        System.out.println("\t8. Search objects");
        System.out.println("\t9. Delete object");
        System.out.println("\t0. Exit");

    }

    private static void getChooserListOfObjects(String objectName, String heading, String searchSection) {
        System.out.println(heading);
        System.out.println("\t-1. Exit");
        System.out.println("\t1. Brand name");
        System.out.println("\t2. Number of tyres");
        System.out.println("\t3. Is electric");
        System.out.println("\t4. Type of vehicle");
        System.out.println("\t5. Gear type");
        System.out.println("\t6. Production date");

        if (objectName.equals("Car")) {
            System.out.println("\t7. Horsepower " + searchSection);
        }
    }

}
