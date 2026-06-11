package pekan9_2511532001;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PetaKampus_2511532001 extends JFrame {

    // Struktur Data Graph
    private Map<String, List<String>> graph_2001;
    private Map<String, Point> nodeCoords_2001;
    
    // Variabel state untuk visualisasi
    private List<String> visitedNodes_2001;
    private List<String> pathNodes_2001;
    private int nodesExplored_2001 = 0;

    // Komponen GUI
    private JComboBox<String> startCombo_2001;
    private JComboBox<String> goalCombo_2001;
    private JTextArea resultArea_2001;
    private GraphPanel_2001 panelGraph_2001;

    public PetaKampus_2511532001() {
        setTitle("Pencarian Jalur Kampus Unand - BFS & DFS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initGraphData_2001();

        // Panel Atas (Kontrol)
        JPanel controlPanel_2001 = new JPanel(new FlowLayout());
        
        String[] nodes_2001 = nodeCoords_2001.keySet().toArray(new String[0]);
        Arrays.sort(nodes_2001); // Urutkan alfabetis untuk combobox
        
        startCombo_2001 = new JComboBox<>(nodes_2001);
        goalCombo_2001 = new JComboBox<>(nodes_2001);
        
        JButton btnBFS_2001 = new JButton("BFS");
        btnBFS_2001.setBackground(new Color(144, 238, 144));
        
        JButton btnDFS_2001 = new JButton("DFS");
        btnDFS_2001.setBackground(new Color(255, 204, 102));
        
        JButton btnReset_2001 = new JButton("RESET");
        btnReset_2001.setBackground(new Color(255, 102, 102));
        btnReset_2001.setForeground(Color.WHITE);

        controlPanel_2001.add(new JLabel("Lokasi Awal:"));
        controlPanel_2001.add(startCombo_2001);
        controlPanel_2001.add(new JLabel("Lokasi Tujuan:"));
        controlPanel_2001.add(goalCombo_2001);
        controlPanel_2001.add(btnBFS_2001);
        controlPanel_2001.add(btnDFS_2001);
        controlPanel_2001.add(btnReset_2001);

        // Panel Tengah (Visualisasi Graph)
        panelGraph_2001 = new GraphPanel_2001();
        panelGraph_2001.setBackground(Color.WHITE);
        panelGraph_2001.setBorder(BorderFactory.createTitledBorder("VISUALISASI GRAPH"));

        // Panel Bawah (Hasil)
        resultArea_2001 = new JTextArea(6, 50);
        resultArea_2001.setEditable(false);
        resultArea_2001.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollResult_2001 = new JScrollPane(resultArea_2001);
        scrollResult_2001.setBorder(BorderFactory.createTitledBorder("Hasil Pencarian"));

        add(controlPanel_2001, BorderLayout.NORTH);
        add(panelGraph_2001, BorderLayout.CENTER);
        add(scrollResult_2001, BorderLayout.SOUTH);

        // Event Listeners
        btnBFS_2001.addActionListener(e -> BFS_2001());
        btnDFS_2001.addActionListener(e -> DFS_2001());
        btnReset_2001.addActionListener(e -> resetGraph_2001());

        resetGraph_2001(); // Inisialisasi awal
    }

    private void initGraphData_2001() {
        graph_2001 = new HashMap<>();
        nodeCoords_2001 = new HashMap<>();
        
        // Inisialisasi 10 Node beserta koordinat GUI-nya
        nodeCoords_2001.put("Gerbang", new Point(100, 200));
        nodeCoords_2001.put("Masjid", new Point(250, 300));
        nodeCoords_2001.put("Asrama", new Point(250, 100));
        nodeCoords_2001.put("Rektorat", new Point(250, 200));
        nodeCoords_2001.put("Perpus", new Point(450, 100));
        nodeCoords_2001.put("PKM", new Point(450, 300));
        nodeCoords_2001.put("Fak_Ekonomi", new Point(450, 200));
        nodeCoords_2001.put("Fak_Hukum", new Point(650, 100));
        nodeCoords_2001.put("FMIPA", new Point(650, 200));
        nodeCoords_2001.put("FTI", new Point(650, 300));

        for (String node : nodeCoords_2001.keySet()) {
            graph_2001.put(node, new ArrayList<>());
        }

        // Inisialisasi 15 Edge
        addEdge_2001("Gerbang", "Rektorat");
        addEdge_2001("Gerbang", "Masjid");
        addEdge_2001("Gerbang", "Asrama");
        addEdge_2001("Rektorat", "Fak_Ekonomi");
        addEdge_2001("Rektorat", "Perpus");
        addEdge_2001("Rektorat", "PKM");
        addEdge_2001("Masjid", "PKM");
        addEdge_2001("Asrama", "Perpus");
        addEdge_2001("Perpus", "Fak_Hukum");
        addEdge_2001("Perpus", "Fak_Ekonomi");
        addEdge_2001("PKM", "Fak_Ekonomi");
        addEdge_2001("PKM", "FTI");
        addEdge_2001("Fak_Ekonomi", "FMIPA");
        addEdge_2001("Fak_Hukum", "FMIPA");
        addEdge_2001("FMIPA", "FTI");
    }

    private void addEdge_2001(String u, String v) {
        graph_2001.get(u).add(v);
        graph_2001.get(v).add(u); // Undirected graph
    }

    // Method Wajib: BFS
    private void BFS_2001() {
        resetState_2001();
        String start_2001 = (String) startCombo_2001.getSelectedItem();
        String goal_2001 = (String) goalCombo_2001.getSelectedItem();

        Queue<String> queue_2001 = new LinkedList<>();
        Map<String, String> parentMap_2001 = new HashMap<>();
        
        queue_2001.add(start_2001);
        visitedNodes_2001.add(start_2001);
        parentMap_2001.put(start_2001, null);

        boolean found_2001 = false;

        while (!queue_2001.isEmpty()) {
            String current_2001 = queue_2001.poll();
            nodesExplored_2001++;

            if (current_2001.equals(goal_2001)) {
                found_2001 = true;
                break;
            }

            for (String neighbor : graph_2001.get(current_2001)) {
                if (!visitedNodes_2001.contains(neighbor)) {
                    visitedNodes_2001.add(neighbor);
                    parentMap_2001.put(neighbor, current_2001);
                    queue_2001.add(neighbor);
                }
            }
        }

        if (found_2001) {
            reconstructPath_2001(parentMap_2001, goal_2001);
        }
        displayPath_2001("BFS");
        displayGraph_2001();
    }

    // Method Wajib: DFS
    private void DFS_2001() {
        resetState_2001();
        String start_2001 = (String) startCombo_2001.getSelectedItem();
        String goal_2001 = (String) goalCombo_2001.getSelectedItem();

        Stack<String> stack_2001 = new Stack<>();
        Map<String, String> parentMap_2001 = new HashMap<>();
        
        stack_2001.push(start_2001);
        parentMap_2001.put(start_2001, null);

        boolean found_2001 = false;

        while (!stack_2001.isEmpty()) {
            String current_2001 = stack_2001.pop();

            if (!visitedNodes_2001.contains(current_2001)) {
                visitedNodes_2001.add(current_2001);
                nodesExplored_2001++;

                if (current_2001.equals(goal_2001)) {
                    found_2001 = true;
                    break;
                }

                // Push tetangga ke stack
                for (String neighbor : graph_2001.get(current_2001)) {
                    if (!visitedNodes_2001.contains(neighbor)) {
                        stack_2001.push(neighbor);
                        parentMap_2001.put(neighbor, current_2001);
                    }
                }
            }
        }

        if (found_2001) {
            reconstructPath_2001(parentMap_2001, goal_2001);
        }
        displayPath_2001("DFS");
        displayGraph_2001();
    }

    private void reconstructPath_2001(Map<String, String> parentMap_2001, String goal_2001) {
        String current_2001 = goal_2001;
        while (current_2001 != null) {
            pathNodes_2001.add(0, current_2001); // Insert at beginning to reverse
            current_2001 = parentMap_2001.get(current_2001);
        }
    }

    // Method Wajib: displayPath
    private void displayPath_2001(String algorithm_2001) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hasil Pencarian (").append(algorithm_2001).append(") :\n");
        
        if (pathNodes_2001.isEmpty()) {
            sb.append("Jalur : Tidak Ditemukan\n");
        } else {
            sb.append("Jalur : ").append(String.join(" -> ", pathNodes_2001)).append("\n");
        }
        
        sb.append("Node Dikunjungi : ").append(String.join(" -> ", visitedNodes_2001)).append("\n");
        sb.append("Jumlah Node Dieksplorasi : ").append(nodesExplored_2001).append("\n");
        
        resultArea_2001.setText(sb.toString());
    }

    // Method Wajib: displayGraph
    private void displayGraph_2001() {
        panelGraph_2001.repaint();
    }

    // Method Wajib: resetGraph
    private void resetGraph_2001() {
        resetState_2001();
        resultArea_2001.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dieksplorasi : 0");
        displayGraph_2001();
    }

    private void resetState_2001() {
        visitedNodes_2001 = new ArrayList<>();
        pathNodes_2001 = new ArrayList<>();
        nodesExplored_2001 = 0;
    }

    // Inner Class untuk Gambar Graf
    class GraphPanel_2001 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Gambar Edge
            g2.setColor(Color.GRAY);
            g2.setStroke(new BasicStroke(2));
            for (String u : graph_2001.keySet()) {
                Point p1 = nodeCoords_2001.get(u);
                for (String v : graph_2001.get(u)) {
                    Point p2 = nodeCoords_2001.get(v);
                    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }

            // Gambar Node
            for (String node : nodeCoords_2001.keySet()) {
                Point p = nodeCoords_2001.get(node);
                
                // Logika Pewarnaan Node sesuai instruksi
                if (pathNodes_2001.contains(node)) {
                    g2.setColor(Color.GREEN); // Jalur terpilih
                } else if (visitedNodes_2001.contains(node)) {
                    g2.setColor(Color.ORANGE); // Node terekspolrasi
                } else {
                    g2.setColor(Color.LIGHT_GRAY); // Belum disentuh
                }

                g2.fillOval(p.x - 15, p.y - 15, 30, 30);
                g2.setColor(Color.BLACK);
                g2.drawOval(p.x - 15, p.y - 15, 30, 30);
                
                // Nama Node
                g2.setFont(new Font("Arial", Font.BOLD, 12));
                g2.drawString(node, p.x - 20, p.y - 20);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetaKampus_2511532001().setVisible(true);
        });
    }
}