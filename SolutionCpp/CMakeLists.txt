cmake_minimum_required(VERSION 3.0)
project(SolutionCpp)

set(CMAKE_CXX_STANDARD 23)

add_executable(SolutionCpp main.cpp
        Solution.h
        entity/ListNode.cpp
        entity/ListNode.h
        entity/TreeNode.cpp
        entity/TreeNode.h)
