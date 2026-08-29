class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i>= 0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i]+1;
                return digits;
            }
            digits[i] = 0;
        }

        int [] newAns = new int[n+1];
        newAns[0] = 1;
        return newAns;
    }
}