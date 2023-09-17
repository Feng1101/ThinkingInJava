package feng.LeetCode.HW;

public class findMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{},new int[]{3,4}));
    }
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2){
        int left= nums1.length;
        int right=nums2.length;
        int len=nums1.length+nums2.length;
        int lk=0;
        int rk=0;
        double result=0.0;
        if(len%2!=0){
           len=(len+1)/2;
            for (int i = 0; i < len; i++) {
                if(nums1[lk]>nums2[rk]){
                    result=nums2[rk];
                    rk++;
                }else {
                    result=nums1[lk];
                    lk++;
                }
            }
        }else{
            len=len/2;
            for (int i = 0; i < len; i++) {
                if(nums1[lk]>nums2[rk]){
                    result=nums2[rk];
                    rk++;
                }else {
                    result=nums1[lk];
                    lk++;
                }
            }
        }

        return result;
    }
}
