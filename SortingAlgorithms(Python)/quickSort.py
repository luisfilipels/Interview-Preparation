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
    j = partitionInPlace(v, random.randint(inicio, fim-1), inicio, fim-1)
    quickSortInPlace(v, inicio, j)
    quickSortInPlace(v, j + 1, fim)
    return v

def quickSortInPlaceIter(v, inicio, fim):
    listBegin = [inicio]
    listEnd = [fim]
    while (len(listBegin) > 0):
        LB = listBegin.pop()
        LE = listEnd.pop()
        if LE - LB <= 1:
            continue
        j = partitionInPlace(v, LB, LB, LE - 1)
        listBegin.append(LB)
        listEnd.append(j)
        listBegin.append(j + 1)
        listEnd.append(LE)
        break

    return v

def quickSortNDet(v):
    if len(v) <= 1:
        return v
    j = partition(v, v.index(random.choice(v)))
    left = quickSort(v[:j+1])
    right = quickSort(v[j+1:])
    return left + right