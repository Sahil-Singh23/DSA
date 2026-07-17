class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j= i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> temp = new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
                    ls.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
            }

        }
        return ls;









        // HashSet<List<Integer>> set = new HashSet<>();
        
        
        // for(int i=0 ; i<n ; i++){
        //     HashSet<Integer> hs = new HashSet<>();
        //     for(int j= i+1 ; j<n ; j++){
        //         //nums[i]+nums[j]+nums[k] = 0
        //         int third = -(nums[i]+nums[j]);
        //         if(hs.contains(third)){
        //             List<Integer> temp = new ArrayList<>(List.of(nums[i],nums[j],third));
        //             Collections.sort(temp);
        //             set.add(temp);
        //         }
        //         hs.add(nums[j]);
        //     }
        // }
        // List<List<Integer>> ls = new ArrayList<>(set);
        // return ls;










        // HashSet<List<Integer>> hs = new HashSet<>();

        // for(int i=0 ; i<n ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         for(int k=j+1 ; k<n ; k++){
        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 List<Integer> temp = new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
        //                 Collections.sort(temp);
        //                 hs.add(temp);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> ls = new ArrayList<>(hs);
        // return ls;
    }
}