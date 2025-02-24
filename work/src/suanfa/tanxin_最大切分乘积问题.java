package suanfa;

public class tanxin_最大切分乘积问题 {

    /**
     * 数学推论：
     * ①大于等于4的整数都应该被切分
     * ②分出3比切分出2更优，即最多两个2（3个2可以组成2个3）
     * 思路找3的余数，0不做处理，1的话将最后一个3和1变成2*2，2的话不做处理
     *
     * @param n
     * @return
     */
    public int maxProductCutting(int n) {
        if (n <= 3) {
            return 1 * (n - 1);
        }
        int num = n / 3;
        int tmp = n % 3;
        if (tmp == 1) {
            return (int)Math.pow(3, num - 1) * 2 * 2;
        }
        if (tmp == 2) {
            return (int)Math.pow(3, num) * 2;
        }
        return (int)Math.pow(3, num);
    }

}
