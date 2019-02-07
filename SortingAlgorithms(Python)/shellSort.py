def encontraSeparacoes (v):
    sep = []
    atual = 1
    while sep < len(v):
        atual = (3 * atual) + 1
        sep.append(atual)
    sep.reverse()
    return sep


def shellSort (v):
    separacoes = []
    separacoes = encontraSeparacoes(v)
    for separacao in separacoes:
        for i in range(separacao, len(v), 1):
            pivo = separacoes[i]
            j = i

