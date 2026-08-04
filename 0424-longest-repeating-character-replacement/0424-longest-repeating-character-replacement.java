class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, freq.get(ch));

            while ((right - left + 1) - maxFreq > k) {

                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}