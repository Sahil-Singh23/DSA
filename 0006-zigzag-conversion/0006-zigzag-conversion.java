class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1 || n <= numRows) return s; 

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) rows[i]= new StringBuilder(); 
        
        int row = 0;
        boolean flag = true;
        int i = 0;
        while(i<n){
            char cur = s.charAt(i);
            rows[row].append(cur);
            if(row==0) flag = true;
            if(row==numRows-1) flag = false;
            if(flag)row++;
            else row--;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder cur: rows){
            sb.append(cur);            
        }
        return sb.toString();
    }
}