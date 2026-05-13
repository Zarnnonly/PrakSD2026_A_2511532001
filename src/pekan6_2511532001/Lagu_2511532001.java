package pekan6_2511532001;

public class Lagu_2511532001 {
	
    private String judul_2001;
    private String penyanyi_2001;
    private Lagu_2511532001 next_2001;
    private Lagu_2511532001 prev_2001;

    // konstruktor
    public Lagu_2511532001(String judul_2001, String penyanyi_2001) {
        this.judul_2001 = judul_2001;
        this.penyanyi_2001 = penyanyi_2001;
        this.next_2001 = null;
        this.prev_2001 = null;
    }

    // getter dan setter
    public String getJudul_2001() { return judul_2001; }
    public void setJudul_2001(String judul_2001) { this.judul_2001 = judul_2001; }
    
    public String getPenyanyi_2001() { return penyanyi_2001; }
    public void setPenyanyi_2001(String penyanyi_2001) { this.penyanyi_2001 = penyanyi_2001; }
    
    public Lagu_2511532001 getNext_2001() { return next_2001; }
    public void setNext_2001(Lagu_2511532001 next_2001) { this.next_2001 = next_2001; }
    
    public Lagu_2511532001 getPrev_2001() { return prev_2001; }
    public void setPrev_2001(Lagu_2511532001 prev_2001) { this.prev_2001 = prev_2001; }
}