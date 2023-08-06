#ifndef SOLUTIONCPP_SOLUTION_H
#define SOLUTIONCPP_SOLUTION_H

#include "entity/ListNode.h"

class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        auto dummy = new ListNode();
        for (auto pre = dummy, temp = head; temp != nullptr;) {
            auto v0 = temp;
            auto v1 = temp->next;
            if (v1 == nullptr) {
                pre->next = v0;
                break;
            }
            auto v2 = v1->next;
            v1->next = v0;
            v0->next = v2;
            pre->next = v1;
            pre = v0;
            temp = v2;
        }
        return dummy->next;
    }
};

#endif //SOLUTIONCPP_SOLUTION_H
