package lab2;

class Triangle {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        if (areColinear(a, b, c)) {
            throw new IllegalArgumentException("Points must not lie on the same line — triangle is degenerate.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean areColinear(Point p1, Point p2, Point p3) {
        // Використовуємо площу паралелограма, щоб перевірити на колінеарність
        double area = p1.x * (p2.y - p3.y) +
                p2.x * (p3.y - p1.y) +
                p3.x * (p1.y - p2.y);
        return area == 0;
    }

    public double area() {
        return Math.abs(
                a.x * (b.y - c.y) +
                        b.x * (c.y - a.y) +
                        c.x * (a.y - b.y)
        ) / 2.0;
    }

    public Point centroid() {
        double x = (a.x + b.x + c.x) / 3;
        double y = (a.y + b.y + c.y) / 3;
        return new Point(x, y);
    }
}

public class task3 {public static void main(String[] args) {
    Triangle t = new Triangle(
            new Point(0, 0),
            new Point(4, 0),
            new Point(2, 3)
    );

    System.out.println("Area: " + t.area()); // 6.0
    System.out.println("Centroid: " + t.centroid()); // (2.0;1.0)
}
}

