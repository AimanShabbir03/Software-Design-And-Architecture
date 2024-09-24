//Incorrect Version
class Rectangle {
    protected int width;
    protected int height;
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }
}
class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;  
    }
    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;  
    }
}
public class LSPViolation {
    public static void main(String[] args) {
        Rectangle rect = new Square();  
        rect.setWidth(10);
        rect.setHeight(20);      
        System.out.println(rect.getArea()); 
}
}

