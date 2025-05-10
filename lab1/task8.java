package lab1;

import java.util.Scanner;

public class task8 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int sum = 0;
    int count = 0;

    while (true) {
        int num = scanner.nextInt();
        if (num == 0) {
            break;
        }
        sum += num;
        count++;
    }

    int average = sum / count;
    System.out.println("Average: " + average);
}
}

