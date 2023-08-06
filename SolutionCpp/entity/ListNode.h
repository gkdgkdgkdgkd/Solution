//
// Created by null on 8/5/23.
//

#ifndef SOLUTIONCPP_LISTNODE_H
#define SOLUTIONCPP_LISTNODE_H


class ListNode {
public:
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


#endif //SOLUTIONCPP_LISTNODE_H
