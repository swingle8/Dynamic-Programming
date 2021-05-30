class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0 ; i < wordDict.size() ; i++)
            set.add(wordDict.get(i));

        return isKnownWord (set, s, len-1, len);
    }
    
    public boolean isKnownWord (HashSet<String> set, String s, int start, int end) {
        if (start == 0 && set.contains(s.substring(start, end)))
            return true;
        if (start == 0 && ! set.contains(s.substring(start, end)))
            return false;

        if (set.contains(s.substring(start, end))) {
            return isKnownWord (set, s, start-1, start) || isKnownWord(set, s, start-1, end);
        }
        
        return isKnownWord (set, s, start-1, end);
    }
}