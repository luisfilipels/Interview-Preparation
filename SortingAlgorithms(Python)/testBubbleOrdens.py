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

setup = "from helperFunctions import geraListaOrdenada\n" \
        "from bubbleSort import bubbleSort"

vectMelhor = geraListaOrdenada(6000)
tempoMelhor = []
passoMelhor = []
vectPior = geraListaReversa(6000)
tempoPior = []
passoPior = []
vect = geraLista(6000)
tempo = []
passo = []

numeros = [1000, 2000, 4000, 6000]

#INICIO PIOR CASO
for x in numeros:
    tempoPior.append(timeit.timeit("bubbleSort({})".format(vectPior[0:x].copy()), setup, number=1))
    passoPior.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoPior.copy().pop()))

#INICIO MELHOR CASO
for x in numeros:
    tempoMelhor.append(timeit.timeit("bubbleSort({})".format(vectMelhor[0:x].copy()), setup, number=1))
    # print(tempo)
    passoMelhor.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoMelhor.copy().pop()))

#INICIO CASO NORMAL
for x in numeros:
    tempo.append(timeit.timeit("bubbleSort({})".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempo.copy().pop()))

desenhaGrafico(passoPior, tempoPior, xl="Elementos", yl="Tempo", titulo="Pior caso")
desenhaGrafico(passoMelhor, tempoMelhor, xl="Elementos", yl="Tempo", titulo="Melhor caso")
desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo", titulo="Caso normal")
