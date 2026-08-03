class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while(j < s.length()) {
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i) {
                int pos = map.get(ch);
                i = pos+1;
            } 

            map.put(ch, j);
            j++;

            max = Math.max(max, j-i);

            // System.out.printf("i=%d, j=%d, max=%d\n", i,j,max);
                
        }
        return max;
    }
}