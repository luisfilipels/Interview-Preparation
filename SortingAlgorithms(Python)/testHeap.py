from helperFunctions import *
from heap import heap
from heapSort import heapSort

heapSrt = heap()
heapSrt.constroiHeap(geraLista(100))
lista = heapSort(heapSrt)
print(lista)
printIfSorted(lista)
