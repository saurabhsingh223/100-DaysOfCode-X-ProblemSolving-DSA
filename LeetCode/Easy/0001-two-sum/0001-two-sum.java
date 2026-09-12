class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Optimal Approach
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int compliment = target-nums[i];
            if(map.containsKey(compliment)){
                return new int [] {map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        return new int [] {};

        //Brute Force Approach
        // int [] ans = new int[2];
        // for(int i = 0; i<nums.length-1; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         if(nums[i]+nums[j] == target){
        //             ans[0] = i;
        //             ans[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return ans;
    }
}