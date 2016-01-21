
"""
In this example we will run 2 threads.
Both threads will work against the same global var.
The value should then be 0 again, or?
This illustrates a synchronization problem.
"""

import threading

global_var = 0
number_of_iterations = 100000

def increment():
    global global_var
    for i in range(0, number_of_iterations):
        global_var += 1

def decrement():
    global global_var
    for i in range(0, number_of_iterations):
        global_var -= 1

if __name__ == '__main__':
    t1 = threading.Thread(target=increment)  # Create increase thread
    t2 = threading.Thread(target=decrement)  # Create decrease thread
    t1.start()  # Start increase thread
    t2.start()  # Start decrease thread
    t1.join()  # Join in thread to main thread
    t2.join()  # Join in thread to main thread

    print('global_var = {}'.format(global_var))

    """
    The problem here is that there is no controll in the critical section.
    Python3 seems to handle this example much better than Python2
    """
