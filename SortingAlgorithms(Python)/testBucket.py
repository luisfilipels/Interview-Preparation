from bucketSort import bucketSort
from helperFunctions import *
#lista = [1, 1, 3, 5, 6, 7]
lista = geraListaSemiOrd(100000)
#print(lista)
lista = bucketSort(lista)
printIfSorted(lista)
#print(lista)