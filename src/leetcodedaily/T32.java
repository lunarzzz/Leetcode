package leetcodedaily;

import java.util.Stack;

/**
 *
 */
public class T32 {
    /**
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        //
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j < s.length(); j+=2) {
                if (isParentheses(s.substring(i, j))) {
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        T32 t32 = new T32();
        System.out.println(t32.longestValidParentheses("(()))"));
    }

    public boolean isParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }



    //   (()())    ()
}
