package DiningPhilosophers.Utils;

import java.util.concurrent.atomic.LongAdder;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Timer {
    LongAdder thinkingTime = new LongAdder();
    int thinkCounter = 0;
    LongAdder eatingTime = new LongAdder();
    int eatingCounter = 0;
    LongAdder hungryTime = new LongAdder();
    int hungryCounter = 0;
    private DoubleProperty averageThinking;
    private DoubleProperty averageEating;
    private DoubleProperty averageHungry;



    public Timer() {
    }


    public void setAverageThinking(Double value) { averageThinkingProperty().set(value); }
    public DoubleProperty averageThinkingProperty() {
        if (averageThinking == null) averageThinking = new SimpleDoubleProperty(this, "averageThinking");
        return averageThinking;
    }

    public void setAverageEating(Double value) { averageEatingProperty().set(value); }
    public DoubleProperty averageEatingProperty() {
        if (averageEating == null) averageEating = new SimpleDoubleProperty(this, "averageEating");
        return averageEating;
    }

    public void setAverageHungry(Double value) { averageHungryProperty().set(value); }
    public DoubleProperty averageHungryProperty() {
        if (averageHungry == null) averageHungry = new SimpleDoubleProperty(this, "averageHungry");
        return averageHungry;
    }


    public long getThinkingTime() {
        return thinkingTime.longValue();
    }

    public void addThinkingTime(long thinkingTime) {
        this.thinkingTime.add(thinkingTime);
    }

    public int getThinkCounter() {
        return thinkCounter;
    }

    public void increateThinkCounter() {
        this.thinkCounter++;
    }

    public long getEatingTime() {
        return eatingTime.longValue();
    }

    public void addEatingTime(long eatingTime) {
        this.eatingTime.add(eatingTime);
    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    public void increateEatingCounter() {
        this.eatingCounter++;
    }

    public long getHungryTime() {
        return hungryTime.longValue();
    }

    public void addHungryTime(long hungryTime) {
        this.hungryTime.add(hungryTime);
    }

    public int getHungryCounter() {
        return hungryCounter;
    }

    public void increaseHungryCounter() {
        this.hungryCounter++;
    }

    @Override
    public String toString() {
        return "Timer{" + "\n" +
                "\tthinkingTime=" + Long.toString(thinkingTime.longValue()) + "\n" +
                "\tthinkCounter=" + Integer.toString(thinkCounter) + "\n" +
                "\teatingTime=" + Long.toString(eatingTime.longValue()) + "\n" +
                "\teatingCounter=" + Integer.toString(eatingCounter) + "\n" +
                "\thungryTime=" + Long.toString(hungryTime.longValue()) + "\n" +
                "\thungryCounter=" + Integer.toString(hungryCounter) + "\n" +
                '}';
    }
}
