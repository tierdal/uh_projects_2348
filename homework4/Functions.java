import java.util.Scanner;

public class Functions extends Player{

    //init Classes
    Player player_dealer = new Player();
    Player player_user = new Player();
    Bank player_bank = new Bank();

    //init vars
    Double bet_amount;

    //init Scanner
    Scanner sc = new Scanner(System.in);

    public void init_game(){
        //this function will init the game

        welcome_message();

        //init player balance
        player_bank.player_cash = 1000;

        //init players
        player_dealer.playerName = "Bank";
        System.out.print("Please enter your name: ");
        String playerNameInput = sc.next();
        player_user.playerName = playerNameInput;

    }

    private void welcome_message(){
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#            Welcome to Texas Hold'em            #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
        System.out.println("# Written by Egor Shumeyko.  Last Rev 04/02/2019 #");
        System.out.println("##################################################");
        System.out.println("#   To exit the game type 'EXIT' at any prompt   #");
        System.out.println("##################################################");
        System.out.println("");
    }

    public void place_bet(){
        boolean can_bet = false;
        while(!can_bet) {
            System.out.print("Please enter your bet: ");
            bet_amount = sc.nextDouble();
            can_bet = player_bank.check_bet(bet_amount);
        }
    }

    public void test_vars(){
        System.out.println();
        System.out.println(player_user.playerName);
        System.out.println(player_dealer.playerName);
        System.out.println("$" + player_bank.player_cash);
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
