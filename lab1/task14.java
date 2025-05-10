package lab1;

import java.util.Arrays;

public class task14 {// Зсув на одну позицію
    public static void cycleSwap(int[] array) {
        if (array.length == 0) return;

        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;
    }

    // Зсув на shift позицій
    public static void cycleSwap(int[] array, int shift) {
        if (array.length == 0 || shift == 0) return;

        shift = shift % array.length; // для безпеки

        reverse(array, 0, array.length - 1);
        reverse(array, 0, shift - 1);
        reverse(array, shift, array.length - 1);
    }

    // Допоміжний метод для розвороту частини масиву
    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Демонстрація
    public static void main(String[] args) {
        int[] data1 = {1, 3, 2, 7, 4};
        cycleSwap(data1);
        System.out.println("Shift by 1: " + Arrays.toString(data1)); // [4, 1, 3, 2, 7]

        int[] data2 = {1, 3, 2, 7, 4};
        cycleSwap(data2, 3);
        System.out.println("Shift by 3: " + Arrays.toString(data2)); // [2, 7, 4, 1, 3]
    }
}

