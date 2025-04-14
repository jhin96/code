package offer;

/**
 * 数字以 0123456789101112131415... 的格式作为一个字符序列，在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，以此类题，请你输出第 n 位对应的数字。
 *
 * https://www.nowcoder.com/practice/29311ff7404d44e0b07077f4201418f5?tpId=13&tqId=2285751&sourceUrl=
 *
 */
public class offer44_数字序列中某一位的数字 {

    /**
     * 可以理解为返回1234567891011...返回第n位的数字
     * 除了个位数以外，n位数有n * 9 * 10的n-1次方 个数字，确定位数，然后找元素
     *
     * @param n
     * @return
     */
    public int findNthDigit (int n) {
        // step1：确定是几位数
        int digit = 1;
        // start需要从1开始
        long start = 1;
        // 后面乘法可能超过范围
        long count = 9;
        while (n > count) {
            n -= count;
            start = (long) Math.pow(10, digit);
            digit++;
            count = 9 * digit * start;
        }
        // step2：确定是哪个数字，需要-1
        long num = start + (n - 1) / digit;
        // step3：确定该数字的具体位数
        char c = String.valueOf(num).charAt(((n - 1) % digit));
        return c - '0';
    }

}
