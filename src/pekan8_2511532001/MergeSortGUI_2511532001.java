package pekan8_2511532001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MergeSortGUI_2511532001 extends JFrame {

    private static final long serialVersionUID_2001 = 1L;

    private int[] array_2001;
    private JLabel[] labelArray_2001;
    private JButton stepButton_2001, resetButton_2001, setButton_2001;
    private JTextField inputField_2001;
    private JPanel panelArray_2001;
    private JTextArea stepArea_2001;

    private int i_2001, j_2001, k_2001;
    private int left_2001, mid_2001, right_2001;
    private int[] temp_2001;

    private boolean isMerging_2001 = false;
    private boolean copying_2001 = false;
    private int stepCount_2001 = 1;

    private Queue<int[]> mergeQueue_2001 = new LinkedList<>();

    public MergeSortGUI_2511532001() {
        setTitle("Merge Sort Langkah per Langkah");
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
            for (int i_2001 = 0; i_2001 < parts_2001.length; i_2001++) {
                array_2001[i_2001] = Integer.parseInt(parts_2001[i_2001].trim());
            }
        } catch (NumberFormatException e_2001) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_2001 = new JLabel[array_2001.length];
        panelArray_2001.removeAll();

        for (int i_2001 = 0; i_2001 < array_2001.length; i_2001++) {
            labelArray_2001[i_2001] = new JLabel(String.valueOf(array_2001[i_2001]));
            labelArray_2001[i_2001].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2001[i_2001].setOpaque(true);
            labelArray_2001[i_2001].setBackground(Color.WHITE);
            labelArray_2001[i_2001].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2001[i_2001].setPreferredSize(new Dimension(50, 50));
            labelArray_2001[i_2001].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2001.add(labelArray_2001[i_2001]);
        }

        mergeQueue_2001.clear();
        generateMergeSteps_2001(0, array_2001.length - 1);

        stepButton_2001.setEnabled(true);
        stepArea_2001.setText("");
        stepCount_2001 = 1;
        isMerging_2001 = false;
        copying_2001 = false;

        panelArray_2001.revalidate();
        panelArray_2001.repaint();
    }

    private void generateMergeSteps_2001(int left_2001, int right_2001) {
        if (left_2001 < right_2001) {
            int mid_2001 = left_2001 + (right_2001 - left_2001) / 2;

            generateMergeSteps_2001(left_2001, mid_2001);
            generateMergeSteps_2001(mid_2001 + 1, right_2001);

            mergeQueue_2001.add(new int[] { left_2001, mid_2001, right_2001 });
        }
    }

    private void performStep_2001() {
        resetHighlights_2001();

        if (!isMerging_2001 && !mergeQueue_2001.isEmpty()) {
            int[] range_2001 = mergeQueue_2001.poll();

            left_2001 = range_2001[0];
            mid_2001 = range_2001[1];
            right_2001 = range_2001[2];

            temp_2001 = new int[right_2001 - left_2001 + 1];

            i_2001 = left_2001;
            j_2001 = mid_2001 + 1;
            k_2001 = 0;

            copying_2001 = false;
            isMerging_2001 = true;

            stepArea_2001.append(
                    "Langkah " + stepCount_2001++
                            + ": Mulai merge dari "
                            + left_2001 + " ke "
                            + right_2001 + "\n"
            );

            return;
        }

        if (isMerging_2001 && !copying_2001) {
            if (i_2001 <= mid_2001 && j_2001 <= right_2001) {
                labelArray_2001[i_2001].setBackground(Color.CYAN);
                labelArray_2001[j_2001].setBackground(Color.CYAN);

                if (array_2001[i_2001] <= array_2001[j_2001]) {
                    temp_2001[k_2001++] = array_2001[i_2001++];
                } else {
                    temp_2001[k_2001++] = array_2001[j_2001++];
                }

                stepArea_2001.append(
                        "Langkah " + stepCount_2001++
                                + ": Bandingkan dan salin elemen\n"
                );

                return;

            } else if (i_2001 <= mid_2001) {
                temp_2001[k_2001++] = array_2001[i_2001++];

                stepArea_2001.append(
                        "Langkah " + stepCount_2001++
                                + ": Salin sisa kiri\n"
                );

                return;

            } else if (j_2001 <= right_2001) {
                temp_2001[k_2001++] = array_2001[j_2001++];

                stepArea_2001.append(
                        "Langkah " + stepCount_2001++
                                + ": Salin sisa kanan\n"
                );

                return;

            } else {
                copying_2001 = true;
                k_2001 = 0;
                return;
            }
        }

        if (copying_2001 && k_2001 < temp_2001.length) {
            array_2001[left_2001 + k_2001] = temp_2001[k_2001];
            labelArray_2001[left_2001 + k_2001].setText(String.valueOf(temp_2001[k_2001]));
            labelArray_2001[left_2001 + k_2001].setBackground(Color.GREEN);
            k_2001++;

            stepArea_2001.append("Langkah " + stepCount_2001++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_2001 && k_2001 == temp_2001.length) {
            isMerging_2001 = false;
            copying_2001 = false;
        }

        if (mergeQueue_2001.isEmpty() && !isMerging_2001) {
            stepArea_2001.append("Selesai.\n");
            stepButton_2001.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights_2001() {
        if (labelArray_2001 == null) return;

        for (JLabel label_2001 : labelArray_2001) {
            label_2001.setBackground(Color.WHITE);
        }
    }

    private void reset_2001() {
        inputField_2001.setText("");
        panelArray_2001.removeAll();
        panelArray_2001.revalidate();
        panelArray_2001.repaint();
        stepArea_2001.setText("");
        stepButton_2001.setEnabled(false);
        mergeQueue_2001.clear();
        isMerging_2001 = false;
        copying_2001 = false;
        stepCount_2001 = 1;
    }

    public static void main(String[] args_2001) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511532001 frame_2001 = new MergeSortGUI_2511532001();
            frame_2001.setVisible(true);
        });
    }
}