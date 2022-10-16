package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution10 {

    int kthSmallest = 0;
    int rank = 0;

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);
        kthSmallest(root, 3);
    }

    int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return kthSmallest;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        System.out.print(root.val + " -> ");
        rank++;
        if (k == rank) {
            kthSmallest = root.val;
        }
        traverse(root.right, k);
    }
}
