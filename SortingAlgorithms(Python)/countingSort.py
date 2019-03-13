def countingSort (lista):
    maiorElemento = max(lista)
    maior = [0] * (maiorElemento+1)
    aux = []
    for i in range(0, len(lista), 1):
        maior[lista[i]] += 1
    for i in range(0, maiorElemento + 1, 1):
        aux.extend(maior[i] * [i])
    lista = aux
    return lista