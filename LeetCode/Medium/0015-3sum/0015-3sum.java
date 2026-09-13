class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Optimal Solution
        
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j-1] == nums[j]) j++;
                    while(j < k && nums[k+1] == nums[k]) k--;
                } else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
            return list;

        // Better Sol

        // Set<List<Integer>> ans = new HashSet<>();
        // for(int i = 0; i<nums.length-1; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i+1; j<nums.length; j++){
        //         int k = -(nums[i] + nums[j]);
        //         if(set.contains(k)){
        //             List<Integer> temp = Arrays.asList(nums[i],nums[j],k);
        //             Collections.sort(temp);
        //             ans.add(temp);
        //         }
        //         set.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(ans);

        //Better Solution

        // Brute 
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         for (int k = j; k < n; k++) {
        //             List<Integer> sums = new ArrayList<>();
        //             if (nums[i] + nums[j] + nums[k] == 0 && i != j && j != k && i != k) {
        //                 sums.add(nums[i]);
        //                 sums.add(nums[j]);
        //                 sums.add(nums[k]);
        //                 Collections.sort(sums);
        //                 if (!list.contains(sums)) {
        //                     list.add(sums);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return list;
    }
}