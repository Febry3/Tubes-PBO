
package ComponentGUI;

import MenuModel.ModelMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.DefaultListModel;

public class MenuPharmacist extends javax.swing.JPanel {

    public MenuPharmacist() {
        initComponents();
        setOpaque(false);
        adminListMenu1.setOpaque(false);
        init();
    }
   
    private void init() {
        adminListMenu1.addItem(new ModelMenu("", "PHARMACIST OPTION", ModelMenu.MenuType.TITLE));
        adminListMenu1.addItem(new ModelMenu("1", "DashBoard", ModelMenu.MenuType.MENU));
        adminListMenu1.addItem(new ModelMenu("1", "tes", ModelMenu.MenuType.MENU));
        adminListMenu1.addItem(new ModelMenu("1", "tolol", ModelMenu.MenuType.MENU));
        adminListMenu1.addItem(new ModelMenu("","", ModelMenu.MenuType.EMPTY));
        adminListMenu1.addItem(new ModelMenu("", "Pengajuan", ModelMenu.MenuType.TITLE));
        adminListMenu1.addItem(new ModelMenu("1", "Dokter", ModelMenu.MenuType.MENU));
        adminListMenu1.addItem(new ModelMenu("1", "Pasien", ModelMenu.MenuType.MENU));     
        adminListMenu1.addItem(new ModelMenu("","", ModelMenu.MenuType.EMPTY));
        adminListMenu1.addItem(new ModelMenu("", "Lainnya", ModelMenu.MenuType.TITLE));
        adminListMenu1.addItem(new ModelMenu("1", "Ganti Password", ModelMenu.MenuType.MENU));
        adminListMenu1.addItem(new ModelMenu("1", "Logout", ModelMenu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppNamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adminListMenu1 = new MenuModel.ListMenu<>();

        AppNamePanel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/HospitalLogo100x100.png"))); // NOI18N
        jLabel1.setText("Amba Hospital");

        javax.swing.GroupLayout AppNamePanelLayout = new javax.swing.GroupLayout(AppNamePanel);
        AppNamePanel.setLayout(AppNamePanelLayout);
        AppNamePanelLayout.setHorizontalGroup(
            AppNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppNamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
            .addComponent(adminListMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AppNamePanelLayout.setVerticalGroup(
            AppNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppNamePanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(adminListMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AppNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0,0,Color.decode("#4CB8C4"),0, getHeight(),Color.decode("#3CD3AD"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppNamePanel;
    private MenuModel.ListMenu<String> adminListMenu1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
