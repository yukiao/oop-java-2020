import bangun_ruang.*;

import java.util.Scanner;

import bangun_datar.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Geometry Calculator =====");
        System.out.println("1. Bangun Ruang");
        System.out.println("2. Bangun Datar");
        System.out.print("Pilih : ");
        
        int choice = sc.nextInt();

        switch(choice){
            case 1 :
                System.out.println("===== BANGUN RUANG =====");
                System.out.println("1. KUBUS");
                System.out.println("2. BALOK");
                System.out.println("3. PRISMA SEGITIGA");
                System.out.println("4. BOLA");
                System.out.println("5. TABUNG");
                System.out.print("Pilih : ");

                int nextChoice = sc.nextInt();

                switch(nextChoice){
                    case 1 :
                        System.out.print("Sisi = ");
                        double sisi = sc.nextDouble();
                        Kubus kubus = new Kubus(sisi);
                        kubus.showResult();
                        break;
                    case 2 :
                        //Complete this section
                        break;
                    case 3 :
                        //Complete this section
                        break;
                    case 4 :
                        //Complete this section
                        break;
                    case 5 :
                        //Complete this section
                        break;    
                    default:
                        System.out.println("Inputan salah");
                        break;
                }
                break;
            case 2 :
                
                break;
            default:
                System.out.println("Inputan salah");
                break;
        }

    }
}