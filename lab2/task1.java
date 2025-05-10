package lab2;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}

class Line {
    double k, b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        // Якщо коефіцієнти k однакові
        if (this.k == other.k) {
            // Якщо вільні члени також однакові — лінії збігаються
            if (this.b == other.b) {
                return null; // нескінченно багато точок
            } else {
                return null; // паралельні — не перетинаються
            }
        }

        // Знаходимо x, y
        double x = (other.b - this.b) / (this.k - other.k);
        double y = this.k * x + this.b;

        return new Point(x, y);
    }
}

public class task1{public static void main(String[] args) {
    Line line1 = new Line(1, 1);
    Line line2 = new Line(-1, 3);

    System.out.println(line1.intersection(line2)); // (1.0;2.0)
}
}
