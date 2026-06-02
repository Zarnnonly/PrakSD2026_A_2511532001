package pekan8_2511532001;

public class MergeSort_2511532001 {
    void merge_2001(int arr_2001[], int l_2001, int m_2001, int r_2001) {
        // Find sizes of two subarrays to be merged
        int n1_2001 = m_2001 - l_2001 + 1;
        int n2_2001 = r_2001 - m_2001;

        /* Create temp arrays */
        int L_2001[] = new int[n1_2001];
        int R_2001[] = new int[n2_2001];

        /* Copy data to temp arrays */
        for (int i_2001 = 0; i_2001 < n1_2001; ++i_2001)
            L_2001[i_2001] = arr_2001[l_2001 + i_2001];

        for (int j_2001 = 0; j_2001 < n2_2001; ++j_2001)
            R_2001[j_2001] = arr_2001[m_2001 + 1 + j_2001];

        int i_2001 = 0, j_2001 = 0;

        // Initial index of merged subarray array
        int k_2001 = l_2001;
        while (i_2001 < n1_2001 && j_2001 < n2_2001) {
            if (L_2001[i_2001] <= R_2001[j_2001]) {
                arr_2001[k_2001] = L_2001[i_2001];
                i_2001++;
            } else {
                arr_2001[k_2001] = R_2001[j_2001];
                j_2001++;
            }
            k_2001++;
        }

        /* Copy remaining elements of L[] if any */
        while (i_2001 < n1_2001) {
            arr_2001[k_2001] = L_2001[i_2001];
            i_2001++;
            k_2001++;
        }

        /* Copy remaining elements of R[] if any */
        while (j_2001 < n2_2001) {
            arr_2001[k_2001] = R_2001[j_2001];
            j_2001++;
            k_2001++;
        }
    }
    void sort_2001 (int arr[], int l_2001, int r_2001) {
    	if (r_2001 < l_2001) {
    		// find
    		int m_2001 = (1+l_2001) / 2;
    		// soft
    		sort_2001 (arr, 1, m_2001);
    		sort_2001 (arr, m_2001 + 1, r_2001);
    		// merge
    		merge_2001(arr, 1, m_2001, l_2001);
    	}
    }
    static void printArray_2001(int arr[]) {
    	int n = arr.length;
    	for (int i = 0; i < n; ++i) {
    		System.out.print(arr[i] + " ");
    	System.out.println();
    	}
    }
    public static void main(String args[]) {
    	int arr[] = { 12, 11, 13, 5, 6, 7};
    	System.out.println("Sebelum terurut");
    	printArray_2001(arr);
    	MergeSort_2511532001 ob = new MergeSort_2511532001();
    	ob.sort_2001(arr, 0, arr.length - 1);
    	System.out.println("\nSesudah terurut menggunakan merge sort");
    	printArray_2001(arr);
    }
}