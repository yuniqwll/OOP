package lab1;

import java.util.Scanner;

public class task4 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("How many strangers will you meet? ");
    int count = scanner.nextInt();
    scanner.nextLine(); // зчитує залишок після числа

    if (count < 0) {
        System.out.println("Error: number of strangers cannot be negative.");
    } else if (count == 0) {
        System.out.println("Oh, it looks like there is no one to meet.");
    } else {
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of stranger " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name);
        }
    }
}
}
