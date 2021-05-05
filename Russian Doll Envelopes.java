class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int []>() {
           public int compare (final int[] a, final int [] b) {
               if (a[0] > b[0])
                   return 1;
               else
                   return -1;
           } 
        });
        
        int [] ans = new int[envelopes.length];
        int max = 1;
        for (int i = 0 ; i < envelopes.length ; i++)
            ans[i] = 1;
        
        for (int i = 1 ; i < envelopes.length ; i++) {
            
            for (int j = 0 ; j < i ; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && 1+ans[j] > ans[i])
                    ans[i] = 1+ans[j];
            }
            max = Math.max(max, ans[i]);
        }
        
        return max; 
    }
}