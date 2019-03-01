import matplotlib.pyplot as plt
from timeit import timeit
import functools
import SortingAlgorithm
import bubbleSort

def isSorted(list):
    for i in range(len(list))[1:]:
        if list[i-1] > list[i]:
            return False
    return True

class Experiment:
    def __init__(self, vets, intervalos, labelLeft="Tempo", labelBottom="Elementos", title="Tempo de algoritmo"):
        self.intervalos = intervalos if intervalos else [10000, 20000, 30000, 40000, 50000]
        self.vets = vets
        self.numTestes = len(vets) - 1
        self.labelLeft = labelLeft
        self.labelBottom = labelBottom
        self.title= title

    def calculaTempos(self, algorithm):
        for vet in self.vets:
            for interval in self.intervalos:
                vet.stats.tempos["{}".format(interval)] = timeit(functools.partial(vet.sort, 0, interval), "", number=1)
                print(vet.stats.tempos["{}".format(interval)])
                print(isSorted(vet.vet[0:interval]))


    def plotar(self, salvar=True, x1="Tempo", y1="Entradas"):
        fig = plt.figure(figsize=(10, 8))
        ax = fig.add_subplot(111)
        for vet in self.vets:
            ax.plot(self.intervalos, vet.stats.tempos)
        ax.legend(bbox_to_anchor=(1, 1), bbox_transform=plt.gcf().transFigure)
        plt.ylabel(y1)
        plt.xlabel(x1)
        plt.title("AAA")
        plt.show()
        """for vet in self.vets:
            for i in self.intervalos:
                vet.sort()
                tempoPior.append(timeit.timeit("insertionSort({})".format(vectPior[0:x].copy()), setup, number=1))
                passoPior.append(x)
                print("Elementos: {}".format(x))
                print("Tempo: {}\n".format(tempoPior.copy().pop()))
        """
