// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) { 
	    int [] ans = new int[V+1];
	    ans[0] = 0;
	    
	    for (int i = 1 ; i <= V ; i++) {
	        ans[i] = Integer.MAX_VALUE;
	        for (int j = 0 ; j < M ; j++) {
	            if (coins[j] <= i) {
	                int times = ans[i - coins[j]];
	                if (times != Integer.MAX_VALUE)
                        ans[i] = Math.min(ans[i], times+1);	                
	            }
	        }
	    }
	    
	    if (ans[V] == Integer.MAX_VALUE)
	        return -1;
	   return ans[V];
	} 
}