package pekan7_2511532001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TugasSortingGUI_2511532001 extends JFrame {
    private ArrayList<Mahasiswa_2511532001> listMahasiswa_2001;
    
    private JTextField txtNama_2001, txtNim_2001, txtProdi_2001;
    private JComboBox<String> comboSort_2001;
    private JTextArea txtVisualisasi_2001;

    public TugasSortingGUI_2511532001() {
        listMahasiswa_2001 = new ArrayList<>();

        setTitle("Program Sorting Mahasiswa - 2511532001");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // panel Input (atas)
        JPanel panelInput_2001 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_2001.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput_2001.add(new JLabel("Nama Mahasiswa:"));
        txtNama_2001 = new JTextField();
        panelInput_2001.add(txtNama_2001);

        panelInput_2001.add(new JLabel("NIM:"));
        txtNim_2001 = new JTextField();
        panelInput_2001.add(txtNim_2001);

        panelInput_2001.add(new JLabel("Program Studi:"));
        txtProdi_2001 = new JTextField();
        panelInput_2001.add(txtProdi_2001);

        JButton btnTambah_2001 = new JButton("Tambah Data");
        JButton btnReset_2001 = new JButton("Reset Data");
        panelInput_2001.add(btnTambah_2001);
        panelInput_2001.add(btnReset_2001);

        add(panelInput_2001, BorderLayout.NORTH);

        // panel tengah (visualisasi dan tabel)
        txtVisualisasi_2001 = new JTextArea();
        txtVisualisasi_2001.setEditable(false);
        txtVisualisasi_2001.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll_2001 = new JScrollPane(txtVisualisasi_2001);
        scroll_2001.setBorder(BorderFactory.createTitledBorder("Visualisasi Sorting & Hasil"));
        add(scroll_2001, BorderLayout.CENTER);

        // panel bawah (kontrol sorting)
        JPanel panelKontrol_2001 = new JPanel(new FlowLayout());
        String[] metodeSort_2001 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        comboSort_2001 = new JComboBox<>(metodeSort_2001);
        JButton btnSort_2001 = new JButton("Mulai Sorting");

        panelKontrol_2001.add(new JLabel("Pilih Metode: "));
        panelKontrol_2001.add(comboSort_2001);
        panelKontrol_2001.add(btnSort_2001);

        add(panelKontrol_2001, BorderLayout.SOUTH);

        // event listener tombol tambah
        btnTambah_2001.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama_2001 = txtNama_2001.getText();
                String nim_2001 = txtNim_2001.getText();
                String prodi_2001 = txtProdi_2001.getText();

                if (!nama_2001.isEmpty() && !nim_2001.isEmpty() && !prodi_2001.isEmpty()) {
                    listMahasiswa_2001.add(new Mahasiswa_2511532001(nama_2001, nim_2001, prodi_2001));
                    tampilkanDataMentah_2001();
                    txtNama_2001.setText(""); txtNim_2001.setText(""); txtProdi_2001.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Isi semua data!");
                }
            }
        });

        // event listener tombol rset
        btnReset_2001.addActionListener(e -> {
            listMahasiswa_2001.clear();
            txtVisualisasi_2001.setText("Data telah di-reset.");
        });

        // event listener tombol sorting
        btnSort_2001.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listMahasiswa_2001.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data kosong! Tambahkan data dulu.");
                    return;
                }
                
                // copy data agar array list asli tidak berubah (untuk mengetes algo lain)
                ArrayList<Mahasiswa_2511532001> listCopy_2001 = new ArrayList<>(listMahasiswa_2001);
                String pilihan_2001 = (String) comboSort_2001.getSelectedItem();
                
                txtVisualisasi_2001.setText("=== " + pilihan_2001.toUpperCase() + " ===\n");
                txtVisualisasi_2001.append("Data Awal: " + dapatkanHanyaNama_2001(listCopy_2001) + "\n\n");

                if (pilihan_2001.equals("Insertion Sort")) {
                    insertionSort_2001(listCopy_2001);
                } else if (pilihan_2001.equals("Selection Sort")) {
                    selectionSort_2001(listCopy_2001);
                } else {
                    bubbleSort_2001(listCopy_2001);
                }

                txtVisualisasi_2001.append("\n=== HASIL AKHIR ===\n");
                for (Mahasiswa_2511532001 mhs_2001 : listCopy_2001) {
                    txtVisualisasi_2001.append(mhs_2001.toString() + "\n");
                }
            }
        });
    }

    private void tampilkanDataMentah_2001() {
        txtVisualisasi_2001.setText("Data Saat Ini:\n");
        for (Mahasiswa_2511532001 mhs_2001 : listMahasiswa_2001) {
            txtVisualisasi_2001.append(mhs_2001.toString() + "\n");
        }
    }

    private String dapatkanHanyaNama_2001(ArrayList<Mahasiswa_2511532001> list_2001) {
        StringBuilder sb_2001 = new StringBuilder("[");
        for (int i = 0; i < list_2001.size(); i++) {
            sb_2001.append(list_2001.get(i).getNama_2001());
            if (i < list_2001.size() - 1) sb_2001.append(", ");
        }
        sb_2001.append("]");
        return sb_2001.toString();
    }

    // algoritma sorting

    private void insertionSort_2001(ArrayList<Mahasiswa_2511532001> arr_2001) {
        int n_2001 = arr_2001.size();
        for (int i_2001 = 1; i_2001 < n_2001; i_2001++) {
            Mahasiswa_2511532001 key_2001 = arr_2001.get(i_2001);
            int j_2001 = i_2001 - 1;

            // compareToIgnoreCase menghasilkan > 0 jika string pertama lebih besar secara alfabetis
            while (j_2001 >= 0 && arr_2001.get(j_2001).getNama_2001().compareToIgnoreCase(key_2001.getNama_2001()) > 0) {
                arr_2001.set(j_2001 + 1, arr_2001.get(j_2001));
                j_2001--;
            }
            arr_2001.set(j_2001 + 1, key_2001);
            
            txtVisualisasi_2001.append("Langkah " + i_2001 + ": " + dapatkanHanyaNama_2001(arr_2001) + "\n");
        }
    }

    private void selectionSort_2001(ArrayList<Mahasiswa_2511532001> arr_2001) {
        int n_2001 = arr_2001.size();
        for (int i_2001 = 0; i_2001 < n_2001 - 1; i_2001++) {
            int minIdx_2001 = i_2001;
            for (int j_2001 = i_2001 + 1; j_2001 < n_2001; j_2001++) {
                if (arr_2001.get(j_2001).getNama_2001().compareToIgnoreCase(arr_2001.get(minIdx_2001).getNama_2001()) < 0) {
                    minIdx_2001 = j_2001;
                }
            }
            // swap
            Mahasiswa_2511532001 temp_2001 = arr_2001.get(minIdx_2001);
            arr_2001.set(minIdx_2001, arr_2001.get(i_2001));
            arr_2001.set(i_2001, temp_2001);

            txtVisualisasi_2001.append("Pass " + (i_2001 + 1) + ": " + dapatkanHanyaNama_2001(arr_2001) + "\n");
        }
    }

    private void bubbleSort_2001(ArrayList<Mahasiswa_2511532001> arr_2001) {
        int n_2001 = arr_2001.size();
        for (int i_2001 = 0; i_2001 < n_2001 - 1; i_2001++) {
            for (int j_2001 = 0; j_2001 < n_2001 - i_2001 - 1; j_2001++) {
                if (arr_2001.get(j_2001).getNama_2001().compareToIgnoreCase(arr_2001.get(j_2001 + 1).getNama_2001()) > 0) {
                    // Swap
                    Mahasiswa_2511532001 temp_2001 = arr_2001.get(j_2001);
                    arr_2001.set(j_2001, arr_2001.get(j_2001 + 1));
                    arr_2001.set(j_2001 + 1, temp_2001);
                }
            }
            txtVisualisasi_2001.append("Pass " + (i_2001 + 1) + ": " + dapatkanHanyaNama_2001(arr_2001) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasSortingGUI_2511532001().setVisible(true);
        });
    }
}