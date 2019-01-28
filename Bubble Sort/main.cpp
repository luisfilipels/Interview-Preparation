#include <iostream>
#include <vector>
#include <ctime>
#include <chrono>
#include <cstdlib>
#include <random>

#define SIZE 100
#define MAX 100

std::vector<int> fillRand (int size, int max) {
    std::mt19937 mersenne(static_cast<unsigned int>(std::time(nullptr)));
    std::uniform_int_distribution<> die(1, max);
    std::vector<int> vet;
    for (int i = 0; i < size; i++) {
        vet.push_back(die(mersenne));aaaaa
    }
    return vet;
}

int main() {
    std::vector<int> vet = fillRand(SIZE, MAX);
    for (int i = 1; i < SIZE; i++) {
        std::cout << vet[i]  << std::endl;
    }
    return 0;
}