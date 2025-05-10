package lab2;

class Segment {
    Point p1, p2;

    public Segment(Point p1, Point p2) {
        if (p1.x == p2.x && p1.y == p2.y) {
            throw new IllegalArgumentException("Segment cannot be degenerate (same start and end point)");
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    public double length() {
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point middle() {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    public Point intersection(Segment other) {
        double x1 = this.p1.x, y1 = this.p1.y;
        double x2 = this.p2.x, y2 = this.p2.y;
        double x3 = other.p1.x, y3 = other.p1.y;
        double x4 = other.p2.x, y4 = other.p2.y;

        double denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (denom == 0) {
            return null; // лінії паралельні або збігаються
        }

        double px = ((x1*y2 - y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4)) / denom;
        double py = ((x1*y2 - y1*x2)*(y3 - y4) - (y1 - y2)*(x3*y4 - y3*x4)) / denom;

        if (isBetween(px, py, x1, y1, x2, y2) && isBetween(px, py, x3, y3, x4, y4)) {
            return new Point(px, py);
        } else {
            return null;
        }
    }

    private boolean isBetween(double px, double py, double x1, double y1, double x2, double y2) {
        return px >= Math.min(x1, x2) && px <= Math.max(x1, x2) &&
                py >= Math.min(y1, y2) && py <= Math.max(y1, y2);
    }
}

public class task2 {
    public static void main(String[] args) {
        Segment seg1 = new Segment(new Point(0, 0), new Point(4, 4));
        Segment seg2 = new Segment(new Point(0, 4), new Point(4, 0));

        System.out.println("Length seg1: " + seg1.length());
        System.out.println("Middle seg2: " + seg2.middle());
        System.out.println("Intersection: " + seg1.intersection(seg2)); // (2.0;2.0)
    }
}
