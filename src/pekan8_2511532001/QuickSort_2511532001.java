package pekan8_2511532001;

public class QuickSort_2511532001 {
    static void swap_2001(int[] arr_2001, int i_2001, int j_2001) {
        int temp_2001 = arr_2001[i_2001];
        arr_2001[i_2001] = arr_2001[j_2001];
        arr_2001[j_2001] = temp_2001;
    }

    // Metode tambahan untuk mengatur pivot menggunakan Median-of-Three
    static void medianOfThree_2001(int[] arr_2001, int low_2001, int high_2001) {
        int mid_2001 = low_2001 + (high_2001 - low_2001) / 2;

        // Urutkan elemen low, mid, dan high
        if (arr_2001[low_2001] > arr_2001[mid_2001]) {
            swap_2001(arr_2001, low_2001, mid_2001);
        }
        if (arr_2001[low_2001] > arr_2001[high_2001]) {
            swap_2001(arr_2001, low_2001, high_2001);
        }
        if (arr_2001[mid_2001] > arr_2001[high_2001]) {
            swap_2001(arr_2001, mid_2001, high_2001);
        }
        swap_2001(arr_2001, mid_2001, high_2001);
    }

    static int partition_2001(int[] arr_2001, int low_2001, int high_2001) {
        // Panggil fungsi medianOfThree sebelum menentukan pivot
        medianOfThree_2001(arr_2001, low_2001, high_2001);

        int pivot_2001 = arr_2001[high_2001]; // Sekarang arr[high] sudah berisi nilai median
        int i_2001 = (low_2001 - 1);

        for (int j_2001 = low_2001; j_2001 <= high_2001 - 1; j_2001++) {
            // Jika elemen saat ini lebih kecil dari atau sama dengan pivot
            if (arr_2001[j_2001] < pivot_2001) {
                // Increment indeks elemen yang lebih kecil
                i_2001++;
                swap_2001(arr_2001, i_2001, j_2001);
            }
        }
        swap_2001(arr_2001, i_2001 + 1, high_2001);
        return (i_2001 + 1);
    }
    static void quickSort_2001(int[] arr_2001, int low_2001, int high_2001) {
        if (low_2001 < high_2001) {
            int pi_2001 = partition_2001(arr_2001, low_2001, high_2001);

            quickSort_2001(arr_2001, low_2001, pi_2001 - 1);
            quickSort_2001(arr_2001, pi_2001 + 1, high_2001);
        }
    }

    public static void printArr_2001(int[] arr_2001) {
        for (int i_2001 = 0; i_2001 < arr_2001.length; i_2001++) {
            System.out.print(arr_2001[i_2001] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr_2001 = { 10, 7, 8, 9, 1, 5 };
        int N_2001 = arr_2001.length;

        System.out.print("Data sebelum diurutkan: ");
        printArr_2001(arr_2001);

        quickSort_2001(arr_2001, 0, N_2001 - 1);

        System.out.print("Data Terurut QuickSort: ");
        printArr_2001(arr_2001);
    }
}