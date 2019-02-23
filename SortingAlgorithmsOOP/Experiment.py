import matplotlib.pyplot as plt

class Experiment:
    def __init__(self, vets, intervalos, labelLeft="Tempo", labelBottom="Elementos", title="Tempo de algoritmo"):
        self.vets = vets
        self.intervalos = intervalos
        self.numTestes = len(vets) - 1
        self.labelLeft = labelLeft
        self.labelBottom = labelBottom
        self.title= title

    def plotar(self, salvar=True):
        if self.intervalos <= 1:
            raise Exception("Tentou plotar intervalo invalido!")
        fig = plt.figure(figsize=(10, 8))
        ax = fig.add_subplot(111)
        X = []
        Y = []
        """for vet in self.vets:
            for i in self.intervalos:
                vet.sort()
                tempoPior.append(timeit.timeit("insertionSort({})".format(vectPior[0:x].copy()), setup, number=1))
                passoPior.append(x)
                print("Elementos: {}".format(x))
                print("Tempo: {}\n".format(tempoPior.copy().pop()))
        """
