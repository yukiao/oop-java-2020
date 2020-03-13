package no2;

import no1.Player;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static Player champion = null;
    public static void main(String[] args) {
        BattleHandler battle = new BattleHandler();
        Player player1 = new Player("Yorn", "Archer");
        Player player2 = new Player("Zephys","Warrior");

        battle.preparation(player1, player2);
        champion = battle.startBattle(player1, player2);
        
        System.out.println("The winner is : "+champion.getName());
        System.out.println();
        System.out.println(champion.getName()+" status");
        System.out.println("--------------------------");
        champion.showStatus();
    }    
}