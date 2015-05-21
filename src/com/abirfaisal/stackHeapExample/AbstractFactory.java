package com.abirfaisal.stackHeapExample;

/**
 * Created by abirfaisal on 5/20/15.
 */
public abstract class AbstractFactory {


    abstract Color getColor(String color);

    abstract Shape getShape(String shape);

}