public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> list = new ArrayList<>();
        ListNode current = head;

        // Save all nodes in a list
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null; // terminate the list
    }
}