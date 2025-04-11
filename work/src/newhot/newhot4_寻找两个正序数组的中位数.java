package newhot;

public class newhot4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (getKMin(nums1, nums2, len / 2) + getKMin(nums1, nums2, len / 2 + 1)) / 2.0d;
        } else {
            return getKMin(nums1, nums2, len / 2 + 1);
        }
    }

    /**
     * 找两个数组第k小的元素
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int getKMin(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
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

            int newIndex1 = Math.min(index1 + k / 2 - 1, len1 - 1);
            int newIndex2 = Math.min(index2 + k / 2 - 1, len2 - 1);
            if (nums1[newIndex1] < nums2[newIndex2]) {
                // nums1的左边元素排除
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
        // 不会走到这一步
        return -1;
    }

}
