package bangun_datar;

public class Segitiga extends BangunDatar{

    double alas;
    double tinggi;

    public Segitiga(double alas, double tinggi){
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double luas(){
        return 0.5 * alas * tinggi;
    }

    @Override
    public double keliling(){
        return alas + tinggi + getSisiMiring();
    }

    private double getSisiMiring(){
        double miring;
        miring = Math.sqrt((Math.pow(alas, 2))+(Math.pow(tinggi, 2)));
        return miring;
    }
}
