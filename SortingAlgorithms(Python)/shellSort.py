def encontraSeparacoes (v):
    sep = []
    atual = 1
    sep.append(atual)
    while atual < len(v):
        atual = (3 * atual) + 1
        sep.append(atual)
    sep.pop()
    sep.reverse()

    return sep


def shellSort (v):
    separacoes = []
    separacoes = encontraSeparacoes(v)
    for separacao in separacoes:
        for i in range(separacao, len(v), 1):
            j = i - separacao
            if v[i] < v[i - separacao]:
                while j >= 0 and v[j] > v[i]:
                    j -= separacao
                v.insert(j + separacao, v.pop(i))
