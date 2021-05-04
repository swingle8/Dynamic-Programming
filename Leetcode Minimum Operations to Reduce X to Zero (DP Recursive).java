class Solution {
    public int minOperations(int[] nums, int x) {
        int i = 0;
        int j = nums.length-1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int ans = getMinRemovals (nums, x, i, j, map);
        if (ans >= 100000000)
            return -1;
        return ans;
    }
    
    public int getMinRemovals (int [] nums, int x, int i, int j, HashMap<String, Integer> map) {
        if (x == 0)
            return 0;
        if (i > j)
            return 100000000;
        String key = i + "*" + j + "*" + x;
        if (map.containsKey(key))
            return map.get(key);
        map.put(key, Math.min (1 + getMinRemovals (nums, x-nums[i], i+1, j, map), 1 + getMinRemovals (nums, x-nums[j], i, j-1, map)));
        
        return map.get(key);
    }
}