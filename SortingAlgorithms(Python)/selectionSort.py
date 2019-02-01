def selectionSort(v):
    for i in range(len(v) - 2):
        min = i
        for j in range(len(v))[i+1:]:
            if v[j] < v[min]:
                min = j
        v[i], v[min] = v[min], v[i]
