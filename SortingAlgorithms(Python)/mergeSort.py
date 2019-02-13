from helperFunctions import *
import variables

def merge(v, esq, dir):
    aux = []
    swapsAux = 0
    i = j = 0
    while i < len(esq) and j < len(dir):
        if esq[i] < dir[j]:
            aux.append(esq[i])
            swapsAux += 1
            i += 1
        else:
            aux.append(dir[j])
            swapsAux += 1
            j += 1
    while i < len(esq):
        aux.append(esq[i])
        swapsAux += 1
        i += 1
    while j < len(dir):
        aux.append(dir[j])
        swapsAux += 1
        j += 1
    v = aux
    variables.swaps += swapsAux
    return v
"""while len(esq) is not 0 and len(dir) is not 0:
    if esq[0] < dir[0]:
        aux.append(esq.pop(0))
        swapsAux += 1
    else:
        aux.append(dir.pop(0))
        swapsAux += 1
while len(esq) is not 0:
    aux.append(esq.pop(0))
    swapsAux += 1
while len(dir) is not 0:
    aux.append(dir.pop(0))
    swapsAux += 1
v = aux
variables.swaps += swapsAux
print(variables.swaps)
return v"""


def mergeSort(v):
    if len(v) is 1:
        return v
    meio = int(len(v)/2)
    esq = v[:meio]
    dir = v[meio:]
    esq = mergeSort(esq)
    dir = mergeSort(dir)
    v = merge(v, esq, dir)
    return v


""""def mergeSort(v):
    inicio = 0
    fim = len(v)
    if inicio < fim:
        meio = int((inicio + fim) / 2)
    if inicio < meio:
        mergeSort(v, inicio, meio)
    if meio + 1 < fim:
        mergeSort(v, int(meio + 1), fim)
    merge(v, inicio, meio, fim)"""
