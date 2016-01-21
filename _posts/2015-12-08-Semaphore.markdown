---
layout: post
title:  "Semaphore"
date:   2015-12-08 12:10:21 +0100
categories: java python semaphore
---

## Resources
* [Wikipedia](https://en.wikipedia.org/wiki/Semaphore_(programming))
* [Python 3.5 Documentation](https://docs.python.org/3.5/library/threading.html#semaphore-objects)
* [Jenkov Tut](http://tutorials.jenkov.com/java-util-concurrent/semaphore.html)

-------------------------------------------------------------------------------------------

## Introduction
* A semaphore is a variable or abstract data type that is used to control access to common resources.
* Semaphores are a useful tool in prevention of race conditions.
* Has found wide spread use in variety of operating systems.
* Its often used as the control mechanism for I/O controllers.
* Semaphore usage:
  1. To guard a critical section against entry by more than N threads at a time.
  2. To send signals between two threads.

-------------------------------------------------------------------------------------------

### acquire()
Acquire a semaphore.


### release()
Release the semaphore.

-------------------------------------------------------------------------------------------

## History
Semaphore concept was invented by Dutch computer scientist Edsger Dijkstra in 1962 or 1963.
This is one of the oldest synchronization primitives in the history of compute science.
[source](https://docs.python.org/3.5/library/threading.html#semaphore-objects)
* Instead of using acquire() and release(), he use P() and V().

-------------------------------------------------------------------------------------------

### Example in Python

In computer science, a semaphore is a variable or abstract data type that is used for controlling access, by multiple processes, to a common resource in a concurrent system such as a multiprogramming operating system.

-------------------------------------------------------------------------------------------

### Example in Java

* Lives in java.util.concurrent.Semaphore
* Is a counting semaphore
* Two main methods, acquire() and release().

#### Critical section

In this example we use a semaphore to guard a critical section.
{% highlight java %}
Semaphore semaphore = new Semaphore(1);

// Entering critical section
semaphore.acquire();

// Do critical stuff

semaphore.release();
// Exiting critical section
{% endhighlight %}


#### Sending signals between threads

