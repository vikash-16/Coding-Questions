package DSAPractice.Stack;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        for(String val : tokens) {
                switch (val) {
                    case "+":
                        if (!stack.isEmpty() && stack.size() >= 2) {
                            Integer op1 = stack.pop();
                            Integer op2 = stack.pop();
                            stack.push(op2 + op1);
                        }
                        break;
                    case "-":
                        if (!stack.isEmpty() && stack.size() >= 2) {
                            Integer op1 = stack.pop();
                            Integer op2 = stack.pop();
                            stack.push(op2 - op1);
                        }
                        break;
                    case "*":
                        if (!stack.isEmpty() && stack.size() >= 2) {
                            Integer op1 = stack.pop();
                            Integer op2 = stack.pop();
                            stack.push(op2 * op1);
                        }
                        break;
                    case "/":
                        if (!stack.isEmpty() && stack.size() >= 2) {
                            Integer op1 = stack.pop();
                            Integer op2 = stack.pop();
                            stack.push(op2 / op1);
                        }
                        break;
                    default:
                        stack.push(Integer.valueOf(val));
                }
            }
        return stack.peek();
    }
}
