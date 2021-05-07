class Solution {
    public int largestRectangleArea(int[] hist) {
        int n = hist.length;
        Stack<Integer> st = new Stack<Integer>();
        int [] histLeftDip = new int [n];
        histLeftDip[0] = 0;
        st.push(0);
        
        for (int i = 1 ; i < n ; i++) {
            while (! st.isEmpty()) {
                int index = st.pop();
                if (hist[index] < hist[i]) {
                    st.push(index);
                    histLeftDip[i] = index+1;
                    break;
                }
                else {
                     histLeftDip[i] = histLeftDip[index];
                }
                
             }
            st.push(i);
        }
        
        st.clear();
        
        int [] histRightDip = new int [n];
        histRightDip[n-1] = n-1;
        st.push(n-1);
        
        for (int i = n-2 ; i >= 0 ; i--) {
            while (! st.isEmpty()) {
                int index = st.pop();
                if (hist[index] < hist[i]) {
                    st.push(index);
                    histRightDip[i] = index-1;
                    break;
                }
                else {
                     histRightDip[i] = histRightDip[index];
                }
                
             }
            st.push(i);
        }
        
        int area = 0;
        
        for (int i = 0 ; i < n ; i++) {
            int diff = histRightDip[i] - histLeftDip[i] + 1;
            int currentArea = diff * hist[i];
            area = Math.max (area, currentArea);
        }
        
        return area;
    }
}