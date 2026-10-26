/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private List<int> list;
    public Solution() {
        list = new List<int>();
    }

    private void getInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // first recur to the left:
        getInorder(node.left);

        // deal with the current node:
        this.list.Add(node.val);

        // second recur to the right:
        getInorder(node.right);
    }

    public IList<int> InorderTraversal(TreeNode root) {
        getInorder(root);
        return this.list;
    }
}