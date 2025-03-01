package leetcode100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot297_二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        hot297_二叉树的序列化与反序列化 func = new hot297_二叉树的序列化与反序列化();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(func.serialize(node1));

        func.deserialize("");
    }

    /**
     * 队列允许添加null，最后的null处不处理都行
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                res.append(poll.val).append(",");
                // 不论是不是空都将左、右节点添加进来
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.length() < 3) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < split.length) {
            TreeNode currentNode = queue.poll();

            // 处理左节点
            if (!split[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                currentNode.left = left;
                queue.offer(left);
            }
            index++;

            // 处理右节点
            if (index < split.length && !split[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                currentNode.right = right;
                queue.offer(right);
            }
            index++;
        }
        return root;
    }

    /**
     * 序列化结束之后格式为[1,2,3,null,null,4,5]这种用[]包围的
     * 因为需要将null节点加到queue中，不能用node(0)，所以用一个辅助queue跟层序遍历同步，若碰到null说明是空节点
     * 只用string的queue不行，因为没法记录子节点关系
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public String method1(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> nodeList = new ArrayList<>();

        // 层序遍历,用一个队列辅助，主要是为了区分null
        Queue<String> nodeQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        nodeQueue.offer(String.valueOf(root.val));
        while (!queue.isEmpty() && !nodeQueue.isEmpty()) {
            TreeNode poll = queue.poll();
            String nodePoll = nodeQueue.poll();
            nodeList.add(nodePoll);
            if (nodePoll.equals("null")) {
                // 当前是空节点
                continue;
            }
            // 左子树
            if (poll.left != null) {
                queue.offer(poll.left);
                nodeQueue.offer(String.valueOf(poll.left.val));
            } else {
                queue.offer(new TreeNode());
                nodeQueue.offer("null");
            }
            // 右子树
            if (poll.right != null) {
                queue.offer(poll.right);
                nodeQueue.offer(String.valueOf(poll.right.val));
            } else {
                queue.offer(new TreeNode());
                nodeQueue.offer("null");
            }
        }

        // 去掉末尾的null
        while (!nodeList.isEmpty() && nodeList.get(nodeList.size() - 1).equals("null")) {
            nodeList.remove(nodeList.size() - 1);
        }
        return "[" + String.join(",", nodeList) + "]";
    }

    /**
     * 构建二叉树，还是借助队列重建二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，退化为链表
     *
     * @param data
     * @return
     */
    public TreeNode method1(String data) {
        if(data == null || data.length() < 3) {
            return null;
        }
        String[] nodeArray = data.substring(1, data.length() - 1).split(",");
        // 索引记录nodeArray的进度
        int index = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeArray[0]));
        queue.offer(root);

        // 因为是层序遍历，所以index处的节点一定是current节点的子节点，可以画图理解（相当于一层层处理）
        while (!queue.isEmpty() && index < nodeArray.length) {
            // 只处理当前节点
            TreeNode currentNode = queue.poll();

            // 左节点，这里不需要判断index，因为还没运算
            if (!nodeArray[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeArray[index]));
                currentNode.left = leftNode;
                queue.offer(leftNode);
            }
            // 不论是不是节点，index都要更新
            index++;

            // 右节点
            if (index < nodeArray.length && !nodeArray[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeArray[index]));
                currentNode.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }

        return root;
    }

}
