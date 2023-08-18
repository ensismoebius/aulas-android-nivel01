package org.dedira.calculadora;

import java.util.Stack;

public class Interpretador {
    public static String avaliar(String expressao) {

        if (expressao.trim().isEmpty()) {
            return "";
        }

        Stack<String> valores = new Stack<String>();
        Stack<Character> operacoes = new Stack<Character>();

        char[] caracteres = expressao.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == ' ') {
                continue;
            }
            if (caracteres[i] >= '0' && caracteres[i] <= '9' || Character.isAlphabetic(caracteres[i])) {

                StringBuilder sbuf = new StringBuilder();
                while (i < caracteres.length && isPartOfANumber(caracteres[i])) {
                    sbuf.append(caracteres[i++]);
                }

                valores.push(sbuf.toString());

                i--;

                continue;
            }

            if (caracteres[i] == '(') {
                operacoes.push(caracteres[i]);
                continue;
            }

            if (caracteres[i] == ')') {
                while (operacoes.peek() != '(') {
                    valores.push(applyOperation(operacoes.pop(), valores.pop(), valores.pop()));
                }
                operacoes.pop();
                continue;
            }

            if (caracteres[i] == '+' || caracteres[i] == '-' || caracteres[i] == '*' || caracteres[i] == '/' || caracteres[i] == '=') {
                while (!operacoes.empty() && hasPrecedence(caracteres[i], operacoes.peek())) {
                    valores.push(applyOperation(operacoes.pop(), valores.pop(), valores.pop()));
                }

                operacoes.push(caracteres[i]);
            }
        }

        while (!operacoes.empty()) {
            valores.push(applyOperation(operacoes.pop(), valores.pop(), valores.pop()));
        }

        return valores.pop();
    }

    private static boolean isPartOfANumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c == '.') {
            return true;
        }
        return false;
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '=') return false;

        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        else return true;
    }

    private static boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private static String applyOperation(char operation, String valueTwo, String valueOne) {

        boolean isValueOneNumeric = isNumber(valueOne);
        boolean isValueTwoNumeric = isNumber(valueTwo);

        double firstNumber = Double.parseDouble(valueOne);
        double secondNumber = Double.parseDouble(valueTwo);

        double result = 0;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                result = firstNumber / secondNumber;
        }
        return String.valueOf(result);
    }
}