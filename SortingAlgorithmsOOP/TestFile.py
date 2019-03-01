from SortingAlgorithm import SortingAlgorithm
from bubbleSort import bubbleSort
from Experiment import Experiment
import random

def geraListaOrdenada(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    return lista

def geraLista(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    random.shuffle(lista)
    return lista

def geraListaReversa(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    lista.reverse()
    return lista
'''
vet = bubbleSort([7, 6, 5, 4, 3, 2, 1])
print(vet.vet)
#print(vet.stats.swaps)
vet.sort()
print(vet.vet)
#print(vet.stats.swaps)
'''
intervals = [100, 200, 300, 400, 500]
vectMelhor = bubbleSort(geraListaOrdenada(500), intervals)
vectPior = bubbleSort(geraListaReversa(500), intervals)
vect = bubbleSort(geraLista(500), intervals)
E1 = Experiment([vect, vectMelhor, vectPior], intervals, title="Bubble Sort")
E1.calculaTempos(bubbleSort)
E1.plotar()
x = 1