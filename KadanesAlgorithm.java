public class MyClass {
	/*
 		Objective of this algorithm is to find the max sum of contiguous sub-array in an array
  	*/
    public static void main(String args[]) {
      //int[] x = new int[] {1,5,-8,3,9,-2,-7,0,3};   //12 3,4
      //int[] x = new int[] {1,5,-8,3,9,-2,-7,0,3, 20, -8};   //26 3,9
      int[] x = new int[] {17,-15,-8,3,9,-2,11,0,3, 20, -8};   //44 3,9
      
      System.out.println("max sum contiguous sub-array = " + maxSumContiguous(x));
      
    }
    public static int maxSumContiguous(int[] array) {
        int maxSum = array[0];
        int curSum = array[0];
        int tempStart = 0;
        int startIndex = 0;
        int endIndex = 0;
            
        for(int i=1; i<array.length; i++) {
            if(array[i] > curSum + array[i]) {
                tempStart = i;
                curSum = array[i];
            }
            else {
                curSum += array[i];
                maxSum = Math.max(curSum, maxSum);
                if(maxSum == curSum) {
                    endIndex = i;
                    startIndex = tempStart;
                }
            }
        }
        System.out.println("Max sub array start = " + startIndex + " end = " + endIndex);
        return maxSum;
    }
}
