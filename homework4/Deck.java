import java.util.Random;

public class Deck {

    public Card[] deck_cards = new Card[52];

    public Deck(){
        buildNewDeck();
    }

    public void buildNewDeck(){
        int card_count = 0;
        for (int suit=0; suit<4; suit++){
            for (int value=0; value<13;value++){
                deck_cards[card_count++] = new Card(value, suit);
            }
        }
    }

    public void deck_shuffle(){ //https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
        int deck_size = deck_cards.length;
        Random rnd = new Random();
        for (int deck_counter=0;deck_counter<deck_size;deck_counter++){
            int random_index = deck_counter + rnd.nextInt(deck_size - deck_counter);
            Card temp = deck_cards[deck_counter];
            deck_cards[deck_counter] = deck_cards[random_index];
            deck_cards[random_index] = temp;
        }
    }

    public Card getCard(int card_number){
        return deck_cards[card_number];
    }
}
