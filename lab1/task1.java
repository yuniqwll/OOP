package lab1;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        // Створюємо об'єкт Scanner для зчитування введених даних
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо рядок із консолі
        String input = scanner.nextLine();

        // Виводимо повідомлення
        System.out.println("Hello, " + input);

        // Закриваємо Scanner
        scanner.close();
    }
}
