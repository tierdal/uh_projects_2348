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

        //sort_value();

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

        for (int counter=0;counter<13;counter++){
            value_evaluator[evaluator_hand[counter].get_value()]++;
            suit_evaluator[evaluator_hand[counter].get_suit()]++;
        }

        sort_both();

        //start with Royal and then work my way down to the lowest possible win
        while (evaluate_result == null) {
            evaluate_result = win_condition_royalflush(value_evaluator, suit_evaluator);
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_straightflush();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_fourofakind();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_fullhouse();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_flush();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_straight();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_threeofakind();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_twopairs();
            if (evaluate_result != null) {break;}
            evaluate_result = win_condition_pair();
        }



    }

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
    private String win_condition_straightflush(){

        return win_type;
    }
    private String win_condition_fourofakind(){

        return win_type;
    }
    private String win_condition_fullhouse(){

        return win_type;
    }
    private String win_condition_flush(){

        return win_type;
    }
    private String win_condition_straight(){

        return win_type;
    }
    private String win_condition_threeofakind(){

        return win_type;
    }
    private String win_condition_twopairs(){

        return win_type;
    }
    private String win_condition_pair(){

        return win_type;
    }
}
