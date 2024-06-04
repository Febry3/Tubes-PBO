package CardModel;

import java.sql.Date;

public class ModelCard {
    private String nama_obat;
    private String dosis;
    private String[] kegunaan;
    private String[] komposisi;
    private String no_registrasi;
    private Date kadaluarsa;
    private String aturan_pakai;
    private String petunjuk_penyimpanan;
    private int harga;
    private int stock;

    public ModelCard(String nama_obat, String dosis, String[] kegunaan, String[] komposisi, String no_registrasi, Date kadaluarsa, String aturan_pakai, String petunjuk_penyimpanan, int harga, int stock) {
        this.nama_obat = nama_obat;
        this.dosis = dosis;
        this.kegunaan = kegunaan;
        this.komposisi = komposisi;
        this.no_registrasi = no_registrasi;
        this.kadaluarsa = kadaluarsa;
        this.aturan_pakai = aturan_pakai;
        this.petunjuk_penyimpanan = petunjuk_penyimpanan;
        this.harga = harga;
        this.stock = stock;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String[] getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String[] kegunaan) {
        this.kegunaan = kegunaan;
    }

    public String[] getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String[] komposisi) {
        this.komposisi = komposisi;
    }

    public String getNo_registrasi() {
        return no_registrasi;
    }

    public void setNo_registrasi(String no_registrasi) {
        this.no_registrasi = no_registrasi;
    }

    public Date getKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(Date kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public String getAturan_pakai() {
        return aturan_pakai;
    }

    public void setAturan_pakai(String aturan_pakai) {
        this.aturan_pakai = aturan_pakai;
    }

    public String getPetunjuk_penyimpanan() {
        return petunjuk_penyimpanan;
    }

    public void setPetunjuk_penyimpanan(String petunjuk_penyimpanan) {
        this.petunjuk_penyimpanan = petunjuk_penyimpanan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
