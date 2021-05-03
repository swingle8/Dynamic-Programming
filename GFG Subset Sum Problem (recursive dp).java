// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int [][] dp = new int[arr.length+1][sum+1];
        int calculatedSum = hasSum (arr, sum, N-1, dp);
        return calculatedSum == sum;
    }
    
    static int hasSum (int [] arr, int sum, int index, int [][] dp) {
        if (sum == 0 || index < 0)
            return 0;
        if (dp[index+1][sum] != 0)
            return dp[index+1][sum];
        if (sum < arr[index])
            dp[index+1][sum] = hasSum(arr, sum, index-1, dp);
        else
            dp[index+1][sum] = Math.max(hasSum (arr, sum, index-1, dp), arr[index] + hasSum (arr, sum-arr[index], index-1, dp));
        
        return dp[index+1][sum]; 
    }
}