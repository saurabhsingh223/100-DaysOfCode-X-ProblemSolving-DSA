class Solution {
    public int minimumDeletions(int[] nums) {
        int minInd = 0;
        int maxInd = 0;
        int n = nums.length;
        if(n == 1) return 1;
        for(int i = 0; i<n; i++){
            if(nums[i] > nums[maxInd]){
                maxInd = i;
            }else if(nums[i] < nums[minInd]){
                minInd = i;
            }
        }
        int delFromLeft = Math.max(minInd, maxInd)+1;
        int delFromRight = n - Math.min(minInd, maxInd);
        int delFromBoth = (Math.min(minInd, maxInd) + 1) + (n - Math.max(minInd, maxInd));

        return Math.min(delFromLeft, Math.min(delFromRight, delFromBoth)); 
    }
}