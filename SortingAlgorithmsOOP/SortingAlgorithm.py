import timeit
import math

class Stats:
    def __init__(self):
        self.time = 0
        self.swaps = 0
        self.comparisons = 0


class SortingAlgorithm:
    def __init__(self, vet, setup=""):
        self.stats = Stats()
        self.testSetup = setup
        self.vet = vet
        self.len = len(vet)

    def sort(self, start=0, stop=False):
        if type(stop) != bool:
            self.vet[start:math.floor(stop)] = sorted(self.vet[start:math.floor(stop)])
            return
        else:
            self.vet = sorted(self.vet)
            return
