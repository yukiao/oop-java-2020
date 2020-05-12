package bangun_datar;

public class Lingkaran extends BangunDatar{

    private double radius;

    public Lingkaran(double radius){
        this.radius = radius;
    }

    @Override
    public double keliling(){
        return 2 * Math.PI * radius;
    }

    @Override
    public double luas(){
        return Math.PI * Math.pow(radius, 2);
    }
}