public class Square implements AreaShape {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return  Math.pow(side, 2);
    }
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
