package Lesson2;

public class Work_3 {
    static void main(String[] args) {

        int [] arrey = {3, 22, 1, 13, 4, 6, 16, 5};

        //выводит (через пробел) те элементы массива, которые являются чётными числами.
        for (int num : arrey){
            if(num % 2 ==0){
                System.out.println(num + " ");
            }
        }

        //Выводит все двузначные числа массива.
        for (int num1 : arrey){
            if (num1 >= 10 && num1 <= 99){
                System.out.println(num1 + " ");
            }
        }

        //Выводит на экран наибольшее целое число этого массива.
        int max = arrey[0];
        for (int num2 : arrey){
            if (num2 > max) {
                max = num2;
            }
        }
        System.out.println("Самое большое число " + max);

        // считает сумму элементов массива и выводит её на экран.
        int sum = arrey[0];
        for (int num3 : arrey){
            sum += num3;
        }
        System.out.println("Сумма " + sum);

        //переворачивает массив в обратном порядке

        for (int i = arrey.length - 1; i >= 0; i--){
            System.out.println(arrey[i]);
        }
    }
}
