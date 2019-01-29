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
    std::vector<int> vet2 = vet;
    std::cout << "Unordered vector:" << std::endl;
    printVector(vet);
    bubbleSort(vet);
    std::cout << "Ordered vector (regular Bubble Sort): " << std::endl;
    printVector(vet);
    std::cout << "Ordered vector (Bubble Sort with flag): " << std::endl;
    flagBubbleSort(vet2);
    printVector(vet2);
    return 0;
}