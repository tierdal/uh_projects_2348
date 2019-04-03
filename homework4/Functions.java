import java.util.Random;
import java.util.Scanner;

public class Functions extends Player{

    //init Classes
    Player player_dealer = new Player();
    Player player_user = new Player();
    Player player_community = new Player();
    Bank player_bank = new Bank();
    Deck card_deck = new Deck();

    //init vars
    public Double bet_amount; //move out to place_bet
    public Boolean is_winner = false;
    public int card_counter = 0;

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

    public void buildDeck(){
        card_deck.buildNewDeck();
        card_deck.deck_shuffle();
        card_deck.deck_shuffle();
        card_deck.deck_shuffle();
    }

    public void deal_cards(){
        for (int card_number=0;card_number<2;card_number++){
            player_dealer.setPlayer_hand(card_deck.getCard(card_counter++), card_number);
        }
        for (int card_number=0;card_number<2;card_number++){
            player_user.setPlayer_hand(card_deck.getCard(card_counter++), card_number);
        }
    }

    public void deal_community(){
        for (int card_number=0;card_number<5;card_number++){
            player_community.setCommunity_hand(card_deck.getCard(card_counter++), card_number);
        }
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

    public void debug_vars(){
        System.out.println();
        System.out.println(player_user.playerName);
        System.out.println(player_dealer.playerName);
        System.out.println("$" + player_bank.player_cash);
        System.out.println("$" + bet_amount);
        System.out.println();
        System.out.println("--- CARDS ------------");
        card_deck.printDeck();
        System.out.println();
        System.out.println("--- DEALER -----------");
        player_dealer.print_cards();
        System.out.println();
        System.out.println("--- PLAYER -----------");
        player_user.print_cards();
        System.out.println();
        System.out.println("--- COMMUNITY --------");
        player_community.print_community();


    }
}
