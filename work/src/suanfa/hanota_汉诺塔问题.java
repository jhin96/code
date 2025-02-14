package suanfa;

import java.util.List;


public class hanota_汉诺塔问题 {

    /**
     * 思路就是将n - 1个圆盘看做一个整体通过buff移动到tar
     * 时间复杂度O(2的n次方)，空间复杂度O(n)
     *
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A.size(), A, B, C);
    }

    /**
     * 将前n个圆盘从A移动到C
     *
     * @param n
     * @param src
     * @param buff
     * @param tar
     */
    public void dfs(int n, List<Integer> src, List<Integer> buff, List<Integer> tar) {
        // 只有一个圆盘则直接移动
        if (n == 1) {
            move(src, tar);
            return;
        }
        // 子问题，将n - 1个圆盘从src移动到buff
        dfs(n - 1, src, tar, buff);
        // 移动最大的到tar
        move(src, tar);
        // 将n - 1个圆盘移动到tar
        dfs(n - 1, buff, src, tar);
    }

    /**
     * 移动一个圆盘
     *
     * @param src
     * @param tar
     */
    public void move(List<Integer> src, List<Integer> tar) {
        Integer remove = src.remove(src.size() - 1);
        tar.add(remove);
    }

}