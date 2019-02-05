import timeit
import random
import matplotlib as mpl
import matplotlib.pyplot as plt




tempo1 = timeit.timeit("geraLista({})".format(100),setup="from __main__ import geraLista",number=1000)
tempo2 = timeit.timeit("geraLista({})".format(100), setup="from __main__ import geraLista", number=10000)
tempo3 = timeit.timeit("geraLista({})".format(100),setup="from __main__ import geraLista",number=50000)
tempo4 = timeit.timeit("geraLista({})".format(100),setup="from __main__ import geraLista",number=100000)

desenhaGrafico([1000, 10000, 50000, 100000], [tempo1, tempo2, tempo3, tempo4])