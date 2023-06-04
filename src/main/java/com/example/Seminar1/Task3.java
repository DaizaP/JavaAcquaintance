package com.example.Seminar1;
//Дан массив nums = [3,2,2,3,4,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
//а остальные - равны ему.
public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3,4,2,3};
        int val = 3;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[count] = nums[i];
                count++;
            }
        }
        for (int j = count; j < nums.length ; j++) {
            nums[j] = val;
        }
        PrintIntArray(nums);
    }

    public static void PrintIntArray(int[] args) {
        System.out.print("[");
        for (int i = 0; i < args.length-1; i++) {
            System.out.printf("%s, ", args[i]);
        }
        System.out.printf("%s", args[args.length-1]);
        System.out.println("]");
    }

}
