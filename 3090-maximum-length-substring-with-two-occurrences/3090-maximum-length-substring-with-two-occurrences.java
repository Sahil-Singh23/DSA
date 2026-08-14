class Solution {
    public int maximumLengthSubstring(String s) {
        int[] hash = new int[26];
        int left=0, max=0, len=0;
        char[] a = s.toCharArray();
        int n = a.length;
        for(int i=0 ; i<n ; i++){
            hash[a[i]-'a']++;
            if(hash[a[i]-'a']<=2){
                len = i-left+1;
                max= Math.max(len,max);
            }
            while(hash[a[i]-'a']>2){
                hash[a[left]-'a']--;
                left++;
            }
        }return max;
    }
}