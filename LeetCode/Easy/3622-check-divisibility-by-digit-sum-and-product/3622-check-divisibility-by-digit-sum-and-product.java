class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int real = n;
        while(n > 0){
            int digit = n%10;
            sum += digit;
            prod *= digit;
            n /= 10;
        }
        if(real % (sum+prod) == 0) return true;
        return false;
    }
}