package no2;

import no1.Player;
import java.util.Scanner;

class BattleHandler{
    Scanner sc = new Scanner(System.in);

    //Give player chance to buy or sell item before battle start
    public void preparation(Player one, Player two){
        boolean loop = true;
        System.out.println("Welcome Challenger");
        System.out.println("This is preparation mode");
        while(loop){
            System.out.println("Player 1 Turn");
            System.out.println("1. Buy Item");
            System.out.println("2. Sell Item");
            System.out.println("3. Show Item");
            System.out.println("4. Show player status");
            System.out.println("5. Show Item Detail");
            System.out.print("Command : ");
            int n = sc.nextInt();
            System.out.println();
            switch (n) {
                case 1:
                    one.startBuy();
                    System.out.println();
                    break;
                case 2:
                    one.sellItem();
                    System.out.println();
                    break;
                case 3:
                    one.showItems();
                    System.out.println();
                    break;
                case 4:
                    one.showStatus();
                    System.out.println();
                    break;
                case 5:
                    one.itemDetail();
                    System.out.println();
                    break;
                default:
                    break;
            }
            System.out.print("Finish(Y/N) : ");
            String option = sc.next();
            System.out.println();
            if(option.equalsIgnoreCase("Y")){
                loop = false;
            }else{
                loop = true;
            }
        }
        loop = true;
        while(loop){
            System.out.println("Player 2 Turn");
            System.out.println("1. Buy Item");
            System.out.println("2. Sell Item");
            System.out.println("3. Show Item");
            System.out.println("4. Show player status");
            System.out.println("5. Show Item Detail");
            System.out.print("Command : ");
            int n = sc.nextInt();
            System.out.println();
            switch (n) {
                case 1:
                    two.startBuy();
                    System.out.println();
                    break;
                case 2:
                    two.sellItem();
                    System.out.println();
                    break;
                case 3:
                    two.showItems();
                    System.out.println();
                    break;
                case 4:
                    two.showStatus();
                    System.out.println();
                    break;
                case 5:
                    two.itemDetail();
                    System.out.println();
                    break;
                default:
                    break;
            }
            System.out.print("Finish(Y/N) : ");
            String option = sc.next();
            System.out.println();
            if(option.equalsIgnoreCase("Y")){
                loop = false;
            }else{
                loop = true;
            }
        }
    }

    //Method to start battle. Return winner as an object
    public Player startBattle(Player player1 , Player player2){
        Player winner = null;
        while(true){
            System.out.println(player1.getName());
            if(player1.useItem()==false){
                player1.attack(player2);
                System.out.println();
                player2.showStatus();
                System.out.println();
            }else{
                System.out.println();
                player1.showStatus();
                System.out.println();
            }


            if(player2.getHp()<=0){
                winner = player1;
                player1.levelUp();
                break;
            }

            System.out.println(player2.getName());
            if(player2.useItem()==false){
                player2.attack(player1);
                System.out.println();
                player1.showStatus();
                System.out.println();
            }else{
                System.out.println();
                player2.showStatus();
                System.out.println();
            }
            
            if(player1.getHp()<=0){
                winner = player2;
                player2.levelUp();
                break;
            }
        }
        return winner;

    }
}