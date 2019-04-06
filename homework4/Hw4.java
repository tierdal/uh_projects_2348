public class Hw4 {

    public static void main(String[] args) {
        boolean runtime = true;

        //init
        Functions system_functions = new Functions();
        system_functions.init_game();

        //main runtime

        while(runtime){

            //reset vars at the beginning of each round
            system_functions.card_counter = 0;
            system_functions.evaluate_player_hand.evaluate_result = 0;
            system_functions.evaluate_player_hand.win_rank = 0;
            system_functions.evaluate_dealer_hand.evaluate_result = 0;
            system_functions.evaluate_dealer_hand.win_rank = 0;
            system_functions.is_dealer_winner = false;
            system_functions.is_player_winner = false;
            system_functions.is_winner = false;
            system_functions.is_draw = false;

            system_functions.place_bet();

            system_functions.buildDeck();

            system_functions.deal_cards();

            system_functions.deal_community();

            system_functions.build_evaluators();

            system_functions.evaluate_results();

            //print vars for debug
            system_functions.print_info();

            //transfer money from bet to bank
            system_functions.fund_transfer();

            //ask whether to keep playing (if balance is 0 it will exit)
            runtime = system_functions.exit_prompt();

        }

        //print exit message and end terminate
        system_functions.exit_message();

    }

}
