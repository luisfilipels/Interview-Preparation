import random
from bubbleSort import bubbleSort
import bubbleSort
from insertionSort import insertionSort
from helperFunctions import *
import time
import matplotlib.pyplot as plt
from bubbleWFlag import bubbleWFlag
from selectionSort import selectionSort
import timeit
import datetime
import variables
from shellSort import shellSort

setup = "from helperFunctions import geraLista\n" \
        "from shellSort import shellSort"
vect = geraLista(50000)

#vect = [5, 3, 2, 7, 1, 0, 8, 6, 4]
#shellSort(vect)
#print(vect)
#printIfSorted(vect)

swaps = []
tempo = []
passo = []
for x in range(10000, len(vect)+1, 10000):
    tempo.append(timeit.timeit("shellSort({})".format(vect[0:x].copy()), setup, number=1))
    #print(tempo)
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    print("Tempo: {}\n".format(tempo.copy().pop()))



desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo")
desenhaGrafico(passo, swaps, xl="Elementos", yl="Swaps")

#desenhaGrafico(passo, tempo)
