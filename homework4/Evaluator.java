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

    //evaluate based on winning sequence
    public void evaluate_hand(){

        sort_value();
        sort_both();

    }


}
