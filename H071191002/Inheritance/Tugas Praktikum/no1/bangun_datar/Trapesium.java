package bangun_datar;

public class Trapesium extends BangunDatar{

    private double sisiAtas;
    private double sisiBawah;
    private double tinggi;

    public Trapesium (double sisiAtas, double sisiBawah, double tinggi){
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.tinggi = tinggi;
    }

    @Override
    public double luas(){
        return ((sisiAtas + sisiBawah)*tinggi)/2;
    }

    @Override
    public double keliling(){
        return sisiAtas + sisiBawah + tinggi + getSisiMiring();
    }

    private double getSisiMiring(){
        double sisiMiring;
        sisiMiring = Math.sqrt((Math.pow(sisiAtas-sisiBawah,2) + Math.pow(tinggi,2)));
        return sisiMiring;
    }
}