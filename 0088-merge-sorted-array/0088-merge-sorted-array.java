class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int r = n-1;
        int l = m-1;
        int w = nums1.length-1;
        //three pointers,
        //l - left  point at the end of first array elements,  
        //r - right point at the end of second array elements,  
        //w - write pointer points where we need to write what 

        while(w>=0 && r>=0 && l>=0){
            if(nums1[l]<nums2[r]){
                nums1[w]=nums2[r];
                r--;
                w--;
            }else if(nums1[l]>=nums2[r]){
                nums1[w]=nums1[l];
                l--;
                w--;
            }
        }
        while(r>=0){
            nums1[w]=nums2[r];
            r--;
            w--;
        }
        while(l>=0){
            nums1[w]=nums1[l];
            l--;
            w--;
        }
    }
}