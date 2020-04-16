public class ConverterData extends Converter implements Data{

    @Override
    public void start() {
        System.out.println("Data Converter is started");
    }

    @Override
    public void end() {
        System.out.println("Data Converter is terminated");
    }

    @Override
    public long teraToKilo(long value) {
        return value * 1073741824L;
    }

    @Override
    public long teraToMega(long value) {
        return value * 1048576;
    }

    @Override
    public long teraToGiga(long value) {
        return value * 1024;
    }
}