package pekan2_2511532001;
import java.util.*;

public class DaftarKata_2511532001 {
	private final ArrayList<String> data;
	// Konstruksi
	public DaftarKata_2511532001() {
		this.data = new ArrayList<>();
	}
	/** Menambahkan elemen di akhir list. */
	public void tambah_2511532001 (String elemen) {
		data.add(elemen);
	}
	/**Menambahkan elemen pada indeks tertentu*/
	public void tambahPada_2511532001(int index, String elemen) {
		data.add(index, elemen);
	}
	/**
	 * Mengubah elemen pada posisi 'index' menjadi 'nilaiBaru'
	 * Bertindak sebagai "setter" untuk elemen tertentu"
	 */
	public void ubahElemen_2511532001(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	/**
	 * Menghapus elemen pada posisi 'index' dan mengembalikan nilai yang dihapus
	 */
	public String hapusElemen_2511532001(int index) {
		return data.remove(index);
	}
	/**
	 * Melakukan iterasi dan mencetak setiap elemen dalam format: [index] nilai
	 * (Metode ini tidak mengembalikan nilai; hanya demonstrasi iterasi)
	 */
	public void iterasiCetak_2511532001() {
		for (int i = 0; i < data.size(); i++)
			System.out.print(data.get(i) + " ");
		}
	//
	public String get (int index) {
		return data.get(index);
	}
	
	//
	@Override
	public String toString() {
		return data.toString();
	}
	}
