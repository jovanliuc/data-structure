package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution15 {

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);
        countNodes(root);
    }

    int countNodes(TreeNode root) {
        int high = 0;
        while (root != null) {
            root = root.left;
            high++;
        }

        return (int)Math.pow(2, high) - 1;
    }
}
