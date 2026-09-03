class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = Integer.MAX_VALUE;
        boolean allEven = true;
        for (int num : nums1) {
            mn = Math.min(mn, num);
            if (num % 2 != 0) allEven = false;
        }
        return (mn % 2 != 0) || allEven;
    }
}