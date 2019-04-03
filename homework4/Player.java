public class Player {
    public String playerName;
    public Card[] player_hand = new Card[2];

    public Player(){
    }
    public Player(Card player_card_1, Card player_card_2){
        player_hand[0] = player_card_1;
        player_hand[1] = player_card_2;
    }

    public void setPlayer_hand(Card player_hand, int card_number) {
        this.player_hand[card_number] = player_hand;
    }
    public Card getPlayer_hand(int card_number) {
        return player_hand[card_number];
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
