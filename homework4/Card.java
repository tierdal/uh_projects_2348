import java.util.Comparator;

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

    public int getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }
}

//comparators - https://stackoverflow.com/questions/8699195/cannot-be-cast-to-java-lang-comparable
//              https://www.geeksforgeeks.org/comparator-interface-java/

class value_comparator implements Comparator<Object> {
    public int compare(Object object_1, Object object_2){

        int card_value_1 = ((Card)object_1).getValue();
        int card_value_2 = ((Card)object_2).getValue();

        return card_value_1 - card_value_2;
    }
}

class suit_comparator implements Comparator<Object>{
    public int compare(Object object_1, Object object_2){

        int card_suit_1 = ((Card)object_1).getSuit();
        int card_suit_2 = ((Card)object_2).getSuit();

        return card_suit_1 - card_suit_2;
    }
}