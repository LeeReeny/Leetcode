public class FindMedianSortedArrays_4 {
    public static double getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 让len1的长度小于len2，这样保证如果有数组空了一定是nums1
        if(len1 > len2) return getKthElement(nums2, start2, end2, nums1, start1, end1, k);
        if(len1 == 0) return nums2[start2+k-1];

        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;
        if(nums1[i] > nums2[j]) return getKthElement(nums1, start1, end1, nums2, j+1, end2,k-(j-start2 + 1));
        else return getKthElement(nums1, i+1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKthElement(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKthElement(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    public static void main(String[] args) {
    }
}
