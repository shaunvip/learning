package misc;

import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators
//are +, -, *, /. Each operand may be an integer or another expression. For
//example:
//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] str = {"2", "1", "+", "3", "*"};
        evaluateReversePolishNotation( str);
        evaluateReversePolishNotation(new String[]{"4", "13", "5", "/", "+"});
    }

    private static String evaluateReversePolishNotation(String[] str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            String item = str[i];
            if (item.equals("+")) {
                int num = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num + num2));
            } else if (item.equals("*")) {
                int num = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num * num2));
            } else if (item.equals("/")) {
                int num2 = Integer.parseInt(stack.pop());
                int num = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num / num2));
            } else {
                stack.push(item);
            }
        }
        String result=stack.pop();
        System.out.println(result);
        return result;
    }
}
