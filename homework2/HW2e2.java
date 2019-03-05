import java.util.Scanner;

public class HW2e2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This function will take a Dollar value and it will be broken down into change.");
        System.out.println();
        System.out.print("Enter Dollar amount: ");
        double value_to_convert = sc.nextDouble();
        System.out.println();
        System.out.println();

        int count_100 = 0, count_50 = 0, count_20 = 0, count_10 = 0, count_5 = 0, count_1 = 0, count_025 = 0, count_010 = 0, count_005 = 0, count_001 = 0;

        while (value_to_convert >= 100) {
            count_100++;
            value_to_convert = value_to_convert - 100;
        }
        while (value_to_convert >= 50) {
            count_50++;
            value_to_convert = value_to_convert - 50;
        }
        while (value_to_convert >= 20) {
            count_20++;
            value_to_convert = value_to_convert - 20;
        }
        while (value_to_convert >= 10) {
            count_10++;
            value_to_convert = value_to_convert - 10;
        }
        while (value_to_convert >= 5) {
            count_5++;
            value_to_convert = value_to_convert - 5;
        }
        while (value_to_convert >= 1) {
            count_1++;
            value_to_convert = value_to_convert - 1;
        }
        while (value_to_convert >= 0.25) {
            count_025++;
            value_to_convert = value_to_convert - 0.25;
        }
        while (value_to_convert >= 0.10) {
            count_010++;
            value_to_convert = value_to_convert - 0.10;
        }
        while (value_to_convert >= 0.05) {
            count_005++;
            value_to_convert = value_to_convert - 0.05;
        }
        while (value_to_convert >= 0) {
            count_001++;
            value_to_convert = value_to_convert - 0.01;
        }

        System.out.println("Below is your breakdown.");
        System.out.println("Number of $100 Bills: " + count_100);
        System.out.println("Number of $50 Bills: " + count_50);
        System.out.println("Number of $20 Bills: " + count_20);
        System.out.println("Number of $10 Bills: " + count_10);
        System.out.println("Number of $5 Bills: " + count_5);
        System.out.println("Number of $1 Bills: " + count_1);
        System.out.println("Number of $0.25 Coins: " + count_025);
        System.out.println("Number of $0.10 Coins: " + count_010);
        System.out.println("Number of $0.5 Coins: " + count_005);
        System.out.println("Number of $0.1 Coins: " + count_001);
    }
}
