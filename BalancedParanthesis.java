import java.util.*;

class Main {
  private boolean isClosingBracket(char bracket) {
    return bracket == ')' || bracket == '}' || bracket == ']';
  }
  
  private boolean match(char openBracket, char closingBracket) {
    return (openBracket == '(' && closingBracket == ')') || (openBracket == '{' && closingBracket == '}') || (openBracket == '[' && closingBracket == ']'); 
  }
  
  boolean isBalanced(String s) {
    Stack<Character> brackets = new Stack();
    for(int i=0; i<s.length(); i++) {
      if(isClosingBracket(s.charAt(i)) ) {
        if(brackets.isEmpty()) {
          return false;
        }
        if(!match(brackets.pop(), s.charAt(i))) {
          return false;
        }
      }
      else {
        brackets.push(s.charAt(i));
      }
    }
    
    return brackets.isEmpty();
  }

  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[" + str + "]");
  }
  
  public void run() {
    String s_1 = "{[(])}";
    boolean expected_1 = false;
    boolean output_1 = isBalanced(s_1);
    check(expected_1, output_1);

    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = isBalanced(s_2);
    check(expected_2, output_2);

    // Add your own test cases here
        
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
