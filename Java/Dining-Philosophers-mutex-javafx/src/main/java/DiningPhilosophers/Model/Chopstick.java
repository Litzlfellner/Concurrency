package DiningPhilosophers.Model;

import java.util.concurrent.locks.ReentrantLock;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import org.apache.log4j.Logger;

public class Chopstick {

    // Log4j logger
    private static Logger LOG = Logger.getLogger(Chopstick.class);

    // Chopstick id
    private int id;

    // If chopstick is taken or not.
    private boolean taken = false;

    // Mutex lock
    private final ReentrantLock lock = new ReentrantLock();

    // Rectangle object comes from View.Controller.
    // It is used to visualize the pick and drop.
    private Rectangle rectangle;

    // Construct
    public Chopstick(int id, Rectangle rectangle) {
        this.id = id;
        this.rectangle = rectangle;
    }

    public boolean isTaken() {
        return taken;
    }

    public void pick(Philosopher philosopher) {

            this.lock.lock();                                                                           // Enter critical code section
            this.rectangle.setFill(Paint.valueOf("#000000"));                                           // Change color off the stick
            this.taken = true;                                                                          // Chopstick is taken
            System.out.println(philosopher + " picked up chopstick nr " + Integer.toString(this.id));   // Pick Print in console
            LOG.info(philosopher + " picked up chopstick nr " + Integer.toString(this.id));             // Pick to LOG

    }


    public void drop(Philosopher philosopher) {

        if(this.lock.isHeldByCurrentThread()){                                                          // If we are the owning thread
            this.taken = false;                                                                         // Drop chopstick
            this.rectangle.setFill(Paint.valueOf("#ffffff"));                                           // Change color off the stick
            this.lock.unlock();                                                                         // Exit critical code section
            System.out.println(philosopher + " droped up chopstick nr " + Integer.toString(this.id));   // Drop Print
            LOG.info(philosopher + " droped up chopstick nr " + Integer.toString(this.id));             // Drop LOG
        }

    }
}
