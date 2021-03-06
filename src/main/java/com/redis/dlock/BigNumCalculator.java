package com.redis.dlock;

import java.util.Stack;

public class BigNumCalculator {


    private static Stack<Integer> stringToStack(String bigNum) {
        bigNum.replaceAll(" ", "");
        char[] chars = bigNum.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < bigNum.length(); i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                continue;
            }
            stack.push(Integer.valueOf(String.valueOf(chars[i])));
        }

        return stack;
    }

    public static String plus(String bigA, String bigB) {
        Stack<Integer> stackA = stringToStack(bigA);
        Stack<Integer> stackB = stringToStack(bigB);
        Stack<Integer> sum = new Stack();
        boolean isCarry = false;

        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            int tempSum = stackA.pop() + stackB.pop();

            if (isCarry) {
                tempSum += 1;
            }

            if (tempSum >= 10) {
                isCarry = true;
                sum.push(tempSum - 10);
            } else {
                sum.push(tempSum);
                isCarry = false;
            }
        }

        Stack<Integer> nonEmptyStack = stackA.isEmpty() ? stackB : stackA;
        while (!nonEmptyStack.isEmpty()) {
            if (isCarry) {
               int end =  nonEmptyStack.pop() + 1;
               if (end >= 10) {
                   sum.push(end - 10);
               } else {
                   sum.push(end);
                   isCarry = false;
               }
            } else {
                sum.push(nonEmptyStack.pop());
            }
        }

        if (isCarry) {
            sum.push(1);
        }

        StringBuilder result = new StringBuilder();
        while (!sum.isEmpty()) {
            result.append(sum.pop().toString());
        }

        return result.toString();
    }

    public static String multiply(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int maxLength = arrayA.length + arrayB.length;
        int[] result = new int[maxLength];

        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                result[i+j] += (arrayA[i] - '0') * (arrayB[j] - '0');
            }
        }

        for (int i = result.length - 1; i > 0; i--) {
         if (result[i] >= 10) {
             result[i-1] += result[i] / 10;
             result[i] %= 10;
         }
        }

        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxLength - 1; i++) {
                sb.append(result[i]);
            }
        return sb.toString();
    }
}
