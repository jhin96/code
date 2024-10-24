package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/course-schedule/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot207 {

    public static void main(String[] args) {

    }

    /**
     * 本题可约化为： 课程安排图是否是 有向无环图(DAG)。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。
     * 思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG) 。 拓扑排序原理： 对 DAG 的顶点进行排序，使得对每一条有向边 (u,v)，均有 u（在排序记录中）比 v 先出现。亦可理解为对某点 v 而言，只有当 v 的所有源点均出现了，v 才能出现。
     * 通过课程前置条件列表 prerequisites 可以得到课程安排图的 邻接表 adjacency，以降低算法时间复杂度，以下两种方法都会用到邻接表。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length < 1) {
            return true;
        }
        // 存储每个节点的入度
        int[] indegrees = new int[numCourses];
        // 邻接表，存储节点以及节点指向的节点(比如0，1则是由1指向0，1依赖于0)
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 初始邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 入度和邻接表添加数据
        for (int[] data : prerequisites) {
            indegrees[data[0]]++;
            adjacency.get(data[1]).add(data[0]);
        }
        for (int j = 0; j < indegrees.length; j++) {
            if (indegrees[j] == 0) {
                // 入度为0的接口入队
                queue.add(j);
            }
        }

        // 出队
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--;
            // poll出队之后，将poll所有的前置减1
            for (int num : adjacency.get(poll)) {
                indegrees[num]--;
                if (indegrees[num] == 0) {
                    queue.add(num);
                }
            }
        }
        return numCourses == 0;
    }

}
