package no1;
public class Item{
    private String name;
    private int price;
    private String info;

    public Item(String name, int price, String info){
        this.name = name;
        this.price = price;
        this.info = info;
    }
    //Detail of an item
    public void detail(){
        System.out.println("Name   : "+name);
        System.out.println("Price  : "+price);
        System.out.println("Usage  : "+info);
    }

    //use an item
    public int use(){
        if(name.equals("Healing Spell")){
             return 40;
        }else if(name.equals("Rage Spell")){
            return 10;
        }else if(name.equals("Energy Regen")){
            return 50;
        }
        return 0;
    }

    //sell an item and return money-50
    public int sell(){
        return price-50;
    }

    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }

}