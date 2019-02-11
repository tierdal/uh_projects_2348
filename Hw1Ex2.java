import java.util.Scanner;

public class Hw1Ex2 {

    /*

    TEMPERATURE CONVERSION

    WRITTEN BY EGOR SHUMEYKO

    VERSION 1.00

    LAST REVISION: FEBRUARY 11, 2019

    */

    public static void main(String[] args) {

        //DEFINE LOCAL VARS
        double value_temperature, value_converted;
        int menuSelection_begin, menuSelection_end;
        String menuSwitch = "";
        String menuSwitch1 = "";
        String menuSwitch2 = "";

        //DEFINE SCANNER
        Scanner keyboard = new Scanner(System.in);

        //DISPLAY WELCOME MESSAGE
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("##### WELCOME TO TEMPERATURE CONVERTER #####");
        System.out.println("############################################");
        System.out.println("############################################");

        System.out.println("");
        System.out.println("============================================");
        System.out.println("This program will convert temperatures from ");
        System.out.println("one scale to another.");
        System.out.println("");

        //GET FIRST SELECTION AND ASSIGN A SELECTOR FOR FUTURE
        System.out.println("Please select the initial temperature scale. ");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your selection (number): ");
        menuSelection_begin = keyboard.nextInt();
        switch (menuSelection_begin) {
            case 1:
                menuSwitch1 = "C";
                break;
            case 2:
                menuSwitch1 = "F";
                break;
            case 3:
                menuSwitch1 = "K";
                break;
        }

        //GET SECOND SELECTION AND ASSIGN A SELECTOR FOR FUTURE
        System.out.println("Please select the desired temperature scale. ");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your selection (number): ");
        menuSelection_end = keyboard.nextInt();
        switch (menuSelection_end) {
            case 1:
                menuSwitch2 = "C";
                break;
            case 2:
                menuSwitch2 = "F";
                break;
            case 3:
                menuSwitch2 = "K";
                break;
        }

        //ASK FOR THE VALUE TO CONVERT
        System.out.println("");
        System.out.print("Please enter the temperature for conversion: ");
        value_temperature = keyboard.nextInt();

        //COMBINE THE SELECTORS AND PICK CORRECT FORMULA FOR CALCULATION
        //OUTPUT RESULT THEN TERMINATE APP
        menuSwitch = menuSwitch1 + menuSwitch2;
        switch (menuSwitch) {
            case "CF":
                value_converted = ((value_temperature * 9) / 5) + 32;
                System.out.println("");
                System.out.println("Celsius to Fahrenheit");
                System.out.println("---------------------");
                System.out.println(value_temperature + "C is " + value_converted + "F");
                break;
            case "CK":
                value_converted = value_temperature + 273.15;
                System.out.println("");
                System.out.println("Celsius to Kelvin");
                System.out.println("---------------------");
                System.out.println(value_temperature + "C is " + value_converted + "K");
                break;
            case "FC":
                value_converted = ((value_temperature - 32) * 5) / 9;
                System.out.println("");
                System.out.println("Fahrenheit to Celsius");
                System.out.println("---------------------");
                System.out.println(value_temperature + "F is " + value_converted + "C");
                break;
            case "FK":
                value_converted = (((value_temperature - 32) * 5) / 9) + 273.15;
                System.out.println("");
                System.out.println("Fahrenheit to Kelvin");
                System.out.println("---------------------");
                System.out.println(value_temperature + "F is " + value_converted + "K");
                break;
            case "KC":
                value_converted = value_temperature - 273.15;
                System.out.println("");
                System.out.println("Kelvin to Celsius");
                System.out.println("---------------------");
                System.out.println(value_temperature + "K is " + value_converted + "C");
                break;
            case "KF":
                value_converted = (((value_temperature - 273.15) * 9) / 5) +32;
                System.out.println("");
                System.out.println("Kelvin to Fahrenheit");
                System.out.println("---------------------");
                System.out.println(value_temperature + "K is " + value_converted + "F");
                break;
            default:
                System.out.println("");
                System.out.println("Nothing to Convert");
                System.out.println("---------------------");
                break;
        }

        //TERMINATE
    }
}
