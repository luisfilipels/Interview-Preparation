def bubbleWFlag(v):
    flag = None
    i = 0
    while True:
        flag = False
        for j in range(len(v) - 1):
            if v[j] > v[j + 1]:
                v[j], v[j+1] = v[j+1], v[j]
                flag = True
        i += 1
        if (flag is False):
            break
