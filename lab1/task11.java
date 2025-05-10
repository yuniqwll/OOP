package lab1;

public class task11 {public static int sum(int[] array) {
    if (array == null || array.length == 0) {
        return 0;
    }

    int total = 0;
    for (int num : array) {
        if (num % 2 == 0) {
            total += num;
        }
    }

    return total;
}

    public static void main(String[] args) {
        int[] data = {1, 4, 3, 6, 5, 12};
        System.out.println("Sum of even numbers: " + sum(data));
    }
}

