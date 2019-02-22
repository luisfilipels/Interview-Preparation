class heap:
    def __init__(self, vetor, tam, ultima):
        self.vetor = vetor
        self.tam = tam
        self.ultima = ultima

    def inserir (self, x):
        if self.tam == self.ultima:
            raise Exception("A ultima posicao e o tamanho!")
        self.ultima += 1
        i = self.ultima
        while i > 1 and self.vetor[i/2] > x:
            self.vetor[i] = self.vetor[i/2]
            i /= 2
        self.vetor[i] = x

    def removeMenor(self):
        if self.ultima == 0:
            raise Exception("A lista tem tamanho minimo!")
        valor = self.vetor[1]
        self.vetor[1] = self.vetor[self.ultima]
        self.ultima = self.ultima - 1
        i = 1
        while (2 * i <= self.ultima and self.vetor[i] > self.vetor[2*i]) or (2 * i < self.ultima and self.vetor[i] > self.vetor[2*i+1]):
            menor = 2 * i
            if 2 * i < self.ultima and self.vetor[2*i+1] <= self.vetor[2*i]:
                menor += 1
            self.vetor[i], self.vetor[menor] = self.vetor[menor], self.vetor[i]
        return valor

    #TODO Implementar heapify e melhorar compreensão do algoritmo.


