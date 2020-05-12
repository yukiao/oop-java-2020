package bangun_ruang;

public class PrismaSegitiga extends BangunRuang{
    private double panjangAlas;
    private double tinggiAlas;
    private double tinggiPrisma;

    public PrismaSegitiga(double panjangAlas, double tinggiAlas, double tinggiPrisma){
        this.panjangAlas  = panjangAlas;
        this.tinggiAlas   = tinggiAlas;
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double luasPermukaan(){
        return 0;
    }
    @Override
    public double volume(){
       return 0;
    }
}
