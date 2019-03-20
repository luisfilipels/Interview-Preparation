from countingSort import countingSort

def radixSort (lista):
    maiorElemento = max(lista)
    expoente = 1
    while maiorElemento/expoente > 0:
        countingSort()
    maior = [0] * 10
    for j in range(0, maiorElemento):
        for i in range(0, len(lista)):
            maior[lista[j]] += 1
        for i in range(1, 10):
            maior[i] += maior[i-1]
