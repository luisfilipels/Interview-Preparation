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

#vet = bubbleSort([5, 4, 3, 2, 1])
#print(vet.vet)
#print(vet.stats.swaps)
#vet.sort()
#print(vet.vet)
#print(vet.stats.swaps)

vectMelhor = bubbleSort(geraListaOrdenada(10000))
vectPior = bubbleSort(geraListaReversa(10000))
vect = bubbleSort(geraLista(10000))
E1 = Experiment([vect, vectMelhor, vectPior], [2500, 5000, 7500, 10000], title="Bubble Sort")
E1.plotar(salvar=False)