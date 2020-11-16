//https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0#
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
	    
	        int rows = sc.nextInt();
	        int cols = sc.nextInt();
	        int [][] mat = new int [rows][cols];
	        for (int i = 0 ; i < rows ; i++)
	            for (int j = 0 ; j < cols ; j++)
	                mat[i][j] = sc.nextInt();
	        
	        int max = 0;
	        
	        for (int i = 0 ; i < cols ; i ++) {
	            int [] tempdata = new int [rows];
	            for (int j = i ; j < cols ; j++) {
	                for (int m = 0 ; m < rows ; m ++) {
	                    tempdata[m] = tempdata[m] + mat[m][j];
	                }
	                
	                int localmax = tempdata[0];
	                int maxTillHere = tempdata[0];
	                int previous = tempdata[0];
	         
	               //kadane's algo
	               //References : https://www.youtube.com/watch?v=yCQN096CwWM
	               //Kadane : https://www.youtube.com/watch?v=86CQq3pKSUw
	                for (int k = 1 ; k < rows ; k ++) {
	                    maxTillHere = Math.max(tempdata[k], previous + tempdata[k]);
	                    previous = maxTillHere;
	                    localmax = Math.max(localmax, maxTillHere);
	                }
	                
	                max = Math.max(max, localmax);
	            }
	        }
	        
	        System.out.println(max);
	        
	    }
	 }
}