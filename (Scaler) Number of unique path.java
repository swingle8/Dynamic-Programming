// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        int [][] matrix = new int[a][b];
        matrix[0][0] = 1;
        
        for (int i = 0 ; i < a ; i++) {
            for (int j = 0 ; j < b ; j++) {
                if (i == 0 && j == 0)
                    continue;
                
                if (i-1 >= 0)
                    matrix[i][j] += matrix[i-1][j];
                
                if (j-1 >= 0)
                    matrix[i][j] += matrix[i][j-1];
            }
        }
        
        return matrix[a-1][b-1];
    }
}