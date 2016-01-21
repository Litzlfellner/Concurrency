---
layout: post
title:  "Syncronization"
date:   2015-12-08 12:05:21 +0100
categories: java concurrency critical code section synchronization
---

### Resources
* [Tutorials Point](http://www.tutorialspoint.com/operating_system/)
* [Book](http://cdon.se/b%C3%B6cker/abraham_silberschatz/operating_system_concepts-23554228)

### Intro

Synchronization refers to the idea that multiple processes or threads are to link or handshake at a certain point, so as to reach an agreement or commit to a certain sequence of action. It can also include communication between processes or threads.

Syncronization is the 

### Producer-Consumer

This is a syncronization problem.

Watch the following example:

{% highlight python %}

items = []

def producer():

    while len(items) == 10:
       pass  # Dont produce anymore items
    
    items.append(random.randInt())
    
def consumer():

    while len(items) == 0:
       pass  # Dont consume anymore items

    items.pop()
    
{% endhighlight %}

2 threads are running the and using producer() and consumer().
This code looks valid but it is not. We need to have some controll over it.


### Critical-Section

In synchronization, "Critical code section" is the code section where problems in synchronization can occur.
If two threads would run in parallel.
One thread would increment the global_var 10000 times and one thread would decrement the global_var 10000 times, the result would be 0 again right?

This may not be the case.

{% highlight python %}

import threading

global_var = 0

def increment():
    global global_var
    for i in range(0, 10000):
        global_var += 1  # This is a critical section

def decrement():
    global global_var
    for i in range(0, 10000):
        global_var -= 1  # This is a critical section

thread1 = threading.Thread(target=increment)
thread2 = threading.Thread(target=decrement)
thread1.start()
thread2.start()
thread1.join()
thread2.join()

print(global_var)

# Examples of execution:
# -2210
# -1888
# 455
# 606
# 9888
{% endhighlight %}




### Peterson's Solution


### Mutex Locks


### Semaphores


### Classical Problems of Synchronization

#### The Bounded-Buffer Problem

#### The Readers-Writers Problem

#### The Dinning-Philosophers Problem


### Monitors



