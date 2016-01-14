package DiningPhilosophers.View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import DiningPhilosophers.Model.Chopstick;
import DiningPhilosophers.Model.Philosopher;
import DiningPhilosophers.Utils.Timer;

import org.apache.log4j.Logger;

public class Controller implements Initializable{

    private static Logger LOG = Logger.getLogger(Controller.class);

    // List with philosophers
    ArrayList<Philosopher> philosopherArrayList;

    // List with chopsticks
    ArrayList<Chopstick> chopstickArrayList;

    // List with threads.
    // This is used to iterate over for start and stop of the simulation
    ArrayList<Thread> threadArrayList;

    // List with circles.
    // Each circle in the list that corresponds to philosopher is passed as an argument when a philosopher is created.
    // We use the circle object to modify the color depending on philosopher state (thinking/hungry/eating).
    ArrayList<Circle> circleArrayList = new ArrayList<Circle>();

    // List with rectangles
    // Each rectangle in the list is passed to corresponding chopstick then chopstick is created.
    // We use the rectangle object to modify the color of the state (pick/drop)
    ArrayList<Rectangle> rectangleArrayList = new ArrayList<Rectangle>();

    // List with timers.
    // Used to update the table with average execution time.
    ObservableList<Timer> timers = FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resources) {                // This function runs at startup

        System.out.println("Starting up.....");
        LOG.info("\n\nApplication starting up......");
        stopButton.setDisable(true);

        circleArrayList.add(phil0);
        circleArrayList.add(phil1);
        circleArrayList.add(phil2);
        circleArrayList.add(phil3);
        circleArrayList.add(phil4);

        rectangleArrayList.add(stick0);
        rectangleArrayList.add(stick1);
        rectangleArrayList.add(stick2);
        rectangleArrayList.add(stick3);
        rectangleArrayList.add(stick4);

        TableColumn<Timer, Double> avgThinkingColumn = new TableColumn<Timer, Double>("averageThinking");
        avgThinkingColumn.setCellValueFactory(new PropertyValueFactory("averageThinking"));

        TableColumn<Timer, Double> avgEatingColumn = new TableColumn<Timer, Double>("averageEating");
        avgEatingColumn.setCellValueFactory(new PropertyValueFactory("averageEating"));

        TableColumn<Timer, Double> avgHungerColumn = new TableColumn<Timer, Double>("averageHungry");
        avgHungerColumn.setCellValueFactory(new PropertyValueFactory("averageHungry"));

        table.getColumns().setAll(avgThinkingColumn, avgEatingColumn, avgHungerColumn);
        table.setItems(timers);

        timers.add(0, new Timer());
        timers.add(1, new Timer());
        timers.add(2, new Timer());
        timers.add(3, new Timer());
        timers.add(4, new Timer());


    }

    @FXML
    private Circle phil0;

    @FXML
    private Circle phil1;

    @FXML
    private Circle phil2;

    @FXML
    private Circle phil3;

    @FXML
    private Circle phil4;

    @FXML
    private Rectangle stick0;

    @FXML
    private Rectangle stick1;

    @FXML
    private Rectangle stick2;

    @FXML
    private Rectangle stick3;

    @FXML
    private Rectangle stick4;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private TableView<Timer> table;

    @FXML
    void start() {
        LOG.info("Start session.");
        startButton.setDisable(true);
        stopButton.setDisable(false);
        System.out.println("Start");
        philosopherArrayList = new ArrayList<Philosopher>();
        chopstickArrayList = new ArrayList<Chopstick>();
        threadArrayList = new ArrayList<Thread>();

        int n = 5;                                                                          // Number of philosophers.

        for(int i = 0; i < n; i++){
            chopstickArrayList.add(new Chopstick(i, rectangleArrayList.get(i)));
        }

        for(int i = 0; i < n; i++){
            philosopherArrayList.add(new Philosopher(i, chopstickArrayList.get(i), chopstickArrayList.get((i+1)%n), new Timer(), circleArrayList.get(i), timers));
        }

        for (Philosopher philosopher: philosopherArrayList){
            Thread p = new Thread(philosopher);
            p.start();
            threadArrayList.add(p);
        }
    }

    @FXML
    void stop() {
        startButton.setDisable(false);
        stopButton.setDisable(true);
        System.out.println("Stop");
        for (Thread t: threadArrayList){
            t.stop();
        }
        LOG.info("Stop session.\n\n");
    }

}

