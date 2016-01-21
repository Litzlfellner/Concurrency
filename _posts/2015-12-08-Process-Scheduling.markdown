---
layout: post
title:  "Process Scheduling"
date:   2015-12-08 12:05:21 +0100
categories: java concurrency critical code section synchronization
---

### Resources
* [Tutorials Point](http://www.tutorialspoint.com/operating_system/)
* [Book](http://cdon.se/b%C3%B6cker/abraham_silberschatz/operating_system_concepts-23554228)

## Preemptive, Non-Preemptive
* Preemptive:
  * Allow preemption of process.
  * This allows the process to be taken away and paused while another process is executing.
  * Context-Switching
  
* Non-Preemptive
  * Real time systems.
  * One process needs to run until it finished.
  * Doent allow Context-Switching.

------------------------------------------------------------------------------------------------------

## Solutions to Critical-Section problem

1. Mutal Exclusion
  * If process P1 is executing in its critical section, then no other process can execute in their critical section.

2. Progress
  * If no process is executing in its critical section and there exist some processes that wish to enter their
  critical section, then the selection of the processes that will enter the critical section next cannot be postponed
  indefinitely.
  * means that the process will eventually do some work - an example of where this may not be the case is when a low-priority
  thread might be pre-empted and rolled back by high-priority threads. Once your processes reach
  their critical section they won't be pre-empted, so they'll make progress.
  [Source](http://stackoverflow.com/questions/25962097/what-is-progress-and-bounded-waiting-in-critical-section-algorithm)

3. Bound waiting
  * A bound must exist on the number of times that other processes are allowed to enter their critical sections
  after a process has made a request to enter its critical section and before the request s granted.
  * Assume that each process executes at a non-zero speed.
  * No assumption concidering "relative speed"of the N process.
  * means that the process will eventually gain control of the processor - an example of where this may not be the case is when a
  nother process has a non-terminating loop in a critical section with no possibility of the th read being interrupted.
  Your code has bounded waiting IF the critical sections terminate AND the remainder
  section will not re-invoke the process's critical section
  (otherwise a process might keep running its critical secti  on without the other process ever gaining control of the processor).
  [Source](http://stackoverflow.com/questions/25962097/what-is-progress-and-bounded-waiting-in-critical-section-algorithm)

------------------------------------------------------------------------------------------------------

## Scheduling Algorithms

------------------------------------------------------------------------------------------------------

##  First-Come, First-Served 
![Image of first-come, first-served](http://image.slidesharecdn.com/final-130402232110-phpapp02/95/cpu-scheduling-algorithms-11-638.jpg?cb=1364945443)

------------------------------------------------------------------------------------------------------

##  Shortest-Job-First 
![Image of shortest-job-first](http://image.slidesharecdn.com/final-130402232110-phpapp02/95/cpu-scheduling-algorithms-13-638.jpg?cb=1364945443)

------------------------------------------------------------------------------------------------------

##  Priority 
![Image of priority](http://image.slidesharecdn.com/final-130402232110-phpapp02/95/cpu-scheduling-algorithms-17-638.jpg?cb=1364945443)

------------------------------------------------------------------------------------------------------

##  Round-Robin 
![Image of round-robin](http://image.slidesharecdn.com/final-130402232110-phpapp02/95/cpu-scheduling-algorithms-19-638.jpg?cb=1364945443)

------------------------------------------------------------------------------------------------------

##  Multilevel Queue 
![Image of multi-queue](http://www.read.cs.ucla.edu/111/_media/notes/mlq.png)

------------------------------------------------------------------------------------------------------

##  Multilevel Feedback Queue 
![Image of multi-feedback-queue](http://www.read.cs.ucla.edu/111/_media/notes/mlfeedback.png)

------------------------------------------------------------------------------------------------------

