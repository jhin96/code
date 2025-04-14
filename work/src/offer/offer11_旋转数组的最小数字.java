package offer;

/**
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=23269&sourceUrl=
 *
 */
public class offer11_旋转数组的最小数字 {

    public int minNumberInRotateArray (int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 右边有序
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 会有22212这种，无法判断在哪一边，但是right排除不影响（至少有个mid在）
                right--;
            }
        }
        return nums[left];
    }

    /**
     * 递归写法，较为复杂
     *
     * @param nums
     * @return
     */
    public int method1 (int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public int dfs (int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        if (nums[mid] <= nums[right]) {
            // 右边有序，但是无法排除mid(22212这种不知道到底在那边)
            return Math.min(dfs(nums, left, mid), dfs(nums, mid + 1, right));
        } else {
            // 右边无序（这里不要当成左边有序）
            return dfs(nums, mid + 1, right);
        }
    }

}
