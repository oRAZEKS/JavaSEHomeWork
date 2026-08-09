package Lesson2;

public class Work_4 {
    static void main(String[] args) {

        int[][] arr = new int[4][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        //выводит номера строк и суммы их элементов
        //(пример: Line 2: 17).
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }

            System.out.println("Line " + (i + 1) + ": " + sum);
        }

        //выводит номера столбцов и суммы их
        //элементов (пример: Column 3: 21).
        for (int j = 0; j < arr[0].length; j++) {
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][j];
            }

            System.out.println("Column " + (j + 1) + ": " + sum);
        }

        //4. Напишите программу, которая для в каждой строке находит целое среднее
        //арифметическое и выводит его на экран.
        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }

            int average = sum / arr[i].length;

            System.out.println("Line " + (i + 1) + ": " + average);
        }

        //5.***Напишите программу, которая преобразует двумерный массив в перевёрнутый одномерный и выводит все элементы одномерного массива на
        //экран.
        int[] newArr = new int[arr.length * arr[0].length];

        int index = 0;

        // Перевод двумерного массива в одномерный
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[index] = arr[i][j];
                index++;
            }
        }

        // Вывод одномерного массива в обратном порядке
        for (int i = newArr.length - 1; i >= 0; i--) {
            System.out.print(newArr[i] + " ");
        }

        //заменяет все нечётные элементы массива на
        //1, а четные на 0 и выводит его на экран.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] % 2 == 0) {
                    arr[i][j] = 0;  // чётное
                } else {
                    arr[i][j] = 1;  // нечётное
                }

            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
