// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int [] ans = getMax (a, n);
        int sum = ans[0];
        int max = ans[2];
        int min = ans[1];

        if (min == sum)
            return max;
        return Math.max(max, sum-min);
    }
    
    static int[] getMax (int [] a, int n) {
        int sum = 0;
        int maxHere = 0;
        int minHere = 0;
        int minTillNow = Integer.MAX_VALUE;
        int maxTillNow = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < n ; i++) {
            sum += a[i];
            maxHere += a[i];
            minHere += a[i];
            minHere = Math.min (minHere, a[i]);
            maxHere = Math.max (maxHere, a[i]);
            minTillNow = Math.min (minTillNow, minHere);
            maxTillNow = Math.max (maxTillNow, maxHere);
        }
        int [] ans = new int [3];
        ans[0] = sum;
        ans[1] = minTillNow;
        ans[2] = maxTillNow;
        return ans;
    }
}

