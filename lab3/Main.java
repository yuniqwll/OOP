package lab3;

import java.util.ArrayList;
import java.util.List;

// Базовий клас Ticket
abstract class Ticket {
    private final int id;
    private final String name;
    private final int estimate;
    private boolean completed = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }
}

// Клас UserStory
class UserStory extends Ticket {
    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory[] dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies != null ? dependencies.clone() : new UserStory[0];
    }

    @Override
    public void complete() {
        for (UserStory dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return; // Не завершувати, якщо залежність не виконана
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}

// Клас Bug
class Bug extends Ticket {
    private final UserStory relatedStory;

    private Bug(int id, String name, int estimate, UserStory relatedStory) {
        super(id, name, estimate);
        this.relatedStory = relatedStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + relatedStory.getName() + ": " + getName();
    }
}

// Клас Sprint
class Sprint {
    private final int timeCapacity;
    private final int ticketLimit;
    private final List<Ticket> tickets = new ArrayList<>();

    public Sprint(int timeCapacity, int ticketLimit) {
        this.timeCapacity = timeCapacity;
        this.ticketLimit = ticketLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        return addTicket(userStory);
    }

    public boolean addBug(Bug bugReport) {
        return addTicket(bugReport);
    }

    private boolean addTicket(Ticket ticket) {
        if (ticket == null || ticket.isCompleted()) {
            return false;
        }
        if (tickets.size() >= ticketLimit) {
            return false;
        }
        if (getTotalEstimate() + ticket.getEstimate() > timeCapacity) {
            return false;
        }
        tickets.add(ticket);
        return true;
    }

    public Ticket[] getTickets() {
        return tickets.toArray(new Ticket[0]);
    }

    public int getTotalEstimate() {
        int total = 0;
        for (Ticket ticket : tickets) {
            total += ticket.getEstimate();
        }
        return total;
    }
}

// Головний клас Main
public class Main {
    public static void main(String[] args) {
        // Створення UserStory без залежностей
        UserStory us1 = new UserStory(1, "Реєстрація користувача", 5, new UserStory[0]);
        us1.complete();

        // Перевірка залежностей (метод використано)
        UserStory[] dependencies = us1.getDependencies();
        System.out.println("Кількість залежностей: " + dependencies.length);

        // Створення Bug на основі завершеної UserStory
        Bug bug1 = Bug.createBug(2, "Виправити перевірку пароля", 3, us1);

        // Створення Sprint
        Sprint sprint = new Sprint(10, 3);

        // Додаємо задачі в Sprint з перевіркою
        if (sprint.addUserStory(us1)) {
            System.out.println("UserStory додано до спринту.");
        } else {
            System.out.println("UserStory НЕ додано до спринту.");
        }

        if (bug1 != null && sprint.addBug(bug1)) {
            System.out.println("Bug додано до спринту.");
        } else {
            System.out.println("Bug НЕ додано до спринту.");
        }

        // Виводимо задачі у спринті
        System.out.println("Тікети у спринті:");
        for (Ticket ticket : sprint.getTickets()) {
            System.out.println(ticket);
        }

        // Виводимо загальну оцінку
        System.out.println("Загальна оцінка часу: " + sprint.getTotalEstimate());
    }
}