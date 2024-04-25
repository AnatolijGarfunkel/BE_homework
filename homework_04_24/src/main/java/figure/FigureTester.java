package figure;

public class FigureTester {
    public static void main(String[] args) {
        Figure[] figs = new Figure[5];
        figs[0] = new Rectangle(1, 2);
        figs[1] = new Rectangle(2, 3);
        figs[3] = new Circle(1);
        figs[3] = new Triangle(10, 12, 7);
        figs[4] = new Triangle(15, 15, 15);

        System.out.println(figs[0].perimeter());
        System.out.println(figs[0].area());
    }

    public static double calculateArea(Figure[] figs) {
        double area = 0;
        for (int i = 0; i < figs.length; i ++) {
            area += figs[i].area();
        }
        return area;
    }

    public static double calculatePerimeter(Figure[] figs) {
        double perimeter = 0;
        for (int i = 0; i < figs.length; i ++) {
            perimeter += figs[i].perimeter();
        }
        return perimeter;
    }
}
