class Bulb{
    //Inisialisasi atribut Bulb
    boolean blueIsOn; 
    boolean redIsOn; 

    //Inisisalisasi method turnOn untuk menyalakan lampu
    void turnOn() {
        try{
            if(redIsOn==false && blueIsOn==false){
                blueIsOn=true;
            }else{
                //Melempar exception jika salah satu lampu menyala 
                throw new Exception("Salah satu lampu menyala. Turn On dibatalkan\n\n"); 
            }
        }catch(Exception e){
            //Menampilkan pesan error
            System.out.println(e.getMessage()); 
        }
    }

    //Inisialisasi method switchBulb untuk menukar lampu yang menyala
    void switchBulb() {
        try{
            if(blueIsOn==true){
                redIsOn=true;
                blueIsOn=false;
            }else if(redIsOn==true){
                redIsOn=false;
                blueIsOn=true;
            }else{
                 //Melempar exception jika kedua lampu dalam keadaan padam
                throw new Exception("Kedua lampu dalam keadaan padam. Switch Bulb dibatalkan.\n\n");
            }
        }catch(Exception e){
            //Menampilkan pesan error
            System.out.println(e.getMessage());
        }
    }

    //Inisialisasi method turnOff untuk mematikan lampu yang menyala
    void turnOff(){
        blueIsOn=false;
        redIsOn=false;
    }

    //Inisialisasi method getState untuk menampilkan kondisi masing masing lampu
    String getState() {
        if(blueIsOn==true){
            return "Biru  : Menyala \nMerah : Padam\n\n";
        }
        else if(redIsOn==true){
            return "Biru  : Padam \nMerah : Menyala\n\n";
        }else{
            return "Biru  : Padam \nMerah : Padam\n\n";
        }

    }
}