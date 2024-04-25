package figure;

public class Triangle extends Figure{
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double p = perimeter() * 0.5;
        double temp = (p * (p - a) * (p - b) * (p - c));
        double result = Math.sqrt(temp);
        return result;
    }
}
