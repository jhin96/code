package tree;

import utils.TreeNode;

import java.util.*;

public class traverse_二叉树遍历 {

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
     * 层序遍历并按层打印
     *
     * @param root
     */
    private static void levelOrderPrint(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                level.add(poll.val);
            }
            list.add(level);
        }
        for (List<Integer> level : list) {
            System.out.println(level);
        }
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
        Stack<TreeNode> stack = new Stack<>();
        // 记录上一个遍历的节点
        TreeNode tmp = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.peek();
                // 右子树为空 or 右节点访问过，遍历该节点
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

}
