class Solution {
    private void findWrongNodes(
        TreeNode currentNode,
        TreeNode[] prevNode,
        TreeNode[] firstWrongNode,
        TreeNode[] secondWrongNode
    ) {
        // base case
        if (currentNode == null) return;

        // recurse on left
        findWrongNodes(currentNode.left, prevNode, firstWrongNode, secondWrongNode);

        // check current against the previous node in inorder order
        if (prevNode[0] != null && prevNode[0].val > currentNode.val) {
            // first time we see a descent, the previous node is wrong
            if (firstWrongNode[0] == null) {
                firstWrongNode[0] = prevNode[0];
            }
            // the current node is the second wrong one (updated again if there's a 2nd descent)
            secondWrongNode[0] = currentNode;
        }
        prevNode[0] = currentNode;

        // recurse on right
        findWrongNodes(currentNode.right, prevNode, firstWrongNode, secondWrongNode);
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] prevNode = new TreeNode[1];
        TreeNode[] firstWrongNode = new TreeNode[1];
        TreeNode[] secondWrongNode = new TreeNode[1];

        // find the two wrongly placed nodes
        findWrongNodes(root, prevNode, firstWrongNode, secondWrongNode);

        if (firstWrongNode[0] == null || secondWrongNode[0] == null) {
            return; // nothing to fix
        }

        // swap their values
        int tempVal = firstWrongNode[0].val;
        firstWrongNode[0].val = secondWrongNode[0].val;
        secondWrongNode[0].val = tempVal;
    }
}