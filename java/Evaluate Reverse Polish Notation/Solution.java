import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // The second operand was pushed last, so it pops first
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); // Java integer division naturally truncates toward zero
                        break;
                }
            } else {
                // If it is a number, convert it to an integer and push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final remaining element in the stack is the result
        return stack.pop();
    }
}
S
