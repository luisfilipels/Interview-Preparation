import random

"""
def partition(xs, start, end):
    follower = leader = start
    while leader < end:
        if xs[leader] <= xs[end]:
            xs[follower], xs[leader] = xs[leader], xs[follower]
            follower += 1
        leader += 1
    xs[follower], xs[end] = xs[end], xs[follower]
    return follower


def _quicksort(xs, start, end):
    if start >= end:
        return
    p = partition(xs, start, end)
    _quicksort(xs, start, p - 1)
    _quicksort(xs, p + 1, end)
    return xs


def quicksort(xs):
    xs = _quicksort(xs, 0, len(xs) - 1)
    return xs"""

def particiona(v, inicio, fim):
    if fim - inicio > 0:
        pivo = v[0]
        i = inicio
        j = fim
        while i <= j:
            while i <= j and not v[i] > pivo:
                i += 1
            while not v[j] <= pivo:
                j -= 1
            if i <= j:
                v[i], v[j] = v[j], v[i]
                i += 1
                j -= 1
        v[inicio], v[j] = v[j], v[inicio]
        return j
    return fim


def quickSort(v):
    if len(v) <= 1:
        return v
    j = particiona(v, 0, len(v)-1)
    esq = quickSort(v[:j])
    dir = quickSort(v[j:])
    return esq + dir


"""
def quickSort(v):
    v = quickSortEfet(v, 0, len(v)-1)
    return v


def quickSortEfet(v, inicio, fim):
    if fim - inicio > 0:
        pivo = v[inicio]
        i = inicio
        j = fim - 1
        while i <= j:
            while v[i] < pivo:
                i += 1
            while v[j] > pivo:
                j -= 1
            if i <= j:
                v[i], v[j] = v[j], v[i]
                i += 1
                j -= 1
        a = quickSortEfet(v, inicio, j)
        b = quickSortEfet(v, i, fim)
        a = a + b
        return a

    return v
"""