package newhot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class newhot15_三数之和 {

    public static void main(String[] args) {
        newhot15_三数之和 func = new newhot15_三数之和();
        List<List<Integer>> list = func.threeSum(new int[]{1,-1,-1,0});
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 减枝
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 后续都是大于0的
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 处理相同元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
