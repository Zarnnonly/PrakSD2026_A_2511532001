package pekan7_2511532001;

public class InsertionSort_2511532001 {
	public static void InsertionSort_2511532001 (int[]arr){
		int n_2001 = arr.length;
		for (int i = 1; i < n_2001; i++) {
			int key_2001 = arr[i];
			int j_2001 = i-1;
			
			while (j_2001 >= 0 && arr[j_2001] > key_2001) {
				arr[j_2001+1] = arr[j_2001];
				j_2001--;
			}
			arr[j_2001+1] = key_2001;
		}
	}
		
		
	public static void main(String[]args) {
		int arr[] = { 23,78,45,8,32,56,1 };
		int n_2001 = arr.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i = 0; i < n_2001; i++ )
			System.out.print(arr[i] + " ");
		System.out.println(" ");
		InsertionSort_2511532001(arr);
		System.out.printf("array yang terurut:\n");
		for (int i = 1; i < n_2001; i++) 
			System.out.print(arr[i] + " ");
		System.out.println(" ");


		}
		
	}


