// { Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}

// } Driver Code Ends




/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        if (lenA + lenB != lenC)
            return false;
        if (Math.abs(lenA - lenB) > 1)
            return false;
        if (lenC == 0)
            return true;
        return isInterLeaving (a, b, c, i, j, k);
	}
	
	public boolean isInterLeaving (String a, String b, String c, int i, int j, int k) {
	     if (k == c.length()) {
	        if (i == a.length() && j == b.length())
	            return true;
	        return false;
	     }
	     
	     boolean aMatch = false;
	     boolean bMatch = false;
	     if (i < a.length() && a.charAt(i) == c.charAt(k))
	        aMatch = isInterLeaving (a, b, c, i+1, j, k+1);
	     else if (j < b.length() && b.charAt(j) == c.charAt(k))
	        bMatch = isInterLeaving (a, b, c, i, j+1, k+1);
	   
	     if (j < b.length() && b.charAt(j) == c.charAt(k))
	        bMatch = isInterLeaving (a, b, c, i, j+1, k+1);
	     else if (i < a.length() && a.charAt(i) == c.charAt(k))
	        aMatch = isInterLeaving (a, b, c, i+1, j, k+1);
	          
	    return aMatch || bMatch;
	}
}

