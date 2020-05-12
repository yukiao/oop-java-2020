package bangun_ruang;
public class Bola extends BangunRuang{
    private double radius;

    public Bola(double radius){
        this.radius = radius;
    }

    @Override
    public double luasPermukaan(){
        return 4*Math.PI*Math.pow(radius, 2);
    }

    @Override
    public double volume(){
        return (4*Math.PI*Math.pow(radius, 3))/3;
    }
}