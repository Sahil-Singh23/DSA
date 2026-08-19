class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 || s==null) return "";

        int start=0,end=0;

        char[] str = s.toCharArray();

        for(int i=0 ; i<str.length ; i++){
            int odd = expand(str,i,i);
            int even = expand(str,i,i+1);
            int len = Math.max(odd,even);

            if(len > end-start){
                start = i - (len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expand(char[] str, int left, int right){
        while(left>=0  && right<str.length && str[left]==str[right]){
            left--;
            right++;
        }
        return right-left-1;
    }
}