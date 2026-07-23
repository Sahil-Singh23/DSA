class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        int low=0;
        int high=x/2;
        long mid=-1;
        while(low<=high){
            mid = low + ((high - low) >> 1);
            if(mid*mid<=x){
                low=(int)mid+1;
            }
            else{
                high=(int)mid-1;
            }
        }return high;
    }
}