public class LongestSubstringKDistinctCharacters {
    public void run() {
        //String input = "aabcbcdbca";
        String input = "caababatbaaad";
        System.out.println("Longest substr:" + getLongestSubstrWithKDistinctChars(input, 2));
    }

    private String getLongestSubstrWithKDistinctChars(String input, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        String output = "";

        int i=0, j=0;
        while(i<=j && j<input.length()) {
            while(j<input.length()) {
                charMap.put(input.charAt(j), charMap.getOrDefault(input.charAt(j), 0)+1);
                j++;

                if(charMap.size() == k) {
                    if(output.length() < j-i) {
                        output = input.substring(i, j);
                    }
                }
                else if(charMap.size() > k) {
                    break;
                }
            }

            while(charMap.size() > k && i<j) {
                if(charMap.get(input.charAt(i)) == 1) {
                    charMap.remove(input.charAt(i));
                }
                else {
                    charMap.put(input.charAt(i), charMap.get(input.charAt(i))-1);
                }
                i++;
            }
        }
        return output;
    }
}
