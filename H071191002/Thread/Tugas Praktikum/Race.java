import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private Integer runner = 0;
    private List<String> runners = Collections.synchronizedList(new ArrayList<>());
    private boolean started = false;
    
    public void start() {
        if (runner >= 3) {
            System.out.println("The race is started");
            started = true;
        }
    }
    public void result() {
         if(getRank()==runner){
            try {
                Thread.sleep(runner * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The race is over.");
            System.out.printf("1st : %s\n",runners.get(0));
            System.out.printf("2nd : %s\n",runners.get(1));
            System.out.printf("3rd : %s\n",runners.get(2));
            for(int i = 3; i < runners.size(); i++){
                System.out.printf("%s losses\n", runners.get(i));
            }
        }
    }
    public void addRunner(){
        runner++;
    }
    public Integer getRunner(){
        return runner;
    }
    public void addRunnerName(String name){
        runners.add(name);
    }
    public int getRank(){
        return runners.size();
    }

    public boolean checkStarted(){
        return started;
    }
}