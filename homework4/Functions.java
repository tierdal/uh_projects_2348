import java.util.Scanner;

public class Functions extends Player{

    //init vars
    public double bet_amount; //move out to place_bet
    public boolean is_winner;
    public boolean is_dealer_winner = false;
    public boolean is_player_winner = false;
    public boolean is_draw = false;
    public int card_counter = 0;
    public String [] win_result = {"No Hand","Royal Flush","Straight Flush","Four Of A Kind","Full House","Flush","Straight","Three Of A Kind","Two Pair","One Pair"};
    public String return_player_result;
    public String return_dealer_result;

    Bank player_bank = new Bank();
    Player player_dealer = new Player();
    Player player_user = new Player();
    Player player_community = new Player();
    //init Classes
    Deck card_deck = new Deck();
    Evaluator evaluate_player_hand = new Evaluator();
    Evaluator evaluate_dealer_hand = new Evaluator();

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
        System.out.println("# Written by Egor Shumeyko.  Last Rev 04/06/2019 #");
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
            player_bank.add_winnings(bet_amount * 2, is_draw);
        } else {
            player_bank.subtract_winnings(bet_amount, is_draw);
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
        return_player_result = win_result[evaluate_player_hand.evaluate_hand()];
        return_dealer_result = win_result[evaluate_dealer_hand.evaluate_hand()];


        if (evaluate_player_hand.win_rank == evaluate_dealer_hand.win_rank){
            player_bank.add_winnings(bet_amount, is_draw);
            is_winner = false;
            is_draw = true;
        } else if (evaluate_player_hand.win_rank > 0 && evaluate_player_hand.win_rank < evaluate_dealer_hand.win_rank) {
            is_winner = true;
            is_player_winner = true;
        } else {
            is_winner = false;
            is_dealer_winner = true;
        }
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

    public void print_info(){
        System.out.println();
        System.out.println("--- DEALER -----------");
        player_dealer.print_cards();
        System.out.println();
        System.out.println("--- PLAYER -----------");
        player_user.print_cards();
        System.out.println();
        System.out.println("--- COMMUNITY --------");
        player_community.print_community();
        System.out.println();
        System.out.println("--- PLAYER HAND ------");
        System.out.print(return_player_result);
        if (is_player_winner) {System.out.println(" <= WINNER");}
        System.out.println();
        System.out.println("--- BANK HAND --------");
        System.out.print(return_dealer_result);
        if (is_dealer_winner) {System.out.println(" <= WINNER");}
        System.out.println();
        System.out.println();
        if (!is_player_winner && !is_dealer_winner) {
            System.out.println("IT'S A DRAW");
        }
        System.out.println();


    }
}
