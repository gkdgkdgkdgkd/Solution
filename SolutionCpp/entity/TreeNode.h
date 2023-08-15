//
// Created by null on 8/13/23.
//

#ifndef SOLUTIONCPP_TREENODE_H
#define SOLUTIONCPP_TREENODE_H


class TreeNode {
public:
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


#endif //SOLUTIONCPP_TREENODE_H
