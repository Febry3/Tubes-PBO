package ComponentGUI;

import Model.Obat;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.EmptyBorder;

public class DetailCard extends javax.swing.JPanel {

    public DetailCard() {
        initComponents();
        setOpaque(false);
    }

    public void setObat(Obat obat) {
        obatLB.setText(obat.getNama_obat());
        dosisLB.setText(obat.getDosis());
        kegunaanLB.setText(obat.getKegunaan());
        komposisiLB.setText(obat.getKomposisi());
        noRegistrasiLB.setText(obat.getNo_registrasi());
        kadaluarsaLB.setText(obat.getKadaluarsa().toString());
        aturanPakaiLB.setText(obat.getAturan_pakai());
        penyimpananLB.setText(obat.getPetunjuk_penyimpanan());
        hargaLB.setText(String.valueOf(obat.getHarga()));
        stokLB.setText(String.valueOf(obat.getStock()));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
//        Graphics2D g2 = (Graphics2D)grphcs;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        //GradientPaint g = new GradientPaint(0,0,Color.decode("#D3CCE3"),0, getHeight(),Color.decode("#E9E4F0"));
//        GradientPaint g = new GradientPaint(0,0,Color.decode("#83a4d4"),0, getHeight(),Color.decode("#b6fbff"));
//        g2.setPaint(g);
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        setBorder(new EmptyBorder(10, 5, 10, 5));
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obatLB = new javax.swing.JLabel();
        LabelDosis = new javax.swing.JLabel();
        labelKegunaan = new javax.swing.JLabel();
        labelKomposisi = new javax.swing.JLabel();
        labelNoRegistrasi = new javax.swing.JLabel();
        labelKadaluarsa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelAturanPakai = new javax.swing.JLabel();
        labelPetunjukPenyimpnan = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelStok = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dosisLB = new javax.swing.JLabel();
        kegunaanLB = new javax.swing.JLabel();
        komposisiLB = new javax.swing.JLabel();
        kadaluarsaLB = new javax.swing.JLabel();
        aturanPakaiLB = new javax.swing.JLabel();
        penyimpananLB = new javax.swing.JLabel();
        noRegistrasiLB = new javax.swing.JLabel();
        hargaLB = new javax.swing.JLabel();
        stokLB = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 255));
        setOpaque(false);

        obatLB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        obatLB.setText("Nama Obat");

        LabelDosis.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LabelDosis.setText("Dosis  ");

        labelKegunaan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelKegunaan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelKegunaan.setText("Kegunaan  ");

        labelKomposisi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelKomposisi.setText("Komposisi");

        labelNoRegistrasi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelNoRegistrasi.setText("No Registrasi ");

        labelKadaluarsa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelKadaluarsa.setText("Kadaluarsa");

        jLabel1.setText(":");

        jLabel2.setText(":");

        jLabel3.setText(":");

        jLabel4.setText(":");

        labelAturanPakai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelAturanPakai.setText("Aturan Pakai");

        labelPetunjukPenyimpnan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelPetunjukPenyimpnan.setText("Penyimpanan");

        labelHarga.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelHarga.setText("Harga");

        labelStok.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelStok.setText("Stok");

        jLabel6.setText(":");

        jLabel7.setText(":");

        jLabel8.setText(":");

        jLabel9.setText(":");

        jLabel10.setText(":");
        jLabel10.setPreferredSize(new java.awt.Dimension(5, 15));

        dosisLB.setText("jLabel5");

        kegunaanLB.setText("jLabel5");

        komposisiLB.setText("jLabel5");

        kadaluarsaLB.setText("jLabel5");

        aturanPakaiLB.setText("jLabel5");

        penyimpananLB.setText("jLabel5");

        noRegistrasiLB.setText("jLabel5");

        hargaLB.setText("jLabel5");

        stokLB.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(labelKadaluarsa)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(LabelDosis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(20, 20, 20)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labelAturanPakai)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelPetunjukPenyimpnan)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelKegunaan)
                            .addComponent(labelKomposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dosisLB)
                            .addComponent(kegunaanLB)
                            .addComponent(aturanPakaiLB)
                            .addComponent(penyimpananLB)
                            .addComponent(komposisiLB)
                            .addComponent(kadaluarsaLB))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(obatLB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(471, 471, 471)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelHarga)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hargaLB)
                                .addGap(20, 20, 20)
                                .addComponent(labelStok)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stokLB)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNoRegistrasi, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noRegistrasiLB)
                                .addGap(112, 112, 112))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(obatLB)
                    .addComponent(labelNoRegistrasi)
                    .addComponent(jLabel3)
                    .addComponent(noRegistrasiLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDosis)
                    .addComponent(jLabel1)
                    .addComponent(dosisLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKegunaan)
                    .addComponent(jLabel2)
                    .addComponent(kegunaanLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKomposisi)
                    .addComponent(jLabel4)
                    .addComponent(komposisiLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKadaluarsa)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kadaluarsaLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelAturanPakai)
                    .addComponent(aturanPakaiLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPetunjukPenyimpnan)
                    .addComponent(jLabel7)
                    .addComponent(penyimpananLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHarga)
                    .addComponent(jLabel8)
                    .addComponent(labelStok)
                    .addComponent(jLabel9)
                    .addComponent(hargaLB)
                    .addComponent(stokLB))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDosis;
    private javax.swing.JLabel aturanPakaiLB;
    private javax.swing.JLabel dosisLB;
    private javax.swing.JLabel hargaLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel kadaluarsaLB;
    private javax.swing.JLabel kegunaanLB;
    private javax.swing.JLabel komposisiLB;
    private javax.swing.JLabel labelAturanPakai;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelKadaluarsa;
    private javax.swing.JLabel labelKegunaan;
    private javax.swing.JLabel labelKomposisi;
    private javax.swing.JLabel labelNoRegistrasi;
    private javax.swing.JLabel labelPetunjukPenyimpnan;
    private javax.swing.JLabel labelStok;
    private javax.swing.JLabel noRegistrasiLB;
    private javax.swing.JLabel obatLB;
    private javax.swing.JLabel penyimpananLB;
    private javax.swing.JLabel stokLB;
    // End of variables declaration//GEN-END:variables
}
