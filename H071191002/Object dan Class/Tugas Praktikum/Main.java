public class Main {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        
        //Menyalakan lampu berwarna biru
        bulb.turnOn(); 

        //Method tidak dieksekusi karena lampu biru menyala.Pesan error ditampilkan
        bulb.turnOn(); 

        // Menampilkan status lampu
        System.out.println(bulb.getState());
        
        //Menukar lampu yang menyala ke merah
        bulb.switchBulb();

        //Menampilkan status lampu
        System.out.print(bulb.getState());

    }
    
}