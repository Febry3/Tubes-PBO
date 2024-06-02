
package ComponentGUI;

import MenuModel.ModelMenu;
import MenuModel.SelectedMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.DefaultListModel;

public class MenuDokter extends javax.swing.JPanel {

    private SelectedMenu event;
    
    public void addEventMenuSelected(SelectedMenu event) {
        this.event = event;
        dokterListMenu.addEventMenuSelected(event);
    }
    public MenuDokter() {
        initComponents();
        setOpaque(false);
        dokterListMenu.setOpaque(false);
        init();
    }
   
    private void init() {
        dokterListMenu.addItem(new ModelMenu("", "DOCTOR OPTION", ModelMenu.MenuType.TITLE));
        dokterListMenu.addItem(new ModelMenu("", "Jadwal", ModelMenu.MenuType.TITLE));
        dokterListMenu.addItem(new ModelMenu("request", "Pengajuan Jadwal", ModelMenu.MenuType.MENU));
        dokterListMenu.addItem(new ModelMenu("jadwal", "Jadwal Praktek", ModelMenu.MenuType.MENU));     
        dokterListMenu.addItem(new ModelMenu("","", ModelMenu.MenuType.EMPTY));
        dokterListMenu.addItem(new ModelMenu("", "Laporan", ModelMenu.MenuType.TITLE));
        dokterListMenu.addItem(new ModelMenu("buatLaporan", "Buat Laporan", ModelMenu.MenuType.MENU));  
        dokterListMenu.addItem(new ModelMenu("","", ModelMenu.MenuType.EMPTY));
        dokterListMenu.addItem(new ModelMenu("", "Lainnya", ModelMenu.MenuType.TITLE));
        dokterListMenu.addItem(new ModelMenu("GantiPassword", "Ganti Password", ModelMenu.MenuType.MENU));
        dokterListMenu.addItem(new ModelMenu("logoutIcon", "Logout", ModelMenu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppNamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dokterListMenu = new MenuModel.ListMenu<>();

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
            .addComponent(dokterListMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AppNamePanelLayout.setVerticalGroup(
            AppNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppNamePanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(dokterListMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private MenuModel.ListMenu<String> dokterListMenu;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
