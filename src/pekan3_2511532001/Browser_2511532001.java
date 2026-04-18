package pekan3_2511532001;

import java.util.Stack;
import java.util.Scanner;

public class Browser_2511532001 {
    public static void main(String[] args) {
        // deklarasi stack
        Stack<Website_2511532001> history = new Stack<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Browser History NIM: 2511532001 ===");
            System.out.println("1. Kunjungi Website (Push)");
            System.out.println("2. Tombol Back (Pop)");
            System.out.println("3. Lihat Halaman Aktif (Peek)");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    // push: memasukkan data website baru ke tumpukan
                    System.out.print("Masukkan Judul: ");
                    String judul_2001 = input.nextLine();
                    System.out.print("Masukkan URL: ");
                    String url_2001 = input.nextLine();

                    Website_2511532001 webBaru = new Website_2511532001(judul_2001, url_2001);
                    history.push(webBaru);
                    System.out.println("Berhasil mengunjungi halaman!");
                    break;

                case 2:
                    // pop: menghapus halaman terakhir dengan handling EmptyStackException
                    if (history.isEmpty()) {
                        System.out.println("History masih kosong.");
                    } else {
                        Website_2511532001 webDihapus = history.pop();
                        System.out.println("Berhasil mundur dari halaman: " + webDihapus.getJudul_2001());
                    }
                    break;

                case 3:
                    // peek: melihat halaman aktif tanpa menghapus dari tumpukan
                    if (history.isEmpty()) {
                        System.out.println("Belum ada halaman yang dibuka.");
                    } else {
                        Website_2511532001 webAktif = history.peek();
                        System.out.println("Halaman Aktif: " + webAktif.getJudul_2001() + " - " + webAktif.getUrl_2001());
                        System.out.println("Total Riwayat: " + history.size() + " halaman tersimpan.");
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari browser");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        input.close();
    }
}