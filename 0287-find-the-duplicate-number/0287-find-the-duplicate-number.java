class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;

        while(slow==0 || slow!=fast){

            slow=nums[slow];
            fast=nums[fast];
            fast=nums[fast];
        }
        System.out.println(slow);
        System.out.println(fast);
         slow = 0;

        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        System.out.println(slow);
        System.out.println(fast);

        return slow;
    }
}