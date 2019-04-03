public class Card {
    public int value; //1 - 13, 1 = Ace, 11 = Jack, 12 = Queen, 13 = King
    public String card_value;
    public int suit;
    public String card_suit; //Spades, Hearts, Clubs, Diamonds

    public Card(int value, int suit){
        this.value = value;
        this.suit = suit;
    }

    public void setCard_suit(String card_suit) {
        this.card_suit = card_suit;
    }

    public void setCard_value(String card_value) {
        this.card_value = card_value;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
