class Solution {
    public int countSubstrings(String s) {
        
        char[] chars = s.toCharArray();
        int len = chars.length;
        int cnt = 0;

        for(int i=0 ; i<len ; i++){
            int oddLen = expandAndCount(i,i,chars,len);
            int evenLen = (i<len-1 && chars[i]==chars[i+1])?expandAndCount(i,i+1,chars,len):0;
            cnt+= oddLen+evenLen;
        }
        return cnt;
    }
    private int expandAndCount(int l , int r, char[] chars, int n){

        int cnt =1;
        while(l-1>=0 && r+1<n && chars[l-1]==chars[r+1]){
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}