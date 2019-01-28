#include <iostream>
#include <vector>
#include <chrono>
#include <random>

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
    std::cout << "Ordered vector: " << std::endl;
    printVector(vet);
    return 0;
}