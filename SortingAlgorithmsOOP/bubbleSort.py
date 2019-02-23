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


class bubbleSort(SortingAlgorithm):
    def __init__(self, vet):
        SortingAlgorithm.__init__(self, vet)

    def sort(self, stop, start=0):
        self.stats.swaps = 0
        for i in range(start+1, len(self.vet)):
            for j in range(len(self.vet) - i):
                if self.vet[j] > self.vet[j + 1]:
                    self.vet[j], self.vet[j + 1] = self.vet[j + 1], self.vet[j]
                    self.stats.swaps += 1

    def sort(self):
        self.stats.swaps = 0
        for i in range(len(self.vet))[1:]:
            for j in range(len(self.vet) - i):
                if self.vet[j] > self.vet[j + 1]:
                    self.vet[j], self.vet[j + 1] = self.vet[j + 1], self.vet[j]
                    self.stats.swaps += 1
