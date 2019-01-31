import random

def isSorted(list):
    for i in range(len(list))[1:]:
        if list[i-1] > list[i]:
            return False
    return True

def printIfSorted(list):
    if isSorted(list):
        print("List sorted!")
    else:
        print("List NOT sorted!")

def randList(size):
    vect = []
    for x in range(size):
        vect.append(random.randint(0, size))
    return vect

def secondsToInt(time):
    (h, m, s) = time.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)
