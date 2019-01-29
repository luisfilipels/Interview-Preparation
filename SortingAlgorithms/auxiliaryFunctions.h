//
// Created by luisf on 28-Jan-19.
//
#include <vector>
#include <chrono>
#include <random>
#include <iostream>
#ifndef SORTINGALGORITHMS_AUXILIARYFUNCTIONS_H
#define SORTINGALGORITHMS_AUXILIARYFUNCTIONS_H

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

void printVector (std::vector<int> vet) {
    for (int k = 0; k < vet.size(); k++) {
        std::cout << vet[k] << " ";
    }
    std::cout << std::endl;
}

#endif //SORTINGALGORITHMS_AUXILIARYFUNCTIONS_H
