# Software-Design-and-Architecture
# Liskov Substitution Principle (LSP)
•	The Liskov Substitution Principle (LSP) is one of the five SOLID principles of object-oriented design. 
# Statement: 
It states that;
"Objects of a subclass should be able to replace objects of the parent class without altering the correctness of the program."
In other words, if a class B is a subclass of A, we should be able to use objects of B wherever objects of A are expected, and the program should work correctly.
If the subclass violates this principle, it may result in incorrect behavior or broken functionality when substituting the subclass in place of the parent class.
# Key Concepts:
1.	Behavioral Consistency:
o	Subclasses should behave in a way that users of the parent class expect. If a subclass changes the way a method works, it shouldn't break the original program's logic.
2.	Substitutability:
o	You should be able to replace an object of the parent class with an object of its subclass without causing any problems in the program. The subclass should follow the same rules as the parent class.
3.	Contract Integrity:
o	The subclass must respect the "rules" set by the parent class. If a parent class expects certain inputs or outputs from its methods, the subclass should not break these expectations.
# Why is LSP Important?
1.	Code Reliability:
o	If you break LSP, your code might start behaving unexpectedly because the subclass isn't acting like the parent class. This can lead to bugs when developers assume things will work in a certain way but they don't.
2.	Maintainability:
o	Following LSP makes your code cleaner and easier to maintain. You can change or extend classes without worrying about breaking other parts of the system.
3.	Flexibility and Extensibility:
o	LSP helps create systems that are easy to extend. You can add new subclasses with confidence, knowing they will work correctly when used in place of their parent classes.
# Example Scenario:
Let’s consider a scenario involving a Rectangle and its subclass Square. Both are shapes, and a Square is technically a special type of Rectangle. However, if we implement Square as a subclass of Rectangle without following LSP, the program might behave unexpectedly.
# Incorrect Version:
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
# Explanation of Incorrect Version:
•	The class Square overrides the setWidth() and setHeight() methods to ensure the width and height remain equal (because a square has equal sides).
•	However, this breaks the behavior expected from the Rectangle class.
•	In the main() method, when you try to use a Square as a Rectangle, you expect it to behave like a rectangle, but it doesn’t. Setting the height in a square unintentionally modifies the width, leading to unexpected results. This violates LSP.
# Correct Version:
To fix this issue, we can avoid subclassing Square from Rectangle. Instead, treat Square and Rectangle as separate classes that both implement a common interface, such as Shape.
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
# Explanation of Correct Version:
•	We define a Shape interface, which both Rectangle and Square implement.
•	The Rectangle class handles width and height independently, while the Square class uses a single side property.
•	Each class now represents its respective shape correctly without violating LSP.
•	In the main() method, Rectangle and Square can now be used independently, and their behavior is correct.
# Conclusion:
•	LSP ensures that derived classes (subclasses) are fully interchangeable with their base classes (parent classes).
•	By following LSP, we can create a flexible, reliable, and maintainable system.
•	Violating LSP can lead to unexpected behavior and make your code more prone to bugs.
