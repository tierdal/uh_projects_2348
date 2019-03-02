import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {

        double radius = 4.3;
        double height = 6.2;

        Scanner sc = new Scanner(System.in);

        System.out.println("This function will calculate either the volume or the surface area of a Right Circular Cone.");
        System.out.println("Please select what you want to do:");
        System.out.println("Enter 0 if you want to calculate the Surface Area.");
        System.out.println("Enter 1 if you want to calculate the Volume.");
        System.out.println();
        System.out.print("Enter your selection: ");

        int menu_selector = sc.nextInt();

        switch(menu_selector) {
            case 0:
                double calcSA_result = calcSA(radius, height);
                System.out.println(calcSA_result);
                break;
            case 1:
                double calcVol_result = calcVol(radius, height);
                System.out.println(calcVol_result);
                break;
            default:
                System.out.println("Invalid selection! Exiting...");
                break;
        }
    }
    public static double calcVol(double radius, double height){
        double volume = Math.PI * Math.pow(radius, 2) * (height / 3);
        return volume;
    }
    public static double calcSA(double radius, double height) {
        double surface_area = Math.PI * radius * (radius + Math.sqrt((Math.pow(height, 2) + (Math.pow(radius, 2)))));
        return surface_area;
    }
}
