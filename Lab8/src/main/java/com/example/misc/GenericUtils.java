package com.example.misc;

import java.io.FileInputStream;
import java.util.Scanner;

public class GenericUtils {
    public static String readStringFromFile(String namePath){
        String ret = null;
        try { try (Scanner scanner = new Scanner(new FileInputStream(namePath)).useDelimiter("\\Z")) { ret = scanner.next(); } }
        catch (Exception e){e.printStackTrace();}
        return ret;
    }
}
