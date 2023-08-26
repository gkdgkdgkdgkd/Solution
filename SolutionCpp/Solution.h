#ifndef SOLUTIONCPP_SOLUTION_H
#define SOLUTIONCPP_SOLUTION_H

#include "entity/ListNode.h"
#include "entity/TreeNode.h"
#include<vector>
#include<cmath>
#include<queue>
#include<iostream>
#include<functional>
#include<algorithm>
#include<climits>

using namespace std;

/*
static int x = []() {

    std::ios::sync_with_stdio(false);

    cin.tie(nullptr);

    return 0;
}();*/

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>> &intervals) {
        vector<vector<int>> res;
        std::sort(intervals.begin(), intervals.end());
        auto last = intervals[0];
        auto n = intervals.size();
        for (int i = 1; i < n; ++i) {
            if (last[1] < intervals[i][0]) {
                res.push_back(last);
                last = intervals[i];
            } else if (last[1] < intervals[i][1]) {
                last[1] = intervals[i][1];
            }
        }
        res.push_back(last);
        return res;
    }
};

#endif //SOLUTIONCPP_SOLUTION_H
