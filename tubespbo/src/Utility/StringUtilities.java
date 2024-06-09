/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class StringUtilities {
    public static String convertArrayToString(ArrayList<String> arr) {
        String result = "";
        for (String word : arr) {
            result += word + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
