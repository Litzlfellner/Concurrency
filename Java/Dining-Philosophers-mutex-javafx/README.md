
## Dining-Philosophers with mutex lock on chopsticks.

* JavaFX application to simulate the session.
* Calculates the average execution time on thinking/hungry/eating
* Log4j used for log output

### Problems

The algorithm or times is not optimised.
The average hungry time is bigger that thinking/eating.
This may be solved by optimizing the time in Utils/Utils/RandIntWaitForEating().
This time is the time a philosopher waits before he tries to pick up the chopsticks again (if she fails to pick them up)

### Build and run

This project needs Maven!


Intellij

* Open project with Intellig
* Mark "Dining-Philosophers-mutex-javafx" as source root
* Run Main.java


Maven

* mvn3 package
* java -jar target/Dining-Philosophers-mutex-javafx-1.0-SNAPSHOT.one-jar.jar 