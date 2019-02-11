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

setup = "from helperFunctions import geraLista\n" \
        "from bubbleSort import bubbleSort"
vect = geraLista(50000)
swaps = []
tempo = []
passo = []
for x in range(10000, len(vect)+1, 10000):
    tempo.append(timeit.timeit("bubbleSort({})".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    print("Tempo: {}\n".format(tempo.copy().pop()))



desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo")
desenhaGrafico(passo, swaps, xl="Elementos", yl="Swaps")
