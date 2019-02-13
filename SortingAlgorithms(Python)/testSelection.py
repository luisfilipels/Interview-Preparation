from helperFunctions import *
import timeit
import variables


setup = "from helperFunctions import printfIfSorted\n" \
        "from selectionSort import selectionSort"
vect = geraLista(50000)
swaps = []
tempo = []
passo = []
for x in range(10000, len(vect)+1, 10000):
    tempo.append(timeit.timeit("aux={}\naux=selectionSort(aux)\nprintIfSorted(aux)".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    swaps.append(variables.swaps)
    print("Elementos: {}".format(x))
    print("Swaps: {}".format(variables.swaps))
    print("Tempo: {}\n".format(tempo.copy().pop()))



desenhaTresGraficos()