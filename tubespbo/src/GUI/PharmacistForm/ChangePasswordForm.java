/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.PharmacistForm;

import GUI.AdminForms.*;

/**
 *
 * @author ASUS
 */
public class ChangePasswordForm extends javax.swing.JPanel {

    /**
     * Creates new form DoctorRequestForm
     */
    public ChangePasswordForm() {
        initComponents();
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
        ConfirmNewPasswordField = new ComponentGUI.JTextFieldCustom();
        NewPasswordField = new ComponentGUI.JTextFieldCustom();
        ButtonSubmitChange = new javax.swing.JButton();
        OldPasswordField = new ComponentGUI.JTextFieldCustom();
        newPassLabel = new javax.swing.JLabel();
        oldPassLabel1 = new javax.swing.JLabel();
        confirmNewPassLabel = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(984, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ganti Password");

        ConfirmNewPasswordField.setOpaque(false);

        NewPasswordField.setOpaque(false);

        ButtonSubmitChange.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSubmitChange.setText("Submit");
        ButtonSubmitChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSubmitChangeActionPerformed(evt);
            }
        });

        OldPasswordField.setOpaque(false);
        OldPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldPasswordFieldActionPerformed(evt);
            }
        });

        newPassLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newPassLabel.setText("Password Baru");

        oldPassLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel1.setText("Password Lama");

        confirmNewPassLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirmNewPassLabel.setText("Konfirmasi Password Baru");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(OldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmNewPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSubmitChange, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPassLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(oldPassLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(newPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(confirmNewPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(ButtonSubmitChange, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSubmitChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSubmitChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSubmitChangeActionPerformed

    private void OldPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OldPasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSubmitChange;
    private ComponentGUI.JTextFieldCustom ConfirmNewPasswordField;
    private ComponentGUI.JTextFieldCustom NewPasswordField;
    private ComponentGUI.JTextFieldCustom OldPasswordField;
    private javax.swing.JLabel confirmNewPassLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JLabel oldPassLabel1;
    // End of variables declaration//GEN-END:variables
}
