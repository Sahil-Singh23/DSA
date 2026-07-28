class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        int left=0;
        int len=0;

        for(int i =0 ; i<s.length() ; i++){
            char c= s.charAt(i);
            if(hash[(int)c]!=-1){
                left=Math.max(left,hash[(int)c]+1);
            }
            hash[(int)c]=i;
            len = Math.max(len,i-left+1);
        }return len;
    }
}