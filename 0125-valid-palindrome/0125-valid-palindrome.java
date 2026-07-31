class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(char ch : s.toCharArray()) {
            if(Character.isLetter(ch) || Character.isDigit(ch)) 
                sb.append(ch);
        }

        // if(sb.length() <= 1)
        //     return false;

        System.out.println(sb);

        return sb.toString().equals(sb.reverse().toString());
    }
}