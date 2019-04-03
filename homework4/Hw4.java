import java.util.Scanner;
import java.util.ArrayList; //https://stackoverflow.com/questions/9342859/i-need-to-find-a-integer-data-in-arraylist
import java.util.Random;
import java.util.Arrays; //https://study.com/academy/lesson/how-to-sort-an-array-in-java.html

public class Hw4 {

    public static void main(String[] args) {
        //do stuff
        Functions system_functions = new Functions();

        system_functions.init_game();

        system_functions.place_bet();

        system_functions.assignCards();

        system_functions.assignCommunity();

        system_functions.debug_vars();



    }

}
