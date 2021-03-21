public class Retangle implements Shape {
    private final int width;
    private final int height;

    public Retangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
