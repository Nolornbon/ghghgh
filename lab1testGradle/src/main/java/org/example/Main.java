package org.example;

public class Main {

    public static void main(String[] args) {

        StringCalculator Calculator = new StringCalculator();

        System.out.println("sum " + Calculator.add("//[*][%]\n1*2%3"));
        System.out.println("sum " + Calculator.add(""));
        System.out.println("sum " + Calculator.add("1"));
        System.out.println("sum " + Calculator.add("1,2"));
        System.out.println("sum " + Calculator.add("1,2,95,8,5,8,10"));
        System.out.println("sum " + Calculator.add("1\n2,95,8,5"));
        System.out.println("sum " + Calculator.add("//;\n1;2"));
        System.out.println("sum " + Calculator.add("//[*][%]\n1%%%%%%2,8\n7*****7"));
        System.out.println("sum " + Calculator.add("1,2,5000\n7"));
        System.out.println("sum " + Calculator.add("//;\n1;2;8,7,7"));

    }
}

