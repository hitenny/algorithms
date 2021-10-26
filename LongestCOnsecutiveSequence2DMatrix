package com.algorithms;

public class LongestConsecutiveSequenceIn2DMatrix {
    private int[][] matrix = {  {1, 3, 2},
                                {4, 7, 6},
                                {5, 8, 9}
                            };

    public void run() {
        System.out.println("Max chain length: " + findMaxChainLength(matrix));
    }

    public int findMaxChainLength(int[][] matrix) {
        int maxChainLength = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                maxChainLength = Math.max(maxChainLength, findChainLength(matrix, i, j)+1);
            }
        }

        return maxChainLength;
    }

    private int findChainLength(int[][] matrix, int i, int j) {
        int chainLength = 0;
        if(i > 0 && matrix[i][j] == matrix[i-1][j] - 1) { //top
            chainLength++;
            i = i-1;
        }
        else if(i < matrix.length-1 && matrix[i][j] == matrix[i+1][j] - 1) { //bottom
            chainLength++;
            i = i+1;
        }
        else if(j > 0 && matrix[i][j] == matrix[i][j-1] - 1) { //left
            chainLength++;
            j = j-1;
        }
        else if(j < matrix[0].length-1 && matrix[i][j] == matrix[i][j+1] - 1) { //right
            chainLength++;
            j = j+1;
        }
        else {
            return chainLength;
        }

        return chainLength + findChainLength(matrix, i, j);
    }
}
