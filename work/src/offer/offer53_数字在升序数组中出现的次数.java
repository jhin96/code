package offer;


/**
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 *
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=23274&sourceUrl=
 *
 */
public class offer53_数字在升序数组中出现的次数 {

    public static void main(String[] args) {
        offer53_数字在升序数组中出现的次数 offer53_数字在升序数组中出现的次数 = new offer53_数字在升序数组中出现的次数();
        int[] nums = new int[]{3};
        int i = offer53_数字在升序数组中出现的次数.GetNumberOfK(nums, 3);
        System.out.println(i);
    }

    public int GetNumberOfK (int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = 1;
        int end = 0;
        int left = 0;
        int right = nums.length - 1;
        // 找第一个
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > k) {
                right = mid - 1;
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                start = mid;
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        // 找最后一个
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > k) {
                right = mid - 1;
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                end = mid;
                left = mid + 1;
            }
        }
        return end - start + 1;
    }

}
