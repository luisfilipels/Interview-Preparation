import random
from bubbleSort import bubbleSort
from insertionSort import insertionSort
from helperFunctions import *
import time
import matplotlib.pyplot as plt
from bubbleWFlag import bubbleWFlag
from selectionSort import selectionSort

vect = randList(6)
#vect = [5, 4, 3, 2, 1]
#print(vect, sep=' ')
printIfSorted(vect)
#start_time = time.time()
#bubbleSort(vect)
selectionSort(vect)
#insertionSort(vect)
#bubbleWFlag(vect)
#exec_time = time.time() - start_time
#print(vect, sep=' ')
printIfSorted(vect)
#print("Time taken: ")
#print(time.strftime("%H:%M:%S", time.gmtime(exec_time)))
elapsed = time.time()

#while secondsToInt(elapsed) < 30:
