class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] interval1, final int[] interval2) {
                final int int1 = interval1[0];
                final int int2 = interval2[0];
                return Integer.compare(int1, int2);
            }
        });
        
        Stack<Integer[]> intStack = new Stack<>();
        
        for(int i=0; i<intervals.length; i++) {
            if(intStack.isEmpty()) {
                intStack.push(new Integer[]{intervals[i][0], intervals[i][1]});
            }    
            else {
                Integer[] lastInterval = intStack.peek();
                if(lastInterval[1] >= intervals[i][0]) {
                    int end = lastInterval[1] > intervals[i][1] ? lastInterval[1] : intervals[i][1];
                    Integer mergedInterval[] = new Integer[]{lastInterval[0], end};
                    intStack.pop();
                    intStack.push(mergedInterval);
                }   
                else {
                    intStack.push(new Integer[]{intervals[i][0], intervals[i][1]});
                }
            }
        }
        
        int[][] result = new int[intStack.size()][2];
        
        int i=0;
        while(!intStack.isEmpty()) {
            int[] intArray = Arrays.stream(intStack.pop()).mapToInt(Integer::intValue).toArray();
            result[i++] = intArray;
        }
        
        return result;
    }
}
