package com.example.Seminar1;

//2) Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
public class Task2 {
    public static void main(String[] args) {
        int count = 0;
        int maxCount = 0;
        int[] arr = new int[]{1, 1, 0, 1, 1, 1,};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        PrintIntArray(arr);
        System.out.println(maxCount);
    }

    public static void PrintIntArray(int[] args) {
        System.out.printf("[");
        for (int i = 0; i < args.length-1; i++) {
            System.out.printf("%s, ", args[i]);
        }
        System.out.printf("%s", args[args.length-1]);
        System.out.println("]");
    }
}
