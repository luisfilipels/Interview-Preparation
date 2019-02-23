"""from helperFunctions import *
import timeit
import variables
from quickSort import *

#vect = [6, 9, 4, 7, 3, 5, 2, 0, 1, 8]
#vect = [8, 6, 1, 5, 9, 7, 3, 2, 4, 0]
vect = geraListaReversa(100000)
#print(vect)
quickSortInPlace(vect, 0, len(vect))
printIfSorted(vect)
#print(vect)
"""

from helperFunctions import *
import timeit
import time
from quickSort import quickSortInPlace
import sys
#sys.setrecursionlimit(100000)



setup = "from helperFunctions import printIfSorted\n" \
        "from quickSort import quickSortInPlace"
vectMelhor = geraListaOrdenada(50000)
tempoMelhor = []
passoMelhor = []
vectPior = geraListaReversa(50000)
tempoPior = []
passoPior = []
vect = geraLista(50000)
tempo = []
passo = []
vectUmM = geraListaReversa(1000000)
tempoUmM = []
passoUmM = []

numeros = [10000, 20000, 30000, 40000, 50000]
numeros2 = [200000, 400000, 600000, 800000, 1000000]

#INICIO PIOR CASO
for x in numeros:
    tempoPior.append(timeit.timeit("aux={}\nquickSortInPlace(aux, 0, len(aux))\nprintIfSorted(aux)".format(vectPior[0:x]), setup, number=1))
    passoPior.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoPior.copy().pop()))

#INICIO MELHOR CASO
for x in numeros:
    tempoMelhor.append(timeit.timeit("aux={}\nquickSortInPlace(aux, 0, len(aux))\nprintIfSorted(aux)".format(vectMelhor[0:x]), setup, number=1))
    passoMelhor.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoMelhor.copy().pop()))

#INICIO CASO NORMAL
for x in numeros:
    tempo.append(timeit.timeit("aux={}\nquickSortInPlace(aux, 0, len(aux))\nprintIfSorted(aux)".format(vect[0:x]), setup, number=1))
    passo.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempo.copy().pop()))

#INICIO CASO UM MILHAO
for x in numeros2:
    tempoUmM.append(
        timeit.timeit("aux={}\nquickSortInPlace(aux, 0, len(aux))\nprintIfSorted(aux)".format(vectUmM[0:x]), setup,
                      number=1))
    passoUmM.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoUmM.copy().pop()))

#INICIO ENCONTRAR PIOR CASO
listas = geraListaDeLista(6)
casoTempo = []
casoLista = []

for lista in listas:
    casoTempo.append(
        timeit.timeit("aux={}\nquickSortInPlace(aux, 0, len(aux))".format(list(lista).copy()), setup,
                      number=1))
    casoLista.append(lista)
print("O tempo da lista com pior caso e: {}".format(max(casoTempo)))
print("A lista com pior caso é: {}\n".format(casoLista[casoTempo.index(max(casoTempo))]))
print("O tempo da lista com melhor caso e: {}".format(min(casoTempo)))
print("A lista com melhor caso é: {}".format(casoLista[casoTempo.index(min(casoTempo))]))

desenhaTresGraficos(passoMelhor, tempoMelhor, passoPior, tempoPior, passo, tempo, x1="Tempo", y1="Elementos", titulo="Quick Sort")
desenhaGrafico(passoUmM, tempoUmM, xl="Elementos", yl="Tempo", titulo="Quick Sort Um milhao")