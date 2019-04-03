import java.util.Arrays;

public class Evaluator {
    public Card[] evaluator_hand = new Card[7]; //because we must evaluate 7 cards: 2 from hand and 5 from community

    public Evaluator(){
    }

    public void setEvaluator_hand(Card player_hand, int card_number) {
        this.evaluator_hand[card_number] = player_hand;
    }


}
