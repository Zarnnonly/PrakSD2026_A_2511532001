package pekan2_2511532001;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532001 {
    public static void main(String[] args) {
        ArrayList<Musik_2511532001> playlist = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n--- Playlist Musik NIM: 2511532001 ---");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Hapus Lagu");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul: ");
                    String judul_2001 = input.nextLine();
                    System.out.print("Masukkan Penyanyi: ");
                    String penyanyi_2001 = input.nextLine();
                    System.out.print("Masukkan Durasi (detik): ");
                    int durasi_2001 = input.nextInt();
                    
                    // membuat object dari class ADT dan dimasukkan ke ArrayList
                    Musik_2511532001 laguBaru = new Musik_2511532001(judul_2001, penyanyi_2001, durasi_2001);
                    playlist.add(laguBaru);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\nCek Kapasitas: " + playlist.size() + " lagu");
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist masih kosong");
                    } else {
                        // looping untuk menampilkan isi playlist
                        for (int i = 0; i < playlist.size(); i++) {
                            Musik_2511532001 m = playlist.get(i);
                            System.out.println((i + 1) + ". " + m.getJudul_2001() + " - " + m.getPenyanyi_2001() + " (" + m.getDurasi_2001() + " detik)");
                        }
                    }
                    break;

                case 3:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist kosong");
                    } else {
                        System.out.print("Masukkan nomor lagu yang ingin dihapus (1 - " + playlist.size() + "): ");
                        int indexHapus = input.nextInt();
                        
                        // validasi agar tidak terkena error index
                        if (indexHapus > 0 && indexHapus <= playlist.size()) {
                            playlist.remove(indexHapus - 1); // kurang 1 karena index mulai dari 0
                            System.out.println("Lagu berhasil dihapus!");
                        } else {
                            System.out.println("Nomor tidak valid");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 4);

        input.close();
    }
}