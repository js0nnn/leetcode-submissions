class Solution {
  public boolean canEat(int[] piles, int h, int speed) {
    long ctr = 0;
    for(int pile : piles) {
      // long eats = (long)Math.ceil((double)pile/(double)speed);
      // System.out.printf("%d/%d = %d\n", pile, speed, eats);
      // ctr +=  (long)Math.ceil((double)pile/(double)speed);
      ctr += (pile + (long)speed - 1) / speed;
    }
    // System.out.printf("ctr=%d, speed(mid)=%d\n", ctr, speed);
    return ctr <= h;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int max = 0;
    for(int pile : piles) {
      max = Math.max(max, pile);
    }

    int start = 1;
    int end = max;
    int min = max;

    while(start <= end) {
      int mid = (start + end) / 2;

      if(canEat(piles, h, mid)) {
        min = Math.min(min, mid);
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return min;
  }
}