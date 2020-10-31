//https://leetcode.com/problems/perfect-squares/
class Solution {
    public int numSquares(int n) {        
        int [] arr = new int[n+1];
        for (int i = 0 ; i <= n ; i ++) {
            arr[i] = i;
        }
        
        for (int i = 2 ; i < n+1 ; i ++) {
            for (int j = 1 ; j * j <= i ; j++) {
                arr[i] = Math.min(arr[i], arr[i - j*j]+1);
            }
        }
        
        return arr[n];
    }   
}