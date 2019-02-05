import random
from bubbleSort import bubbleSort
from insertionSort import insertionSort
from helperFunctions import *
import time
import matplotlib.pyplot as plt
from bubbleWFlag import bubbleWFlag
from selectionSort import selectionSort
import timeit


#vect = randList(6)
#vect = [5, 4, 3, 2, 1]
#print(vect, sep=' ')
#printIfSorted(vect)
#start_time = time.time()
#bubbleSort(vect)
#selectionSort(vect)
#insertionSort(vect)
#bubbleWFlag(vect)
#exec_time = time.time() - start_time
#print(vect, sep=' ')
#printIfSorted(vect)
#print("Time taken: ")
#print(time.strftime("%H:%M:%S", time.gmtime(exec_time)))
#elapsed = time.time()

#while secondsToInt(elapsed) < 30:
tempo = timeit.timeit("geraLista({})".format(100),setup="from helperFunctions import geraLista",number=10)
tempo2 = timeit.timeit("geraLista({})".format(1000),setup="from helperFunctions import geraLista",number=10)
tempo3 = timeit.timeit("geraLista({})".format(50000),setup="from helperFunctions import geraLista",number=10)



desenhaGrafico([100, 1000, 50000], [tempo, tempo2, tempo3])
