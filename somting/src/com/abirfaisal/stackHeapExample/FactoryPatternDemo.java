package com.abirfaisal.stackHeapExample;

/**
 * Created by abirfaisal on 5/20/15.
 */
public class FactoryPatternDemo {


    public static void main(String[] args){

        ShapeFactory shapeFactory = new ShapeFactory();


        Shape shape = shapeFactory.getShape("Circle");
        shape.draw();


        shape = shapeFactory.getShape("Square");
        shape.draw();


        shape = shapeFactory.getShape("Rectangle");
        shape.draw();



    }



}
