import java.util.ArrayList; //https://stackoverflow.com/questions/9342859/i-need-to-find-a-integer-data-in-arraylist
import java.util.Random;
import java.util.Arrays; //https://study.com/academy/lesson/how-to-sort-an-array-in-java.html

public class Powerball {
    //properties

    //1-69
    public int ball_1;
    public int ball_2;
    public int ball_3;
    public int ball_4;
    public int ball_5;

    //1-26
    public int powerball;

    public void play(int play_1,int play_2,int play_3,int play_4,int play_5,int play_powerball, boolean roll_until_win){
        boolean play_result_1 = false,play_result_2 = false,play_result_3 = false,play_result_4 = false,play_result_5 = false,win_powerball = false,win = false;
        String winning_numbers = "",winning_message_numbers = "";
        int win_counter = 0, roll_counter = 0;

        System.out.println("Your Numbers: " + play_1 + " " + play_2 + " " + play_3 + " " + play_4 + " " + play_5 + " Powerball: " + play_powerball);

        //build two arrays
        int [] ball_array = new int[5];
        int [] play_array = new int[5];

        play_array[0] = play_1;
        play_array[1] = play_2;
        play_array[2] = play_3;
        play_array[3] = play_4;
        play_array[4] = play_5;
        ball_array[0] = ball_1;
        ball_array[1] = ball_2;
        ball_array[2] = ball_3;
        ball_array[3] = ball_4;
        ball_array[4] = ball_5;

        Arrays.sort(play_array);
        Arrays.sort(ball_array);

        if (!roll_until_win) {
            //roll - single play

            ArrayList<Integer> ball_list = new ArrayList<>(); //https://stackoverflow.com/questions/9342859/i-need-to-find-a-integer-data-in-arraylist
            ball_list.add(ball_array[0]);
            ball_list.add(ball_array[1]);
            ball_list.add(ball_array[2]);
            ball_list.add(ball_array[3]);
            ball_list.add(ball_array[4]);

            if (ball_list.contains(play_array[0])) {
                play_result_1 = true;
                winning_message_numbers = winning_message_numbers + Integer.toString(play_array[0]);
                win_counter++;
            }
            if (play_result_1) {winning_message_numbers = winning_message_numbers + " ";}
            if (ball_list.contains(play_array[1])) {
                play_result_2 = true;
                winning_message_numbers = winning_message_numbers + Integer.toString(play_array[1]);
                win_counter++;
            }
            if (play_result_2) {winning_message_numbers = winning_message_numbers + " ";}
            if (ball_list.contains(play_array[2])) {
                play_result_3 = true;
                winning_message_numbers = winning_message_numbers + Integer.toString(play_array[2]);
                win_counter++;
            }
            if (play_result_3) {winning_message_numbers = winning_message_numbers + " ";}
            if (ball_list.contains(play_array[3])) {
                play_result_4 = true;
                winning_message_numbers = winning_message_numbers + Integer.toString(play_array[3]);
                win_counter++;
            }
            if (play_result_4) {winning_message_numbers = winning_message_numbers + " ";}
            if (ball_list.contains(play_array[4])) {
                play_result_5 = true;
                winning_message_numbers = winning_message_numbers + Integer.toString(play_array[4]);
                win_counter++;
            }
            if (play_result_5) {winning_message_numbers = winning_message_numbers + " ";}
            if (powerball == play_powerball) {
                win_powerball = true;
                winning_message_numbers = winning_message_numbers + "Powerball: " + Integer.toString(powerball);
                win_counter++;
            }

            if (play_result_1 || play_result_2 || play_result_3 || play_result_4 || play_result_5 || win_powerball) {
                winning_numbers = "Congratulations, you matched " + win_counter + " number(s)! Your matching number(s) are: " + winning_message_numbers;
                System.out.println(winning_numbers);
            } else {
                System.out.println("Sorry, you didn't win. Better luck next time!");
            }
        } else if (roll_until_win) {
            //roll - until you win

            while (!win) {
                roll_ball();
                roll_counter++;

                ball_array[0] = ball_1;
                ball_array[1] = ball_2;
                ball_array[2] = ball_3;
                ball_array[3] = ball_4;
                ball_array[4] = ball_5;

                Arrays.sort(ball_array);

                if (ball_array[0] == play_array[0]) {
                    play_result_1 = true;
                } else {play_result_1 = false;}
                if (ball_array[1] == play_array[1]) {
                    play_result_2 = true;
                } else {play_result_2 = false;}
                if (ball_array[2] == play_array[2]) {
                    play_result_3 = true;
                } else {play_result_3 = false;}
                if (ball_array[3] == play_array[3]) {
                    play_result_4 = true;
                } else {play_result_4 = false;}
                if (ball_array[4] == play_array[4]) {
                    play_result_5 = true;
                } else {play_result_5 = false;}
                if (powerball == play_powerball) {
                    win_powerball = true;
                } else {win_powerball = false;}

                if (play_result_1 && play_result_2 && play_result_3 && play_result_4 && play_result_5 && win_powerball) {
                    System.out.println("Winning Numbers: " + ball_1 + " " + ball_2 + " " + ball_3 + " " + ball_4 + " " + ball_5 + " Powerball: " + powerball);
                    System.out.println("Congratulations, you finally won and matched all numbers! It took " + roll_counter + " rolls!");
                    win = true;
                }
            }
        }
    }

    public void roll_ball(){
        boolean ball_1_roll = false,ball_2_roll = false,ball_3_roll = false,ball_4_roll = false,ball_5_roll = false,powerball_roll = false;

        Random rnd = new Random();

        while (!ball_1_roll) {
            ball_1 = rnd.nextInt(69);
            if (ball_1 > 0) {
                ball_1_roll = true;
            }
        }
        while (!ball_2_roll) {
            ball_2 = rnd.nextInt(69);
            if (ball_2 > 0 && ball_2 != ball_1) {
                ball_2_roll = true;
            }
        }
        while (!ball_3_roll) {
            ball_3 = rnd.nextInt(69);
            if (ball_3 > 0 && ball_3 != ball_1 && ball_3 != ball_2) {
                ball_3_roll = true;
            }
        }
        while (!ball_4_roll) {
            ball_4 = rnd.nextInt(69);
            if (ball_4 > 0 && ball_4 != ball_1 && ball_4 != ball_2 && ball_4 != ball_3) {
                ball_4_roll = true;
            }
        }
        while (!ball_5_roll) {
            ball_5 = rnd.nextInt(69);
            if (ball_5 > 0 && ball_5 != ball_1 && ball_5 != ball_2 && ball_5 != ball_3 && ball_5 != ball_4) {
                ball_5_roll = true;
            }
        }
        powerball = rnd.nextInt(26);
    }
}

