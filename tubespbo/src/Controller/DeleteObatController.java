
package Controller;

import ComponentGUI.Table;
import Model.Obat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ASUS
 */
public class DeleteObatController implements ActionListener {

    private String nama;
    private Table tableObat;

    public DeleteObatController(String nama, Table tableObat) {
        this.nama = nama;
        this.tableObat = tableObat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Obat obat = new Obat();

        try {
            obat.deleteObat(nama);
            System.out.println(nama);
            String sql = "DELETE from Obat where nama_obat = '" + nama + "'; ";
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Obat berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
