---
layout: post
title:  "Intro to parallel computing."
date:   2015-12-30 17:48:42 +0100
categories: parallel computing
---

## Resources
* [Packt, Parallel Programming with Python](https://www.packtpub.com/application-development/parallel-programming-python)
* [Wikipedia](https://en.wikipedia.org/wiki/Parallel_computing)

## The parallel computing memory architecture
* Single instruction, single data (SISD)
* Single instruction, multiple data (SIMD)
* Multiple instruction, single data (MISD)
* Multiple instruction, multiple data (MIMD)

This classification is known as [Flynn's taxonomy.](https://en.wikipedia.org/wiki/Flynn%27s_taxonomy)

### SISD (Single instruction stream, single data stream)
[Wikipedia](https://en.wikipedia.org/wiki/SISD)

A sequential computer which exploits no parallelism in either the instruction or data streams. Single control unit (CU) fetches single instruction stream (IS) from memory. The CU then generates appropriate control signals to direct single processing element (PE) to operate on single data stream (DS) i.e. one operation at a time.
Examples of SISD architecture are the traditional uniprocessor machines like a PC (currently manufactured PCs have multiple cores) or old mainframes.


### SIMD (Single instruction stream, multiple data streams)
[Wikipedia](https://en.wikipedia.org/wiki/SIMD)

A computer which exploits multiple data streams against a single instruction stream to perform operations which may be naturally parallelized. For example, an array processor or GPU.

### MISD (Multiple instruction streams, single data stream)
[Wikipedia](https://en.wikipedia.org/wiki/MISD)

Multiple instructions operate on a single data stream. Uncommon architecture which is generally used for fault tolerance. Heterogeneous systems operate on the same data stream and must agree on the result. Examples include the Space Shuttle flight control computer.

### MIMD (Multiple instruction streams, multiple data streams)
[Wikipedia](https://en.wikipedia.org/wiki/MIMD)

Multiple autonomous processors simultaneously executing different instructions on different data. Distributed systems are generally recognized to be MIMD architectures; either exploiting a single shared memory space or a distributed memory space. A multi-core superscalar processor is a MIMD processor.

---------------------------------------------------------------------------------------------------------------------

## Memory organization

"In a system, shared memory is suf cient to build a data structure in memory and go to the parallel subroutine, which are the reference variables of this data structure. Moreover, a distributed memory machine must make copies of shared data in each local memory."

### Shared memory


![Img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Shared_memory.svg/450px-Shared_memory.svg.png)


* [Wikipedia](https://en.wikipedia.org/wiki/Shared_memory)

"In computer science, shared memory is memory that may be simultaneously accessed by multiple programs with an intent to provide communication among them or avoid redundant copies. Shared memory is an efficient means of passing data between programs. Depending on context, programs may run on a single processor or on multiple separate processors.
Using memory for communication inside a single program, for example among its multiple threads."

The main features of shared memory systems are:

* The memory is the same for all processors, for example, all the processors associated with the same data structure will work with the same logical memory addresses, thus accessing the same memory locations.

* The synchronization is made possible by controlling the access of processors to the shared memory. In fact, only one processor at a time can have access to the memory resources.

* A shared memory location must not be changed from a task while another task accesses it.

* Sharing data is fast; the time required for the communication between two tasks is equal to the time for reading a single memory location (it is depending on the speed of memory access).


### Shared memory systems may use:

#### Uniform memory access (UMA)

All the processors share the physical memory uniformly.

Sometimes called Symmetric multiprocessor (SMP)

#### Non-uniform memory access (NUMA)

Memory access time depends on the memory location relative to a processor.

Sometimes called Distributed Shared Memory Systems (DSM)

#### Cache-only memory architecture (COMA)

The local memories for the processors at each node is used as cache instead of as actual main memory.


--------------------------------------------------------------------------


### Distributed memory

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Distributed_Memory.jpeg/600px-Distributed_Memory.jpeg)

In computer science, distributed memory refers to a multiprocessor computer system in which each processor has its own private memory. Computational tasks can only operate on local data, and if remote data is required, the computational task must communicate with one or more remote processors. In contrast, a shared memory multiprocessor offers a single memory space used by all processors. Processors do not have to be aware where data resides, except that there may be performance penalties, and that race conditions are to be avoided.


#### Main features of distributed memory

* Memory is physically distributed between processors; each local memory is directly accessible only by its processor.

* Synchronization is achieved by moving data (even if it's just the message itself) between processors (communication).

* The subdivision of data in the local memories affects the performance of the machine—it is essential to make a subdivision accurate, so as to minimize the communication between the CPUs. In addition to this, the processor that coordinates these operations of decomposition and composition must effectively communicate with the processors that operate on the individual parts of data structures.

* The message-passing protocol is used so that the CPU's can communicate with each other through the exchange of data packets. The messages are discrete units of information; in the sense that they have a well-de ned identity, so it is always possible to distinguish them from each other.




------------------------------

You’ll find this post in your `_posts` directory. Go ahead and edit it and re-build the site to see your changes. You can rebuild the site in many different ways, but the most common way is to run `jekyll serve`, which launches a web server and auto-regenerates your site when a file is updated.

To add new posts, simply add a file in the `_posts` directory that follows the convention `YYYY-MM-DD-name-of-post.ext` and includes the necessary front matter. Take a look at the source for this post to get an idea about how it works.

Jekyll also offers powerful support for code snippets:

{% highlight ruby %}
def print_hi(name)
  puts "Hi, #{name}"
end
print_hi('Tom')
#=> prints 'Hi, Tom' to STDOUT.
{% endhighlight %}

Check out the [Jekyll docs][jekyll-docs] for more info on how to get the most out of Jekyll. File all bugs/feature requests at [Jekyll’s GitHub repo][jekyll-gh]. If you have questions, you can ask them on [Jekyll Talk][jekyll-talk].

[jekyll-docs]: http://jekyllrb.com/docs/home
[jekyll-gh]:   https://github.com/jekyll/jekyll
[jekyll-talk]: https://talk.jekyllrb.com/
