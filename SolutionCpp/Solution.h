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

using namespace std;

static int x = []() {

    std::ios::sync_with_stdio(false);

    cin.tie(nullptr);

    return 0;
}();

class Solution {
private:
    ListNode *mergeSort(vector<ListNode *> &lists, auto l, auto r) {
        if (l == r) {
            return lists[l];
        }
        auto m = (l + r) >> 1;
        auto *left = mergeSort(lists, l, m);
        auto *right = mergeSort(lists, m + 1, r);
        if (!left) {
            return right;
        }
        if (!right) {
            return left;
        }
        return merge(left, right);
    }

    ListNode *merge(ListNode *l1, ListNode *l2) {
        auto dummy = new ListNode();
        auto temp = dummy;
        while (l1 && l2) {
            if (l1->val > l2->val) {
                temp->next = l2;
                l2 = l2->next;
            } else {
                temp->next = l1;
                l1 = l1->next;
            }
            temp = temp->next;
        }
        if (l1) {
            temp->next = l1;
        }
        if (l2) {
            temp->next = l2;
        }
        return dummy->next;
    }

public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        lists.erase(remove_if(begin(lists), end(lists), [](auto p) { return !p; }), end(lists));
        if (lists.empty()) {
            return nullptr;
        }
        return mergeSort(lists, 0, lists.size() - 1);
    }
};

#endif //SOLUTIONCPP_SOLUTION_H
