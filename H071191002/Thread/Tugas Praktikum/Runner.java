class Runner implements Runnable {
    private Integer number;
    private Thread thread;
    private Race race;

    public Runner(Integer number) {
        this.number = number;
        
    }

    public Runner joinRace(Race race) {
        if (this.race == null) {
            this.race = race;
            thread = new Thread(this);
        }
        race.addRunner();
        return this;
    }

    public String getRunnerName() {
        return String.format("Runner-%d", number);
    }
    public void start() {
        if(thread != null){
            thread.start();
        }else{
            System.out.printf("%s have not entered any race\n",getRunnerName());
        }
    }
    @Override
    public void run() {
        System.out.printf("%s is running ...\n",getRunnerName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        race.addRunnerName("Runner-"+this.number);
    }
}