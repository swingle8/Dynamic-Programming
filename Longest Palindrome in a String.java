import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases -- > 0) {
	        String s = sc.next();
	        System.out.println(getLongestPermutation(s));
	    }
	 }
	 
	 public static String getLongestPermutation (String s) {
	     int len = s.length();
	     boolean  [][] matrix = new boolean [len][len];
	     int start = 0;
	     int end = 0;
	     //single character
	     for (int i = 0 ; i < len ; i++)
	        matrix[i][i] = true;
	        
	     //two char string
	     char prev = s.charAt(0);
	     for (int i = 1 ; i < len ; i++) {
	         if (prev == s.charAt(i)) {
	            matrix[i-1][i] = true;
	            if (i-i+1+1 > end-start+1) {
	                     start = i-1;
	                     end = i;
	            }
	         }
	         prev = s.charAt(i);
	     }
	     
	     //fill the complete matrix for all strings
	     for (int j = 2 ; j < len ; j++) {
	         int jIterator = j;
	         for (int i = 0; i < len ; i++) {
	             if (s.charAt(i) == s.charAt(jIterator) && matrix[i+1][jIterator-1]) {
	                 
	                 matrix[i][jIterator] = true;
	                 if (jIterator-i+1 > end-start+1) {
	                     start = i;
	                     end = jIterator;
	                 }
	             }
                jIterator++;
                if (jIterator == len)
                    break;
	         }
	     }
	     
	     String ans = s.substring(start, end+1);
	     return ans;
	     
	 } 
}