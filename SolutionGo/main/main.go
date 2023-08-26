package main

import (
	"SolutionGo/main/utils"
)

func main() {
	utils.PrintTestData(1, func() {
		n := utils.RandomInt(100, 200)
		res := make([][]int, n)
		for i := 0; i < n; i++ {
			r := utils.RandomInt(10, 1000)
			start := utils.RandomInt(1, r)
			end := utils.RandomInt(start, start*2)
			arr := make([]int, 2)
			arr[0], arr[1] = start, end
			res[i] = arr
		}
		utils.Print(res)
	})
}
