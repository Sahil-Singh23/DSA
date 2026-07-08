class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        
        int n = s.length();
        int a=0;
        int b=0;

        for(int i=0 ; i<t.length() ; i++){
            if(s.charAt(a)==t.charAt(i)) a++;
            a = Math.max(a,b+1);
            if(s.charAt(b)==t.charAt(i)) b++;
            if(a==n || b == n ) return true;
        }
        return false;
    }
}