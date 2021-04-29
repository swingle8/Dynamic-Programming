class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int [] arr = new int [n+1];
        return nthFibonacci (n, arr);
    }
    
    public int nthFibonacci (int n, int [] arr) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (arr[n-1] == 0)
            arr[n-1] = nthFibonacci (n-1, arr);
        if (arr[n-2] == 0)
            arr[n-2] = nthFibonacci (n-2, arr);
        if (arr[n] == 0)
            arr[n] = arr[n-1] + arr[n-2];
        return arr[n];
    }
}