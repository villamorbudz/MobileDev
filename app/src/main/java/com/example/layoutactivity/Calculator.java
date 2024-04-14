package com.example.layoutactivity;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button num0 = findViewById(R.id.num0Btn);
        Button num1 = findViewById(R.id.num1Btn);
        Button num2 = findViewById(R.id.num2Btn);
        Button num3 = findViewById(R.id.num3Btn);
        Button num4 = findViewById(R.id.num4Btn);
        Button num5 = findViewById(R.id.num5Btn);
        Button num6 = findViewById(R.id.num6Btn);
        Button num7 = findViewById(R.id.num7Btn);
        Button num8 = findViewById(R.id.num8Btn);
        Button num9 = findViewById(R.id.num9Btn);
        Button equals = findViewById(R.id.equalsBtn);
        Button decimal = findViewById(R.id.decimalBtn);
        Button sign = findViewById(R.id.signBtn);
        Button addition = findViewById(R.id.additionBtn);
        Button subtraction = findViewById(R.id.subtractionBtn);
        Button multiplication = findViewById(R.id.multiplicationBtn);
        Button division = findViewById(R.id.divisionBtn);
        Button percentage = findViewById(R.id.percentageBtn);
        Button parentheses = findViewById(R.id.parenthesesBtn);
        Button clear = findViewById(R.id.clearBtn);
        TextView opDisplay = findViewById(R.id.opDisplayTextView);
        TextView resDisplay = findViewById(R.id.resultTextView);

        Stack<String> inputStack = new Stack<>();

        num0.setOnClickListener(view -> {
            inputStack.push(String.valueOf(0));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num1.setOnClickListener(view -> {
            inputStack.push(String.valueOf(1));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num2.setOnClickListener(view -> {
            inputStack.push(String.valueOf(2));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num3.setOnClickListener(view -> {
            inputStack.push(String.valueOf(3));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num4.setOnClickListener(view -> {
            inputStack.push(String.valueOf(4));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num5.setOnClickListener(view -> {
            inputStack.push(String.valueOf(5));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num6.setOnClickListener(view -> {
            inputStack.push(String.valueOf(6));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num7.setOnClickListener(view -> {
            inputStack.push(String.valueOf(7));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num8.setOnClickListener(view -> {
            inputStack.push(String.valueOf(8));
            opDisplay.setText(displayOp(inputStack));
            
        });
        num9.setOnClickListener(view -> {
            inputStack.push(String.valueOf(9));
            opDisplay.setText(displayOp(inputStack));
        });
        decimal.setOnClickListener(view -> {
            inputStack.push(".");
            opDisplay.setText(displayOp(inputStack));
        });

        addition.setOnClickListener(view -> {
            if(isOperand(inputStack.peek())) {
                inputStack.pop();
            }
            inputStack.push("+");
            opDisplay.setText(displayOp(inputStack));
        });
        subtraction.setOnClickListener(view -> {
            if(isOperand(inputStack.peek())) {
                inputStack.pop();
            }
            inputStack.push("-");
            opDisplay.setText(displayOp(inputStack));
        });
        multiplication.setOnClickListener(view -> {
            if(isOperand(inputStack.peek())) {
                inputStack.pop();
            }
            inputStack.push("*");
            opDisplay.setText(displayOp(inputStack));
        });
        division.setOnClickListener(view -> {
            if(isOperand(inputStack.peek())) {
                inputStack.pop();
            }
            inputStack.push("/");
            opDisplay.setText(displayOp(inputStack));
        });
        equals.setOnClickListener(view -> {
            resDisplay.setText(evaluatePostfix(infixToPostfix(displayOp(inputStack))));
        });
        clear.setOnClickListener(view -> {
            while(!inputStack.isEmpty()) {
                inputStack.pop();
            }
            opDisplay.setText("");
            resDisplay.setText("");
            
        });
    }

    public boolean isOperand(String i) {
        if(i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
            return true;
        }
        return false;
    }

    public String displayOp(Stack<String> inputStack) {
        Stack<String> opStack = new Stack<>();
        opStack.addAll(inputStack);
        StringBuilder opString = new StringBuilder();
        while (!opStack.empty()) {
            opString.append(opStack.pop());
        }
        return opString.reverse().toString();
    }
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public String  infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Discard '('
            } else { // Operator
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        // Pop remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

        // Method to evaluate value of a postfix expression
    public int evaluatePostfix(String exp)
    {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == ' ')
                continue;

                // If the scanned character is an operand
                // (number here),extract the number
                // Push it to the stack.
            else if (Character.isDigit(c)) {
                int n = 0;

                // Extract the characters and store it in num
                while (Character.isDigit(c)) {
                    n = n * 10 + (int)(c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                // Push the number in stack
                stack.push(n);
            }

            // If the scanned character is an operator, pop
            // two elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
