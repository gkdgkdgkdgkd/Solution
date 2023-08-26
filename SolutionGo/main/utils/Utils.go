package utils

import (
	"fmt"
	"math/rand"
)

func Print(v [][]int) {
	fmt.Printf("[")
	for i := range v {
		fmt.Printf("[")
		for j, k := range v[i] {
			if j < len(v[i])-1 {
				fmt.Printf("%d,", k)
			} else {
				fmt.Printf("%d", k)
			}
		}
		fmt.Printf("]")
		if i < len(v)-1 {
			fmt.Printf(",")
		}
	}
	fmt.Printf("]\n")
}

func Array2(k int, v ...int) [][]int {
	l := len(v)
	count := l / k
	arr := make([][]int, count)
	for i := 0; i < count; i++ {
		arr[i] = make([]int, k)
		for j := 0; j < k; j++ {
			arr[i][j] = v[i*k+j]
		}
	}
	return arr
}

func RandomArray(len, start, end int) []int {
	res := make([]int, len)
	for i := 0; i < len; i++ {
		res[i] = RandomInt(start, end)
	}
	return res
}

func RandomInt(start, end int) int {
	return rand.Intn(end-start+1) + start
}

func PrintTestData(k int, f func()) {
	for i := 0; i < k; i++ {
		f()
	}
}
