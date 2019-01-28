#include <iostream>
#include <vector>
#include <ctime>
#include <chrono>
#include <cstdlib>
#include <random>

#define SIZE 20
#define MAX 50

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

int main() {
    std::vector<int> vet = fillRand(SIZE, MAX);
    int aux;
    for (int i = 1; i < SIZE; i++) {    //Bubble sort, propriamente dito.
        for (int j = 0; j < SIZE - i; j++) {
            if (vet[j] > vet[j+1]) {
                swap(vet[j], vet[j+1]);
            }
        }
    }
    for (int k = 0; k < SIZE; k++) {
        std::cout << vet[k] << " ";
    }
    return 0;
}