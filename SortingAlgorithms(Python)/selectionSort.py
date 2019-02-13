import variables
from helperFunctions import *

def selectionSort(v):
    variables.swaps = 0
    for i in range(len(v)-1):
        min = i
        for j in range(len(v))[i+1:]:
            if v[j] < v[min]:
                min = j
        v[i], v[min] = v[min], v[i]
        variables.swaps += 1