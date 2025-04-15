package offer;

/**
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 *
 * https://www.nowcoder.com/practice/11662ff51a714bbd8de809a89c481e21?tpId=13&tqId=2282583&sourceUrl=
 *
 */
public class offer85_连续子数组的最大和II {

    public int[] FindGreatestSumOfSubArray (int[] array) {
        if (array == null || array.length < 1) {
            return new int[0];
        }
        int n = array.length;
        int max = Integer.MIN_VALUE;
        // 以i结尾的最大子数组和
        int[] dp = new int[n];
        dp[0] = array[0];
        // 记录最大和起、止索引(其实用一个int[]记录当前位置结束的最大子数组起点更好理解)
        int start = 0;
        int end = 0;
        // 借助一个临时start记录答案
        int tmpStart = 0;
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] + array[i] >= array[i]) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
                // 这里证明当前的最大值起点是i；上一步不用更新是因为tmpStart没变化
                tmpStart = i;
            }
            // 更新max，加=记录最大的数组
            if (dp[i] >= max) {
                max = dp[i];
                start = tmpStart;
                end = i;
            }
        }
        int[] res = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            res[i - start] = array[i];
        }
        return res;
    }

}
