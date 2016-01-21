
"""
In this example we will run 2 threads.
Both threads will work against the same global var.
We use a Lock to make sure that critical code section
can only be used by one thread at a time.
"""

import threading

global_var = 0
number_of_iterations = 100000
lock = threading.Lock()  # Lock

def increment():
    global global_var
    for i in range(0, number_of_iterations):
        lock.acquire()
        global_var += 1  # Critical code section
        lock.release()        

def decrement():
    global global_var
    for i in range(0, number_of_iterations):
        lock.acquire()                
        global_var -= 1  # Critical code section
        lock.release()        

if __name__ == '__main__':
    t1 = threading.Thread(target=increment)  # Create increase thread
    t2 = threading.Thread(target=decrement)  # Create decrease thread
    t1.start()  # Start increase thread
    t2.start()  # Start decrease thread
    t1.join()  # Join in thread to main thread
    t2.join()  # Join in thread to main thread

    print('global_var = {}'.format(global_var))

    """
    No both Python2 and Python3 work as expected.
    We take care of the critical code section by using a lock.
    """
