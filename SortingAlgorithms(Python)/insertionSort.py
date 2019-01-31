def insertionSort(v):
    for i in range(len(v))[1:]:
        j = i - 1
        if v[i] < v[i - 1]:
            while j >= 0 and v[j] > v[i]: #Enquanto não chegarmos a 0 ou a um elemento menor que o atual...
                j -= 1
            v.insert(j + 1, v.pop(i))