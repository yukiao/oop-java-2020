package no1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Player{
    private String name;
    private String role;
    private int level;
    private double damage;
    private double hp;
    private double energy;
    private int money;
    private Item [] items;
    private ArrayList<Item> itemsOwned = new ArrayList<>();
    private ArrayList<String> itemName =  new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    
    public Player(String name,String role){
        this.name = name;
        this.role = role;
        level = 1;
        damage = damage==0?random.nextInt(10)+20 : damage;
        hp = 100;
        energy = 100;
        money = 1000;
        callItem(); //invoke array of item
    }

    //Show player stat
    public void showStatus(){
        System.out.printf("Name   : %s%n",name);
        System.out.printf("Role   : %s%n",role);
        System.out.printf("Level  : %d%n",level);
        System.out.printf("Damage : %.2f%n",damage);
        System.out.printf("HP     : %.2f%n",hp);
        System.out.printf("Energy : %.2f%n",energy);
        System.out.printf("Money  : %d%n",money);
        System.out.println();
    }

    //Show item in inventory
    public void showItems(){
        for(int i =0; i<itemsOwned.size();i++){
            System.out.println((i+1)+". "+itemsOwned.get(i).getName());
        }    
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDamage(){
        return " has taken " + damage + " damage from ";
    }
    public void attack(Player player){
        player.remainHp(player.getHp()-damage);
        System.out.println(player.getName()+getDamage()+this.name);
    }

    //Instantiate array of item
    public void callItem(){
        items = new Item[3];
        items[0] = new Item("Healing Spell", 200, "Restore current health by 40");
        items[1]  = new Item("Rage Spell", 300, "Increase damage in current game by 10");
        items[2] = new Item("Energy Regen", 500, "Restore energy by 50");
    }   
    
    public void startBuy(){
        buy(items);//Invoke buy method with parameter : item
    }

    //Buy and add item to inventory
    public void buy(Item item[]){
        System.out.println("Item list :");
        System.out.println("1. Healing Spell");
        System.out.println("2. Rage Spell");
        System.out.println("3. Energy  Regen");
        
        System.out.print("Select : ");
        int select = sc.nextInt();
        switch(select){
            case 1 :
                if(item[0].getPrice()<=money){
                    if(itemsOwned.size()<3){
                        money = money-item[0].getPrice();
                        itemsOwned.add(item[0]);
                        itemName.add(item[0].getName());
                        System.out.println(item[0].getName()+" has been added to your inventory");
                    }
                    else{
                        System.out.println("Item capacity is full");
                    }
                }
                else{
                    System.out.println("Not enough money");
                }
                break;
            case 2 :
                if(item[1].getPrice()<=money){
                    if(itemsOwned.size()<3){
                        money = money-item[1].getPrice();
                        itemsOwned.add(item[1]);
                        itemName.add(item[1].getName());
                        System.out.println(item[1].getName()+" has been added to your inventory");
                    }
                    else{
                        System.out.println("Item capacity is full");
                    }
                }
                else{
                    System.out.println("Not enough money");
                }
                break;
            case 3 :
                if(item[2].getPrice()<=money){
                    if(itemsOwned.size()<3){
                        money = money-item[2].getPrice();
                        itemsOwned.add(item[2]);
                        itemName.add(item[2].getName());
                        System.out.println(item[2].getName()+" has been added to your inventory");
                    }
                    else{
                        System.out.println("Item capacity is full");
                    }
                }
                else{
                    System.out.println("Not enough money");
                }
                break;

        }
    }

    //Sell an item in inventory
    public void sellItem(){
        System.out.println("Item Owned");
        showItems();
        System.out.print("Command : ");
        int command = sc.nextInt();
        money+=itemsOwned.get(command-1).sell(); 
        itemsOwned.remove(command-1);
        itemName.remove(command-1);
    }

    //Showing detail of an item
    public void itemDetail(){
        for(int i =0; i<items.length;i++){
            System.out.println((i+1)+". "+items[i].getName());
        }
        System.out.print("Command : ");
        int command = sc.nextInt();
        items[command-1].detail();
    }

    public double getHp(){
        return hp;
    }
    
    //Using to set remaining hp of player if get attacked
    public void remainHp(double hp){
        this.hp = hp;
    }

    //Increase player staif win a battle
    public void levelUp(){
        level++;
        damage+=5 + (level*5);
        hp=100 + + (level*10) ;
        energy = 100 + (level*10);
    }

    //Control about using an item in inventory
    public boolean useItem(){
        if(itemsOwned.size()==0){
            return false;
        }else{
            System.out.println("Use item?(Y/n)");
        System.out.print("Command : ");
        String command = sc.next();
        
        if(command.equalsIgnoreCase("N")){
            return false; // return false if player not use an item
        }

        showItems(); // Invoke showItem method
        int command1 = sc.nextInt();
        if(itemsOwned.get(command1-1).getName().equals("Healing Spell")){
            if(energy<60){
                if(itemName.contains("Energy Regen")){
                    System.out.println("Not enough energy. Use Energy Regen");
                }else{
                    System.out.println("Not enough money. Energy regen not found. Item delete");
                    itemsOwned.remove(command1-1);
                }
            }else{
                hp += itemsOwned.get(command1-1).use();
                energy -= 60;
                System.out.println("Using healing spell. Hp increase by "+ itemsOwned.get(command1-1).use());
                itemsOwned.remove(command1-1);
                itemName.remove(command1-1);
            }
        }
        else if(itemsOwned.get(command1-1).getName().equals("Rage Spell")){
            if(energy<60){
                if(itemName.contains("Energy Regen")){
                    System.out.println("Not enough energy. Use Energy Regen");
                }else{
                    System.out.println("Not enough money. Energy regen not found. Item delete");
                    itemsOwned.remove(command1-1);
                }
            }else{
            damage += itemsOwned.get(command1-1).use();
            System.out.println("Using Rage Spell. Attack increase by "+itemsOwned.get(command1-1).use());
            itemsOwned.remove(command1-1);
            itemName.remove(command1-1);
            }

        }else if(itemsOwned.get(command1-1).getName().equals("Energy Regen")){
            energy += itemsOwned.get(command1-1).use();
            System.out.println("Using Energy regen. energy increase by "+ itemsOwned.get(command1-1).use());
            itemsOwned.remove(command1-1);
            itemName.remove(command1-1);
        }

        return true; // return true if player use an item
        }
        
    }

    public void resetStatus(){
        hp = 100;
        energy = 100;
    }

}
