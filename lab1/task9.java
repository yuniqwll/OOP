package lab1;

import java.util.Scanner;

public class task9 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    double c = scanner.nextDouble();

    double discriminant = b * b - 4 * a * c;

    if (discriminant < 0) {
        System.out.println("no roots");
    } else if (discriminant == 0) {
        double x = -b / (2 * a);
        System.out.println(x);
    } else {
        double sqrtD = Math.sqrt(discriminant);
        double x1 = (-b - sqrtD) / (2 * a);
        double x2 = (-b + sqrtD) / (2 * a);
        System.out.println(x1 + " " + x2);
    }
}
}
