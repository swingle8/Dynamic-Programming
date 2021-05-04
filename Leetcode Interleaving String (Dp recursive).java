class Solution {
    public boolean isInterleave(String a, String b, String c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        if (lenA + lenB != lenC)
            return false;
        if (lenC == 0)
            return true;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return isInterLeaving (a, b, c, i, j, k, map);
    }
    
    public boolean isInterLeaving (String a, String b, String c, int i, int j, int k, HashMap<String, Boolean> map) {
	     if (k == c.length()) {
	        if (i == a.length() && j == b.length())
	            return true;
	        return false;
	     }
	     
	     String key = i + "*" + j + "*" + k;
	     if (map.containsKey(key))
	        return map.get(key);
	     if (i == a.length()) {
	         if (b.charAt(j) == c.charAt(k))
	            return isInterLeaving (a, b, c, i, j+1, k+1, map);
	       return false;
	     }
	     if (j == b.length()) {
	         if (a.charAt(i) == c.charAt(k))
	            return isInterLeaving (a, b, c, i+1, j, k+1, map);
	         return false;
	     }
	     
	        
	     boolean aMatch = false;
	     boolean bMatch = false;
	     if (a.charAt(i) == c.charAt(k))
	        aMatch = isInterLeaving (a, b, c, i+1, j, k+1, map);
	     if (b.charAt(j) == c.charAt(k))
	        bMatch = isInterLeaving (a, b, c, i, j+1, k+1, map);
	      
	      map.put(key, aMatch || bMatch);
	    return map.get(key);
	}
}