package calculator;

import java.util.Stack;

public class Calculator {

    public int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        //ertert
        // Parsing
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder strBuilder = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    strBuilder.append(tokens[i++]);
                }
                values.push(Integer.parseInt(strBuilder.toString()));
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                if (operators.empty()) {
                    throw new RuntimeException("Mismatches parentheses");
                }
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(tokens[i]);
            } else {
                throw new UnsupportedOperationException("Wrong operator: " + tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // operators to remaining values
        while (!operators.empty()) {
            if (operators.peek() == '(') {
                throw new RuntimeException("Mismatches parentheses");
            }
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')') &&
                ((op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-'));
    }

    private int applyOperator(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
