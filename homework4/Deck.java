public class Deck {

    public Card[] deck_cards = new Card[52];

    public Deck(){
    }

    public void buildNewDeck(){
        int card_count = 1;
        for (int suit=1; suit<5; suit++){
            for (int value=1; value<14;value++){
                deck_cards[card_count++] = new Card(value, suit);
            }
        }
    }
}
