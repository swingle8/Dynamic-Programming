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
        int rows = s1.length();
        int cols = s2.length();
        
        int [][] matrix = new int [rows+1][cols+1];
        int ans = 0;
        for (int i = 1; i <= rows ; i++) {
            for (int j = 1 ; j <= cols ; j++) {
                char s1Char = s1.charAt(i-1);
                char s2Char = s2.charAt(j-1);
                
                if (s1Char == s2Char) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    ans = Math.max(ans, matrix[i][j]);
                }
                else {
                    matrix[i][j] = Math.max (matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        return ans;
    }
    
}