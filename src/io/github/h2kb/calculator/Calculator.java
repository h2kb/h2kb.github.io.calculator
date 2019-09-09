package io.github.h2kb.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.h2kb.calculator.Operators.*;
import static io.github.h2kb.calculator.Convert.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawData = scanner.nextLine();
        //Работаю как с 10 + 10, так и с 10+10.
        String[] numbersAsString = rawData.split("\\s?[\\+\\-\\/\\*]\\s?");

        int num1;
        int num2;
        int flagForRome = 0;

        //Получение операндов.
        try {
            //Если не удаётся распарсить Int, то по NumberFormatException пробуем обработать римские цифры.
            num1 = Integer.parseInt(numbersAsString[0]);
            num2 = Integer.parseInt(numbersAsString[1]);

            if (num1 == 0 || num2 == 0) {
                throw new UnsupportedOperationException("Рабочий диапозон цифр 1 - 10.");
            }
        } catch (NumberFormatException e) {
            num1 = romeToInt(numbersAsString[0]);
            num2 = romeToInt(numbersAsString[1]);
            //сработал NumberFormatException, видимо хотим считать римские цифры.
            flagForRome = 1;
        }

        //Получение оператора.
        String operator = "";
        Pattern pattern = Pattern.compile("[\\+\\-\\/\\*]");
        Matcher matcher = pattern.matcher(rawData);
        while (matcher.find()) {
            operator = matcher.group();
        }

        switch (operator) {
            case "+":
                if (flagForRome == 1) {
                    System.out.println(intToRome(add(num1, num2)));
                } else {
                    System.out.println(add(num1, num2));
                }
                break;
            case "-":
                if (flagForRome == 1) {
                    System.out.println(intToRome(sub(num1, num2)));
                } else {
                    System.out.println(sub(num1, num2));
                }
                break;
            case "*":
                if (flagForRome == 1) {
                    System.out.println(intToRome(multi(num1, num2)));
                } else {
                    System.out.println(multi(num1, num2));
                }
                break;
            case "/":
                if (flagForRome == 1) {
                    System.out.println(intToRome(div(num1, num2)));
                } else {
                    System.out.println(div(num1, num2));
                }
                break;
        }
    }
}
