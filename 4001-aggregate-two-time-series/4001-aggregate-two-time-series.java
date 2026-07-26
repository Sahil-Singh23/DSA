class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n = series1.length;
        int m = series2.length;
        
        List<List<Integer>> ls = new ArrayList<>();

        int lastKnown = series1[0][1];
        int lastKnown2 = series2[0][1];

        int l = 0 ;
        int r = 0 ; 

        while(l<n && r<m){
            List<Integer> temp = new ArrayList<>();
            if(series1[l][0]<series2[r][0]){
                temp.add(series1[l][0]);
                temp.add(lastKnown+lastKnown2);
                l++;
                lastKnown = l>=n?0:series1[l][1];
            }
            else if(series1[l][0]>series2[r][0]){
                temp.add(series2[r][0]);
                temp.add(lastKnown+lastKnown2);
                r++;
                lastKnown2 = r>=m?0:series2[r][1];
            }else if(series1[l][0]==series2[r][0]){
                temp.add(series1[l][0]);
                temp.add(lastKnown+lastKnown2);
                r++;
                l++;
                lastKnown = l>=n?0:series1[l][1];
                lastKnown2 = r>=m?0:series2[r][1];
            }
            ls.add(temp);   
            //System.out.println(ls);
        }

        while(l<n){
            List<Integer> temp = new ArrayList<>();
            temp.add(series1[l][0]);
            temp.add(series1[l][1]);
            ls.add(temp);
            l++;
        }
        while(r<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(series2[r][0]);
            temp.add(series2[r][1]);
            ls.add(temp);
            r++;
        }

        return ls;
            
        
    }
}