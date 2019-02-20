import variables
import random

def partition(v, n):
    v[0], v[n] = v[n], v[0]
    pivo = v[0]
    i = 1
    j = len(v)-1
    while i <= j:
        while i <= j and v[i] < pivo:
            i += 1
        while v[j] > pivo:
            j -= 1
        if i <= j:
            v[i], v[j] = v[j], v[i]
            variables.swaps += 1
            i += 1
            j -= 1
    v[j], v[0] = v[0], v[j]
    variables.swaps += 1
    return j

def partitionInPlace (v, n, inicio, fim):
    v[inicio], v[n] = v[n], v[inicio]
    pivo = v[inicio]
    i = inicio + 1
    j = fim
    while i <= j:
        while i <= j and v[i] < pivo:
            i += 1
        while v[j] > pivo:
            j -= 1
        if i <= j:
            v[i], v[j] = v[j], v[i]
            variables.swaps += 1
            i += 1
            j -= 1
    v[j], v[inicio] = v[inicio], v[j]
    variables.swaps += 1
    return j

def quickSort(v):
    if len(v) <= 1:
        return v
    j = partition(v, 0)
    left = quickSort(v[:j+1])
    right = quickSort(v[j+1:])
    return left + right

def quickSortInPlace(v, inicio, fim):
    if fim - inicio <= 1:
        return v
    j = partitionInPlace(v, inicio, inicio, fim-1)
    quickSortInPlace(v, inicio, j)
    quickSortInPlace(v, j + 1, fim)
    return v

def quickSortNDet(v):
    if len(v) <= 1:
        return v
    j = partition(v, v.index(random.choice(v)))
    left = quickSort(v[:j+1])
    right = quickSort(v[j+1:])
    return left + right