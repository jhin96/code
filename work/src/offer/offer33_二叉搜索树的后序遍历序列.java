package offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=23289&sourceUrl=
 *
 */
public class offer33_二叉搜索树的后序遍历序列 {

    /**
     * 最后一位是根节点，从右到左大于root的就当成右子树，剩下是左子树，左子树都必须小于root
     * 接着递归遍历左右子树
     * 时间复杂度：O(n方)，退化成链表
     * 空间复杂度：O(n)，退化成链表
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }
        return dfs(sequence, 0, sequence.length - 1);
    }

    /**
     * 递归找左右子树，从右到左找第一个比root小的，左边都是左子树，判断左子树是否含有大于root的元素
     *
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    public boolean dfs (int [] sequence, int start, int end) {
        // 单个节点返回true
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        // 找左、右子树的分界点
        int right = end - 1;
        // 这里要加>=，因为如果只有右子树，最后right + 1就是start
        while (sequence[right] > root && right >= start) {
            right--;
        }
        // 判断左子树
        for (int i = start; i < right; i++) {
            if (sequence[i] > root) {
                return false;
            }
        }
        return dfs(sequence, start, right) && dfs(sequence, right + 1, end - 1);
    }

}
