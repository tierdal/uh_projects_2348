import java.util.Arrays; //https://study.com/academy/lesson/how-to-sort-an-array-in-java.html

public class Evaluator {
    public Card[] evaluator_hand = new Card[7]; //because we must evaluate 7 cards: 2 from hand and 5 from community

    public Evaluator(){
    }

    public void setEvaluator_hand(Card player_hand, int card_number) {
        this.evaluator_hand[card_number] = player_hand;
    }

    public void print_evaluator(){
        for (int card_number=0;card_number<7;card_number++){
            System.out.println(evaluator_hand[card_number].returnCard());
        }
    }

    protected void sort_value(){
        Arrays.sort(evaluator_hand, new value_comparator());
    }

    //have to define custom sorting attributes https://www.geeksforgeeks.org/comparator-interface-java/
    protected void sort_both(){
        Arrays.sort(evaluator_hand, new value_comparator());
        Arrays.sort(evaluator_hand, new suit_comparator());
    }

    public String evaluate_result;
    public String win_type;

    //evaluate based on winning sequence
    public void evaluate_hand(){

        //split and dump evaluator hand into the individual arrays below, then sort and compare.
        int [] value_evaluator = new int[13];
        int [] suit_evaluator = new int[4];

        //initialize each evaluator slot with 0
        for (int counter=0;counter<13;counter++){
            value_evaluator[counter] =0;
        }
        for (int counter=0;counter<4;counter++){
            suit_evaluator[counter] = 0;
        }

        for (int counter=0;counter<7;counter++){
            value_evaluator[evaluator_hand[counter].get_value()]++;
            suit_evaluator[evaluator_hand[counter].get_suit()]++;
        }

        sort_both();

        //start with Royal and then work my way down to the lowest possible win
        while (evaluate_result == null) {
            evaluate_result = win_condition_royalflush(value_evaluator, suit_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_straightflush(suit_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_fourofakind(value_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_fullhouse(value_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_flush(suit_evaluator);
            if (evaluate_result == null) {break;}
        }

        sort_value();
        //continue with trying to find result
        while (evaluate_result == null) {
            evaluate_result = win_condition_straight(value_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_threeofakind(value_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_twopairs(value_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_pair(value_evaluator);
        }
    }

    //https://stackoverflow.com/questions/52575356/need-help-in-understanding-texas-holdem-game
    private String win_condition_royalflush(int[] value_evaluator,int[] suit_evaluator){
        if ((value_evaluator[9] >= 1 && value_evaluator[10] >= 1 && value_evaluator[11] >= 1 && value_evaluator[12] >= 1 && value_evaluator[13] >= 1)
                && //check if the last 5 card slots are filled and if there are 5 of the same suit
                (suit_evaluator[0] == 5 || suit_evaluator[1] == 5  || suit_evaluator[2] == 5 || suit_evaluator[3] == 5)) {
            for (int counter = 0; counter < 4; counter++) {
                if ((evaluator_hand[counter].get_value() == 9 && evaluator_hand[counter+1].get_value() == 10 && evaluator_hand[counter + 2].get_value() == 11 && evaluator_hand[counter + 3].get_value() == 12 && evaluator_hand[counter + 4].get_value() == 13)
                    && //check if for each suit we have matching suit and value
                ((evaluator_hand[counter].get_suit() == evaluator_hand[counter].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter + 1].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter + 2].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter + 3].get_suit()))) {
                    win_type = "Royal Flush!";
                    break;
                }
            }
        }
        return win_type;
    }
    private String win_condition_straightflush(int[] suit_evaluator){
        if (suit_evaluator[0] == 5 || suit_evaluator[1] == 5  || suit_evaluator[2] == 5 || suit_evaluator[3] == 5) {
            for (int counter=13;counter>3;counter--){
                if ((evaluator_hand[counter].get_value() - evaluator_hand[counter-1].get_value() == 1 && evaluator_hand[counter-1].get_value() - evaluator_hand[counter-2].get_value() == 1 && evaluator_hand[counter-2].get_value() - evaluator_hand[counter-3].get_value() == 1 && evaluator_hand[counter-3].get_value() - evaluator_hand[counter-4].get_value() == 1)
                        &&
                        (evaluator_hand[counter].get_suit() == evaluator_hand[counter-1].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-2].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-3].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-4].get_suit())){
                    win_type = "Straight Flush!";
                    break;
                }
            }
        }
        return win_type;
    }
    private String win_condition_fourofakind(int[] value_evaluator){
        for (int counter=0;counter<13;counter++){
            if (value_evaluator[counter] == 4){
                win_type = "Four of a Kind!";
                break;
            }
        }
        return win_type;
    }
    private String win_condition_fullhouse(int[] value_evaluator){
        int three_kinds = -1;
        int two_kinds = -1;

        for (int counter=13;counter>0;counter--){
            if (three_kinds < 0 || two_kinds < 0){
                if (value_evaluator[counter-1] > 2){
                    three_kinds = counter-1;
                } else if (value_evaluator[counter-1] > 1){
                    two_kinds = counter-1;
                }
            } else {
                break;
            }
        }

        if (three_kinds >= 0 && two_kinds >= 0) {
            win_type = "Full House!";
        }
        return win_type;
    }
    private String win_condition_flush(int[] suit_evaluator){
        if (suit_evaluator[0] == 5 || suit_evaluator[1] == 5  || suit_evaluator[2] == 5 || suit_evaluator[3] == 5) {
            for (int counter=13;counter>3;counter--){
                if (evaluator_hand[counter].get_suit() == evaluator_hand[counter-1].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-2].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-3].get_suit() && evaluator_hand[counter].get_suit() == evaluator_hand[counter-4].get_suit()) {
                    win_type = "Flush!";
                    break;
                }
            }
        }
        return win_type;
    }
    private String win_condition_straight(int[] value_evaluator){
        for (int counter=13;counter>4;counter--){
            if (value_evaluator[counter-1] > 0 && value_evaluator[counter-2] > 0 && value_evaluator[counter-3] > 0 && value_evaluator[counter-4] > 0 && value_evaluator[counter-5] > 0){
                win_type = "Straight!";
                break;
            }
        }
        return win_type;
    }
    private String win_condition_threeofakind(int[] value_evaluator){
        for (int counter=13;counter>0;counter--){
            if (value_evaluator[counter-1] > 2){
                win_type = "Three of a Kind!";
                break;
            }
        }
        return win_type;
    }
    private String win_condition_twopairs(int[] value_evaluator){
        int pair_1 = -1;
        int pair_2 = -1;

        for (int counter=13;counter>0;counter--){
            if (pair_1 < 0 || pair_2 < 0){
                if (value_evaluator[counter-1] > 1 && pair_1 < 0) {
                    pair_1 = counter-1;
                } else if (value_evaluator[counter-1] > 1){
                    pair_2 = counter-1;
                }
            } else {
                break;
            }
        }
        if (pair_1 >= 0 && pair_2 >= 0){
            win_type = "Two Pair!";
        }
        return win_type;
    }
    private String win_condition_pair(int[] value_evaluator){
        for (int counter=13;counter>0;counter--){
            if((value_evaluator[counter-1]) > 1){
                win_type = "One Pair!";
                break;
            }
        }
        return win_type;
    }
}
