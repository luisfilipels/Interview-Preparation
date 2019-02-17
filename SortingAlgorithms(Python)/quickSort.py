import variables

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

def quickSort(v):
    if len(v) <= 1:
        return v
    j = partition(v, 0)
    left = quickSort(v[:j+1])
    right = quickSort(v[j+1:])
    return left + right