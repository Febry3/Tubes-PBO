/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.DoctorForm;

import Model.JadwalPraktek;
import Utility.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class RequestJadwalForm extends javax.swing.JPanel {

    ArrayList<JadwalPraktek> tabel_JadwalPraktek;
    ArrayList<String> ArrayJam;
    DefaultListModel tabel_nama;
    Model.JadwalPraktek jadwal;

    public RequestJadwalForm() {
        initComponents();
        tabel_JadwalPraktek = new ArrayList();
        ArrayJam = new ArrayList();
        tabel_nama = new DefaultListModel();
        buttonAjukan.setVisible(false);
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        buttonAjukan = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(984, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pengajuan Jadwal");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(76, 184, 196));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jadwal Tersedia");

        buttonAjukan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonAjukan.setText("Ajukan");
        buttonAjukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjukanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAjukan)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(buttonAjukan)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        buttonAjukan.setVisible(true);
    }//GEN-LAST:event_jList1ValueChanged

    private void buttonAjukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjukanActionPerformed
        int indexJadwal = jList1.getSelectedIndex();
        JadwalPraktek jadwal = new JadwalPraktek();

        try {
            if (tabel_JadwalPraktek.get(indexJadwal).getStatus().equals("available")) {
                jadwal.pengajuanJadwal("pending", tabel_JadwalPraktek.get(indexJadwal).getId_jadwal_praktek());
                JOptionPane.showMessageDialog(null, "Pengajuan jadwal berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Status sudah pending");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabel_JadwalPraktek.clear();
        tabel_nama.clear();
        showTable();


    }//GEN-LAST:event_buttonAjukanActionPerformed
    private void showTable() {
        try {
            Database db = new Database();
            String sql = "select * from JadwalPraktek";
            ResultSet resultset = db.getData(sql);
            while (resultset.next()) {
                JadwalPraktek jadwal = new JadwalPraktek(resultset.getString("ruangan"), resultset.getString("hari"), resultset.getString("jam"), resultset.getString("Status"), resultset.getInt("id_jadwal_praktek"), resultset.getInt("id_dokter"));
                if (jadwal.getStatus().equals("available") && jadwal.getId_dokter() == 0) {
                    tabel_JadwalPraktek.add(jadwal);
                    tabel_nama.addElement("Ruangan : " + jadwal.getRuangan() + " /Hari : " + jadwal.getHari() + " /Jam : " + jadwal.getJam() + " /Status : " + jadwal.getStatus());
                }
            }
            jList1.setModel(tabel_nama);
        } catch (SQLException e) {
            Logger.getLogger(RequestJadwalForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjukan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
