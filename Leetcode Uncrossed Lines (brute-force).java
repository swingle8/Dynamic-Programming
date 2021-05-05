class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        return maxLines (A, B, lenA-1, lenB-1);
    }
    
    public int maxLines (int [] A, int [] B, int lenA, int lenB) {
        if (lenA < 0 || lenB < 0)
            return 0;
        
        if (A[lenA] == B[lenB])
            return (1 + maxLines (A, B, lenA-1, lenB-1));
        
        return Math.max (maxLines (A, B, lenA-1, lenB), maxLines (A, B, lenA, lenB-1));
    }
}