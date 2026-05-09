import java.util.*;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class ClosestPairAndShortestPath {

    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static void closestPair(Point[] points) {
        double minDist = Double.MAX_VALUE;
        int p1 = 0, p2 = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = distance(points[i], points[j]);
                if (d < minDist) {
                    minDist = d;
                    p1 = i;
                    p2 = j;

                }
               System.out.println("Point 1: (" + points[p1].x + ", " + points[p1].y + ")");
               System.out.println("Point 2: (" + points[p2].x + ", " + points[p2].y + ")");
               System.out.println("Distance: " + minDist);

            }
        }

        System.out.println("\n--- Closest Pair ---");
        System.out.println("Point 1: (" + points[p1].x + ", " + points[p1].y + ")");
        System.out.println("Point 2: (" + points[p2].x + ", " + points[p2].y + ")");
        System.out.println("Minimum Distance: " + minDist);
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        Point[] points = new Point[n];

        System.out.println("Enter coordinates:");
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point(x, y);
        }

        closestPair(points);


    }
}