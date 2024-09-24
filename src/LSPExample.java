//Correct Version
interface Shape {
    int getArea();
}
class Rectangle implements Shape {
    protected int width;
    protected int height;
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public int getArea() {
        return width * height;
    }
}
class Square implements Shape {
    private int side;
    public void setSide(int side) {
        this.side = side;
    }
 @Override
    public int getArea() {
        return side * side;
    }
}
public class LSPExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        System.out.println("Rectangle Area: " + rectangle.getArea()); 
        Square square = new Square();
        square.setSide(10);
        System.out.println("Square Area: " + square.getArea());  
    }
}
