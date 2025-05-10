package lab1;

public class task10 {

    public static int max(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
            maxValue = array[i];
             }
         }
    return maxValue;
}

    public static void main(String[] args) {
        int[] sample = {3, 8, 2, 10, 5};
        System.out.println("Maximum value: " + max(sample));
    }
}

