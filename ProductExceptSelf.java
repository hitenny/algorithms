package com.algorithms;

public class ProductOfAllNumbersExceptCurrent {
    int[] array = new int[]{2, 3, 6};
    //int[] array = new int[]{2, 3, 6, 9, 0};
    //int[] array = new int[]{2, 0, 6, 9, 0};

    public void run() {
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }

        //int[] newArray = productUsingDivision(array);
        int[] newArray = productWithoutDivision(array);
        for(int i=0; i<newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    private int[] productWithoutDivision(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] newArr = new int[arr.length];

        left[0] = 1;
        right[arr.length-1] = 1;

        for(int i=1; i<arr.length; i++) {
            left[i] = arr[i-1] * left[i-1];
        }

        for(int i=arr.length-2; i>=0; i--) {
            right[i] = arr[i+1] * right[i+1];
        }

        for(int i=0; i<arr.length; i++) {
            newArr[i] = left[i] * right[i];
        }

        return newArr;
    }

    private int[] productUsingDivision(int[] arr) {
        int product = 1;
        int zeroCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }
            else {
                product *= arr[i];
            }
        }

        int[] newArr = new int[arr.length];
        if(zeroCount > 1) {
            return newArr;
        }

        for(int i=0; i<arr.length; i++) {
            if(zeroCount == 0) {
                newArr[i] = product/arr[i];
            }
            else {
                if(arr[i] == 0) {
                    newArr[i] = product;
                }
            }
        }
        return newArr;
    }
}
