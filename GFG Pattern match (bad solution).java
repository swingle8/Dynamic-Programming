// { Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}// } Driver Code Ends




class Solution
{
    int wildCard(String pattern, String str)
    {   
        int i = pattern.length()-1;
        int j = str.length()-1;
        if (wildCardMatch(pattern, str, i, j))
            return 1;
        return 0;
    }
    
    boolean wildCardMatch (String pattern, String str, int i, int j) {
        if (i > 0 && pattern.charAt(i) == '*' && j < 0)
            return wildCardMatch(pattern, str, i-1, j);
        if (i == 0 && pattern.charAt(i) == '*')
            return true;
        
        if (i < 0 && j < 0)
            return true;
        
        if (i < 0 || j < 0)
            return false;
        
        char atI = pattern.charAt(i);
        char atJ = str.charAt(j);
        
        boolean ans = false;
        if (atI != '?' && atI != '*') {
            if (atI == atJ)
                ans = wildCardMatch (pattern, str, i-1, j-1);
            else
                ans = false;
        }
        else if (atI == '?') {
                ans = wildCardMatch (pattern, str, i-1, j-1);
        }
        else if (atI == '*') {
            for (int k = j ; k >= 0 ; k--) {
                if (wildCardMatch (pattern, str, i-1, j-k)) {
                    ans = true;
                    break;
                }
            }
        }
        
        return ans;
    }
}
