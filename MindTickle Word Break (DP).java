class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0 ; i < wordDict.size() ; i++)
            set.add(wordDict.get(i));
        
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return isword (set, s, 0, map);
        }
    

    public boolean isword (HashSet<String> set, String s, int row, HashMap<Integer, Boolean> map) {
        if (row == s.length())
            return true;
        int key = row;
        boolean ans = false;
        if (map.containsKey(row))
            return map.get(row);
        for (int j = row ; j < s.length() && !ans ; j++) {
            String sub = s.substring(row, j+1);
            if (set.contains(sub))
                ans = isword (set, s, j+1, map);
        }
        
        map.put(row, ans);
        return ans;
        
    }
}