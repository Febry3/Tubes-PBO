/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.PharmacistForm;

import ComponentGUI.DetailCard;
import ComponentGUI.Table;
import Controller.TambahObatController;
import Model.Obat;
import Utility.Database;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ManageObatForm extends javax.swing.JPanel {

    private DetailCard detailCard;

    public ManageObatForm() {
        initComponents();
        TableScrollPanel.getVerticalScrollBar().setBackground(Color.WHITE);
        TableScrollPanel.getViewport().setBackground(Color.WHITE);
        detailCard = new DetailCard();

//        JPanel panel = new JPanel();
//        panel.add(detailCard);
//        add(panel);
//        detailCard2.add(detailCard);
//        add(detailCard2);
        TambahObatController tambah = new TambahObatController(TableObat);
        tambah.loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        PanelSearch = new GUI.PanelBorder();
        PanelDaftarObat = new GUI.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        TableScrollPanel = new javax.swing.JScrollPane();
        TableObat = new ComponentGUI.Table();
        refreshButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        panelBorder1 = new GUI.PanelBorder();
        detailCard2 = new ComponentGUI.DetailCard();

        jRadioButton1.setText("jRadioButton1");

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(984, 0));

        PanelSearch.setForeground(new java.awt.Color(76, 184, 196));

        javax.swing.GroupLayout PanelSearchLayout = new javax.swing.GroupLayout(PanelSearch);
        PanelSearch.setLayout(PanelSearchLayout);
        PanelSearchLayout.setHorizontalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelSearchLayout.setVerticalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        PanelDaftarObat.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Daftar Obat");

        TableScrollPanel.setBorder(null);

        TableObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Obat", "No Registrasi", "Stok", "Harga"
            }
        ));
        TableScrollPanel.setViewportView(TableObat);

        refreshButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshButton.setText("Refresh");
        refreshButton.setBorder(null);
        refreshButton.setBorderPainted(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.setBorderPainted(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDaftarObatLayout = new javax.swing.GroupLayout(PanelDaftarObat);
        PanelDaftarObat.setLayout(PanelDaftarObatLayout);
        PanelDaftarObatLayout.setHorizontalGroup(
            PanelDaftarObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDaftarObatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelDaftarObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDaftarObatLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TableScrollPanel))
                .addGap(20, 20, 20))
        );
        PanelDaftarObatLayout.setVerticalGroup(
            PanelDaftarObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDaftarObatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDaftarObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(PanelDaftarObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));
        panelBorder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 15));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new java.awt.BorderLayout());
        panelBorder1.add(detailCard2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDaftarObat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDaftarObat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    public void show_table() {
        try {
            Database db = new Database();
            db.connect();
            String sql = "select * from Obat";
            ResultSet rs = db.getData(sql);
            DefaultTableModel table = (DefaultTableModel) TableObat.getModel();

            table.setRowCount(0);
            while (rs.next()) {
                Object[] rowData = {rs.getString("nama_obat"), rs.getString("no_registrasi"), rs.getInt("stock"), rs.getInt("harga")};
                table.addRow(rowData);
            }
        } catch (SQLException e) {
            Logger.getLogger(ManageObatForm.class.getName()).log(Level.SEVERE, null, e);
        }
        TableObat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = TableObat.getSelectedRow();
                if (selectedRow != -1) {
                    String namaObat = (String) TableObat.getValueAt(selectedRow, 0);
                    tampilkanDetailObat(namaObat);
                }
            }
        });
    }

    public void tampilkanDetailObat(String namaObat) {
        try {
            Database db = new Database();
            db.connect();
            String sql = "SELECT * FROM Obat WHERE nama_obat = '" + namaObat + "'";
            ResultSet rs = db.getData(sql);

            if (rs.next()) {
                Obat obat = new Obat(
                        rs.getString("nama_obat"),
                        rs.getString("dosis"),
                        rs.getString("kegunaan"),
                        rs.getString("komposisi"),
                        rs.getString("no_registrasi"),
                        rs.getDate("kadaluarsa"),
                        rs.getString("aturan_pakai"),
                        rs.getString("petunjuk_penyimpanan"),
                        rs.getInt("harga"),
                        rs.getInt("stock")
                );

                detailCard.setObat(obat);
            } else {
                JOptionPane.showMessageDialog(null, "Data obat tidak ditemukan.");
            }
        } catch (SQLException e) {
            Logger.getLogger(ManageObatForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Table getTableObat() {
        return TableObat;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.PanelBorder PanelDaftarObat;
    private GUI.PanelBorder PanelSearch;
    private ComponentGUI.Table TableObat;
    private javax.swing.JScrollPane TableScrollPanel;
    private javax.swing.JButton deleteButton;
    private ComponentGUI.DetailCard detailCard2;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private GUI.PanelBorder panelBorder1;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
