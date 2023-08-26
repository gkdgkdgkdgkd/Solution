//
// Created by null on 8/21/23.
//

#include "Utils.h"

vector<int> Utils::randomArray(int len, int start, int end) {
    vector<int> res;
    random_device rd;
    mt19937 generator(rd());
    uniform_int_distribution<int> range(start, end);
    for (int i = 0; i < len; ++i) {
        res.push_back(range(generator));
    }
    return res;
}

void Utils::print(const vector<int> &out) {
    cout << '[';
    auto len = out.size();
    for (auto v: out) {
        cout << v;
        --len;
        if (len != 0) {
            cout << ',';
        }
    }
    cout << ']' << endl;
}

void Utils::run(int count, function<void()> f) {
    for (int i = 0; i < count; ++i) {
        f.operator()();
    }
}