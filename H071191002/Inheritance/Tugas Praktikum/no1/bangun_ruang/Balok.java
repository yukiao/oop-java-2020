package bangun_ruang;
class Balok extends BangunRuang{
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi){
        this.panjang = panjang;
        this.lebar   = lebar;
        this.tinggi  = tinggi;
    }
    @Override
    public double luasPermukaan(){
        return (2*(panjang*lebar)+2*(panjang*tinggi)+2*(lebar*tinggi));
    }

    @Override
    public double volume(){
        return panjang*lebar*tinggi;
    }
}