from helperFunctions import *
import timeit
import variables
from quickSort import *
import sys

sys.setrecursionlimit(1500)
vect = [4, 3, 2, 1, 0]
vect = quickSort(vect)
printIfSorted(vect)
print(vect)

"""setup = "import helperFunctions\n" \
        "from quickSort import quickSort"
vect = geraLista(50000)
swaps = []
tempo = []
passo = []
for x in range(10000, len(vect)+1, 10000):
    tempo.append(timeit.timeit("aux={}\naux=quickSort(aux, 0, len(aux))\nhelperFunctions.printIfSorted(aux)".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    print("Tempo: {}\n".format(tempo.copy().pop()))


desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo", titulo="Quicksort")"""