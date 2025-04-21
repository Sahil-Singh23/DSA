package DSA.LeetCode.Heap;

import java.util.PriorityQueue;

// Time: O(N log k), where N is total number of nodes and k is the number of lists
// Space: O(N) for the priority queue

public class LC23 {
    public static void main(String[] args) {
        // Example: lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[] { l1, l2, l3 };

        LC23 solution = new LC23();
        ListNode result = solution.mergeKLists(lists);

        // Print the merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode l : lists) {
            while (l != null) {
                pq.offer(l.val);
                l = l.next;
            }
        }

        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while (!pq.isEmpty()) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


/*
 * A better approch would be this
 * 
 * class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        if (a != null) current.next = a;
        if (b != null) current.next = b;

        return dummy.next;
    }
}

 */