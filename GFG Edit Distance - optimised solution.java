// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        //return compare (s, t, s.length()-1, t.length()-1, 0);
        
        //Optimised O(m*n)
        int rows = s.length();
        int cols = t.length();
        int [] [] mat = new int [rows+1][cols+1];
        
        for (int i = 1 ; i <= cols ; i++ )
            mat [0][i] = i;
        for (int i = 1 ; i <= rows ; i++ )
            mat [i][0] = i;
            
        for (int i = 1 ; i <= rows ; i++) {
            for (int j = 1 ; j <= cols ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    mat[i][j] = mat[i-1][j-1];
                else {
                    mat[i][j] = Math.min (mat[i-1][j-1], mat[i-1][j]);
                    mat[i][j] = Math.min (mat[i][j], mat[i][j-1]);
                    mat[i][j]++;
                }
            }
        }
        
        return mat[rows][cols];
    }
    
    
    
    // Brute force - O (3^(m+n))
    public int compare (String s, String t, int i, int j, int sum) {
        if (i < 0 && j < 0)
            return sum;
        
        if (i < 0 || j < 0) {
            return Math.max(i, j) + sum + 1;
        }
        
        int current = sum;
        if (s.charAt(i) == t.charAt(j))
            current = compare (s, t, i-1, j-1, sum);
        else {
            int oneWay = compare (s, t, i-1, j-1, sum+1);
            int secondWay = compare (s, t, i, j-1, sum+1);
            int thirdWay = compare (s, t, i-1, j, sum+1);
            current = Math.min(oneWay, secondWay);
            current = Math.min (thirdWay, current);
        }
        
        return current;
    }
}