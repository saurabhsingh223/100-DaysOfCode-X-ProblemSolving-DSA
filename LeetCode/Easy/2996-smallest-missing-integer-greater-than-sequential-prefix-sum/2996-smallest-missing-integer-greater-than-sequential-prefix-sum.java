class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        // Step 1: calculate longest sequential prefix sum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            sum += nums[i];
        }

        // Step 2: store numbers in HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Step 3: find first missing integer
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}