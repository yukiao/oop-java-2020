public class Lecturer extends Employee{
    private int credit;

    public Lecturer(String name, int credit){
        super(name);
        this.credit = credit;
    }

    @Override
    public int getActualSalary(){
        int initialSalary = getInitialSalary();
        return initialSalary + credit*120000;
    }
}