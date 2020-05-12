package bangun_datar;

public class Persegi extends BangunDatar{
    
    double sisi;

    public Persegi(double sisi){
        this.sisi = sisi;
    }

    @Override
    public double luas(){
        return sisi*sisi;
    }

    @Override
    public double keliling(){
        return 4*sisi;
    }
}