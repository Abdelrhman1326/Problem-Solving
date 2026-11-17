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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null)  {
                nums.add(curr.val);
                curr = curr.next;
            }
        }

        if (nums.size() == 0) {
            return null;
        }

        nums.sort(null);

        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;
        for (int i = 0; i < nums.size(); i++) {
            curr.val = nums.get(i);

            if (i == nums.size() - 1) {
                curr.next = null;
            } else {
                ListNode next = new ListNode();
                curr.next = next;
                curr = next;
            }
        }

        return mergedList;
    }
}