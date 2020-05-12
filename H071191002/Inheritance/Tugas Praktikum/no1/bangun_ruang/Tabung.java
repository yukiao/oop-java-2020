package bangun_ruang;

public class Tabung extends BangunRuang{
    
    private double radius;
    private double tinggi;

    public Tabung(double radius, double tinggi){
        this.radius = radius;
        this.tinggi = tinggi;
    }

    @Override
    public double luasPermukaan(){
        return (2*(Math.PI*Math.pow(radius, 2)))+(2*Math.PI*radius*tinggi);
    }

    @Override
    public double volume(){
        return (Math.PI*Math.pow(radius,2)*tinggi);
    }
}