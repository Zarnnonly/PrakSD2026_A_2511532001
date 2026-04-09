package pekan1_2511532001;

import java.util.ArrayList;

public class Mobil_2511532001 {
	
	 private String nama;
	 private int tahun;
	 private int cc;
	 private double harga;
	 private String merk;
	
	 private ArrayList<Mobil_2511532001> daftarMobil;
	
	 public Mobil_2511532001() {
	     this.daftarMobil = new ArrayList<>();
	 }
	
	 public Mobil_2511532001(String nama, int tahun, int cc, double harga, String merk) {
	     this.nama = nama;
	     this.tahun = tahun;
	     this.cc = cc;
	     this.harga = harga;
	     this.merk = merk;
	 }
	
	 public String getNama() { return nama; }
	 public int getTahun() { return tahun; }
	 public int getCc() { return cc; }
	 public double getHarga() { return harga; }
	 public String getMerk() { return merk; }
	 public ArrayList<Mobil_2511532001> getDaftarMobil() { return daftarMobil; }
	
	 public void setNama(String nama) { this.nama = nama; }
	 public void setTahun(int tahun) { this.tahun = tahun; }
	 public void setCc(int cc) { this.cc = cc; }
	 public void setHarga(double harga) { this.harga = harga; }
	 public void setMerk(String merk) { this.merk = merk; }
	
	 public void tambahMobil(Mobil_2511532001 m) {
	     daftarMobil.add(m);
	     System.out.println("Mobil " + m.getNama() + " berhasil ditambahkan.");
	 }
	
	 public void hapusMobil(String namaMobil) {
	     boolean ditemukan = false;
	     for (int i = 0; i < daftarMobil.size(); i++) {
	         if (daftarMobil.get(i).getNama().equalsIgnoreCase(namaMobil)) {
	             daftarMobil.remove(i);
	             System.out.println("Mobil " + namaMobil + " berhasil dihapus.");
	             ditemukan = true;
	             break;
	         }
	     }
	     if (!ditemukan) {
	         System.out.println("Mobil " + namaMobil + " tidak ditemukan.");
	     }
	 }
	
	 public void tampilkanSemua() {
	     System.out.println("\n===== Daftar Mobil =====");
	     if (daftarMobil.isEmpty()) {
	         System.out.println("Daftar kosong.");
	     } else {
	         for (Mobil_2511532001 m : daftarMobil) {
	             System.out.println(m.toString());
	         }
	     }
	 }
	
	 public String toString() {
	     return String.format("Nama: %s | Tahun: %d | CC: %d | Harga: Rp%.0f | Merk: %s",
	             nama, tahun, cc, harga, merk);
	 }
	}
