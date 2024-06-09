/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lenovo
 */
public class DateUtilities {
    public static String dateAdditionFromNow(String day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dateOfWeekFormatter = DateTimeFormatter.ofPattern("e");
        LocalDateTime now = LocalDateTime.now();
        int days = (convertDayToInt(day) + Integer.parseInt(now.format(dateOfWeekFormatter))) % 7;
        return now.plusDays(days).format(formatter);
    }
    
    public static String dateFormatYYMMDD(String day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateOfWeekFormatter = DateTimeFormatter.ofPattern("e");
        LocalDateTime now = LocalDateTime.now();
        int days = (convertDayToInt(day) + Integer.parseInt(now.format(dateOfWeekFormatter))) % 7;
        return now.plusDays(days).format(formatter);
    }
    
    private static int convertDayToInt(String day){
        String days[] = {"minggu", "senin", "selasa", "rabu", "kamis", "jumat", "sabtu"};
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day.toLowerCase())) {
                return i + 1;
            }
        }
        return -1;
    }
}
