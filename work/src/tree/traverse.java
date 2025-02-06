package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class traverse {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("层序遍历：");
        levelOrder(node1);
        System.out.println();

        System.out.println("前序遍历：");
        preOrder(node1);
        System.out.println();

        System.out.println("中序遍历：");
        inOrder(node1);
        System.out.println();

        System.out.println("后序遍历：");
        postOrder(node1);
        System.out.println();
    }

    /**
     * 层序遍历二叉树
     *
     * @param root
     * @return
     */
    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    /**
     * 前序遍历二叉树
     *
     * @param root
     * @return
     */
    private static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // 每次入栈打印保证中间节点先遍历
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     * @return
     */
    private static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                // 每次出栈打印保证左边节点先遍历
                System.out.print(pop.val + " ");
                root = pop.right;
            }
        }
    }

    /**
     * 后序遍历二叉树
     *
     * @param root
     * @return
     */
    private static void postOrder(TreeNode root) {
        // 用于记录上一个遍历过的节点
        TreeNode tmp = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 左子树全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            // 右节点为空或右节点刚刚遍历过，则可遍历这个节点
            if (node.right == null || node.right == tmp) {
                System.out.print(node.val + " ");
                tmp = node;
                stack.pop();
            } else {
                root = node.right;
            }
        }
    }

}
