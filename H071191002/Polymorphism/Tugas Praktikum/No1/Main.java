import java.util.Scanner;

class Main{
    private static Lecturer lecturer;
    private static Staf staf;
    private static OrdinaryEmployee ordinaryEmployee;

    public static void main(String [] args){
        inputData();
        showResult();
    }
    
    private static void inputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nama Staf ::> ");
        String stafName = sc.nextLine();
        System.out.print("Jumlah kehadiran ::> ");
        int totalAttendance = sc.nextInt();
        sc.nextLine();
        staf = new Staf(stafName, totalAttendance);
        System.out.println();

        System.out.print("Nama Dosen ::> ");
        String lecturerName = sc.nextLine();
        System.out.print("Jumlah SKS ::> ");
        int credit = sc.nextInt();
        sc.nextLine();
        lecturer = new Lecturer(lecturerName, credit);
        System.out.println();

        System.out.print("Nama Pegawai ::> ");
        String employeeName = sc.nextLine();
        ordinaryEmployee = new OrdinaryEmployee(employeeName);
        System.out.println();
        
        sc.close();
    }

    private static void showResult(){
        staf.result();
        lecturer.result();
        ordinaryEmployee.result();
    }
}