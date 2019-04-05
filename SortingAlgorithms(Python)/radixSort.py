from countingSort import countingSort
from functools import reduce
from helperFunctions import *


def radixSort(lista):
    indice = 10
    eMaiorTam = False
    tmp = 1
    placement = -1

    while not eMaiorTam:
        eMaiorTam = True

        buckets = [list() for _ in range(indice)]

        for i in lista:
            tmp = i // placement
            buckets[tmp % indice].append(i)
            if eMaiorTam and tmp > 0:
                eMaiorTam = False

        a = 0
        for b in range(indice):
            buck = buckets[b]
            for i in buck:
                lista[a] = i
                a += 1

        placement *= indice

    return lista
#teste = [103, 106, 43, 48, 30, 11, 1001]
#teste = geraListaOrdenada(10000)
#radixSort(teste)
#printIfSorted(teste)
#print(teste)
