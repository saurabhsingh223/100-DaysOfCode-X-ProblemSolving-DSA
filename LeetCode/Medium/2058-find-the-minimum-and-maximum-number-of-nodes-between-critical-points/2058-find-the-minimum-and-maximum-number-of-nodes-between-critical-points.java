/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1, prevIdx = -1, idx = 0;
        int minDist = Integer.MAX_VALUE, maxDist = -1;

        ListNode prev = head, curr = head.next;
        idx = 1;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (firstIdx == -1) firstIdx = idx;
                else minDist = Math.min(minDist, idx - prevIdx);

                prevIdx = idx;
                maxDist = idx - firstIdx;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        return firstIdx == -1 || prevIdx == firstIdx
            ? new int[]{-1, -1}
            : new int[]{minDist, maxDist};
    }
}