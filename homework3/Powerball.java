import java.util.Random;
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

    public void play(int play_1,int play_2,int play_3,int play_4,int play_5,int play_powerball){
        boolean play_result_1 = false,play_result_2 = false,play_result_3 = false,play_result_4 = false,play_result_5 = false,play_result_powerball = false,win = false;
        String winning_numbers = "",winning_message_numbers = "";
        int win_counter = 0;

        System.out.println("Your Numbers: " + play_1 + " " + play_2 + " " + play_3 + " " + play_4 + " " + play_5 + " Powerball: " + play_powerball);

        if (ball_1 == play_1 || ball_1 == play_2 || ball_1 == play_3 || ball_1 == play_4 || ball_1 == play_5){
            play_result_1 = true;
            winning_message_numbers = winning_message_numbers + Integer.toString(ball_1);
            win_counter++;
        }
        if (play_result_1) {winning_message_numbers = winning_message_numbers + " ";}
        if (ball_2 == play_1 || ball_2 == play_2 || ball_2 == play_3 || ball_2 == play_4 || ball_2 == play_5){
            play_result_2 = true;
            winning_message_numbers = winning_message_numbers + Integer.toString(ball_1);
            win_counter++;
        }
        if (play_result_2) {winning_message_numbers = winning_message_numbers + " ";}
        if (ball_3 == play_1 || ball_3 == play_2 || ball_3 == play_3 || ball_3 == play_4 || ball_3 == play_5){
            play_result_3 = true;
            winning_message_numbers = winning_message_numbers + Integer.toString(ball_1);
            win_counter++;
        }
        if (play_result_3) {winning_message_numbers = winning_message_numbers + " ";}
        if (ball_4 == play_1 || ball_4 == play_2 || ball_4 == play_3 || ball_4 == play_4 || ball_4 == play_5){
            play_result_4 = true;
            winning_message_numbers = winning_message_numbers + Integer.toString(ball_1);
            win_counter++;
        }
        if (play_result_4) {winning_message_numbers = winning_message_numbers + " ";}
        if (ball_5 == play_1 || ball_5 == play_2 || ball_5 == play_3 || ball_5 == play_4 || ball_5 == play_5){
            play_result_5 = true;
            winning_message_numbers = winning_message_numbers + Integer.toString(ball_1);
            win_counter++;
        }
        if (play_result_5) {winning_message_numbers = winning_message_numbers + " ";}
        if (powerball == play_powerball){
            play_result_powerball = true;
            winning_message_numbers = winning_message_numbers + "Powerball: " + Integer.toString(ball_1);
            win_counter++;
        }

        if (play_result_1 || play_result_2 || play_result_3 || play_result_4 || play_result_5 || play_result_powerball) {
            winning_numbers = "Congratulations, you matched " + win_counter + " number(s)! Your matching number(s) are: " + winning_message_numbers;
            System.out.println(winning_numbers);
            win = true;
        } else {
            System.out.println("Sorry, you didn't win. Better luck next time!");
            win = false;
        }
    }

    public void roll_ball(){
        Random rnd = new Random();
        ball_1 = rnd.nextInt(69);
        ball_2 = rnd.nextInt(69);
        ball_3 = rnd.nextInt(69);
        ball_4 = rnd.nextInt(69);
        ball_5 = rnd.nextInt(69);
        powerball = rnd.nextInt(26);
    }
}
