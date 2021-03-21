public class Line implements Shape {
    private final int lenght;

    public Line(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
