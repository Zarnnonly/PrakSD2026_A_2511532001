package pekan8_2511532001;

public class shellSort_2511532001 {
    public static void shellSort_2001(int[] A_2001) {
        int n_2001 = A_2001.length;
        int gap_2001 = n_2001 / 2;

        while (gap_2001 > 0) {
            for (int i_2001 = gap_2001; i_2001 < n_2001; i_2001++) {
                int temp_2001 = A_2001[i_2001];
                int j_2001 = i_2001;

                while (j_2001 >= gap_2001 && A_2001[j_2001 - gap_2001] > temp_2001) {
                    A_2001[j_2001] = A_2001[j_2001 - gap_2001];
                    j_2001 = j_2001 - gap_2001;
                }

                A_2001[j_2001] = temp_2001;
            }

            gap_2001 = gap_2001 / 2;
        }
    }

    public static void main(String[] args) {
        int[] data_2001 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};

        System.out.print("Sebelum: ");
        printArray_2001(data_2001);

        shellSort_2001(data_2001);

        System.out.print("Sesudah (Shell Sort): ");
        printArray_2001(data_2001);
    }

    public static void printArray_2001(int[] arr_2001) {
        for (int i_2001 : arr_2001) {
            System.out.print(i_2001 + " ");
        }
        System.out.println();
    }
}