public class Triangle implements Shape {
    private final int height;
    private final int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        return height * base/2;
    }
}
