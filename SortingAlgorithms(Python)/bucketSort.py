from insertionSort import insertionSort

def bucketSort (lista):
    k = len(lista) - 1
    buckets = [[] for i in range (k)]
    maxValue = max(lista)
    for i in range(k, -1, -1):
        buckets[lista[i] * k// (maxValue + 1)].insert(0, lista[i])
    for i in range(0, k):
        insertionSort(buckets[i])
    returnList = []
    for bucket in buckets:
        returnList.extend(bucket)
    return returnList


