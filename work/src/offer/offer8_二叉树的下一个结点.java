package offer;


/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 *
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=23451&sourceUrl=
 *
 */
public class offer8_二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 若存在右子树，下一节点为right的最小左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 无右子树
        while (pNode.next != null) {
            // 如果是父节点的左节点，则下一节点是父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            // 如果是父节点的右节点，则重复这一过程，知道找到第一个左节点为止
            pNode = pNode.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
