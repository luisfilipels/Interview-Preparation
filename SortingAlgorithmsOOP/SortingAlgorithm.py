import timeit
import math

class Stats:
    def __init__(self):
        self.tempos = {}
        self.swaps = {}
        self.comparisons = {}


class SortingAlgorithm:
    def __init__(self, vet, setup="",):
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
