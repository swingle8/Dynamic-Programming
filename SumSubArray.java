import java.util.*;
class SumSubArray {
    public static void main (String [] args) {
        int [] arr = {8, 11, 1, 7, 9, 0, 21};
        int sum = 16;
        ArrayList<Integer> ans = getSubArray(arr, sum);
        //System.out.println(ans.size());
        for (int i = 0; i < ans.size() ; i++)
            System.out.print(ans.get(i) + " ");
    }

    static ArrayList<Integer> getSubArray(int [] arr, int sum) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int len = arr.length;
        if (len < 1)
            return al;

        int [] sumArray = new int [len];
        sumArray[0] = arr[0];
        for (int i = 1 ; i < len ; i++)
            sumArray[i] = sumArray[i-1] + arr[i];
    
        int start = 0;
        for (int i = 0 ; i < len ; i++) {
            int currentSum = sumArray[i];
            if (currentSum < sum)
                continue;
            else {
                while (currentSum - sumArray[start] > sum && start < i)
                    start++;

            int len1 = i - start+1;
            if (! al.isEmpty() && al.size() > len1) {
                al.clear();
                for (int j = start ; j <= i ; j++)
                    al.add(arr[j]);
            }
            else if (al.isEmpty()) {
                for (int j = start ; j <= i ; j++)
                    al.add(arr[j]);
            }
        }
        start = 0;
    }
    return al;
}

}

