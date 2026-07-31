class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 1)
            return true;
        
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while(i <= j) {

            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }

            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if(i == j) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}