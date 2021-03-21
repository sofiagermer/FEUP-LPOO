public class Triangle implements AreaShape {
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
    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
