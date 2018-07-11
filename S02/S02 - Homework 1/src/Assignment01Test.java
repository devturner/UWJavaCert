import org.junit.Test;
public class Assignment01Test {

  @Test
  public void testEnvironmentSetup() {
    Point p1 = new Point(3, 7);
    Point p2 = new Point(5, 19);
    Line line = new Line(p1, p2);
  }

}

class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

}

class Line {
  Point start;
  Point end;

  Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

}

