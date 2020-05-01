public class Main{
    public static void main(String[] args) {
        Integer number = 0;
        Race race = new Race();
        Runner[] runners = new Runner[10];
    
        for (int i = 0; i < runners.length; i++) {
          runners[i] = new Runner(++number);
          runners[i].joinRace(race);
        }
    
        race.start();
        
        if(race.checkStarted()){
          for (Runner runner : runners) {
            runner.start();
          }
      
          race.result();
        }else{
          if(race.getRunner() < 10){
            System.out.println("The race cannot be started, runners are not enough");
            return;
          }
          for(Runner runner : runners){
            System.out.printf("Hey %s, the race hasn't started yet\n",runner.getRunnerName());
          }
        }
      }
}