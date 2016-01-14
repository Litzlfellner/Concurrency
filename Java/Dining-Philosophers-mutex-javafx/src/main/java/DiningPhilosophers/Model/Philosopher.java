package DiningPhilosophers.Model;

import DiningPhilosophers.Utils.Timer;
import DiningPhilosophers.Utils.Utils;
import javafx.collections.ObservableList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import org.apache.log4j.Logger;

public class Philosopher implements Runnable{

    // Log4j logger
    private static Logger LOG = Logger.getLogger(Philosopher.class);

    private int id;
    private Chopstick chopstickLeft;
    private Chopstick chopstickRight;
    private Status status = Status.THINKING;

    // Timer is an object that messures the time thinking/hungry/eating have been running
    // and how many time each have been called.
    private Timer timer;

    // Circle is the GUI object.
    // Manipulate the colors to make it more visual in what state a philosopher is (thinking/hungry/eating).
    private Circle circle;

    // Used to update the values in the GUI list.
    private ObservableList<Timer> timers;

    public Philosopher(int id, Chopstick chopstickLeft, Chopstick chopstickRight, Timer timer, Circle circle, ObservableList<Timer> timers) {
        this.id = id;
        this.chopstickLeft = chopstickLeft;
        this.chopstickRight = chopstickRight;
        this.timer = timer;
        this.circle = circle;
        this.timers = timers;
    }

    public void run(){

            do{
                think();                                                                // Think

                if (this.status == Status.HUNGRY){                                      // If hungry, try to eat
                    hungry();
                }

                // Update the table in GUI
                // Gets the time thinking/hungry/eating have bee running
                // divide that with how many times we have have been in thinking/hungry/eating function
                // divide that result with 1000 to get the average thinking/hungry/eating in secondes
                timers.get(this.id).setAverageEating(new Double((this.timer.getEatingTime()/this.timer.getEatingCounter())/1000));
                timers.get(this.id).setAverageHungry(new Double((this.timer.getHungryTime()/this.timer.getHungryCounter())/1000));
                timers.get(this.id).setAverageThinking(new Double((this.timer.getThinkingTime()/this.timer.getThinkCounter())/1000));

            } while (true);

    }

    private void think(){
        this.status = Status.THINKING;                                                  // Thinking Status
        this.circle.setFill(Paint.valueOf("#1e90ff"));                                  // Thinking Fill
        System.out.println(this.toString()+ " is " + this.status.name());               // Thinking Print
        LOG.info(this.toString()+ " is " + this.status.name());                         // Thinking LOG
        this.timer.increateThinkCounter();
        long startTime = System.currentTimeMillis();
        try{
            Thread.sleep(new Utils().RandIntEatAndThink());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.timer.addThinkingTime(System.currentTimeMillis()-startTime);               // Finished THINKING

        this.status = Status.HUNGRY;                                                    // Hungry Status
        this.circle.setFill(Paint.valueOf("#ff1f1f"));                                  // Hungry Fill
        System.out.println(this.toString()+ " is " + this.status.name());               // Hungry Print
        LOG.info(this.toString()+ " is " + this.status.name());                         // Hungry LOG

    }

    private void hungry(){
        // Here is the logic
        this.timer.increaseHungryCounter();                                             // Increase hungry counter
        long startTime = System.currentTimeMillis();                                    // Start timer
        if(!chopstickLeft.isTaken()){                                                   // Try to pick up left chopstick
            chopstickLeft.pick(this);                                                   // Pick up left chopstick
            if(!chopstickRight.isTaken()){                                              // Try to pick up right chopstick
                chopstickRight.pick(this);                                              // Pick up right chopstick
                this.timer.addHungryTime(System.currentTimeMillis()-startTime);         //
                this.status = Status.EATING;                                            // Eating Status
                this.circle.setFill(Paint.valueOf("#1fff35"));                          // Eating Fill
                System.out.println(this.toString()+ " is " + this.status.name());       // Eating Printing
                LOG.info(this.toString()+ " is " + this.status.name());                 // Eating LOG
                eating();

            }
            else {
                chopstickLeft.drop(this);
                try{
                    Thread.sleep(new Utils().RandIntWaitForEating());                   // Wait 1-3 sec before trying again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.timer.addHungryTime(System.currentTimeMillis()-startTime);
                hungry();                                                               // Try to get the chopsticks again

            }

        }
        else {

            try{
                Thread.sleep(new Utils().RandIntWaitForEating());                       // Wait 1-3 sec before trying again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.timer.addHungryTime(System.currentTimeMillis()-startTime);
            hungry();                                                                   // Try to get the chopsticks again

        }

        this.timer.addHungryTime(System.currentTimeMillis()-startTime);
    }

    private void eating(){

        this.timer.increateEatingCounter();
        long startTime = System.currentTimeMillis();

        try{
            Thread.sleep(new Utils().RandIntEatAndThink());                             // Eating
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.chopstickRight.drop(this);                                                 // Drop right chopstick
        this.chopstickLeft.drop(this);                                                  // Drop left chopstick
        this.timer.addEatingTime(System.currentTimeMillis()-startTime);
    }

    public String toString(){
        return "philosopher nr: "+Integer.toString(id);
    }

}
