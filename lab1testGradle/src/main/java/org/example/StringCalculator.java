package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        if (!Character.isDigit(numbers.charAt(numbers.length() - 1))) {
            throw new IllegalArgumentException("Incorrect Input Format"); //помилка роздільник є останнім символом//
        }

        getDelimiters(numbers); //виклик внутрішнього методу визначення роздільників

        String[] inputSplit = getInput(numbers); //виклик внутрішнього методу визначення доданків

        List<Integer> numList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        for (String num : inputSplit) {
            if (num.isEmpty() && !numbers.startsWith("//[")){
                throw new IllegalArgumentException("Incorrect Input Format");//помилка використання роздільників//
            }
            if (!num.isEmpty()) {
                int n;
                try {
                    n = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect Delimiter Input"); //помилка невизначеного роздільника//
                }
                if (n < 0) {
                    negList.add(n);
                } else if (n <= 1000) {
                    numList.add(n);
                }
            }
        }

        if (!negList.isEmpty()) {
            String message = "Negatives are not allowed:";
            for (int neg : negList) {
                message += " " + neg;
            }
            throw new IllegalArgumentException(message);
        }

        int sum = 0;
        for (int num : numList) {
            sum += num;
        }
        return sum;
    }

    private final List<String> delimiters = new ArrayList<>();

    private void getDelimiters(String numbers) {
        delimiters.clear();
        delimiters.add(",");
        delimiters.add("\n");
        if (numbers.startsWith("//")) {
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(numbers.substring(2));
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            if (!matcher.find()) {
                delimiters.add(numbers.substring(2, numbers.indexOf('\n')));
            }
        }
    }

    private String[] getInput(String numbers) {
        String input = numbers;
        if (numbers.startsWith("//")) {
            input = input.substring(input.indexOf('\n') + 1);
        }
        String delimiterList = String.join("|", delimiters);
        return input.split(delimiterList);
    }
}


