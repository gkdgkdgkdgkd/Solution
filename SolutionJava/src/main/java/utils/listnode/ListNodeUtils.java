package utils.listnode;

import node.ListNode;

public class ListNodeUtils {
    public static ListNode listNode(int... val) {
        ListNode head = new ListNode(val[0]);
        int len = val.length;
        ListNode temp = head;
        for (int i = 1; i < len; i++) {
            temp.next = new ListNode(val[i]);
            temp = temp.next;
        }
        return head;
    }
}
