//
// Created by luisf on 28-Jan-19.
//
#include "auxiliaryFunctions.h"
#include <vector>

#ifndef BUBBLE_SORT_ORDERFUNCTIONS_H
#define BUBBLE_SORT_ORDERFUNCTIONS_H

void bubbleSort(std::vector<int> vet) {
    std::cout << "Unordered vector:" << std::endl;
    printVector(vet);
    for (int i = 1; i < vet.size(); i++) {    //Bubble sort, propriamente dito.
        for (int j = 0; j < vet.size() - i; j++) {
            if (vet[j] > vet[j+1]) {
                swap(vet[j], vet[j+1]);
            }
        }
    }
    std::cout << "Ordered vector (regular Bubble Sort): " << std::endl;
    printVector(vet);
}

void flagBubbleSort (std::vector<int> vet) { //Bubble sort, com flag.
    int i = 0; // No debugger, a i é atribuído imediatamente o valor 1. Bug na otimização, ou magia?? Pesquisar.
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
    std::cout << "Ordered vector (Bubble Sort with flag): " << std::endl;
    printVector(vet);
}

void insertionSort (std::vector<int> vet) {
    int n = vet.size();
    int pivot;
    int j;
    for (int i = 1; i < n; i++) {
        pivot = vet[i];
        j = i - 1;
        while (j >= 0 && vet[i] > pivot) {
            vet[j+1] = vet[j];
            j -= 1;
        }
        vet[j+1] = pivot;
    }
}

#endif //BUBBLE_SORT_ORDERFUNCTIONS_H
