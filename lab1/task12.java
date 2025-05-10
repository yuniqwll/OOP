package lab1;

import java.util.Arrays;

public class task12 {public static boolean[] getSumCheckArray(int[] array) {
    boolean[] result = new boolean[array.length];

    // Перші два завжди false
    result[0] = false;
    result[1] = false;

    for (int i = 2; i < array.length; i++) {
        result[i] = array[i] == array[i - 1] + array[i - 2];
    }

    return result;
}

    public static void main(String[] args) {
        int[] input = {1, -1, 0, 4, 6, 10, 15, 25};
        boolean[] output = getSumCheckArray(input);
        System.out.println(Arrays.toString(output));
    }
}

