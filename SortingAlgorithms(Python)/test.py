import random
from bubbleSort import bubbleSort
from helperFunctions import *

vect = random.sample(range(100), 10)
print(vect, sep=' ')
printIfSorted(vect)
bubbleSort(vect)
print(vect, sep=' ')
printIfSorted(vect)