public class OrdinaryEmployee extends Employee{
    
    public OrdinaryEmployee(String name){
        super(name);
    }

    @Override
    public int getActualSalary(){
        int salary = getInitialSalary();
        return salary;
    }
}