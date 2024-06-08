
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
        Reservasi rs = new Reservasi("Adi", "Budi", "0812345", "jumat", "15:00");
        System.out.println(rs.getTanggal_reservasi());
        
    }
    
}
