package com.abirfaisal.stackHeapExample;

/**
 * Created by abirfaisal on 5/20/15.
 */
public class FactoryProducer {


    public AbstractFactory getFactory(String factoryType){
        if (factoryType == null) {
            return null;
        }

        if (factoryType.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }


        if (factoryType.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }

        return null;
    }
}
