from heap import heap

def heapSort(heapSrt):
    lista = []
    while heapSrt.tam != 0:
        lista.append(heapSrt.removeMenor())
    return lista