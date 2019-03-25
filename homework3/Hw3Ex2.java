import java.util.Scanner;

public class Hw3Ex2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your numbers below. Regular Balls are 1 - 69 and Powerball is 1 - 26.");
        System.out.print("Ball 1: ");
        int play_1 = sc.nextInt();
        System.out.print("Ball 2: ");
        int play_2 = sc.nextInt();
        System.out.print("Ball 3: ");
        int play_3 = sc.nextInt();
        System.out.print("Ball 4: ");
        int play_4 = sc.nextInt();
        System.out.print("Ball 5: ");
        int play_5 = sc.nextInt();
        System.out.print("Powerball: ");
        int play_powerball = sc.nextInt();

        System.out.print("Do you want to roll until match (WARNING - MIGHT TAKE A LONG TIME) [True | False]: ");
        boolean roll_until_win = sc.nextBoolean();

        Powerball Roll = new Powerball();
        Roll.roll_ball();

        if (!roll_until_win) {
            System.out.println("Winning Numbers: " + Roll.ball_1 + " " + Roll.ball_2 + " " + Roll.ball_3 + " " + Roll.ball_4 + " " + Roll.ball_5 + " Powerball: " + Roll.powerball);
        }

        Roll.play(play_1,play_2,play_3,play_4,play_5,play_powerball,roll_until_win);

    }
}