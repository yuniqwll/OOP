package lab4;

// Клас точки
class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

// Абстрактний клас фігури
abstract class Figure {
    public abstract double area();
    public abstract Point centroid();
    public abstract String toString();
}

// Клас Трикутник
class Triangle extends Figure {
    private final Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        if (areColinear(a, b, c)) {
            throw new IllegalArgumentException("Points are colinear - not a valid triangle");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean areColinear(Point p1, Point p2, Point p3) {
        double area = p1.x * (p2.y - p3.y) +
                p2.x * (p3.y - p1.y) +
                p3.x * (p1.y - p2.y);
        return area == 0;
    }

    @Override
    public double area() {
        return Math.abs(
                a.x * (b.y - c.y) +
                        b.x * (c.y - a.y) +
                        c.x * (a.y - b.y)
        ) / 2.0;
    }

    @Override
    public Point centroid() {
        double x = (a.x + b.x + c.x) / 3;
        double y = (a.y + b.y + c.y) / 3;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Triangle[" + a + " " + b + " " + c + "]";
    }
}

// Клас Чотирикутник
class Quadrilateral extends Figure {
    private final Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (areColinear(a, b, c) || areColinear(b, c, d) || areColinear(c, d, a) || areColinear(d, a, b)) {
            throw new IllegalArgumentException("Invalid quadrilateral - three points are colinear");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private boolean areColinear(Point p1, Point p2, Point p3) {
        double area = p1.x * (p2.y - p3.y) +
                p2.x * (p3.y - p1.y) +
                p3.x * (p1.y - p2.y);
        return area == 0;
    }

    @Override
    public double area() {
        // Площа чотирикутника = площа двох трикутників
        Triangle t1 = new Triangle(a, b, c);
        Triangle t2 = new Triangle(a, c, d);
        return t1.area() + t2.area();
    }

    @Override
    public Point centroid() {
        double x = (a.x + b.x + c.x + d.x) / 4;
        double y = (a.y + b.y + c.y + d.y) / 4;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + a + " " + b + " " + c + " " + d + "]";
    }
}

// Клас Коло
class Circle extends Figure {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public String toString() {
        return "Circle[" + center + " " + radius + "]";
    }
}

// Основний клас Main
public class lab1 {
    public static void main(String[] args) {
        // Створюємо трикутник
        Triangle triangle = new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, 3));
        System.out.println(triangle);
        System.out.println("Площа: " + triangle.area());
        System.out.println("Центроїд: " + triangle.centroid());

        System.out.println();

        // Створюємо чотирикутник
        Quadrilateral quad = new Quadrilateral(new Point(0, 0), new Point(4, 0), new Point(4, 3), new Point(0, 3));
        System.out.println(quad);
        System.out.println("Площа: " + quad.area());
        System.out.println("Центроїд: " + quad.centroid());

        System.out.println();

        // Створюємо коло
        Circle circle = new Circle(new Point(2, 2), 5);
        System.out.println(circle);
        System.out.println("Площа: " + circle.area());
        System.out.println("Центроїд: " + circle.centroid());
    }
}