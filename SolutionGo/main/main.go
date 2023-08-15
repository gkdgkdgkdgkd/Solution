package main

import (
	"SolutionGo/main/utils"
)

func main() {
	utils.PrintTestData(4, func() {
		k := 30
		utils.Print(utils.Array2(k, utils.RandomArray(k*k, -99, 99)...))
	})
}
