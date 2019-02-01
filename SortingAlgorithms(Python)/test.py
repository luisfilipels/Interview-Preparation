import random
from bubbleSort import bubbleSort
from insertionSort import insertionSort
from helperFunctions import *
import time
import matplotlib.pyplot as plt
from bubbleWFlag import bubbleWFlag

vect = randList(1001)
#vect = [2, 4, 5, 3]
#print(vect, sep=' ')
printIfSorted(vect)
#start_time = time.time()
bubbleSort(vect)
#insertionSort(vect)
#bubbleWFlag(vect)
#exec_time = time.time() - start_time
#print(vect, sep=' ')
printIfSorted(vect)
#print("Time taken: ")
#print(time.strftime("%H:%M:%S", time.gmtime(exec_time)))
elapsed = time.time()

#while secondsToInt(elapsed) < 30:
