public class Application {
    public static void main(String[] args) {
        AreaAggregator areaAggregator = new AreaAggregator();
        HasArea shape1, shape2, shape3, shape4;
        shape1 = new Circle(3);
        shape2 = new Square(5);
        shape3 = new Retangle(2,3);
        shape4 = new Triangle(2,3);

        areaAggregator.addShape(shape1);
        areaAggregator.addShape(shape2);
        areaAggregator.addShape(shape3);
        areaAggregator.addShape(shape4);

        AreaStringOutputter areaStringOutputter = new AreaStringOutputter(areaAggregator);
        System.out.println(areaStringOutputter.output());

        AreaXMLOutputter areaXMLOutputter = new AreaXMLOutputter(areaAggregator);
        System.out.println(areaXMLOutputter.outputXML());
    }
}
