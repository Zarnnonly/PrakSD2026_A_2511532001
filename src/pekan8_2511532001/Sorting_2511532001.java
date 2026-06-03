package pekan8_2511532001;
import java.util.Scanner;

// kelas ADT lagu
class Lagu_2511532001 {
    String judul_2001;
    String penyanyi_2001;
    int durasi_2001;

    public Lagu_2511532001(String judul_2001, String penyanyi_2001, int durasi_2001) {
        this.judul_2001 = judul_2001;
        this.penyanyi_2001 = penyanyi_2001;
        this.durasi_2001 = durasi_2001;
    }
}

public class Sorting_2511532001 {
    // array maksimal 20 lagu
    private Lagu_2511532001[] dataLagu_2001 = new Lagu_2511532001[20];
    private int jumlahLagu_2001 = 0;

    // method mengisi data awal (minimal 7 lagu)
    public void inputData_2001() {
        dataLagu_2001[0] = new Lagu_2511532001("Sunflower", "Rex Orange Country", 270);
        dataLagu_2001[1] = new Lagu_2511532001("Wildfire", "HOYO-MiX", 220);
        dataLagu_2001[2] = new Lagu_2511532001("Dark Red", "Steve Lacy", 252);
        dataLagu_2001[3] = new Lagu_2511532001("Hope Is the Thing With Feathers", "HOYO-MiX", 245);
        dataLagu_2001[4] = new Lagu_2511532001("White Night", "Jake Miller & HOYO-MiX", 210);
        dataLagu_2001[5] = new Lagu_2511532001("Harvey", "Her's", 196);
        dataLagu_2001[6] = new Lagu_2511532001("If I Can Stop One Heart From Breaking", "Robin", 235);
        dataLagu_2001[7] = new Lagu_2511532001("Bad Habit", "Steve Lacy", 232);
        dataLagu_2001[8] = new Lagu_2511532001("Dark Red", "Steve Lacy", 173);
        dataLagu_2001[9] = new Lagu_2511532001("Impostor Syndrome", "Sidney Gish", 294);
        dataLagu_2001[10] = new Lagu_2511532001("Shots (feat. Lil Jon)", "LMFAO", 222);
        dataLagu_2001[11] = new Lagu_2511532001("Love Epiphany", "Reality Club", 327);
        dataLagu_2001[12] = new Lagu_2511532001("2112", "Reality Club", 266);
        dataLagu_2001[13] = new Lagu_2511532001("Anything You Want", "Reality Club", 235);
        dataLagu_2001[14] = new Lagu_2511532001("I Wish I Was Your Joke", "Reality Club", 204);
        dataLagu_2001[15] = new Lagu_2511532001("Who Knows", "Daniel Caesar", 180);
        dataLagu_2001[16] = new Lagu_2511532001("Best Friend", "Rex Orange County", 264);
        dataLagu_2001[17] = new Lagu_2511532001("seasons", "wave to earth", 256);
        dataLagu_2001[18] = new Lagu_2511532001("daisy.", "wave to earth", 218);
        dataLagu_2001[19] = new Lagu_2511532001("bad", "wave to earth", 264);
        
        jumlahLagu_2001 = 20;
    }

    // method menampilkan data sebelum/sesudah
    public void tampilData_2001(String status_2001) {
        System.out.println(status_2001);
        for (int i_2001 = 0; i_2001 < jumlahLagu_2001; i_2001++) {
            System.out.println((i_2001 + 1) + ". " + dataLagu_2001[i_2001].judul_2001 + " - " + dataLagu_2001[i_2001].durasi_2001 + " detik");
        }
        System.out.println();
    }

    // shell sort
    public void shellSort_2001() {
        for (int gap_2001 = jumlahLagu_2001 / 2; gap_2001 > 0; gap_2001 /= 2) {
            for (int i_2001 = gap_2001; i_2001 < jumlahLagu_2001; i_2001++) {
                Lagu_2511532001 temp_2001 = dataLagu_2001[i_2001];
                int j_2001;
                for (j_2001 = i_2001; j_2001 >= gap_2001 && dataLagu_2001[j_2001 - gap_2001].judul_2001.compareToIgnoreCase(temp_2001.judul_2001) > 0; j_2001 -= gap_2001) {
                    dataLagu_2001[j_2001] = dataLagu_2001[j_2001 - gap_2001];
                }
                dataLagu_2001[j_2001] = temp_2001;
            }
        }
    }

    // quick sort
    private void swap_2001(int i_2001, int j_2001) {
        Lagu_2511532001 temp_2001 = dataLagu_2001[i_2001];
        dataLagu_2001[i_2001] = dataLagu_2001[j_2001];
        dataLagu_2001[j_2001] = temp_2001;
    }

    private int partition_2001(int low_2001, int high_2001) {
        int pivot_2001 = dataLagu_2001[high_2001].durasi_2001;
        int i_2001 = (low_2001 - 1);
        for (int j_2001 = low_2001; j_2001 <= high_2001 - 1; j_2001++) {
            if (dataLagu_2001[j_2001].durasi_2001 <= pivot_2001) {
                i_2001++;
                swap_2001(i_2001, j_2001);
            }
        }
        swap_2001(i_2001 + 1, high_2001);
        return (i_2001 + 1);
    }

    public void quickSort_2001(int low_2001, int high_2001) {
        if (low_2001 < high_2001) {
            int pi_2001 = partition_2001(low_2001, high_2001);
            quickSort_2001(low_2001, pi_2001 - 1);
            quickSort_2001(pi_2001 + 1, high_2001);
        }
    }

    // merge sort
    private void merge_2001(int left_2001, int mid_2001, int right_2001) {
        int n1_2001 = mid_2001 - left_2001 + 1;
        int n2_2001 = right_2001 - mid_2001;

        Lagu_2511532001[] L_2001 = new Lagu_2511532001[n1_2001];
        Lagu_2511532001[] R_2001 = new Lagu_2511532001[n2_2001];

        for (int i_2001 = 0; i_2001 < n1_2001; ++i_2001)
            L_2001[i_2001] = dataLagu_2001[left_2001 + i_2001];
        for (int j_2001 = 0; j_2001 < n2_2001; ++j_2001)
            R_2001[j_2001] = dataLagu_2001[mid_2001 + 1 + j_2001];

        int i_2001 = 0, j_2001 = 0;
        int k_2001 = left_2001;
        
        while (i_2001 < n1_2001 && j_2001 < n2_2001) {
            // bandingkan judul secara alfabetis (A-Z) mengabaikan kapital
            if (L_2001[i_2001].judul_2001.compareToIgnoreCase(R_2001[j_2001].judul_2001) <= 0) {
                dataLagu_2001[k_2001] = L_2001[i_2001];
                i_2001++;
            } else {
                dataLagu_2001[k_2001] = R_2001[j_2001];
                j_2001++;
            }
            k_2001++;
        }

        while (i_2001 < n1_2001) {
            dataLagu_2001[k_2001] = L_2001[i_2001];
            i_2001++;
            k_2001++;
        }

        while (j_2001 < n2_2001) {
            dataLagu_2001[k_2001] = R_2001[j_2001];
            j_2001++;
            k_2001++;
        }
    }

    public void mergeSort_2001(int left_2001, int right_2001) {
        if (left_2001 < right_2001) {
            int mid_2001 = left_2001 + (right_2001 - left_2001) / 2;

            mergeSort_2001(left_2001, mid_2001);
            mergeSort_2001(mid_2001 + 1, right_2001);

            merge_2001(left_2001, mid_2001, right_2001);
        }
    }

    public static void main(String[] args) {
        Scanner sc_2001 = new Scanner(System.in);
        Sorting_2511532001 playlist_2001 = new Sorting_2511532001();
        
        System.out.println("Sorting Playlist NIM: 2511532001");
        System.out.print("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
        int pilihan_2001 = sc_2001.nextInt();

        // inisialisasi data mentah
        playlist_2001.inputData_2001();
        playlist_2001.tampilData_2001("Data Sebelum Sorting:");

        switch (pilihan_2001) {
            case 1:
                playlist_2001.shellSort_2001();
                playlist_2001.tampilData_2001("Data Setelah Shell Sort (Judul A-Z):");
                break;
            case 2:
                playlist_2001.quickSort_2001(0, playlist_2001.jumlahLagu_2001 - 1);
                playlist_2001.tampilData_2001("Data Setelah Quick Sort (Durasi Asc):");
                break;
            case 3:
                playlist_2001.mergeSort_2001(0, playlist_2001.jumlahLagu_2001 - 1);
                playlist_2001.tampilData_2001("Data Setelah Merge Sort (Judul A-Z):");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
        sc_2001.close();
    }
}