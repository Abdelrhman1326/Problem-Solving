public class Solution {
    private bool Validate(TreeNode node, long? minVal, long? maxVal) {
        if (node == null) return true;

        if (minVal.HasValue && (node.val <= minVal.Value)) return false;
        if (maxVal.HasValue && (node.val >= maxVal.Value)) return false;

        bool leftValid = Validate(node.left, minVal, node.val);
        bool rightValid = Validate(node.right, node.val, maxVal);

        return leftValid && rightValid;
    }

    public bool IsValidBST(TreeNode root) {
        return Validate(root, null, null);
    }
}