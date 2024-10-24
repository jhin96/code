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
            // poll出队之后，将所有依赖他的减一
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
