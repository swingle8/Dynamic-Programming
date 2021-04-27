// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinSquares(int n) {
        int [] arr = new int[n+1];
        
        if (n <= 3)
            return n;
            
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        
        for (int i = 4 ; i <= n ; i++) {
            arr[i] = i;
            for (int j = 1 ; j * j <= i ; j++) {
                arr[i] = Math.min(arr[i], arr[i-j*j]+1);
            }
        }
        
        return arr[n];
    }
}