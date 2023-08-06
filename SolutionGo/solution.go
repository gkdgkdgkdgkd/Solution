package SolutionGo

func swapPairs(head *ListNode) *ListNode {
	dummy := &ListNode{}
	for pre, temp := dummy, head; temp != nil; {
		v0, v1 := temp, temp.Next
		if v1 == nil {
			pre.Next = v0
			break
		}
		v2 := v1.Next
		v1.Next = v0
		v0.Next = v2
		pre.Next = v1
		pre = v0
		temp = v2
	}
	return dummy.Next
}
