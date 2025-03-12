package leetcode100;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。
 * 每个周期或时间间隔允许完成一项任务。任务可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。
 * 返回完成所有任务所需要的 最短时间间隔 。
 *
 * https://leetcode.cn/problems/task-scheduler/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot621_任务调度器 {

    /**
     * 找到最多的任务A数量为m，则前m-1个A后面必须有n个空位，可以用这些空位来填补
     * 如果最多任务A不止一个，则最后执行A之后再执行这些，此时可以算出一个结果
     * 如果上面的空位比其他的任务少，则往每个A后面加就行了，此时时间就是length，取最大值
     * 最好画图理解
     *
     * 时间复杂度：O(n + k)
     * 空间复杂度：O(k) k=26
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        // 统计每个任务出现次数，并记录最大值
        int max = 1;
        int[] array = new int[26];
        for (int c : tasks) {
            array[c - 'A']++;
            max = Math.max(max, array[c - 'A']);
        }

        // 计算一共有几个出现次数最大的任务
        int number = 0;
        for (int num : array) {
            if (num == max) {
                number++;
            }
        }

        // 加空位放不下的
        int res = (max - 1) * (n + 1) + number;
        // 跟第二种情况求最大值
        return Math.max(res, tasks.length);
    }

}
