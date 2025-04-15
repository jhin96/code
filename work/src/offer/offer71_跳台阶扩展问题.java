package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 *
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=23262&sourceUrl=
 *
 */
public class offer71_跳台阶扩展问题 {

    public int jumpFloorII (int number) {
        if (number == 1) {
            return 1;
        }
        int[] dp = new int[number + 1];
        dp[1] = 1;
        for (int i = 2; i <= number; i++) {
            // dp[i] = dp[i - 1] +...+ dp[1] + 1
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
            // 一步跳上来
            dp[i]++;
        }
        return dp[number];
    }

    public int method1(int number) {
        if (number == 1) {
            return 1;
        }
        int[] dp = new int[number + 1];
        dp[1] = 1;
        for (int i = 2; i <= number; i++) {
            // 观察规律
            dp[i] = 2 * dp[i - 1];
        }
        return dp[number];
    }

}
