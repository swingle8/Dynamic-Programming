/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int p = 3;
		System.out.println(getways (p));
	}
	
	public static int getways (int p) {
	    int [] dp = new int [p+1];
	    dp[0] = 0;
	    dp[1] = 1;
	    dp[2] = 2;
	    for (int i = 3 ; i <= p ; i++) {
	        int iDanceSingly = dp[i-1];
	        int iDancePair = (i-1) * dp[i-2];
	        dp[i] = iDanceSingly + iDancePair;
	    }
	    return dp[p];
	}
}