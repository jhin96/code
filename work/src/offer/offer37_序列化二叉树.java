package offer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束.
 * 但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。
 *
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=23455&sourceUrl=
 *
 */
public class offer37_序列化二叉树 {

    public static void main(String[] args) {
        offer37_序列化二叉树 func = new offer37_序列化二叉树();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        node2.right = node3;
        String serialize = func.Serialize(root);
        TreeNode node = func.Deserialize(serialize);
        System.out.println();
    }

    /**
     * 借助队列序列化
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        stb.append("[");
        // 借助队列的层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                stb.append(poll.val + ",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                stb.append("null,");
            }
        }
        stb.deleteCharAt(stb.length() - 1);
        stb.append("]");
        return stb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] split = str.substring(1, str.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        int index = 1;
        // 借助一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && index < split.length) {
            TreeNode poll = queue.poll();
            // 左节点
            if (!"null".equals(split[index])) {
                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                poll.left = left;
                queue.offer(left);
            }
            index++;
            // 右节点
            if (!"null".equals(split[index])) {
                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                poll.right = right;
                queue.offer(right);
            }
            index++;
        }
        return root;
    }

}
