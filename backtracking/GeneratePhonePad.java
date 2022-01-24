//LC: https://leetcode.com/problems/letter-combinations-of-a-phone-number
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> phonePad = new HashMap<>();
        phonePad.put('2', Arrays.asList("a", "b", "c"));
        phonePad.put('3', Arrays.asList("d", "e", "f"));
        phonePad.put('4', Arrays.asList("g", "h", "i"));
        phonePad.put('5', Arrays.asList("j", "k", "l"));
        phonePad.put('6', Arrays.asList("m", "n", "o"));
        phonePad.put('7', Arrays.asList("p", "q", "r", "s"));
        phonePad.put('8', Arrays.asList("t", "u", "v"));
        phonePad.put('9', Arrays.asList("w", "x", "y", "z"));
        
        List<String> combinations = new ArrayList<>();
        generatePhonePad(phonePad, combinations, digits, 0, "");
        
        return combinations;
    }
    
    public void generatePhonePad(Map<Character, List<String>> phonePad, List<String> combinations, String digits, int i, String p) {
        if(i == digits.length()) {
            if(!p.isEmpty())
                combinations.add(p);
            return;
        }
        
        List<String> numStrings = phonePad.get(digits.charAt(i));
        
        for(String s : numStrings) {
            generatePhonePad(phonePad, combinations, digits, i+1, p+s);   
        }
    }
}
