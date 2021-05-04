// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends





class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        return getCount (s1, s2, x-1, y-1);
    }
    
    static int getCount (String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        
        if (s1.charAt(i) == s2.charAt(j))
            return (1 + getCount (s1, s2, i-1, j-1));
        
        return Math.max (getCount (s1, s2, i-1, j), getCount (s1, s2, i, j-1)); 
    }
}