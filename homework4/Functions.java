import java.util.Scanner;

public class Functions extends Player{

    //init Classes
    Player player_dealer = new Player();
    Player player_user = new Player();
    Player player_community = new Player();
    Bank player_bank = new Bank();
    Deck card_deck = new Deck();
    Evaluator evaluate_player_hand = new Evaluator();
    Evaluator evaluate_dealer_hand = new Evaluator();

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

        //start
        System.out.println("Starting New Game.");
        player_bank.check_balance();
    }

    private void welcome_message(){
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#            Welcome to Texas Hold'em            #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
        System.out.println("# Written by Egor Shumeyko.  Last Rev 04/02/2019 #");
        System.out.println("##################################################");
        System.out.println();
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
            player_bank.add_winnings(bet_amount * 2);
        } else {
            player_bank.subtract_winnings(bet_amount);
        }
    }

    public void buildDeck(){
        card_deck.buildNewDeck();

        for(int shuffle_count = 0; shuffle_count < 5; shuffle_count++){
            card_deck.deck_shuffle();
        }
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

    public void build_evaluators(){
        for (int card_number=0;card_number<2;card_number++){
            evaluate_player_hand.setEvaluator_hand(player_user.getPlayer_hand(card_number), card_number);
        }
        for (int card_number=0;card_number<5;card_number++){
            evaluate_player_hand.setEvaluator_hand(player_community.getCommunity_hand(card_number), card_number+2);
        }
        for (int card_number=0;card_number<2;card_number++){
            evaluate_dealer_hand.setEvaluator_hand(player_dealer.getPlayer_hand(card_number), card_number);
        }
        for (int card_number=0;card_number<5;card_number++){
            evaluate_dealer_hand.setEvaluator_hand(player_community.getCommunity_hand(card_number), card_number+2);
        }
    }

    public void evaluate_results(){
        evaluate_player_hand.evaluate_hand();
    }

    public void exit_message(){
        System.out.println();
        System.out.println("##################################################");
        System.out.println("#        EXITING. Thank You for playing!         #");
        System.out.println("##################################################");
    }

    public boolean exit_prompt(){
        boolean input_validation = true;
        System.out.println();
        System.out.println("##################################################");
        while(input_validation) {
            if(player_bank.check_balance()) {
                System.out.print("Round complete. Continue playing? (Y / N):");
                String exit_prompt = sc.next();
                if (exit_prompt.equals("Y") || exit_prompt.equals("y")) {
                    return true;
                } else if (exit_prompt.equals("N") || exit_prompt.equals("n")) {
                    return false;
                } else {
                    System.out.println("Wrong input. Please try again...");
                }
            } else {
                System.out.println("You have no more money left. Game Over!");
                System.out.println("Exiting due to the lack of funds!");
                return false;
            }
        }
        return false;
    }

    public void debug_vars(){
        System.out.println();
        System.out.println(player_user.playerName);
        System.out.println(player_dealer.playerName);
        System.out.println("$" + player_bank.player_cash);
        System.out.println("$" + bet_amount);
        System.out.println();
        //System.out.println("--- CARDS ------------");
        //card_deck.printDeck();
        //System.out.println();
        System.out.println("--- DEALER -----------");
        player_dealer.print_cards();
        System.out.println();
        System.out.println("--- PLAYER -----------");
        player_user.print_cards();
        System.out.println();
        System.out.println("--- COMMUNITY --------");
        player_community.print_community();
        System.out.println();
        System.out.println("--- PLAYER EVALUATOR -");
        evaluate_player_hand.print_evaluator();
        System.out.println();
        System.out.println("--- BANK EVALUATOR ---");
        evaluate_dealer_hand.print_evaluator();


    }
}
