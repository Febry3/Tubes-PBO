
import Model.Reservasi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String result = "";
        String arr[] = {"A", "B", "C"};
        for (String word : arr) {
            result += word + ", ";
        }
        System.out.println(result.substring(0, result.length() - 2));
        
    }
    
}
