package pekan5_2511532001;
import java.util.Scanner;

public class RumahSakit_2511532001 {
    private Pasien_2511532001 head_2001;
    private int counterAntrian_2001;
    private int totalPasien_2001;

    public RumahSakit_2511532001() {
        this.head_2001 = null;
        this.counterAntrian_2001 = 0;
        this.totalPasien_2001 = 0;
    }

    // daftarkan pasien (insert at tail)
    public void daftarkanPasien_2001(String nama_2001, String keluhan_2001) {
        counterAntrian_2001++; // increment nomor antrian
        Pasien_2511532001 nodeBaru_2001 = new Pasien_2511532001(nama_2001, keluhan_2001, counterAntrian_2001);
        
        if (head_2001 == null) {
            head_2001 = nodeBaru_2001; // jika list kosong, jadi head
        } else {
            Pasien_2511532001 temp_2001 = head_2001;
            while (temp_2001.getNext_2001() != null) {
                temp_2001 = temp_2001.getNext_2001();
            }
            temp_2001.setNext_2001(nodeBaru_2001); // taruh di belakang
        }
        totalPasien_2001++;
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counterAntrian_2001);
    }

    // panggil asien (delete head)
    public void panggilPasien_2001() {
        if (head_2001 == null) {
            System.out.println("Antrian kosong. Tidak ada pasien yang dapat dipanggil.");
            return;
        }
        System.out.println("Memanggil Pasien:");
        System.out.println("No Antrian: " + head_2001.getNoAntrian_2001() + " | Nama: " + head_2001.getNama_2001() + " | Keluhan: " + head_2001.getKeluhan_2001());
        
        head_2001 = head_2001.getNext_2001(); // geser head ke node berikutnya
        totalPasien_2001--;
    }

    // tampilkan antrian (display)
    public void tampilkanAntrian_2001() {
        if (head_2001 == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Daftar Antrian Pasien ===");
        Pasien_2511532001 temp_2001 = head_2001;
        int posisi_2001 = 1;
        while (temp_2001 != null) {
            System.out.println(posisi_2001 + ". [No." + temp_2001.getNoAntrian_2001() + "] " + temp_2001.getNama_2001() + " - " + temp_2001.getKeluhan_2001());
            temp_2001 = temp_2001.getNext_2001();
            posisi_2001++;
        }
    }

    // cari pasien
    public void cariPasien_2001(String cariNama_2001) {
        if (head_2001 == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        Pasien_2511532001 temp_2001 = head_2001;
        boolean ditemukan_2001 = false;
        int posisi_2001 = 1;
        
        while (temp_2001 != null) {
            if (temp_2001.getNama_2001().equalsIgnoreCase(cariNama_2001)) {
                System.out.println("Pasien ditemukan pada antrian ke-" + posisi_2001 + ":");
                System.out.println("No Antrian: " + temp_2001.getNoAntrian_2001() + " | Nama: " + temp_2001.getNama_2001() + " | Keluhan: " + temp_2001.getKeluhan_2001());
                ditemukan_2001 = true;
            }
            temp_2001 = temp_2001.getNext_2001();
            posisi_2001++;
        }
        if (!ditemukan_2001) {
            System.out.println("Pasien dengan nama '" + cariNama_2001 + "' tidak ditemukan dalam antrian.");
        }
    }

    // 5. cek status antrian
    public void cekStatusAntrian_2001() {
        if (head_2001 == null) {
            System.out.println("Antrian saat ini kosong.");
            return;
        }
        System.out.println("=== Status Antrian ===");
        System.out.println("Total pasien dalam antrian: " + totalPasien_2001);
        System.out.println("Pasien selanjutnya (Terdepan): [No." + head_2001.getNoAntrian_2001() + "] " + head_2001.getNama_2001());
    }

    // main
    public static void main(String[] args) {
        Scanner sc_2001 = new Scanner(System.in);
        RumahSakit_2511532001 rs_2001 = new RumahSakit_2511532001();
        int pilihan_2001;

        do {
            System.out.println("\nAntrian Rumah Sakit NIM: 2511532001");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_2001 = sc_2001.nextInt();
            sc_2001.nextLine();

            switch (pilihan_2001) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama_2001 = sc_2001.nextLine();
                    System.out.print("Masukkan Keluhan : ");
                    String keluhan_2001 = sc_2001.nextLine();
                    rs_2001.daftarkanPasien_2001(nama_2001, keluhan_2001);
                    break;
                case 2:
                    rs_2001.panggilPasien_2001();
                    break;
                case 3:
                    rs_2001.tampilkanAntrian_2001();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari_2001 = sc_2001.nextLine();
                    rs_2001.cariPasien_2001(cari_2001);
                    break;
                case 5:
                    rs_2001.cekStatusAntrian_2001();
                    break;
                case 6:
                    System.out.println("Keluar dari program simulasi Rumah Sakit.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan_2001 != 6);
        sc_2001.close();
    }
}