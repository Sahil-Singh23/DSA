class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int a=-1;
        int b=-1;
        int c=-1;
        for(int i=0 ; i<s.length() ; i++){
            char x = s.charAt(i);
            if(x=='a') a=i;
            else if(x=='b') b=i;
            else c=i;
            count+= Math.min(c,(Math.min(a,b)))+1;
        }return count;
    }
}