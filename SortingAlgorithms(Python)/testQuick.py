from helperFunctions import *
import timeit
import variables

setup = "import helperFunctions\n" \
        "from quickSort import quickSort, quickSortNDet"
vect = geraLista(50000)
swaps = []
tempo = []
passo = []
for x in range(10000, len(vect)+1, 10000):
    tempo.append(timeit.timeit("aux={}\naux=quickSortNDet(aux)\nhelperFunctions.printIfSorted(aux)".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    variables.swaps = 0
    print("Tempo: {}\n".format(tempo.copy().pop()))


desenhaGrafico(passo, tempo, xl="Elementos", yl="Tempo", titulo="Quicksort Nao Deterministico-Tempo")
desenhaGrafico(passo, swaps, xl="Elementos", yl="Swaps", titulo="Quicsort Nao Deterministico-Swaps")