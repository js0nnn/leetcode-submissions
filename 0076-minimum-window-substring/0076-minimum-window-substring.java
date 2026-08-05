class Solution {
    public boolean has(int c2[], int c1[]) {
        for(int i = 0; i < 128; i++) {
            if(c1[i] == 0) continue;
            else if(c1[i] > c2[i])
                return false;
        }
        return true;
    }

    public void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            System.out.printf("%c=%d ", 'A'+i, arr[i]);
        }
        System.out.println();
    }

    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";


        int count1[] = new int[128];
        int count2[] = new int[128];
        int r = 0;

        for(; r < t.length(); r++) {
            count1[t.charAt(r) - 'A']++;
            count2[s.charAt(r) - 'A']++;
        }

        // printArr(count1);
        // printArr(count2);

        if(has(count2, count1))
            return s.substring(0, r);

        int l = 0;
        int st = 0, ed = 0;
        int min = s.length();

        for(; r <= s.length(); r++) {
            // printArr(count2);
            if(has(count2, count1)) {     
                while(has(count2, count1)) {
                    count2[s.charAt(l) - 'A']--;
                    l++;
                }
                int window_size = r-(l-1);
                // System.out.printf("window_size=%d, l=%d, r=%d\n", window_size,l,r);
                if(window_size <= min) {
                    st = l-1; ed = r;
                    min = window_size;
                }   
            }

            if(r == s.length()) break;
            
            count2[s.charAt(r) - 'A']++;
        }
        
        // System.out.printf("l=%d, r=%d\n", st, ed);
        return s.substring(st, ed);
    }
}