package pekan7_2511532001;

public class BubbleSort_2511532001 {
    public static void bubbleSort_2001(int[] arr_2001) {
        int n_2001 = arr_2001.length;
        for (int i_2001 = 0; i_2001 < n_2001; i_2001++) {
            for (int j_2001 = 0; j_2001 < n_2001 - i_2001 - 1; j_2001++) {
                if (arr_2001[j_2001] > arr_2001[j_2001 + 1]) {
                    int temp_2001 = arr_2001[j_2001];
                    arr_2001[j_2001] = arr_2001[j_2001 + 1];
                    arr_2001[j_2001 + 1] = temp_2001;
                    // System.out.println("data:"+arr[j]+" "+arr[j+1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr_2001[] = { 23, 78, 45, 8, 32, 56, 1 };
        int n_2001 = arr_2001.length;
        System.out.print("array yang belum terurut:");
        for (int i_2001 = 0; i_2001 < n_2001; i_2001++)
            System.out.print(arr_2001[i_2001] + " ");
        System.out.println("");
        bubbleSort_2001(arr_2001);
        System.out.print("array yang terurut menggunakan BubleSort:");
        for (int i_2001 = 0; i_2001 < n_2001; i_2001++)
            System.out.print(arr_2001[i_2001] + " ");
        System.out.println("");
    }
}