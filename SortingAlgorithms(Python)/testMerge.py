import random
from helperFunctions import *
import timeit
import variables
from mergeSort import *

#vect = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
#vect = mergeSort(vect)
#print(vect)

setup = "from helperFunctions import printIfSorted\n" \
        "import mergeSort"
vect = geraLista(10)
swaps = []
tempo = []
passo = []
for x in range(5, len(vect)+1, 5):
    tempo.append(timeit.timeit("aux=[{0}]\naux=mergeSort.mergeSort(aux)\nprintIfSorted(aux)".format(vect[0:x]), setup, number=1))
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    print("Tempo: {}\n".format(tempo.copy().pop()))



desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo")
desenhaGrafico(passo, swaps, xl="Elementos", yl="Swaps")