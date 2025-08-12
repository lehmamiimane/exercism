import java.util.Stack;

class BracketChecker {
    private final String expression;
    
    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        for(char c : chars){
            switch (c) {
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
                default -> {
                    // Ignorer les autres caractères
                }
            }
                
        }

        return stack.isEmpty();
    }

}