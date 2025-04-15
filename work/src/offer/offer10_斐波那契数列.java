package offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 *
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=23255&sourceUrl=
 *
 */
public class offer10_斐波那契数列 {

    public int Fibonacci (int n) {
        if (n < 3) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}
