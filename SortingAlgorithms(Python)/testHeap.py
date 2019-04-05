#from helperFunctions import *
#from heap import heap
#from heapSort import heapSort

#heapSrt = heap()
#heapSrt.constroiHeap(geraLista(100))
#lista = heapSort(heapSrt)
#print(lista)
#printIfSorted(lista)

from helperFunctions import *
from radixSort import radixSort
import timeit

#lista = geraListaSemiOrd(5)
#lista = [6, 5, 3, 5, 3]
#lista = radixSort(lista)
#printIfSorted(lista)
#print(lista)

setup = "from helperFunctions import printIfSorted\n" \
        "from heapSort import heapSort\n" \
        "from heap import heap"
vectMelhor = geraListaOrdenada(50000)
tempoMelhor = []
passoMelhor = []
vectPior = geraListaReversa(50000)
tempoPior = []
passoPior = []
vect = geraLista(50000)
tempo = []
passo = []

numeros = [10000, 20000, 30000, 40000, 50000]

lista  = [6, 5, 4, 3, 2, 1]
radixSort(lista)

#INICIO PIOR CASO
for x in numeros:
    tempoPior.append(timeit.timeit("heapAux = heap()\nheapAux.constroiHeap({})\nlista=heapSort(heapAux)\nprintIfSorted(lista)".format(vectPior[0:x]), setup, number=1))
    passoPior.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoPior.copy().pop()))

#INICIO MELHOR CASO
for x in numeros:
    tempoMelhor.append(timeit.timeit("heapAux = heap()\nheapAux.constroiHeap({})\nlista=heapSort(heapAux)\nprintIfSorted(lista)".format(vectMelhor[0:x]), setup, number=1))
    passoMelhor.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoMelhor.copy().pop()))

#INICIO CASO NORMAL
for x in numeros:
    tempo.append(timeit.timeit("heapAux = heap()\nheapAux.constroiHeap({})\nlista=heapSort(heapAux)\nprintIfSorted(lista)".format(vect[0:x]), setup, number=1))
    passo.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempo.copy().pop()))

#INICIO ENCONTRAR PIOR CASO
listas = geraListaDeLista(6)
casoTempo = []
casoLista = []

for lista in listas:
    casoTempo.append(
        timeit.timeit("heapAux = heap()\nheapAux.constroiHeap({})\nlista=heapSort(heapAux)\nprintIfSorted(lista)".format(list(lista).copy()), setup,
                      number=1))
    casoLista.append(lista)
print("O tempo da lista com pior caso e: {}".format(max(casoTempo)))
print("A lista com pior caso é: {}\n".format(casoLista[casoTempo.index(max(casoTempo))]))
print("O tempo da lista com melhor caso e: {}".format(min(casoTempo)))
print("A lista com melhor caso é: {}".format(casoLista[casoTempo.index(min(casoTempo))]))

desenhaTresGraficos(passoMelhor, tempoMelhor, passoPior, tempoPior, passo, tempo, x1="Tempo", y1="Elementos", titulo="Heap Sort")
