package com.COP2805C.AddressBook;


//TODO please put this in Functions.java
public final class OSUtils
{
    private static String OS = null;
    public static String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    public static boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }
}
