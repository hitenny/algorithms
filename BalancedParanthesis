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
