package leetcode100;


/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot4_寻找两个正序数组的中位数 {


    /**
     * 可转换为求两个数组中第k小的元素
     * 时间复杂度：O(log(len1+len2))
     * 空间复杂度：O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            // 偶数返回中间两个的平均数
            return (getKMin(nums1, nums2, len / 2) + getKMin(nums1, nums2, len / 2 + 1)) / 2.0d;
        } else {
            // 奇数返回中间的
            return getKMin(nums1, nums2, len / 2 + 1);
        }
    }

    /**
     * 每次比较nums1[k/2 - 1]和nums2[k/2 - 1]，然后排除较小的那个左边的元素（这部分一定比k小）
     * 需要处理越界的情况，和右边界取最小值
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int getKMin(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 用指针定义边界
        int index1 = 0;
        int index2 = 0;

        while (k > 0) {
            // 边界条件
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常条件
            //这里必须要-1是因为需要将当前元素排除，这样在边界时就能将len-1排除只看第二个数组（index1 = newIndex1 + 1;）
            int newIndex1 = Math.min(index1 + k / 2 - 1, len1 - 1);
            int newIndex2 = Math.min(index2 + k / 2 - 1, len2 - 1);
            // 去掉左边的
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                // 去掉右边的，等于放在两种情况都行
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
        // 正常不会走到这里
        return -1;
    }

}
