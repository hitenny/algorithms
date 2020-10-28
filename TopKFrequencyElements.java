class Solution {
    class Key implements Comparable<Key> {
        int k;
        int frequency;
        
        public int getKey() {
            return k;
        }
        
        public int getFrequency() {
            return frequency;
        }
        
        public Key(int k, int freq) {
            this.k = k; this.frequency = freq;
        }
        
        @Override
        public int compareTo(Key other) {
            return Integer.compare(other.getFrequency(), this.getFrequency());
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int f = frequency.getOrDefault(nums[i], 0);
            frequency.put(nums[i], f+1);
        }
        
        List<Key> keys = new ArrayList<>();
        frequency.forEach((key, val) -> keys.add(new Key(key, val)));
        
        PriorityQueue<Key> queue = new PriorityQueue<>();
        
        for(Key key : keys) {
            queue.offer(key);    
        }
        
        int[] ret = new int[k];
        for(int i=0; i<k; i++) {
            ret[i] = queue.remove().getKey();
        }
        
        return ret;
    }
}
