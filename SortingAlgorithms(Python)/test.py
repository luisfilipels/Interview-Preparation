import random
from bubbleSort import bubbleSort
from insertionSort import insertionSort
from helperFunctions import *
import time
import matplotlib.pyplot as plt
from bubbleWFlag import bubbleWFlag
from selectionSort import selectionSort
import timeit
import datetime

setup = "from helperFunctions import geraLista\n" \
        "from bubbleSort import bubbleSort"
vect = geraLista(15000)
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
#tempo = timeit.timeit("geraLista({})".format(100),setup="from helperFunctions import geraLista",number=1)
#tempo2 = timeit.timeit("geraLista({})".format(1000),setup="from helperFunctions import geraLista",number=1)
#tempo3 = timeit.timeit("geraLista({})".format(50000),setup="from helperFunctions import geraLista",number=1)

tempo = []
passo = []
for x in range(5000, len(vect)+1, 5000):
    tempo.append(datetime.timedelta(seconds=timeit.timeit("bubbleSort({})".format(vect[0:x].copy()), setup, number=1)))
    print(tempo)
    passo.append(x)


#tempo = timeit.timeit("geraLista({})".format(vect[0:]))



desenhaGrafico(passo, tempo)
