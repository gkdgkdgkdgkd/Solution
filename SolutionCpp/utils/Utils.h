//
// Created by null on 8/21/23.
//

#ifndef SOLUTIONCPP_UTILS_H
#define SOLUTIONCPP_UTILS_H

#include<vector>
#include<random>
#include<iostream>
#include <functional>

using namespace std;

class Utils {
public:
    static vector<int> randomArray(int len, int start, int end);

    static void print(const vector<int> &out);

    static void run(int count, function<void()> f);
};


#endif //SOLUTIONCPP_UTILS_H
