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

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int ways = getMinInstances (coins, M-1, V);
	    if (ways == 100000000)
	        return -1;
	   return ways;
	}
	
	public int getMinInstances (int [] coins, int i, int v) {
	    if (v == 0)
	        return 0;
	    if (v < 0 || i < 0)
	        return 100000000;
	    
	    return Math.min (1 + getMinInstances (coins, i, v-coins[i]), getMinInstances (coins, i-1, v)); 
	}
}