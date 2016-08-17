package com.vivas.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by duyot on 8/17/2016.
 */
public class BundleUtils{

    public static String getString(String key){
    ResourceBundle rb = ResourceBundle.getBundle("lang",Locale.getDefault());
    return  rb.getString(key);
    }
}
