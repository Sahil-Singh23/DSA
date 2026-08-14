class Solution {
    public int maximumSwap(int num) {
        int len = (num==0)?1:(int)Math.log10(num)+1;

        char[] digits = String.valueOf(num).toCharArray();
        int nge[] = new int[len];

        char max = 'x';
        int rmax = -1;
        for(int i=len-1; i>=0 ; i--){
            if(max=='x' || digits[i]>max){
                rmax = i;
                max = digits[i];
            }
            nge[i] = rmax;
        }

        for(int i=0 ; i<len ; i++){
            if(nge[i]!=i && digits[i]!=digits[nge[i]]){
                char temp = digits[i];
                digits[i] = digits[nge[i]];
                digits[nge[i]] = temp;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(digits));
    }
}