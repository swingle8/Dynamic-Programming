// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class gfg
{
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    //sc.next();
    while(t-- > 0)
    {
        int n = sc.nextInt();
        
        int A[]  =new int[105];
        int B[] = new int[105];
        int C[] = new int[105];
        
        for(int i = 0; i < n; i++)
        {
            int a =sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            A[i] = a;
            B[i] = b;
            C[i] = c;
        }
        
        Solution ob = new Solution();
        System.out.println(ob.maxHeight(A,B,C,n));
    }
   }
}// } Driver Code Ends


//User function Template for Java



class Solution 
{
    public static int maxHeight(int height[], int width[], int length[], int n)
   {
        ArrayList<Boxes> list = new ArrayList<Boxes>();
        createBoxes (height, width, length, n, list);
        Collections.sort(list);
    
        int len = list.size();
        int [] heightBoxes = new int[len]; 
        for (int i = 0 ; i < len ; i++)
           heightBoxes[i] = list.get(i).height;
        int ans = 0;
        
        for (int i = 1 ; i < len ; i++) {
            int originalHeight = list.get(i).height;
            int originalWidth = list.get(i).width;
            int originalLength = list.get(i).length;
            for (int j = 0 ; j < i ; j++) {
                if (list.get(j).width > originalWidth && list.get(j).length > originalLength && heightBoxes[j]+originalHeight > heightBoxes[i])
                    heightBoxes[i] = heightBoxes[j]+originalHeight;
            }
            ans = Math.max(ans, heightBoxes[i]);
        }
        
        return ans;
   }
   
   public static void createBoxes (int height[], int width[], int length[], int n, ArrayList<Boxes> list) {
        for (int i = 0 ; i < n ; i ++) {
            int max = Math.max(width[i], length[i]);
            int min = Math.min(width[i], length[i]);
            list.add(new Boxes(height[i], max, min));
            
            max = Math.max(height[i], length[i]);
            min = Math.min(height[i], length[i]);
            
            list.add(new Boxes(width[i], max, min));
            
            max = Math.max(height[i], width[i]);
            min = Math.min(height[i], width[i]);
            list.add(new Boxes(length[i], max, min));
        }
   }
   
   
}

class Boxes implements Comparable<Boxes>{
    int height;
    int width;
    int length;
    int area;
    Boxes (int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
        area = width * length;
    }
    
    public int compareTo (Boxes b) {
        if (b.area > this.area)
            return 1;
        else if (b.area < this.area)
            return -1;
        return 0;
    }
}

