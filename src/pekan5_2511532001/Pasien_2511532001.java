package pekan5_2511532001;

public class Pasien_2511532001 {

	private String nama_2001;
    private String keluhan_2001;
    private int noAntrian_2001;
    private Pasien_2511532001 next_2001; 

    public Pasien_2511532001(String nama_2001, String keluhan_2001, int noAntrian_2001) {
        this.nama_2001 = nama_2001;
        this.keluhan_2001 = keluhan_2001;
        this.noAntrian_2001 = noAntrian_2001;
        this.next_2001 = null;
    }

    // getter dan setter
    public String getNama_2001() { return nama_2001; }
    public void setNama_2001(String nama_2001) { this.nama_2001 = nama_2001; }
    
    public String getKeluhan_2001() { return keluhan_2001; }
    public void setKeluhan_2001(String keluhan_2001) { this.keluhan_2001 = keluhan_2001; }
    
    public int getNoAntrian_2001() { return noAntrian_2001; }
    public void setNoAntrian_2001(int noAntrian_2001) { this.noAntrian_2001 = noAntrian_2001; }
    
    public Pasien_2511532001 getNext_2001() { return next_2001; }
    public void setNext_2001(Pasien_2511532001 next_2001) { this.next_2001 = next_2001; }
}