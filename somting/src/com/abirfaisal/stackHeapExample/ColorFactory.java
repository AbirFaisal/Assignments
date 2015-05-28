package com.abirfaisal.stackHeapExample;

/**
 * Created by abirfaisal on 5/20/15.
 */
public class ColorFactory extends AbstractFactory {

    Color getColor(String colorType) {

        if (colorType == null) {
            return null;
        }

        if (colorType.equalsIgnoreCase("Red")) {
            return new Red();
        }

        if (colorType.equalsIgnoreCase("Blue")) {
            return new Blue();
        }

        if (colorType.equalsIgnoreCase("Green")) {
            return new Green();
        }

        return null;
    }

    Shape getShape(String shape) {
        return null;
    }
}
