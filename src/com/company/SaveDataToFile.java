package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveDataToFile {
    private GetValues getValues = new GetValues();

    void saveData(String filename, String type, List<Car> carObj, List<Bike> bikeObj) throws IOException {
        File file = new File(filename);
        if (file.exists()) {
            int number2 = getValues.getIntValue("The file " + filename + " already exists. Press 1 to override file or Press 2 to append text");
            switch (number2) {
                case 1:
                    PrintWriter printWriter = new PrintWriter(file);
                    saveDataWithPrintWriter(type, carObj, bikeObj, printWriter);

                    printWriter.close();

                    break;
                case 2:
                    FileWriter fileWriter = new FileWriter(file, true);

                    saveDataWithFileWriter(type, carObj, bikeObj, fileWriter);

                    fileWriter.close();
                    break;
            }
        } else {
            PrintWriter printWriter = new PrintWriter(file);
            saveDataWithPrintWriter(type, carObj, bikeObj, printWriter);
            printWriter.close();
        }
    }

    private void saveDataWithPrintWriter(String type, List<Car> carObj, List<Bike> bikeObj, PrintWriter pw){
        if(type.equals("standard")){
            for (Car i : carObj) {
                pw.println("Car " + i.getBrandName() + " " + i.getTyres() + " " + i.isElectric() + " " +
                        i.getType() + " " + i.getGearType() + " " + i.getYear() + " " + i.getHp());
            }

            for (Bike i : bikeObj) {
                pw.println("Bike " + i.getBrandName() + " " + i.getTyres() + " " + i.isElectric() + " " +
                        i.getType() + " " + i.getGearType() + " " + i.getYear());
            }
        }else{
            for (Car i : carObj) {
                pw.println(i.getVehicle());
            }

            for (Bike i : bikeObj) {
                pw.println(i.getVehicle());
            }
        }
    }
    private void saveDataWithFileWriter(String type, List<Car> carObj, List<Bike> bikeObj, FileWriter fw) throws IOException {
        if(type.equals("standard")){
            for (Car i : carObj) {
                fw.append("Car " + i.getBrandName() + " " + i.getTyres() + " " + i.isElectric() + " " +
                        i.getType() + " " + i.getGearType() + " " + i.getYear() + " " + i.getHp() + "\n");
            }

            for (Bike i : bikeObj) {
                fw.append("Bike " + i.getBrandName() + " " + i.getTyres() + " " + i.isElectric() + " " +
                        i.getType() + " " + i.getGearType() + " " + i.getYear() + "\n");
            }
        }else{
            for (Car i : carObj) {
                fw.append(i.getVehicle() + "\n");
            }

            for (Bike i : bikeObj) {
                fw.append(i.getVehicle() + "\n");
            }
        }
    }
}
