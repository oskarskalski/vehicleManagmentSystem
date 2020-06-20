package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

class GetValues {
    private Scanner getInt = new Scanner(System.in);
    private Scanner getBoolean = new Scanner(System.in);
    private Scanner getString = new Scanner(System.in);

    public int getIntValue(String heading) {
        boolean isTrue = true;
        int numOfErrors = 0;
        int value = 0;
        while (isTrue) {
            System.out.println(heading);
            try {
                value = getInt.nextInt();

                if (value < 0 && value != -1) {
                    isTrue = true;
                    heading = "You entered a wrong value. " + heading + " again";
                } else {
                    isTrue = false;
                }
            } catch (InputMismatchException e) {
                isTrue = true;
                getInt.nextLine();

                if (numOfErrors == 0) {
                    heading = "You entered a wrong value. " + heading + " again";
                    numOfErrors++;
                }
            }
        }
        return value;
    }

    public String getStringValue(String heading) {
        System.out.println(heading);
        String value = getString.nextLine();
        return value;
    }

    public boolean getBooleanValue(String heading) {
        boolean isTrue = true;
        int numOfErrors = 0;
        boolean value = false;
        while (isTrue) {
            System.out.println(heading);
            try {
                value = getBoolean.nextBoolean();

                isTrue = false;
            } catch (InputMismatchException e) {
                isTrue = true;
                getBoolean.nextLine();

                if (numOfErrors == 0) {
                    heading = "You entered a wrong value. " + heading + "again";
                    numOfErrors++;
                }
            }
        }
        return value;
    }
}
