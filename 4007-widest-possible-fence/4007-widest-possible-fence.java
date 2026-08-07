class Solution {
    public int maximumWidth(int[] planks) {
        int n = planks.length;

        HashMap<Integer,Integer> cnt = new HashMap<>();
        HashMap<Integer,Integer> res = new HashMap<>();

        for(int cur:planks){
            cnt.put(cur,cnt.getOrDefault(cur,0)+1);
            res.put(cur,res.getOrDefault(cur,0)+1);
        }
        //System.out.println(cnt);

        for(int i:cnt.keySet()){
            for(int j:cnt.keySet()){
                int height = i+j;
                if(i<j){
                    res.put(height,res.getOrDefault(height,0)+Math.min(cnt.get(i),cnt.get(j)));
                }else if(i==j){
                    res.put(height,res.getOrDefault(height,0)+cnt.get(i)/2);
                }
            }
        }
        //System.out.println(res);
        
        int ans = 0;
        for(int key:res.keySet()) ans = Math.max(ans,res.get(key));

        return ans;
    }
}