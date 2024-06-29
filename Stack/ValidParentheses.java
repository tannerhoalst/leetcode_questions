package Stack;

import java.util.Stack;

public class ValidParentheses {
        public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if(c == '}' || c == ']' || c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if((c == '}' && top != '{') || 
                   (c == ']' && top != '[') || 
                   (c == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "The (quick [brown] {fox}) jumps over the lazy dog",
            "([)]",
            "([]){()}",
            "(()",
            "Hello World!",
            "{[]}()",
            "a(b)c{d}e[f]g"
        };
        ValidParentheses vp = new ValidParentheses();
        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Is valid: " + vp.isValid(testCase));
            System.out.println();
        }
    }
}
