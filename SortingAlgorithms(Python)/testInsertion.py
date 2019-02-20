from helperFunctions import *
import timeit

setup = "from helperFunctions import geraListaOrdenada\n" \
        "from insertionSort import insertionSort"
vectMelhor = geraListaOrdenada(50000)
tempoMelhor = []
passoMelhor = []
vectPior = geraListaReversa(50000)
tempoPior = []
passoPior = []
vect = geraLista(50000)
tempo = []
passo = []

numeros = [10000, 20000, 30000, 40000, 50000]

#INICIO PIOR CASO
for x in numeros:
    tempoPior.append(timeit.timeit("insertionSort({})".format(vectPior[0:x].copy()), setup, number=1))
    passoPior.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoPior.copy().pop()))

#INICIO MELHOR CASO
for x in numeros:
    tempoMelhor.append(timeit.timeit("insertionSort({})".format(vectMelhor[0:x].copy()), setup, number=1))
    passoMelhor.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempoMelhor.copy().pop()))

#INICIO CASO NORMAL
for x in numeros:
    tempo.append(timeit.timeit("insertionSort({})".format(vect[0:x].copy()), setup, number=1))
    passo.append(x)
    print("Elementos: {}".format(x))
    print("Tempo: {}\n".format(tempo.copy().pop()))

#INICIO ENCONTRAR PIOR CASO
listas = geraListaDeLista(6)
casoTempo = []
casoLista = []
for lista in listas:
    casoTempo.append(timeit.timeit("insertionSort({})".format(list(lista).copy()), setup, number=1))
    casoLista.append(lista)
print("O tempo da lista com pior caso e: {}".format(max(casoTempo)))
print("A lista com pior caso é: {}\n".format(casoLista[casoTempo.index(max(casoTempo))]))
print("O tempo da lista com melhor caso e: {}".format(min(casoTempo)))
print("A lista com melhor caso é: {}".format(casoLista[casoTempo.index(min(casoTempo))]))



desenhaTresGraficos(passoMelhor, tempoMelhor, passoPior, tempoPior, passo, tempo, x1="Tempo", y1="Elementos", titulo="Selection Sort")