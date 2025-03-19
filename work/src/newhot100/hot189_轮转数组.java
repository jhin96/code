package newhot100;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 *
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot189_轮转数组 {

    public static void main(String[] args) {
        hot189_轮转数组 hot189_轮转数组 = new hot189_轮转数组();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        hot189_轮转数组.rotate(nums, 4);
        System.out.println(nums);
    }

    /**
     * 就是将后面k的元素放到前面，并且顺序要一致
     * 翻转整个数组，翻转前k和，翻转后n-k个
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k == 0) {
            return;
        }
        int n = nums.length;
        // k大于n时需要处理
        k = k % n;
        reverse(nums, 0 , n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * 每次移动一位，超时
     *
     * @param nums
     * @param k
     */
    public void method1(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int right = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = right;
        }
    }

}
