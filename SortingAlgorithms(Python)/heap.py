class heap:
    def __init__(self):
        self.vetor = [0]
        self.tam = 0

    def min(self, i):
        if i * 2 + 1 > self.tam:
            return i * 2
        else:
            if self.vetor[i * 2] < self.vetor[i * 2 + 1]:
                return i * 2
            else:
                return i * 2 + 1

    def moveCima(self, i):
        while i // 2 > 0:
            if self.vetor[i] < self.vetor[i // 2]:
                self.vetor[i], self.vetor[i // 2] = self.vetor[i // 2], self.vetor[i]
            i //= 2

    def moveBaixo(self, i):
        while (i * 2) <= self.tam:
            min = self.min(i)
            if self.vetor[i] > self.vetor[min]:
                self.vetor[i], self.vetor[min] = self.vetor[min], self.vetor[i]
            i = min

    def inserir (self, x):
        self.vetor.append(x)
        self.tam += 1
        self.moveCima(self.tam)

    def removeMenor(self):
        valor = self.vetor[1]
        self.vetor[1] = self.vetor[self.tam]
        self.tam -= 1
        self.vetor.pop()
        self.moveBaixo(1)
        return valor

    def constroiHeap(self, lista):
        i = len(lista) // 2
        self.tam = len(lista)
        self.vetor = [0] + lista[:]
        while (i > 0):
            self.moveBaixo(i)
            i -= 1

    #TODO Implementar heapify e melhorar compreensão do algoritmo.


