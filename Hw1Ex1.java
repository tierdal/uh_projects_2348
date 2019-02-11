import java.util.Scanner;

public class Hw1Ex1 {

    /*

    SHAPE AREA CALCULATOR

    WRITTEN BY EGOR SHUMEYKO

    VERSION 1.00

    LAST REVISION: FEBRUARY 11, 2019

    */

    public static void main(String[] args) {

        //WRAP THE ENTIRE RUNTIME IN A WHILE LOOP
        //IT WILL DECIDE WHETHER TO REPEAT THE FUNCTION OR EXIT

        //DEFINE INIT RUNTIME AS TRUE
        boolean programRuntime = true;

        //DEFINE LOCAL VARS
        double width, base_width, height, area, radius, radius2;
        int menuSelection, exitApp;
        boolean exitSwitch = true;

        //DEFINE SCANNER
        Scanner keyboard = new Scanner(System.in);

        //DISPLAY WELCOME MESSAGE
        System.out.println("############################################");
        System.out.println("############################################");
        System.out.println("### WELCOME TO THE SHAPE AREA CALCULATOR ###");
        System.out.println("############################################");
        System.out.println("############################################");

        while (programRuntime) {
            //PRINT MAIN MENU
            System.out.println("");
            System.out.println("Please select one of the options below:");
            System.out.println("");
            System.out.println("1. Area of a Square");
            System.out.println("2. Area of a Rectangle");
            System.out.println("3. Area of a Trapezoid");
            System.out.println("4. Area of a Parallelogram");
            System.out.println("5. Area of a Triangle");
            System.out.println("6. Area of a Ellipse");
            System.out.println("7. Area of a Circle");
            System.out.println("");
            System.out.println("0. EXIT APP");
            System.out.println("");

            //READ MAIN MENU SELECTION
            System.out.print("Enter your selection (number): ");

            //FOR VALIDATION OF INPUT
            //THIS WHILE LOOP WAS COPIED FROM https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
            while (!keyboard.hasNextInt()) {
                System.out.println("ERROR: INVALID ENTRY, PLEASE TRY AGAIN");
                keyboard.next();
            }
            menuSelection = keyboard.nextInt();

            //SWITCH FOR INDIVIDUAL OPTIONS
            switch (menuSelection) {
                case 0:
                    //EXIT APP
                    exitSwitch = false;
                    programRuntime = false;
                    break;
                case 1:
                    //SQUARE
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A SQUARE");
                    System.out.println("");
                    System.out.print("Please enter the width of the side: ");
                    width = keyboard.nextDouble();
                    area = width * width;
                    System.out.println(" > The area of the square with side width");
                    System.out.println(" > of " + width + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 2:
                    //RECTANGLE
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A RECTANGLE");
                    System.out.println("");
                    System.out.print("Please enter the width: ");
                    width = keyboard.nextDouble();
                    System.out.print("Please enter the height: ");
                    height = keyboard.nextDouble();
                    area = width * height;
                    System.out.println(" > The area of the rectangle with width of " + width);
                    System.out.println(" > and height of " + height + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 3:
                    //TRAPEZOID
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A TRAPEZOID");
                    System.out.println("");
                    System.out.print("Please enter the base width: ");
                    base_width = keyboard.nextDouble();
                    System.out.print("Please enter the top width: ");
                    width = keyboard.nextDouble();
                    System.out.print("Please enter the height: ");
                    height = keyboard.nextDouble();
                    area = ((base_width + width)/2) * height;
                    System.out.println(" > The area of the trapezoid with base width of " + base_width + ", top");
                    System.out.println(" > width of " + width + "and height of " + height + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 4:
                    //PARALLELOGRAM
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A PARALLELOGRAM");
                    System.out.println("");
                    System.out.print("Please enter the base width: ");
                    base_width = keyboard.nextDouble();
                    System.out.print("Please enter the height: ");
                    height = keyboard.nextDouble();
                    area = base_width * height;
                    System.out.println(" > The area of the parallelogram with base width of " + base_width);
                    System.out.println(" > and height of " + height + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 5:
                    //TRIANGLE
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A TRIANGLE");
                    System.out.println("");
                    System.out.print("Please enter the base width: ");
                    base_width = keyboard.nextDouble();
                    System.out.print("Please enter the height: ");
                    height = keyboard.nextDouble();
                    area = (base_width * height)/2;
                    System.out.println(" > The area of the triangle with base width of " + base_width);
                    System.out.println(" > and height of " + height + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 6:
                    //ELLIPSE
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A ELLIPSE");
                    System.out.println("");
                    System.out.print("Please enter the radius of the long side: ");
                    radius = keyboard.nextDouble();
                    System.out.print("Please enter the radius of the short side: ");
                    radius2 = keyboard.nextDouble();
                    area = Math.PI * radius * radius2;
                    System.out.println(" > The area of the ellipse with radius of the long side of " + radius);
                    System.out.println(" > and radius of the short side of " + radius2 + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                case 7:
                    //CIRCLE
                    System.out.println("=======================================================");
                    System.out.println("CALCULATE AREA OF A CIRCLE");
                    System.out.println("");
                    System.out.print("Please enter the radius: ");
                    radius = keyboard.nextDouble();
                    area = Math.PI * radius;
                    System.out.println(" > The area of the circle with radius");
                    System.out.println(" > of " + radius + " is equal to " + area);
                    System.out.println("=======================================================");
                    System.out.println("");
                    break;
                default:
                    //IF INVALID ENTRY THEN
                    System.out.println("ERROR: INVALID ENTRY, PLEASE TRY AGAIN");
                    break;

            }

            //EXIT STATEMENT
            //IF CALLED AFTER CALCULATION IT WILL ASK FOR OPTIONS
            //IF CALLED FROM MAIN MENU IT WILL JUST EXIT
            if (exitSwitch == true) {
                System.out.println("What would you like to do next?");
                System.out.println("");
                System.out.println("1. Calculate another Shape Area");
                System.out.println("2. Exit App");
                System.out.println("");

                System.out.print("Enter your selection (number): ");

                //FOR VALIDATION OF INPUT
                //THIS WHILE LOOP WAS COPIED FROM https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
                while (!keyboard.hasNextInt()) {
                    System.out.println("ERROR: INVALID ENTRY, PLEASE TRY AGAIN");
                    keyboard.next();
                }
                exitApp = keyboard.nextInt();

                switch (exitApp) {
                    case 1:
                        programRuntime = true;
                        break;
                    case 2:
                        programRuntime = false;
                        break;
                }

            } else {
                //MAKE SURE TO BREAK THE LOOP IF ANYTHING
                programRuntime = false;
            }
        }
        //TERMINATE
    }
}
