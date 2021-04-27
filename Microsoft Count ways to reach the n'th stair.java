// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}// } Driver Code Ends



class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        if (n == 0 || n ==1 || n == 2)
            return n;
        //recursice solution o(2^n) 
        // return countWays (n-1) + countWays (n-2);
        
        //Iterative solution O(n)
        int [] arr = new int [n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3 ; i <= n ; i++)
            arr[i] = arr[i-1] + arr[i-2];
        
        return arr[n];
    }
}

