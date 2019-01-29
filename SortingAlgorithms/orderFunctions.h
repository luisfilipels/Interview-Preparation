//
// Created by luisf on 28-Jan-19.
//
#include "auxiliaryFunctions.h"
#include <vector>

#ifndef BUBBLE_SORT_ORDERFUNCTIONS_H
#define BUBBLE_SORT_ORDERFUNCTIONS_H

void bubbleSort(std::vector<int> &vet) {
    for (int i = 1; i < vet.size(); i++) {    //Bubble sort, propriamente dito.
        for (int j = 0; j < vet.size() - i; j++) {
            if (vet[j] > vet[j+1]) {
                swap(vet[j], vet[j+1]);
            }
        }
    }
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

#endif //BUBBLE_SORT_ORDERFUNCTIONS_H
