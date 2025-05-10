package lab1;

import java.util.Scanner;

public class task3 {final static int password = 121212; // секретний пароль

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == password) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}
