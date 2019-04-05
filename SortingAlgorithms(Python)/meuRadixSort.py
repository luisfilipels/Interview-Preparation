expe = [1, 5, 111, 45, 99, 155, 12, 100]


def getNumCasas(lista):
    maxElement = max(lista)
    conta = 0
    while maxElement != 0:
        maxElement = maxElement // 10
        conta += 1
    return conta


def bucket(lista, index):
    buckets = [[] for i in range(0, 10)]
    for i in range(0, len(lista)):
        temp = lista[i] // (pow(10, index)) % 10
        buckets[temp].append(lista[i])
    listaTemp = []
    for i in range(0, len(buckets)):
        listaTemp.extend(buckets[i])

    return listaTemp


def radixSort(lista):
    indice = 0
    for i in range(0, getNumCasas(expe)):
        lista = bucket(lista, i)
    return lista

print(radixSort(expe))

# expe = [1,5,111,45,99,155,12,100]
expe = ["abc", "cde", "adc", "bca", "aedc", "b", "a", "acd", "abcd"]


#def getNumCasas(lista):
#    return len(max(lista))


#def bucket(lista, index):
#    buckets = [[] for i in range(0, 30)]
#    for i in range(0, len(lista)):
#        aux = max(len(lista[i]) - 1 - index, 0)
#        temp = lista[i][aux]
#        temp = ord(temp)
#        buckets[temp - 96].append(lista[i])
#    listaTemp = []
#    for i in range(0, len(buckets)):
#        listaTemp.extend(buckets[i])
#
#    return listaTemp


#def radixSort(lista):
#    for i in range(0, getNumCasas(expe) + 1):
#        print(i)
#        lista = bucket(lista, i)
#    return lista


# print(bucket([0,0))
# print(bucket(expe, 0))
# print((1234//100) % 10)
print(radixSort(expe))
# print(bucket(expe, 1))
# 1000, 88, 7, 123