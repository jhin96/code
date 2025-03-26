package newhot;

public class newhot11_盛最多水的容器 {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        // 贪心算法
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
