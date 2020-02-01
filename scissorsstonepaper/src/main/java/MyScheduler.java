import java.util.HashMap;
import java.util.TimerTask;

public class MyScheduler extends TimerTask {
    private HashMap<String, Integer> statistics;

    public MyScheduler(HashMap<String, Integer> statistics){
        this.statistics = statistics;
    }

    public void run(){ //in Spring mit @Scheduled(fixedRate=1000)
        System.out.println("Wins: " + statistics.get("wins") + ", Loses: " + statistics.get("loses") +
                ", Draws: " + statistics.get("draws"));
    }
}