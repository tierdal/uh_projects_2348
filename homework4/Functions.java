import java.util.Random;
import java.util.Scanner;

public class Functions extends Player{

    //init Classes
    Player player_dealer = new Player();
    Player player_user = new Player();
    Bank player_bank = new Bank();
    Card player_card_1 = new Card();
    Card player_card_2 = new Card();
    Card bank_card_1 = new Card();
    Card bank_card_2 = new Card();
    Card community_card_1 = new Card();
    Card community_card_2 = new Card();
    Card community_card_3 = new Card();
    Card community_card_4 = new Card();
    Card community_card_5 = new Card();

    //init vars
    Double bet_amount;
    int card_rnd_roll;

    //init Scanner
    Scanner sc = new Scanner(System.in);

    public void init_game(){
        //this function will init the game

        welcome_message();

        //init player balance
        player_bank.player_cash = 1000;

        //init players
        player_dealer.playerName = "Bank";
        System.out.print("Please enter your name: ");
        String playerNameInput = sc.next();
        player_user.playerName = playerNameInput;

    }

    private void welcome_message(){
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#            Welcome to Texas Hold'em            #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
        System.out.println("# Written by Egor Shumeyko.  Last Rev 04/02/2019 #");
        System.out.println("##################################################");
        //System.out.println("#   To exit the game type 'EXIT' at any prompt   #");
        //System.out.println("##################################################");
        System.out.println("");
    }

    public void place_bet(){
        boolean can_bet = false;
        while(!can_bet) {
            System.out.print("Please enter your bet: ");
            bet_amount = sc.nextDouble();
            can_bet = player_bank.check_bet(bet_amount);
        }
    }

    public void assignCards(){
        //assign Value
        player_card_1.value = roll_card_value(13);
        player_card_1.card_value = assign_value(player_card_1.value);
        player_card_2.value = roll_card_value(13);
        player_card_2.card_value = assign_value(player_card_2.value);
        bank_card_1.value = roll_card_value(13);
        bank_card_1.card_value = assign_value(bank_card_1.value);
        bank_card_2.value = roll_card_value(13);
        bank_card_2.card_value = assign_value(bank_card_2.value);

        //assign Suit
        player_card_1.suit = roll_card_value(4);
        player_card_1.card_suit = assign_suit(player_card_1.suit);
        player_card_2.suit = roll_card_value(4);
        player_card_2.card_suit = assign_suit(player_card_2.suit);
        bank_card_1.suit = roll_card_value(4);
        bank_card_1.card_suit = assign_suit(bank_card_1.suit);
        bank_card_2.suit = roll_card_value(4);
        bank_card_2.card_suit = assign_suit(bank_card_2.suit);
    }

    public void assignCommunity(){
        community_card_1.value = roll_card_value(13);
        community_card_1.card_value = assign_value(community_card_1.value);
        community_card_2.value = roll_card_value(13);
        community_card_2.card_value = assign_value(community_card_2.value);
        community_card_3.value = roll_card_value(13);
        community_card_3.card_value = assign_value(community_card_3.value);
        community_card_4.value = roll_card_value(13);
        community_card_4.card_value = assign_value(community_card_4.value);
        community_card_5.value = roll_card_value(13);
        community_card_5.card_value = assign_value(community_card_5.value);

        community_card_1.suit = roll_card_value(4);
        community_card_1.card_suit = assign_suit(community_card_1.suit);
        community_card_2.suit = roll_card_value(4);
        community_card_2.card_suit = assign_suit(community_card_2.suit);
        community_card_3.suit = roll_card_value(4);
        community_card_3.card_suit = assign_suit(community_card_3.suit);
        community_card_4.suit = roll_card_value(4);
        community_card_4.card_suit = assign_suit(community_card_4.suit);
        community_card_5.suit = roll_card_value(4);
        community_card_5.card_suit = assign_suit(community_card_5.suit);
    }

    private int roll_card_value(int roll_bound){
        Boolean roll_0 = false;
        int roll_number = 0;
        Random rnd = new Random();

        while (!roll_0) {
            roll_number = rnd.nextInt(roll_bound);
            if (roll_number > 0) {
                roll_0 = true;
            }
        }
        return roll_number;
    }
    private String assign_suit(int suit_value){
        String card_suit = "";

        switch(suit_value){
            case 1:
                card_suit = "Spades";
                break;
            case 2:
                card_suit = "Hearts";
                break;
            case 3:
                card_suit = "Clubs";
                break;
            case 4:
                card_suit = "Diamonds";
                break;
        }

        return card_suit;
    }
    private String assign_value(int value){
        String card_value = "";

        switch(value){
            case 1:
                card_value = "Ace";
                break;
            case 2:
                card_value = "2";
                break;
            case 3:
                card_value = "3";
                break;
            case 4:
                card_value = "4";
                break;
            case 5:
                card_value = "5";
                break;
            case 6:
                card_value = "6";
                break;
            case 7:
                card_value = "7";
                break;
            case 8:
                card_value = "8";
                break;
            case 9:
                card_value = "9";
                break;
            case 10:
                card_value = "10";
                break;
            case 11:
                card_value = "Jack";
                break;
            case 12:
                card_value = "Queen";
                break;
            case 13:
                card_value = "King";
                break;
        }

        return card_value;
    }

    public void debug_vars(){
        System.out.println();
        System.out.println(player_user.playerName);
        System.out.println(player_dealer.playerName);
        System.out.println("$" + player_bank.player_cash);
        System.out.println("$" + bet_amount);
        System.out.println();
        System.out.println("--- CARDS -----------------------------------");
        System.out.println(player_card_1.card_value + " of " + player_card_1.card_suit);
        System.out.println(player_card_2.card_value + " of " + player_card_2.card_suit);
        System.out.println(bank_card_1.card_value + " of " + bank_card_1.card_suit);
        System.out.println(bank_card_2.card_value + " of " + bank_card_2.card_suit);
        System.out.println();
        System.out.println("--- COMMUNITY CARDS -------------------------");
        System.out.println(community_card_1.card_value + " of " + community_card_1.card_suit);
        System.out.println(community_card_2.card_value + " of " + community_card_2.card_suit);
        System.out.println(community_card_3.card_value + " of " + community_card_3.card_suit);
        System.out.println(community_card_4.card_value + " of " + community_card_4.card_suit);
        System.out.println(community_card_5.card_value + " of " + community_card_5.card_suit);
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
