import java.util.Scanner;
public class project1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Double previousResult = null;
            boolean running = true;

            while (running) {
                System.out.println();
                System.out.println("===== КАЛЬКУЛЯТОР =====");
                System.out.println("1. Ввести пример");
                System.out.println("2. Продолжить работать с ответом предыдущего примера");
                System.out.println("3. Выход");
                System.out.print("Выберите пункт: ");

                String menuChoice = scanner.nextLine();

                switch (menuChoice) {
                    case "1":
                        previousResult = calculateExample(scanner);
                        break;

                    case "2":
                        if (previousResult == null) {
                            System.out.println("Недоступно!");
                        } else {
                            previousResult = continueCalculation(scanner, previousResult);
                        }
                        break;

                    case "3":
                        running = false;
                        System.out.println("Программа завершена.");
                        break;

                    default:
                        System.out.println("Некорректный пункт меню!");
                }
            }

            scanner.close();
        }

        /**
         * Считывает и вычисляет новый пример.
         */
        private static Double calculateExample(Scanner scanner) {
            System.out.println();
            System.out.println("Введите пример.");
            System.out.println("Например: 100 + 13, 27 / 3, 7 !, 4 ^ 3, 35 ? 24");
            System.out.print("> ");

            String input = scanner.nextLine().trim();

            try {
                String[] parts = input.split("\\s+");

                if (parts.length != 3) {
                    // Отдельно обрабатываем факториал: 7 !
                    if (parts.length == 2 && parts[1].equals("!")) {
                        double number = Double.parseDouble(parts[0]);

                        if (number < 0 || number != Math.floor(number)) {
                            System.out.println("Факториал определён только для неотрицательных целых чисел.");
                            return null;
                        }

                        long result = factorial((long) number);
                        System.out.println(number + "! = " + result);
                        return (double) result;
                    }

                    System.out.println("Неверный формат примера!");
                    return null;
                }

                double firstNumber = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double secondNumber = Double.parseDouble(parts[2]);

                double result = performOperation(firstNumber, operator, secondNumber);

                if (Double.isNaN(result)) {
                    return null;
                }

                printResult(firstNumber, operator, secondNumber, result);

                return result;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное число.");
                return null;
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return null;
            }
        }

        /**
         * Выполняет операцию с двумя числами.
         */
        private static double performOperation(
                double firstNumber,
                String operator,
                double secondNumber) {

            switch (operator) {
                case "+":
                    return add(firstNumber, secondNumber);

                case "-":
                    return subtract(firstNumber, secondNumber);

                case "*":
                    return multiply(firstNumber, secondNumber);

                case "/":
                    return divide(firstNumber, secondNumber);

                case "^":
                    return power(firstNumber, secondNumber);

                case "?":
                    compare(firstNumber, secondNumber);
                    return comparisonResult(firstNumber, secondNumber);

                default:
                    throw new IllegalArgumentException(
                            "Неизвестная операция: " + operator
                    );
            }
        }

        /**
         * Продолжение работы с предыдущим результатом.
         */
        private static Double continueCalculation(
                Scanner scanner,
                double previousResult) {

            System.out.println();
            System.out.println("Предыдущий результат: " + previousResult);
            System.out.println("Выберите операцию:");
            System.out.println("+ - сложение");
            System.out.println("- - вычитание");
            System.out.println("* - умножение");
            System.out.println("/ - деление");
            System.out.println("^ - возведение в степень");
            System.out.println("? - сравнение");
            System.out.println("! - факториал");
            System.out.println("0 - отмена");

            System.out.print("Операция: ");
            String operator = scanner.nextLine().trim();

            if (operator.equals("0")) {
                return previousResult;
            }

            try {
                // Факториал работает только с одним числом.
                if (operator.equals("!")) {
                    if (previousResult < 0 ||
                            previousResult != Math.floor(previousResult)) {

                        System.out.println(
                                "Факториал определён только для " +
                                        "неотрицательных целых чисел."
                        );

                        return previousResult;
                    }

                    long result = factorial((long) previousResult);

                    System.out.println(
                            previousResult + "! = " + result
                    );

                    return (double) result;
                }

                System.out.print("Введите второе число: ");
                double secondNumber = Double.parseDouble(scanner.nextLine());

                double result = performOperation(
                        previousResult,
                        operator,
                        secondNumber
                );

                printResult(
                        previousResult,
                        operator,
                        secondNumber,
                        result
                );

                return result;

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное число.");
                return previousResult;

            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return previousResult;
            }
        }

        /**
         * Сложение.
         */
        private static double add(double a, double b) {
            return a + b;
        }

        /**
         * Вычитание.
         */
        private static double subtract(double a, double b) {
            return a - b;
        }

        /**
         * Умножение.
         */
        private static double multiply(double a, double b) {
            return a * b;
        }

        /**
         * Деление.
         */
        private static double divide(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль невозможно.");
            }

            return a / b;
        }

        /**
         * Возведение в степень.
         */
        private static double power(double a, double b) {
            return Math.pow(a, b);
        }

        /**
         * Факториал.
         */
        private static long factorial(long number) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        "Факториал отрицательного числа невозможен."
                );
            }

            long result = 1;

            for (long i = 1; i <= number; i++) {
                result *= i;
            }

            return result;
        }

        /**
         * Сравнение двух чисел.
         */
        private static void compare(double a, double b) {
            if (a > b) {
                System.out.println(a + " ? " + b + " = " + a + " > " + b);
            } else if (a < b) {
                System.out.println(a + " ? " + b + " = " + a + " < " + b);
            } else {
                System.out.println(a + " ? " + b + " = " + a + " = " + b);
            }
        }

        /**
         * Возвращает результат сравнения:
         * 1, если a > b
         * -1, если a < b
         * 0, если a == b
         */
        private static double comparisonResult(double a, double b) {
            if (a > b) {
                return a;
            } else if (a < b) {
                return b;
            } else {
                return a;
            }
        }

        /**
         * Вывод обычной операции.
         */
        private static void printResult(
                double a,
                String operator,
                double b,
                double result) {

            if (operator.equals("?")) {
                return;
            }

            System.out.println(
                    a + " " + operator + " " + b + " = " + result
            );
        }
    }

