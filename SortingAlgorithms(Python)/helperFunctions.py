import random
import matplotlib as mpl
import timeit
import matplotlib.pyplot as plt
import datetime
import math
import pylab
import itertools

def isSorted(list):
    for i in range(len(list))[1:]:
        if list[i-1] > list[i]:
            return False
    return True

def printIfSorted(list):
    if isSorted(list):
        print("List sorted!")
    else:
        print("List NOT sorted!")

def geraListaOrdenada(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    return lista

def geraLista(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    random.shuffle(lista)
    return lista

def geraListaReversa(tam):
    lista = []
    for i in range(tam):
        lista.append(i)
    lista.reverse()
    return lista

def geraListaSemiOrd(tam):
    lista = []
    for i in range(tam):
        noise = i + math.floor(math.sqrt(tam))
        lista.append(random.randint(i, noise))
    return lista

"""def timeToInt(time):
    (h, m, s) = time.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)

def intToTime(time):
    return str(datetime.timedelta(seconds=time))"""


def desenhaGrafico(x, y, xl="Entradas", yl="Tempo", titulo="Grafico"):
    fig = plt.figure(figsize=(10, 8))
    ax = fig.add_subplot(111)
    ax.plot(x, y, label="Melhor Tempo")
    ax.legend(bbox_to_anchor=(1, 1), bbox_transform=plt.gcf().transFigure)
    plt.ylabel(yl)
    plt.xlabel(xl)
    plt.title(titulo)
    plt.show()
    plt.savefig("{0}{1}{2}.png".format(xl, yl, titulo))


def desenhaTresGraficos(primX, primY, segX, segY, terX, terY, x1="Entradas", y1="Tempo", titulo="Selection"):
    fig = plt.figure(figsize=(10, 8))
    ax = fig.add_subplot(111)
    ax.plot(primX, primY, label="Lista ordenada")
    ax.plot(segX, segY, label="Lista reversa")
    ax.plot(terX, terY, label="Lista aleatoria")
    ax.legend(bbox_to_anchor=(1, 1), bbox_transform=plt.gcf().transFigure)
    plt.ylabel(x1)
    plt.xlabel(y1)
    plt.title(titulo)
    plt.show()
    plt.savefig("{0}{1}{2}.png".format(x1, y1, titulo))


def geraListaDeLista (tam):
    aux = list(itertools.permutations(list(range(0, tam))))
    return aux






