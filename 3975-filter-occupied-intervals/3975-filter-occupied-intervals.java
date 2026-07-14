class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n = occupiedIntervals.length;

        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(occupiedIntervals,(a,b)->a[0]-b[0]);

        for(int i = 0 ;i<n ; i++){
            int[] interval = occupiedIntervals[i];
            // System.out.print(interval[0]+" ");
            // System.out.print(interval[1]+" ,");
            if(ls.isEmpty() || interval[0]-(ls.get(ls.size()-1).get(1))>1){
                List<Integer> temp = new ArrayList<>();
                temp.add(interval[0]);
                temp.add(interval[1]);
                ls.add(temp);
            }else{
                if(ls.get(ls.size()-1).get(1)<interval[1])
                    ls.get(ls.size()-1).set(1,interval[1]);
            }
        }
        // System.out.println();
        // System.out.println(ls);
        for(int i=0 ; i<ls.size() ; i++){
            List<Integer> cur = ls.get(i);
            //System.out.println(cur);
            if(cur.get(0)>=freeStart && cur.get(1)<=freeEnd){
                //delete interval
                
                ls.remove(i);
                i--;
            }else if(cur.get(0)<freeStart && cur.get(1)>freeEnd){
                ls.add(i + 1, new ArrayList<>(List.of(freeEnd + 1, cur.get(1))));
                cur.set(1,freeStart-1);
                i++;
            }else if(cur.get(0)<freeStart && cur.get(1)>=freeStart){
                //if end of inteval is overlapping we clip the end
                cur.set(1,freeStart-1);
            }else if(cur.get(0)<=freeEnd && cur.get(1)>=freeEnd){
                cur.set(0,freeEnd+1);
            }
        }
        return ls;
    }
}