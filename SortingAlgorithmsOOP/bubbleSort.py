"""import variables

def bubbleSort(vect):
    swapAux = 0
    for i in range(len(vect))[1:]:
        for j in range(len(vect) - i):
            if vect[j] > vect[j + 1]:
                vect[j], vect[j + 1] = vect[j + 1], vect[j]
                swapAux += 1
    variables.swaps = swapAux
    return vect
"""
from SortingAlgorithm import SortingAlgorithm
import math

class bubbleSort(SortingAlgorithm):
    def __init__(self, vet):
        SortingAlgorithm.__init__(self, vet)

    def sort(self, start=0, stop=False):
        '''self.stats.swaps = 0
        for i in range(len(self.vet))[1:]:
            for j in range(len(self.vet) - i):
                if self.vet[j] > self.vet[j + 1]:
                    self.vet[j], self.vet[j + 1] = self.vet[j + 1], self.vet[j]
                    self.stats.swaps += 1'''

        self.stats.swaps = 0
        if type(stop) != bool:
            stop = stop
        else:
            stop = len(self.vet)
        for i in range(start + 1, stop):
            for j in range(stop - i):
                if self.vet[j] > self.vet[j + 1]:
                    self.vet[j], self.vet[j + 1] = self.vet[j + 1], self.vet[j]
                    self.stats.swaps += 1