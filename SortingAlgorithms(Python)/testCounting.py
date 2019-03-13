from helperFunctions import *
from countingSort import countingSort

#lista = geraLista(10)
lista = geraListaSemiOrd(50000)
#lista = [0, 3, 3, 4, 6]
#print(lista)
printIfSorted(lista)
lista = countingSort(lista)
#print(lista)
printIfSorted(lista)