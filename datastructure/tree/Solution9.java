package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution9 {

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);
        traverse(root);
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        System.out.print(root.val + " -> ");
        traverse(root.right);
    }
}
