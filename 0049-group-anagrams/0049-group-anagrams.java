class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        HashMap<String,List<String>> hm = new HashMap<>();

        for(String cur:strs){
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(cur);
        }
        for(List<String> cur: hm.values()){
            ans.add(cur);
        }
        return ans;
    }
}