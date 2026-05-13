package pekan6_2511532001;
import java.util.Scanner;

public class Musik_2511532001 {
    private Lagu_2511532001 head_2001;
    private Lagu_2511532001 tail_2001; // Pointer tambahan untuk memudahkan tampil mundur

    public Musik_2511532001() {
        this.head_2001 = null;
        this.tail_2001 = null;
    }

    // 1. tambah lagu di akhir playlist
    public void tambahLagu_2001(String judul_2001, String penyanyi_2001) {
        Lagu_2511532001 nodeBaru_2001 = new Lagu_2511532001(judul_2001, penyanyi_2001);
        
        if (head_2001 == null) {
            head_2001 = nodeBaru_2001;
            tail_2001 = nodeBaru_2001;
        } else {
            // menyambungkan ekor ke node baru tanpa harus traversal dari head
            tail_2001.setNext_2001(nodeBaru_2001);
            nodeBaru_2001.setPrev_2001(tail_2001);
            tail_2001 = nodeBaru_2001; // pindah status ekor
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }

    // 2. hapus lagu pertama (head)
    public void hapusLaguAwal_2001() {
        if (head_2001 == null) {
            System.out.println("Playlist kosong, tidak ada lagu yang bisa dihapus.");
            return;
        }
        System.out.println("Menghapus lagu: " + head_2001.getJudul_2001());
        head_2001 = head_2001.getNext_2001(); // geser head ke node kedua
        
        if (head_2001 != null) {
            head_2001.setPrev_2001(null); // putus memori prev node kedua ke node lama
        } else {
            tail_2001 = null; // jika lagu habis, tail null
        }
    }

    // 3. tampilkan semua lagu dari awal ke akhir
    public void tampilMaju_2001() {
        if (head_2001 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532001 temp_2001 = head_2001;
        int no_2001 = 1;
        System.out.println("\n=== Playlist Musik (Maju) ===");
        while (temp_2001 != null) {
            System.out.println(no_2001 + ". " + temp_2001.getJudul_2001() + " - " + temp_2001.getPenyanyi_2001());
            temp_2001 = temp_2001.getNext_2001();
            no_2001++;
        }
    }

    // 4. tampilkan semua lagu dari akhir ke awal (Backward Traversal)
    public void tampilMundur_2001() {
        if (tail_2001 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532001 temp_2001 = tail_2001; // mulai dari tail
        int no_2001 = 1;
        System.out.println("\n=== Playlist Musik (Mundur) ===");
        while (temp_2001 != null) {
            System.out.println(no_2001 + ". " + temp_2001.getJudul_2001() + " - " + temp_2001.getPenyanyi_2001());
            temp_2001 = temp_2001.getPrev_2001(); // mundur menggunakan pointer prev
            no_2001++;
        }
    }

    // 5. cari lagu berdasarkan judul (case insensitive)
    public void cariLagu_2001(String cariJudul_2001) {
        if (head_2001 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532001 temp_2001 = head_2001;
        boolean ditemukan_2001 = false;
        int posisi_2001 = 1;
        
        while (temp_2001 != null) {
            if (temp_2001.getJudul_2001().equalsIgnoreCase(cariJudul_2001)) {
                System.out.println("Lagu ditemukan di urutan ke-" + posisi_2001 + " -> " + temp_2001.getJudul_2001() + " - " + temp_2001.getPenyanyi_2001());
                ditemukan_2001 = true;
                break;
            }
            temp_2001 = temp_2001.getNext_2001();
            posisi_2001++;
        }
        
        if (!ditemukan_2001) {
            System.out.println("Lagu dengan judul '" + cariJudul_2001 + "' tidak ditemukan.");
        }
    }

    // main menu Program
    public static void main(String[] args) {
        Scanner sc_2001 = new Scanner(System.in);
        Musik_2511532001 spotify_2001 = new Musik_2511532001();
        int pilihan_2001;

        do {
            System.out.println("\nPlaylist Musik NIM: 2511532001");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu Pertama");
            System.out.println("3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_2001 = sc_2001.nextInt();
            sc_2001.nextLine(); // membersihkan buffer enter

            switch (pilihan_2001) {
                case 1:
                    System.out.print("Judul: ");
                    String judul_2001 = sc_2001.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi_2001 = sc_2001.nextLine();
                    spotify_2001.tambahLagu_2001(judul_2001, penyanyi_2001);
                    break;
                case 2:
                    spotify_2001.hapusLaguAwal_2001();
                    break;
                case 3:
                    spotify_2001.tampilMaju_2001();
                    break;
                case 4:
                    spotify_2001.tampilMundur_2001();
                    break;
                case 5:
                    System.out.print("Cari Judul: ");
                    String cari_2001 = sc_2001.nextLine();
                    spotify_2001.cariLagu_2001(cari_2001);
                    break;
                case 6:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan_2001 != 6);
        sc_2001.close();
    }
}