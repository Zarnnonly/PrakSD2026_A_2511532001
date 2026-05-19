package pekan7_2511532001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class InsertionSortGUI_2511532001 extends JFrame {

    private static final long serialVersionUID_2001 = 1L;
    private int[] array_2001;
    private JLabel[] labelArray_2001;
    private JButton stepButton_2001, resetButton_2001, setButton_2001;
    private JTextField inputField_2001;
    private JPanel panelArray_2001;
    private JTextArea stepArea_2001;

    private int i_2001 = 1, j_2001;
    private boolean sorting_2001 = false;
    private int stepCount_2001 = 1;

    private JPanel contentPane_2001;

    /**
     * Create the frame.
     */
    public InsertionSortGUI_2511532001() {
    	 setTitle("Insertion Sort Langkah per Langkah");
    	    setSize(750, 400);
    	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    setLocationRelativeTo(null);
    	    setLayout(new BorderLayout());

    	    // Panel input
    	    JPanel inputPanel_2001 = new JPanel(new FlowLayout());
    	    inputField_2001 = new JTextField(30);
    	    setButton_2001 = new JButton("Set Array");
    	    inputPanel_2001.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
    	    inputPanel_2001.add(inputField_2001);
    	    inputPanel_2001.add(setButton_2001);

    	    // Panel array visual
    	    panelArray_2001 = new JPanel();
    	    panelArray_2001.setLayout(new FlowLayout());

    	    // Panel kontrol
    	    JPanel controlPanel_2001 = new JPanel();
    	    stepButton_2001 = new JButton("Langkah Selanjutnya");
    	    resetButton_2001 = new JButton("Reset");
    	    stepButton_2001.setEnabled(false);
    	    controlPanel_2001.add(stepButton_2001);
    	    controlPanel_2001.add(resetButton_2001);
    	    
    	 // Area teks untuk log langkah-langkah
    	    stepArea_2001 = new JTextArea(8, 60);
    	    stepArea_2001.setEditable(false);
    	    stepArea_2001.setFont(new Font("Monospaced", Font.PLAIN, 14));
    	    JScrollPane scrollPane_2001 = new JScrollPane(stepArea_2001);

    	    // Tambahkan panel ke frame
    	    add(inputPanel_2001, BorderLayout.NORTH);
    	    add(panelArray_2001, BorderLayout.CENTER);
    	    add(controlPanel_2001, BorderLayout.SOUTH);
    	    add(scrollPane_2001, BorderLayout.EAST);

    	    // Event Set Array
    	    setButton_2001.addActionListener(e_2001 -> setArrayFromInput_2001());

    	    // Event Langkah Selanjutnya
    	    stepButton_2001.addActionListener(e_2001 -> performStep_2001());

    	    // Event Reset
    	    resetButton_2001.addActionListener(e_2001 -> reset_2001());
    	}
    private void setArrayFromInput_2001() {
        String text_2001 = inputField_2001.getText().trim();
        if (text_2001.isEmpty()) return;
        String[] parts_2001 = text_2001.split(",");
        array_2001 = new int[parts_2001.length];
        try {
            for (int k_2001 = 0; k_2001 < parts_2001.length; k_2001++) {
                array_2001[k_2001] = Integer.parseInt(parts_2001[k_2001].trim());
            }
        } catch (NumberFormatException e_2001) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan "
                    + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        i_2001 = 1;
        stepCount_2001 = 1;
        sorting_2001 = true;
        stepButton_2001.setEnabled(true);
        stepArea_2001.setText("");
        panelArray_2001.removeAll();
        labelArray_2001 = new JLabel[array_2001.length];

        for (int k_2001 = 0; k_2001 < array_2001.length; k_2001++) {
            labelArray_2001[k_2001] = new JLabel(String.valueOf(array_2001[k_2001]));
            labelArray_2001[k_2001].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2001[k_2001].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2001[k_2001].setPreferredSize(new Dimension(50, 50));
            labelArray_2001[k_2001].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2001.add(labelArray_2001[k_2001]);
        }

        panelArray_2001.revalidate();
        panelArray_2001.repaint();
    }
    private void performStep_2001() {
        if (i_2001 < array_2001.length && sorting_2001) {
            int key_2001 = array_2001[i_2001];
            j_2001 = i_2001 - 1;

            StringBuilder stepLog_2001 = new StringBuilder();
            stepLog_2001.append("Langkah ").append(stepCount_2001)
                    .append(": Memasukkan ").append(key_2001).append("\n");

            while (j_2001 >= 0 && array_2001[j_2001] > key_2001) {
                array_2001[j_2001 + 1] = array_2001[j_2001];
                j_2001--;
            }
            array_2001[j_2001 + 1] = key_2001;

            updateLabels_2001();
            stepLog_2001.append("Hasil: ").append(arrayToString_2001(array_2001)).append("\n\n");
            stepArea_2001.append(stepLog_2001.toString());

            i_2001++;
            stepCount_2001++;

            if (i_2001 == array_2001.length) {
                sorting_2001 = false;
                stepButton_2001.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Sorting selesai!");
            }
        }
    }
    private void updateLabels_2001() {
        for (int k_2001 = 0; k_2001 < array_2001.length; k_2001++) {
            labelArray_2001[k_2001].setText(String.valueOf(array_2001[k_2001]));
        }
    }

    private void reset_2001() {
        inputField_2001.setText("");
        panelArray_2001.removeAll();
        panelArray_2001.revalidate();
        panelArray_2001.repaint();
        stepArea_2001.setText("");
        stepButton_2001.setEnabled(false);
        sorting_2001 = false;
        i_2001 = 1;
        stepCount_2001 = 1;
    }

    private String arrayToString_2001(int[] arr_2001) {
        StringBuilder sb_2001 = new StringBuilder();
        for (int k_2001 = 0; k_2001 < arr_2001.length; k_2001++) {
            sb_2001.append(arr_2001[k_2001]);
            if (k_2001 < arr_2001.length - 1) sb_2001.append(", ");
        }
        return sb_2001.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InsertionSortGUI_2511532001 gui_2001 = new InsertionSortGUI_2511532001();
            gui_2001.setVisible(true);
        });
    }
}