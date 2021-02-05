// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends


class Solution { 
    // return length of longest strictly increasing subsequence
    static int ans = 0;
    static int longestSubsequence(int size, int a[]){
        int [] dp  = new int [size];
        ans = 0;
        for (int i = size-1 ; i >= 0 ; i--)
            subsequence (a, size, i, dp);
        
        
        return ans;
    }
    
    static int subsequence (int [] arr, int size, int i, int [] dp) {
        if (dp[i] != 0)
            return dp[i];
        
        int maxSum = 1;
        for (int j = i+1 ; j < size ; j++) {
            int sum = 0;
            if (arr[j] > arr[i]) {
                sum = subsequence (arr, size, j, dp) + 1;
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        dp [i] = maxSum;
        ans = Math.max(ans, dp[i]);
        return maxSum;
    }
} 


//[3, 4, 2, 3, 2, 1]