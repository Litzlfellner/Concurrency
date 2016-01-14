package DiningPhilosophers.Utils;

import java.util.Random;

public class Utils {

    // Generate a time for eating and thinking
    public int RandIntEatAndThink(){
        int randTime = new Random().nextInt(30);
        return (randTime+1)*1000;  // 1 - 30 sec
    }

    // Generate a time for waiting to access hungry() again
    public int RandIntWaitForEating(){
        int randTime = new Random().nextInt(30);
        return (randTime+1)*100;  // 1 - 3 sec
    }

}
