package question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Menu");
            System.out.print("Enter your choice: ");
            String choice = reader.readLine();

            Shape shape = null;

            switch (choice.toLowerCase()) {
                case "circle":
                    System.out.print("Enter the radius: ");
                    double radius = Double.parseDouble(reader.readLine());
                    shape = new Circle(radius);
                    break;
                case "rectangle":
                    System.out.print("Enter the length: ");
                    double length = Double.parseDouble(reader.readLine());
                    System.out.print("Enter the width: ");
                    double width = Double.parseDouble(reader.readLine());
                    shape = new Rectangle(length, width);
                    break;
                case "square":
                    System.out.print("Enter the side: ");
                    double side = Double.parseDouble(reader.readLine());
                    shape = new Square(side);
                    break;
                default:
                    System.out.println("This is not a recognized shape. Allowed shapes are: Circle, Square, Rectangle");
                    break;
            }

            if (shape != null) {
                System.out.println("Area of " + choice + " is: " + shape.area());
                System.out.println("Perimeter of " + choice + " is: " + shape.perimeter());
            }

            System.out.println();
        }
    }
}