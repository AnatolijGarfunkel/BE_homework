package figure;

public class Circle extends Figure{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double perimeter() {
        return 2 * 3.14 * r;
    }

    @Override
    public double area() {
        return 3.14 * r * r;
    }


}
