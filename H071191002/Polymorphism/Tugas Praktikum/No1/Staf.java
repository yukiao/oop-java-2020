public class Staf extends Employee {
    private int totalAttendance;

    public Staf(String name, int totalAttendance){
        super(name);
        this.totalAttendance = totalAttendance;
    }

    @Override
    public int getActualSalary(){
        int initialSalary = getInitialSalary();
        return initialSalary + totalAttendance*50000;
    }
}