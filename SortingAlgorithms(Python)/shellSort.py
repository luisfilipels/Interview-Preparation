import variables

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
    variables.swaps = 0
    separacoes = []
    separacoes = encontraSeparacoes(v)
    for separacao in separacoes:
        for i in range(separacao, len(v), 1):
            j = i - separacao
            if v[i] < v[i - separacao]:
                while j >= 0 and v[j] > v[i]:
                    j -= separacao
                v.insert(j + separacao, v.pop(i))
                variables.swaps += 1


    #for i in range(len(v))[1:]:
    #    j = i - 1
    #    if v[i] < v[i - 1]:
    #        while j >= 0 and v[j] > v[i]: #Enquanto não chegarmos a 0 ou a um elemento menor que o atual...
    #            j -= 1
    #        v.insert(j + 1, v.pop(i))

