public abstract class Employee {
    private String name;
    private int initialSalary;

    public Employee(String name){
        this.name = name;
        this.initialSalary = 2500000;
    }

    public abstract int getActualSalary();
    
    public String getName(){
        return name;
    }
    public int getInitialSalary(){
        return initialSalary;
    }

    public void result(){
        System.out.println(name+" mendapat gaji Rp. "+getActualSalary());
    }
}