class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max=0;
        //int[] p= new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0 ;i<n ; i++){
            while(!s.isEmpty() && heights[s.peek()]>heights[i]){
                int deletedTower=s.pop();
                //int width=i-p[deletedTower]-1;
                int delPse=s.isEmpty()?-1:s.peek();
                int width=i-delPse-1;
                max = Math.max(max,heights[deletedTower]*width);
            }
            //p[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        while(!s.isEmpty()){
            int deletedTower=s.pop();
            int delPse=s.isEmpty()?-1:s.peek();
            int width=n-delPse-1;
            max = Math.max(max,heights[deletedTower]*width);
        }return max;
    }
}