class Solution {
  public boolean searchMatrix(int[][] mat, int targ) {
    int l = 0;
    int r = mat.length * mat[0].length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      int row = mid / mat[0].length; // how many rows far
      int col = mid % mat[0].length; // how far inside the row

      if (targ == mat[row][col])
        return true;
      else if (targ > mat[row][col])
        l = mid + 1;
      else
        r = mid - 1;
    }
    return false;
  }
}