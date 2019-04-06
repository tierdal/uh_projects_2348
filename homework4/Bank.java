public class Bank {
    public double player_cash;

    public Bank(){
    }

    public void setPlayer_cash(double player_cash) {
        this.player_cash = player_cash;
    }

    public void add_winnings(double bet_amount, boolean is_draw) {
        if (!is_draw) {System.out.println("Congratulations, you've won $" + bet_amount + "!");}
        player_cash = player_cash + bet_amount;
        //check_balance();
    }

    public void subtract_winnings(double bet_amount, boolean is_draw) {
        if (!is_draw) {System.out.println("Better luck next time, you've lost $" + bet_amount + "!");}
        player_cash = player_cash - bet_amount;
        //check_balance();
    }

    public boolean check_balance(){
        if (player_cash <= 0){
            return false;
        } else {
            System.out.println("Your current balance is: $" + player_cash);
            return true;
        }
    }

    public boolean check_bet(double bet_amount){
        if (bet_amount <= player_cash){
            return true;
        } else {
            System.out.println("Your bet exceeds your balance ($" + player_cash + ")!");
            return false;
        }

    }

}
