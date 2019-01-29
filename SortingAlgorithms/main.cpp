#include <iostream>
#include <vector>
#include <chrono>
#include <random>
#include "orderFunctions.h"

std::vector<int> fillRand (int size, int max) { // Preencher vetor com números aleatórios.
    std::mt19937 mersenne(static_cast<unsigned int>(std::time(nullptr)));
    std::uniform_int_distribution<> die(1, max);
    std::vector<int> vet;
    for (int i = 0; i < size; i++) {
        vet.push_back(die(mersenne));
    }
    return vet;
}

void swap (int &a, int &b) {
    int aux;
    aux = a;
    a = b;
    b = aux;
}

void bubbleSort(std::vector<int> &vet) {
    for (int i = 1; i < vet.size(); i++) {    //Bubble sort, propriamente dito.
        for (int j = 0; j < vet.size() - i; j++) {
            if (vet[j] > vet[j+1]) {
                swap(vet[j], vet[j+1]);
            }
        }
    }
}

void printVector (std::vector<int> vet) {
    for (int k = 0; k < vet.size(); k++) {
        std::cout << vet[k] << " ";
    }
    std::cout << std::endl;
}

void flagBubbleSort (std::vector<int> &vet) { //Bubble sort, com flag.
    int i = 0;
    bool flag;
    do {
        flag = false;
        for (int j = 0;j < vet.size() - i - 1; j++) {
            if (vet[j] > vet[j+1]) {
                swap(vet[j], vet[j+1]);
                flag = true;
            }
        }
        i += 1;
    } while (flag);
}

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