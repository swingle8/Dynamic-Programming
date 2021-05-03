// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends





class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
         int [][] mat = new int[val.length+1][W+1];
         for (int i = 0 ; i <= val.length ; i++)
            mat[i][0] = 0;
         for (int i = 0 ; i <= W ; i++)
            mat[0][i] = 0;
         int i = val.length - 1;
         
         return getValue (W, wt, val, i, mat);
     
    } 
    
    static int getValue (int W, int wt[], int val[], int i, int [][] mat) {
        if (W <= 0 || i < 0)
            return 0;
        if (mat[i+1][W] > 0)
            return mat[i+1][W];
        int result = 0;
        if (W < wt[i])
            result = getValue (W, wt, val, i-1, mat); 
        else
            result =  Math.max(getValue (W, wt, val, i-1, mat), getValue (W-wt[i], wt, val, i-1, mat) + val[i]);
        
        mat[i+1][W] = result;
        return result;
    }
}


