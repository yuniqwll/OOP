package lab1;

import java.util.Scanner;

public class task5 { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a (feet climbed per day): ");
    int a = scanner.nextInt();

    System.out.print("Enter b (feet slipped per night): ");
    int b = scanner.nextInt();

    System.out.print("Enter h (height of the tree): ");
    int h = scanner.nextInt();

    if (a <= b && a < h) {
        System.out.println("The snail will never reach the top.");
    }
    else {
        int effectiveProgress = a - b;
        int days = (h - a + effectiveProgress - 1) / effectiveProgress + 1;
        System.out.println("The snail will reach the top in " + days + " day(s).");
    }
}
}
