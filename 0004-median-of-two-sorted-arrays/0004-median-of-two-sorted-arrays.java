class Solution {

  public void printArr(int arr[] ) {
    for(int n : arr) {
      System.out.print(n+" ");
    }
    System.out.println();
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int t[] = new int[nums1.length + nums2.length];
    int ctr = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        t[ctr++] = nums1[i++];
      } else {
        t[ctr++] = nums2[j++];
      }
    }

    while (i < nums1.length) {
      t[ctr++] = nums1[i++];
    }

    while (j < nums2.length) {
      t[ctr++] = nums2[j++];
    }

    printArr(t);

    if(ctr % 2 == 0) {
      return (double)(t[ctr/2] + t[ctr/2 - 1]) / 2.0;
    } else {
      return (double)t[ctr/2];
    }

  }
}