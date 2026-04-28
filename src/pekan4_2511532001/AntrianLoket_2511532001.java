package pekan4_2511532001;
import java.util.Scanner;

public class AntrianLoket_2511532001 {
    int front;
    int rear;
    int max;
    String[] queue;

    // konstruktor
    public AntrianLoket_2511532001(int kapasitas) {
        this.max = kapasitas;
        this.queue = new String[max];
        this.front = -1;
        this.rear = -1;
    }

    // isEmpty
    boolean isEmpty() {
        return front == -1;
    }

    // isFull
    boolean isFull() {
        return rear == max - 1;
    }

    // enqueue
    void enqueue(String nama) {
        if (isFull()) {
            System.out.println("Antrian penuh");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        queue[++rear] = nama;
        System.out.println("Data berhasil ditambahkan ke antrian");
    }

    // dequeue
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        String nama = queue[front];
        if (front == rear) { // jika hanya ada 1 data
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        System.out.println(nama + " telah dilayani");
    }

    // display
    void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("Isi antrian:");
        int no = 1;
        for (int i = front; i <= rear; i++) {
            System.out.println(no + ". " + queue[i]);
            no++;
        }
    }

    // reverse
    void Reverse() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        int i = front;
        int j = rear;
        // tukar posisi elemen menggunakan perulangan
        while (i < j) {
            String temp = queue[i];
            queue[i] = queue[j];
            queue[j] = temp;
            i++;
            j--;
        }
        display(); // tampilkan langsung setelah direverse
    }

    // main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // inisialisasi antrian dengan kapasitas 10
        AntrianLoket_2511532001 loket = new AntrianLoket_2511532001(10);
        int pilihan;

        do {
            System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan buffer enter

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = sc.nextLine();
                    loket.enqueue(nama);
                    break;
                case 2:
                    loket.dequeue();
                    break;
                case 3:
                    loket.display();
                    break;
                case 4:
                    loket.Reverse();
                    break;
                case 5:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
        sc.close();
    }
}