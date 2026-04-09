package pekan3_2511532001;
import java.util.ArrayList;

class Siswa_2001 {
	String nama_2001;
	int nim_2001;
	
	public Siswa_2001(String nama_2001, int nim_2001) {
		this.nama_2001 = nama_2001;
		this.nim_2001 = nim_2001;
	}
	
	@Override
	public String toString() {
		return "Nim: " + nim_2001 + ", Nama: " + nama_2001;
	}
}

public class SiswaStack_2511532001 {
	private ArrayList<Siswa_2001> stack_2001;
	
	public SiswaStack_2511532001() {
		stack_2001 = new ArrayList<Siswa_2001>();
	}

	public void push(Siswa_2001 mhs) {
		stack_2001.add(mhs);
	}
	public Siswa_2001 pop_2001() {
		if (!isEmpty_2001()) {
			return stack_2001.remove(stack_2001.size() - 1);
		}
		return null;
	}
	public Siswa_2001 peek_2001() {
		if (!isEmpty_2001()) {
			return stack_2001.get(stack_2001.size() - 1);
		}
		return null;
	}
	
	public boolean isEmpty_2001() {
		return stack_2001.isEmpty();
	}
	
	public void tampilkanSiswa_2001() {
		for (int i = stack_2001.size() - 1; i >= 0; i--) {
			System.out.println(stack_2001.get(i));
		}
	}
	public static void main(String[]args) {
		SiswaStack_2511532001 studentStack_2001 = new SiswaStack_2511532001();
		
		Siswa_2001 mhs1_2001 = new Siswa_2001("Ali", 1);
		Siswa_2001 mhs2_2001 = new Siswa_2001("Boby", 2);
		Siswa_2001 mhs3_2001 = new Siswa_2001("Charles", 3);
		
		studentStack_2001.push(mhs1_2001);
		studentStack_2001.push(mhs2_2001);
		studentStack_2001.push(mhs3_2001);
		
		System.out.println("Siswa di dalam stack: ");
		studentStack_2001.tampilkanSiswa_2001();
		
		System.out.println("siswa teratas " + studentStack_2001.peek_2001());
		System.out.println("mengeluarkan siswa teratas dari stack :" + studentStack_2001.pop_2001());
		System.out.println("daftar siswa setelah di pop:");
		studentStack_2001.tampilkanSiswa_2001();
	}
}
