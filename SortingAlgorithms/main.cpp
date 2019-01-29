#include <iostream>
#include <vector>
#include <chrono>
#include <random>
#include "orderFunctions.h"
#include "auxiliaryFunctions.h"

int main() {
    int size;
    int max;
    std::cout << "SIZE: ";
    std::cin >> size;
    std::cout << "MAX: ";
    std::cin >> max;
    std::vector<int> vet = fillRand(size, max);
    std::cout << "Unordered vector:" << std::endl;
    printVector(vet);

    bubbleSort(vet);
    flagBubbleSort(vet);
    insertionSort(vet);

    return 0;
}