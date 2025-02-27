package leetcode100;


import java.util.Arrays;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * https://leetcode.cn/problems/queue-reconstruction-by-height/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot406_根据身高重建队列 {

    /**
     * 每次处理最矮的人，按照前后多少来定位
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n)排序是logn，但是visit数组是n
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) {
            return people;
        }
        // 第一位从小到大排序，第一位相等则第二位也是从小到大
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int[][] res = new int[people.length][people[0].length];
        // 表示这个位置是够被放置了
        boolean[] visit = new boolean[people.length];
        for (int[] person : people) {
            int height = person[0];
            int value = person[1];
            // 从左往右找到>=height的第value + 1个位置放下，该位置必须为空位
            int j = 0;
            while (j < people.length) {
                if (value == 0 && !visit[j]) {
                    break;
                }
                // 没有被占位置或者当前位置元素高于height；相当于留了一个空位，value--
                if (!visit[j] || res[j][0] >= height) {
                    j++;
                    value--;
                } else {
                    j++;
                }
            }
            res[j][0] = height;
            res[j][1] = person[1];
            visit[j] = true;
        }
        return res;
    }
}
