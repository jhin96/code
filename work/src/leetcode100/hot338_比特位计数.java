package leetcode100;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * https://leetcode.cn/problems/counting-bits/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot338_比特位计数 {

    /**
     * 动态规划
     * num的1个数比num & (num - 1)的1个数多1，num & (num - 1)比num小
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 暴力位运算
     * 空间复杂度O(1)
     * 时间复杂度O(nlogn)，logn是二进制的位数
     *
     * @param n
     * @return
     */
    public int[] method1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = getOne(i);
        }
        return res;
    }

    /**
     * 获取num中1的个数
     *
     * @param num
     * @return
     */
    public int getOne(int num) {
        int res = 0;
        while (num > 0) {
            // 还能通过num & (num - 1)去掉最右边的1，然后res++
            res += num & 1;
            num >>= 1;
        }
        return res;
    }
}
