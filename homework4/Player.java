public class Player {
    public String playerName;
    public Card[] player_hand = new Card[2];
    public Card[] community_hand = new Card[5];

    public Player(){
    }

    public void setPlayer_hand(Card player_hand, int card_number) {
        this.player_hand[card_number] = player_hand;
    }

    public void setCommunity_hand(Card community_hand, int card_number) {
        this.community_hand[card_number] = community_hand;
    }

    /*public Card getPlayer_hand(int card_number) {
        return player_hand[card_number];
    }*/

    public void print_cards(){
        for (int card_number=0;card_number<2;card_number++){
            System.out.println(player_hand[card_number].returnCard());
        }
    }

    public void print_community(){
        for (int card_number=0;card_number<5;card_number++){
            System.out.println(community_hand[card_number].returnCard());
        }
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
