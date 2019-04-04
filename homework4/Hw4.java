import java.util.Scanner;
import java.util.ArrayList; //https://stackoverflow.com/questions/9342859/i-need-to-find-a-integer-data-in-arraylist
import java.util.Random;
import java.util.Arrays; //https://study.com/academy/lesson/how-to-sort-an-array-in-java.html

public class Hw4 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runtime = true;

        //init
        Functions system_functions = new Functions();
        system_functions.init_game();

        //main runtime
        while(runtime){

            system_functions.place_bet();

            system_functions.buildDeck();

            system_functions.deal_cards();

            system_functions.deal_community();

            system_functions.build_evaluators();

            system_functions.evaluate_results();

            //transfer money from bet to bank
            system_functions.fund_transfer();

            //print vars for debug
            system_functions.debug_vars();

            //ask whether to keep playing (if balance is 0 it will exit)
            runtime = system_functions.exit_prompt();

        }

        //print exit message and end
        system_functions.exit_message();

    }

}
