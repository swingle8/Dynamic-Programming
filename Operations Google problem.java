//https://leetcode.com/discuss/interview-question/538568/google-onsite-min-operations-to-reduce-number-to-1
import java.util.*;
public class Operations {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if (num == 0 || num == 1) {
            System.out.println(0);
            System.exit(0);
        }
        else if (num == 2 || num == 3) {
            System.out.println(1);
            System.exit(0);
        }
            
        int [] arr = new int[num+1];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4 ; i < num+1 ; i++)
            arr[i] = num+1;
           
        for (int i = 4 ; i < num+1 ; i ++) {
            int one = arr[i] = arr[i-1];
            int two = one;
            int three = one;
            if (i%2 == 0)
               two =  arr[i/2];
            if (i%3 == 0)
               three =  arr[i/3];
            two = Math.min(two, three);
            arr[i] = Math.min(one, two) + 1;
        }

        System.out.println(arr[num]);
    }
}
