public class Card {
    public int value; //1 - 13, 1 = Ace, 11 = Jack, 12 = Queen, 13 = King
    public static String[] card_value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public int suit;
    public String[] card_suit = {"Spades", "Hearts", "Clubs", "Diamonds"};

    public Card(int value, int suit){
        this.value = value;
        this.suit = suit;
    }

    public String returnCard(){
        return card_value[value] + " of " + card_suit[suit];
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
