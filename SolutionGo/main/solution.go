package main

import "sort"

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	last := intervals[0]
	res := make([][]int, 0)
	for i, n := 1, len(intervals); i < n; i++ {
		cur := intervals[i]
		if last[1] < cur[0] {
			res = append(res, last)
			last = cur
		} else if last[1] < cur[1] {
			last[1] = cur[1]
		}
	}
	res = append(res, last)
	return res
}
