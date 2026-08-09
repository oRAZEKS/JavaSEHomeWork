package Lesson3;

import java.util.Scanner;

public class Work_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки
        String input = scanner.nextLine();

        // Разделение строки по пробелу
        String[] data = input.split(" ");

        String name = data[0];
        String number = data[1];

        // Проверка количества цифр
        if (number.length() < 2 || number.length() > 5) {
            System.out.println("Число должно содержать от 2 до 5 цифр.");
            return;
        }

        int sum = sumDigits(number, 0);

        System.out.println("Здравствуй " + name + "! Сумма цифр в числе = " + numberToWord(sum));
    }

    // Рекурсивный метод сложения цифр
    public static int sumDigits(String number, int index) {
        if (index == number.length()) {
            return 0;
        }

        return (number.charAt(index) - '0') + sumDigits(number, index + 1);
    }

    // Конвертер числа в слово
    public static String numberToWord(int number) {
        switch (number) {
            case 0:
                return "ноль";
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            case 10:
                return "десять";
            default:
                return "сумма больше 10";
        }
    }
}
