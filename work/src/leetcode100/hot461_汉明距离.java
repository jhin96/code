package leetcode100;


/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * https://leetcode.cn/problems/hamming-distance/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot461_汉明距离 {

    public static void main(String[] args) {
        hot461_汉明距离 hot461_汉明距离 = new hot461_汉明距离();
        System.out.println(hot461_汉明距离.hammingDistance(1, 3));
    }

    /**
     * 异或运算，相同为0，不同为1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int res = 0;
        int tmp = x ^ y;
        while (tmp != 0) {
            res += tmp & 1;
            tmp >>= 1;
        }
        return res;
    }

    /**
     * 位运算，去掉末尾数 x >> 1
     *
     * @param x
     * @param y
     * @return
     */
    public int method1(int x, int y) {
        int res = 0;
        while (x != 0 && y != 0) {
            if ((x & 1) != (y & 1)) {
                res++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        int tmp = x == 0 ? y : x;
        while (tmp != 0) {
            if ((tmp & 1) != 0) {
                res++;
            }
            tmp = tmp >> 1;
        }
        return res;
    }

}