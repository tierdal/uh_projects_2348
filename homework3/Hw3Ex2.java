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

        Powerball Roll_1 = new Powerball();
        Roll_1.roll_ball();

        System.out.println("Winning Numbers: " + Roll_1.ball_1 + " " + Roll_1.ball_2 + " " + Roll_1.ball_3 + " " + Roll_1.ball_4 + " " + Roll_1.ball_5 + " Powerball: " + Roll_1.powerball);

        Roll_1.play(play_1,play_2,play_3,play_4,play_5,play_powerball);

    }
}