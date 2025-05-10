package lab1;

import java.util.Scanner;

public class task6 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter total bill amount: ");
    double bill = scanner.nextDouble();

    System.out.print("Enter number of friends: ");
    int friends = scanner.nextInt();

    if (bill < 0) {
        System.out.println("Error: bill amount cannot be negative.");
    } else if (friends <= 0) {
        System.out.println("Error: number of friends must be greater than zero.");
    } else {
        double totalWithTip = bill * 1.10; // додати 10% чайових
        int share = (int) Math.round(totalWithTip / friends);
        System.out.println("Each friend should pay: " + share);
    }
}
}

