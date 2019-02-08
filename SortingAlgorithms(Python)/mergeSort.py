def merge ()

def mergeSort (v, inicio=0, fim=1):
    if inicio < fim:
        meio = int((inicio + fim)/2)
    if inicio < meio:
        mergeSort(v, inicio, meio)
    if meio + 1 < fim:
        mergeSort(v, int(meio+1), fim)

