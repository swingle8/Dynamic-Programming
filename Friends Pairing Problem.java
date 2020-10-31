// { Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1#

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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
       int Mod = 1000000007;
       int parent = 1;
       int previous = 2;
       int current = 0;
       
       for (int i = 3 ; i < n+1 ; i++) {
           current = previous + (((i-1) * parent)%Mod);
           parent = previous;
           previous = current;
       }
       
       return current;
    }
}