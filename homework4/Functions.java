import java.util.Random;
import java.util.Scanner;

public class Functions extends Player{

    //init Classes
    Player player_dealer = new Player();
    Player player_user = new Player();
    Bank player_bank = new Bank();
    Deck card_deck = new Deck();
    /*Card player_card_1 = new Card();
    Card player_card_2 = new Card();
    Card bank_card_1 = new Card();
    Card bank_card_2 = new Card();
    Card community_card_1 = new Card();
    Card community_card_2 = new Card();
    Card community_card_3 = new Card();
    Card community_card_4 = new Card();
    Card community_card_5 = new Card();*/

    //init vars
    public Double bet_amount; //move out to place_bet
    public Boolean is_winner = false;

    //init Scanner
    Scanner sc = new Scanner(System.in);

    public void init_game(){
        //this function will init the game

        welcome_message();

        //init player balance
        player_bank.setPlayer_cash(1000);

        //init players
        player_dealer.setPlayerName("Bank");
        System.out.print("Please enter your name: ");
        String playerNameInput = sc.next();
        player_user.setPlayerName(playerNameInput);

    }

    private void welcome_message(){
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#            Welcome to Texas Hold'em            #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
        System.out.println("# Written by Egor Shumeyko.  Last Rev 04/02/2019 #");
        System.out.println("##################################################");
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

    public void fund_transfer(){
        if(is_winner){
            player_bank.add_winnings(bet_amount);
        } else {
            player_bank.subtract_winnings(bet_amount);
        }
    }

    /*
    CHANGE THE WAY THIS WORKS:
    Must build deck in order to avoid duplicate cards.
     */

    public void buildDeck(){
        card_deck.buildNewDeck();
        card_deck.deck_shuffle();
        card_deck.deck_shuffle();
        card_deck.deck_shuffle();
    }

    public void deal_cards(){

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

    /*public void assignCards(){
        //assign Value
        player_card_1.setValue(roll_card_value(13));
        player_card_1.setCard_value(assign_value(player_card_1.value));
        player_card_2.setValue(roll_card_value(13));
        player_card_2.setCard_value(assign_value(player_card_2.value));
        bank_card_1.setValue(roll_card_value(13));
        bank_card_1.setCard_value(assign_value(bank_card_1.value));
        bank_card_2.setValue(roll_card_value(13));
        bank_card_2.setCard_value(assign_value(bank_card_2.value));

        //assign Suit
        player_card_1.setSuit(roll_card_value(4));
        player_card_1.setCard_suit(assign_suit(player_card_1.suit));
        player_card_2.setSuit(roll_card_value(4));
        player_card_2.setCard_suit(assign_suit(player_card_2.suit));
        bank_card_1.setSuit(roll_card_value(4));
        bank_card_1.setCard_suit(assign_suit(bank_card_1.suit));
        bank_card_2.setSuit(roll_card_value(4));
        bank_card_2.setCard_suit(assign_suit(bank_card_2.suit));
    }

    public void assignCommunity(){
        /*community_card_1.setValue(roll_card_value(13));
        community_card_1.setCard_value(assign_value(community_card_1.value));
        community_card_2.setValue(roll_card_value(13));
        community_card_2.setCard_value(assign_value(community_card_2.value));
        community_card_3.setValue(roll_card_value(13));
        community_card_3.setCard_value(assign_value(community_card_3.value));
        community_card_4.setValue(roll_card_value(13));
        community_card_4.setCard_value(assign_value(community_card_4.value));
        community_card_5.setValue(roll_card_value(13));
        community_card_5.setCard_value(assign_value(community_card_5.value));

        community_card_1.setSuit(roll_card_value(4));
        community_card_1.setCard_suit(assign_suit(community_card_1.suit));
        community_card_2.setSuit(roll_card_value(4));
        community_card_2.setCard_suit(assign_suit(community_card_2.suit));
        community_card_3.setSuit(roll_card_value(4));
        community_card_3.setCard_suit(assign_suit(community_card_3.suit));
        community_card_4.setSuit(roll_card_value(4));
        community_card_4.setCard_suit(assign_suit(community_card_4.suit));
        community_card_5.setSuit(roll_card_value(4));
        community_card_5.setCard_suit(assign_suit(community_card_5.suit));
    }*/

    /*private String assign_suit(int suit_value){
        switch(suit_value) {
            case 1:
                return "Spades";
            case 2:
                return "Hearts";
            case 3:
                return "Clubs";
            case 4:
                return "Diamonds";
        }
        return null;
    }

    private String assign_value(int value){
        switch(value){
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
        }
        return null;
    }*/

    public void debug_vars(){
        System.out.println();
        System.out.println(player_user.playerName);
        System.out.println(player_dealer.playerName);
        System.out.println("$" + player_bank.player_cash);
        System.out.println("$" + bet_amount);
        System.out.println();
        System.out.println("--- CARDS -----------------------------------");
        /*System.out.println(player_card_1.card_value + " of " + player_card_1.card_suit);
        System.out.println(player_card_2.card_value + " of " + player_card_2.card_suit);
        System.out.println(bank_card_1.card_value + " of " + bank_card_1.card_suit);
        System.out.println(bank_card_2.card_value + " of " + bank_card_2.card_suit);
        System.out.println();
        System.out.println("--- COMMUNITY CARDS -------------------------");
        System.out.println(community_card_1.card_value + " of " + community_card_1.card_suit);
        System.out.println(community_card_2.card_value + " of " + community_card_2.card_suit);
        System.out.println(community_card_3.card_value + " of " + community_card_3.card_suit);
        System.out.println(community_card_4.card_value + " of " + community_card_4.card_suit);
        System.out.println(community_card_5.card_value + " of " + community_card_5.card_suit);*/
        System.out.println();
        card_deck.printDeck();
        System.out.println();
        System.out.println();

    }
}
