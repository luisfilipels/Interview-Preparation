import timeit


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

    def sort(self, stop, start):
        self.stats.time = timeit.timeit("{}".format(sorted(self.vet[start:stop])), setup=self.testSetup, number=1)
        #TODO Fazer sort com inicio e fim opcionais
