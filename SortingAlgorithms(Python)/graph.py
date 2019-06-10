class Vertex:
    def __init__(self, rotulo):
        self.rotulo = rotulo
    def igualA(self, r):
        return r == self.rotulo

class Grafo:
    def __init__(self):
        self.numVerticesMaximo = 20
        self.numVertices = 0
        self.listaVertices = []
        self.listaArcos = []
        self.matrizAdjacencias = []
        for i in range(self.numVerticesMaximo):
            linhaMatriz = []
            for j in range(self.numVerticesMaximo):
                linhaMatriz.append(0)
            self.matrizAdjacencias.append(linhaMatriz)

    def adicionaVertices(self, rotulo):
        self.numVertices += 1
        self.listaVertices.append(Vertex(rotulo))

    def adicionaArco(self, rotulo, peso, inicio, fim):
        self.listaArcos.append(rotulo)
        self.matrizAdjacencias[inicio][fim] = peso
        self.matrizAdjacencias[fim][inicio] = peso

    def imprimeMatriz(self):
        print(" ", end=" ")
        for i in range(0, self.numVertices):
            print(self.listaVertices[i].rotulo, end=" ")
        print(" ")
        for i in range(0, self.numVertices):
            print(self.listaVertices[i].rotulo, end=" ")
            for j in range(0, self.numVertices):
                print(self.matrizAdjacencias[i][j], end=" ")
            print(" ")

    def localizaNo(self, rotulo):
        for i in range(self.numVertices):
            if self.listaVertices[i].igualA(rotulo):
                return i
        return -1

    def localizaArco(self, rotulo):
        for i in range(len(self.listaArcos)):
            if self.listaArcos[i] == rotulo:
                return i
        return -1


if __name__ == "__main__":
    grf = Grafo()
    while True:
        print("Escolha uma opção:")
        print("(M) - Mostra      (V) - Inserir Vértice      (A) - Inserin Arco     (B) - Buscar   (S) - Sair")
        escolha = input()
        if escolha == "M" or escolha == "m":
            grf.imprimeMatriz()
        elif escolha == "V" or escolha == "v":
            val = input("Digite o rótulo do vertice a inserir: ")
            grf.adicionaVertices(val)
        elif escolha == "A" or escolha == "a":
            rotulo = input("Digite o rótulo do arco: ")
            peso = int(input("Digite o peso do arco: "))
            rinicio = input("Digite o rótulo do vértice de início do arco: ")
            inicio = grf.localizaNo(rinicio)
            if inicio == -1:
                print("Vértice não encontrado. Cadastre o vértice primeiro.")
                input()
                continue
            rfim = input("Digite o rótulo do vértice de fim do arco: ")
            fim = grf.localizaNo(rfim)
            if fim == -1:
                print("Vértice não cadastrado. Cadastre o vértice primeiro")
                input()
                continue
            grf.adicionaArco(rotulo, peso, inicio, fim)
        elif escolha == "s" or escolha == "S":
            break
        elif escolha == "B" or escolha == "b":
            escolha2 = input("Buscar nó ou arco? \n(N) - Nó      (A) - Arco")
            if escolha2 == "N" or escolha2 == "n":
                escolha2 = input("Digite o rótulo do nó: ")
                if grf.localizaNo(escolha2) == -1:
                    print("Nó não encontrado!")
                else:
                    print("Nó encontrado!")
            elif escolha2 == "A" or escolha2 == "a":
                escolha2 = input("Buscar por nome ou origem/destino? \n(N) - Nome         (O) - Origem/Destino")
                if escolha2 == "N" or escolha2 == "n":
                    nome = input("Digite o rótulo do arco a ser pesquisado:")
                    if grf.localizaArco(nome) == -1:
                        print("Arco não encontrado!")
                    else:
                        print("Arco encontrado!")
                elif escolha2 == "O" or escolha2 == "o":
                    aaaa = 0
                    # # FIXME: Terminar a implementação desta parte
        else:
            input("Entrada inválida. Pressione Enter")

