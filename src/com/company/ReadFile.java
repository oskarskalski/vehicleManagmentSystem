package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadFile {
    void getData(List<Bike> bikeObjectsList, List<Car> carObjectsList, String fileName){
        File file = new File(fileName);

        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                int r = 0;
                StringBuilder sb = new StringBuilder();
                List<String> test = new ArrayList<>();
                while ((r = fis.read()) != -1) {
                    if (r == 10) {
                        if (test.get(0).equals("Car")) {
                            Car objectCar = new Car(test.get(1), Integer.parseInt(test.get(2)), Boolean.parseBoolean(test.get(3)),
                                    test.get(4), test.get(5), Integer.parseInt(test.get(6)), Integer.parseInt(test.get(7)));
                            carObjectsList.add(objectCar);
                        } else if (test.get(0).equals("Bike")) {
                            Bike objectBike = new Bike(test.get(1), Integer.parseInt(test.get(2)), Boolean.parseBoolean(test.get(3)),
                                    test.get(4), test.get(5), Integer.parseInt(test.get(6)));
                            bikeObjectsList.add(objectBike);
                        }
                        test.clear();
                        sb.setLength(0);
                    } else if (r == 32 || r == 13) {
                        test.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        if (r != 10)
                            sb.append((char) r);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("This file doesn't exist");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            System.out.println("Added!");
        } else
            System.out.println("This file doesn't exist");
    }
}
