package com.abirfaisal.stackHeapExample;

/**
 * Created by abirfaisal on 5/20/15.
 */
public class ShapeFactory extends AbstractFactory{


    public Color getColor(String color) {

        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("Red")) {
            return new Red();
        }


        if (color.equalsIgnoreCase("Blue")) {
            return new Blue();
        }


        if (color.equalsIgnoreCase("Green")) {
            return new Green();
        }

        return null;
    }


    public Shape getShape(String shapeType){
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        }


        if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }


        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }

        return null;
    }
}
