package leet;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * https://leetcode.cn/problems/maximum-swap/description/
 *
 */
public class leet670_最大交换 {

    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {
        if (num <= 10) {
            return num;
        }
        String s = String.valueOf(num);
        int[] numArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            numArr[i] = s.charAt(i) - '0';
        }
        // 找到每个数字右边的最大数索引(尽量靠右)
        // 其实跟找最右边大于本身的数一样
        int[] rightMax = new int[s.length()];
        int maxIndex = s.length() - 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            rightMax[i] = maxIndex;
            if (numArr[i] > numArr[maxIndex]) {
                maxIndex = i;
            }
        }
        // 找到第一个可以交换的
        for (int i = 0; i < s.length() - 1; i++) {
            // 右边最大的数大于本身
            if (numArr[i] < numArr[rightMax[i]]) {
                int tmp = numArr[i];
                numArr[i] = numArr[rightMax[i]];
                numArr[rightMax[i]] = tmp;
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + numArr[i];
        }
        return res;
    }

}
