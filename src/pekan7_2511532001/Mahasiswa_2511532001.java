package pekan7_2511532001;

public class Mahasiswa_2511532001 {
    private String nama_2001;
    private String nim_2001;
    private String prodi_2001;

    // constructor
    public Mahasiswa_2511532001(String nama_2001, String nim_2001, String prodi_2001) {
        this.nama_2001 = nama_2001;
        this.nim_2001 = nim_2001;
        this.prodi_2001 = prodi_2001;
    }

    // getter dan setter
    public String getNama_2001() { return nama_2001; }
    public void setNama_2001(String nama_2001) { this.nama_2001 = nama_2001; }

    public String getNim_2001() { return nim_2001; }
    public void setNim_2001(String nim_2001) { this.nim_2001 = nim_2001; }

    public String getProdi_2001() { return prodi_2001; }
    public void setProdi_2001(String prodi_2001) { this.prodi_2001 = prodi_2001; }

    //  toString untuk menampilkan teks di GUI
    @Override
    public String toString() {
        return nama_2001 + " (" + nim_2001 + " - " + prodi_2001 + ")";
    }
}