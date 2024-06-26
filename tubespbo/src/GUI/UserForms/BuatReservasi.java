/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.UserForms;

import Controller.ListDokterController;
import Controller.ListHariController;
import Controller.ReservasiController;

/**
 *
 * @author ASUS
 */
public class BuatReservasi extends javax.swing.JPanel {

    /**
     * Creates new form DoctorRequestForm
     */
    public BuatReservasi() {
        initComponents();
        ReservasiController reservasiController = new ReservasiController(TableDokterTersedia, listDokter, listHari, listJam, namaPasien, noHp);
        ListDokterController listDokterController = new ListDokterController(listDokter, listHari);
        ListHariController listHariController = new ListHariController(listDokter, listHari, listJam);
        
        reservasiController.loadData();
        reservasiButton.addActionListener(reservasiController);
        listDokter.addActionListener(listDokterController);
        listHari.addActionListener(listHariController);        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        listDokter = new javax.swing.JComboBox<>();
        reservasiButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDokterTersedia = new ComponentGUI.Table();
        noHp = new ComponentGUI.JTextFieldCustom();
        namaPasien = new ComponentGUI.JTextFieldCustom();
        listHari = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        listJam = new javax.swing.JComboBox<>();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(984, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dokter Tersedia");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Reservasi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Dokter:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Hari:");

        reservasiButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reservasiButton.setText("Reservasi");

        TableDokterTersedia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Spesialisasi", "Hari", "Jam", "Ruangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDokterTersedia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TableDokterTersedia.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableDokterTersedia);
        if (TableDokterTersedia.getColumnModel().getColumnCount() > 0) {
            TableDokterTersedia.getColumnModel().getColumn(0).setResizable(false);
            TableDokterTersedia.getColumnModel().getColumn(1).setResizable(false);
            TableDokterTersedia.getColumnModel().getColumn(2).setResizable(false);
            TableDokterTersedia.getColumnModel().getColumn(3).setResizable(false);
            TableDokterTersedia.getColumnModel().getColumn(4).setResizable(false);
        }

        noHp.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 184, 196), 2, true), " No. HP ", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        noHp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        noHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHpActionPerformed(evt);
            }
        });

        namaPasien.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 184, 196), 2, true), "Nama", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        namaPasien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        namaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPasienActionPerformed(evt);
            }
        });

        listHari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHariMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Jam:");

        listJam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noHp, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(listDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(listHari, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(listJam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(reservasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(listDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(namaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(listJam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(listHari, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noHp, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(reservasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void noHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noHpActionPerformed

    private void namaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPasienActionPerformed

    private void listHariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listHariMouseClicked

    }//GEN-LAST:event_listHariMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComponentGUI.Table TableDokterTersedia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listDokter;
    private javax.swing.JComboBox<String> listHari;
    private javax.swing.JComboBox<String> listJam;
    private ComponentGUI.JTextFieldCustom namaPasien;
    private ComponentGUI.JTextFieldCustom noHp;
    private javax.swing.JButton reservasiButton;
    // End of variables declaration//GEN-END:variables
}
