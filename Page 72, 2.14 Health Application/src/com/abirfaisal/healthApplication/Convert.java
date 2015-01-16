package com.abirfaisal.healthApplication;

/**
 * Created by abirfaisal on 1/16/15.
 */
public class Convert {

    public static double tokg(double pounds) { //convert pounds to kg
        double kg = (pounds * 0.45359237);
        return kg;

    }

    public static double tometers(double inches) { //convert inches to meters
        double meters = (inches * 0.0254);
        return meters;
    }
}
