/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author BERLANDA GULTOM
 */
public class iniiiiterakhirryaaa extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private DefaultTableModel model2;

   
    public iniiiiterakhirryaaa() {
        initComponents();
        
        
        tfnama.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
        });

        tfjabatan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
        });

        tfdepartemen.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
        });
        
        tfid.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
        public void removeUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
        public void changedUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
        });
        
        tfid1.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
        public void removeUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
        public void changedUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
        });
        
        namaproyek.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checproyek(); }
        public void removeUpdate(DocumentEvent e) { checproyek(); }
        public void changedUpdate(DocumentEvent e) { checproyek(); }
        });
        
        durasipengerjaan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checproyek(); }
        public void removeUpdate(DocumentEvent e) { checproyek(); }
        public void changedUpdate(DocumentEvent e) { checproyek(); }
        });
        
        conn = koneksi.getConnection();
        
        // Inisialisasi model untuk tabel karyawan
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        tblkaryawan.setModel(model);

        // Inisialisasi model untuk tabel proyek
        model1 = new DefaultTableModel();
        model1.addColumn("ID");
        model1.addColumn("Nama Proyek");
        model1.addColumn("Durasi");
        tblproyek.setModel(model1);

        // Inisialisasi model untuk tabel transaksi
        model2 = new DefaultTableModel();
        model2.addColumn("id Karyawan");
        model2.addColumn("Karyawan");
        model2.addColumn("id Proyek");
        model2.addColumn("Nama Proyek");
        model2.addColumn("Peran");
        tbltransaksi.setModel(model2);
        
        // Muat data ke tabel masing-masing
        loadData();
        loadData1();
        loadData2();
        loadKaryawanComboBox();
        loadProyekComboBox();
    }
    private void loadData(){
        model.setRowCount(0);
        try{
            String sql = "SELECT * FROM karyawan";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    private void tambahData() {
        String checkSql = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
        String insertSql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";  
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            checkStmt.setString(1, tfid.getText());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "ID ini sudah digunakan. Silakan masukkan ID yang berbeda.");
                    return; // Hentikan proses jika ID sudah ada
                }
            }
            insertStmt.setString(1, tfid.getText());
            insertStmt.setString(2, tfnama.getText());
            insertStmt.setString(3, tfjabatan.getText());
            insertStmt.setString(4, tfdepartemen.getText());
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil ditambahkan.");
            loadData(); // Memuat ulang data karyawan
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
            e.printStackTrace(); // Debugging error log
        }
    }
    private void editData() {
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String id = tfid.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong.");
                return;
            }
            stmt.setString(1, tfnama.getText());
            stmt.setString(2, tfjabatan.getText());
            stmt.setString(3, tfdepartemen.getText());
            stmt.setString(4, id); // ID seharusnya string, karena biasanya ID bisa berupa angka atau teks.
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diubah.");
            loadData(); // Memuat ulang data karyawan
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage());
            e.printStackTrace(); // Debugging error log
        }
    }
    private void hapusData() {
        try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(tfid.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data deleted successfully");
          loadData();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    private void checkButtons() {
        boolean isFilled = !tfid.getText().trim().isEmpty() &&
                           !tfnama.getText().trim().isEmpty() &&
                           !tfjabatan.getText().trim().isEmpty() &&
                           !tfdepartemen.getText().trim().isEmpty();
        buat.setEnabled(isFilled);
    }
    private void checkField() {
        boolean isIdFilled = !tfid.getText().trim().isEmpty();
        boolean isAnyFieldFilled = !tfnama.getText().trim().isEmpty() ||
                                   !tfjabatan.getText().trim().isEmpty() ||
                                   !tfdepartemen.getText().trim().isEmpty();

        edit.setEnabled(isIdFilled && isAnyFieldFilled);
    }
    private void checkHapusButton() {
        boolean isIdFilled = !tfid.getText().trim().isEmpty();
        hapus.setEnabled(isIdFilled); // Enable delete button if ID is filled
    }
    private void loadData1(){
        model1.setRowCount(0);
        try{
            String sql = "SELECT * FROM proyek";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model1.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    private void tambahData1() {
        String checkSql = "SELECT COUNT(*) FROM proyek WHERE id = ?";
        String insertSql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            checkStmt.setString(1, tfid1.getText().trim());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "ID ini sudah digunakan. Silakan masukkan ID yang berbeda.");
                    return; // Stop the process if the ID already exists
                }
            }
            insertStmt.setString(1, tfid1.getText().trim());
            insertStmt.setString(2, namaproyek.getText().trim());
            insertStmt.setString(3, durasipengerjaan.getText().trim());
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil ditambahkan.");
            loadData1(); // Reload project data
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
            e.printStackTrace(); // Debugging error log
        }
    }
    private void editData1(){
        try{
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaproyek.getText());
            stmt.setString(2, durasipengerjaan.getText());
            stmt.setInt(3, Integer.parseInt(tfid1.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Proyek berhasil dirubah.");
            loadData1();
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }
    private void hapusData1(){
        try{
            String sql = "DELETE from proyek WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(tfid1.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
            loadData1();
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }
    private void checproyek() {
        boolean isIdFilled = !tfid1.getText().trim().isEmpty();
        boolean isAnyFieldFilled = !namaproyek.getText().trim().isEmpty() ||
                                   !tfjabatan.getText().trim().isEmpty() ||
                                   !durasipengerjaan.getText().trim().isEmpty();

        edit1.setEnabled(isIdFilled && isAnyFieldFilled);
    }
    private void checkHapusproyek() {
        boolean isIdFilled = !tfid1.getText().trim().isEmpty();
        hapus2.setEnabled(isIdFilled); // Enable delete button if ID is filled
    }
    private void checktambahproyek() {
        boolean isFilled = !tfid1.getText().trim().isEmpty() &&
                       !namaproyek.getText().trim().isEmpty() &&
                       !durasipengerjaan.getText().trim().isEmpty();
        buat2.setEnabled(isFilled);
    }
    private void loadKaryawanComboBox(){
        try{
            String query = "SELECT id FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id"); // Retrieve the ID from the ResultSet
                cbxkaryawan.addItem(String.valueOf(id)); // Add the ID as a String to the combo box
            }
        }catch(SQLException e){
            System.out.println("Error k" + e.getMessage());
        }
    }
    private void loadProyekComboBox(){
        try{
            String query = "SELECT id FROM proyek";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id"); // Retrieve the ID from the ResultSet
                cbxproyek.addItem(String.valueOf(id)); // Add the ID as a String to the combo box
            }
        }catch(SQLException e){
            System.out.println("Error p" + e.getMessage());
        }
    }
    private void loadData2() {
        model2.setRowCount(0);
        try {
            String sql = "SELECT k.nama , p.nama_proyek, " +
                         "t.peran, t.id_karyawan, t.id_proyek " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id_karyawan = k.id " +
                         "JOIN proyek p ON t.id_proyek = p.id " +
                         "ORDER BY k.nama, p.nama_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model2.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("nama"),
                    rs.getInt("id_proyek"),
                    rs.getString("nama_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi: " + e.getMessage());
        }
    }
    private int getSelectedId(String comboBoxText) {
        if (comboBoxText == null || comboBoxText.isEmpty()) return -1;
            try {
            return Integer.parseInt(comboBoxText.split(" - ")[0]);
            } catch (Exception e) {
                System.out.println("Error parsing ID: " + e.getMessage());
            return -1;
        }
    }
    private void tambahData2() {
    try {
        if (cbxkaryawan.getSelectedItem() == null || cbxproyek.getSelectedItem() == null || peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pastikan semua input telah diisi: Karyawan, Proyek, dan Peran.");
            return;
        }
        String selectedKaryawan = cbxkaryawan.getSelectedItem().toString();
        String selectedProyek = cbxproyek.getSelectedItem().toString();

        int idKaryawan = getSelectedId(selectedKaryawan);
        int idProyek = getSelectedId(selectedProyek);

        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(null, "ID Karyawan atau ID Proyek tidak valid.");
            return;
        }

        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, peran.getText().trim());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Transaksi berhasil ditambahkan.");
        loadData2();
        clearTransaksiFields();

        } catch (SQLException e) {
            System.out.println("Error Tambah Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
        }
    }
    private void clearTransaksiFields() {
        peran.setText("");
        cbxkaryawan.setSelectedIndex(0);
        cbxproyek.setSelectedIndex(0);
    }
    
    private void editData2() {
        try {
            String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            int idKaryawan = getSelectedId(cbxkaryawan.getSelectedItem().toString());
            int idProyek = getSelectedId(cbxproyek.getSelectedItem().toString());

            ps.setString(1, peran.getText());
            ps.setInt(2, idKaryawan);
            ps.setInt(3, idProyek);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
            loadData2();
        } catch (SQLException e) {
            System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
        }
    }
    private void hapusData2() {
        try {
            if (cbxkaryawan.getSelectedItem() == null || cbxproyek.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
                return;
            }
            int idKaryawan = getSelectedId(cbxkaryawan.getSelectedItem().toString());
            int idProyek = getSelectedId(cbxproyek.getSelectedItem().toString());

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus data transaksi ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);

                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
                    loadData2();
                    clearTransaksiFields();  // Membersihkan field setelah menghapus data
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah terhapus");
                }
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        tfjabatan = new javax.swing.JTextField();
        tfdepartemen = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        buat = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkaryawan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfid1 = new javax.swing.JTextField();
        namaproyek = new javax.swing.JTextField();
        durasipengerjaan = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        buat2 = new javax.swing.JButton();
        edit2 = new javax.swing.JButton();
        hapus2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblproyek = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxkaryawan = new javax.swing.JComboBox<>();
        cbxproyek = new javax.swing.JComboBox<>();
        peran = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        buat1 = new javax.swing.JButton();
        edit1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbltransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(255, 102, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Manajemen Karyawan & Proyek");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText(" & Proyek");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/[removal.ai]_7019ff51-71e6-4410-8c91-2348deb43ab5-screenshot-2024-11-03-142542.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel7.setBackground(new java.awt.Color(255, 102, 153));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 102, 153));

        jLabel4.setText("ID");

        jLabel5.setText("Nama");

        jLabel6.setText("Jabatan");

        jLabel7.setText("Departemen");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfdepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.GridLayout(3, 1));

        buat.setBackground(new java.awt.Color(116, 168, 221));
        buat.setText("Buat");
        buat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatActionPerformed(evt);
            }
        });
        jPanel9.add(buat);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel9.add(edit);

        hapus.setBackground(new java.awt.Color(255, 102, 153));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel9.add(hapus);

        jPanel7.add(jPanel9, java.awt.BorderLayout.LINE_END);

        tblkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        jScrollPane1.setViewportView(tblkaryawan);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel10, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Manajemen Karyawan", jPanel7);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 102, 153));

        jLabel8.setText("ID");

        jLabel9.setText("Nama Proyek");

        jLabel10.setText("Durasi Pengerjaan");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(tfid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(durasipengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(namaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(tfid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durasipengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(namaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setLayout(new java.awt.GridLayout(3, 1));

        buat2.setBackground(new java.awt.Color(116, 168, 221));
        buat2.setText("Buat");
        buat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buat2ActionPerformed(evt);
            }
        });
        jPanel12.add(buat2);

        edit2.setText("Edit");
        edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit2ActionPerformed(evt);
            }
        });
        jPanel12.add(edit2);

        hapus2.setBackground(new java.awt.Color(255, 102, 153));
        hapus2.setText("Hapus");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });
        jPanel12.add(hapus2);

        jPanel6.add(jPanel12, java.awt.BorderLayout.LINE_END);

        tblproyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Proyek", "Durasi Pengerjaan"
            }
        ));
        jScrollPane2.setViewportView(tblproyek);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel13, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Manajemen Proyek", jPanel6);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(255, 102, 153));

        jLabel11.setText("ID Karyawan ");

        jLabel12.setText("ID Proyek");

        jLabel13.setText("Peran");

        cbxkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        cbxproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxproyek, 0, 115, Short.MAX_VALUE)
                    .addComponent(cbxkaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(peran, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(cbxkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbxproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel15.setLayout(new java.awt.GridLayout(3, 1));

        buat1.setBackground(new java.awt.Color(116, 168, 221));
        buat1.setText("Buat");
        buat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buat1ActionPerformed(evt);
            }
        });
        jPanel15.add(buat1);

        edit1.setText("Edit");
        edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit1ActionPerformed(evt);
            }
        });
        jPanel15.add(edit1);

        hapus1.setBackground(new java.awt.Color(255, 102, 153));
        hapus1.setText("Hapus");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        jPanel15.add(hapus1);

        jPanel5.add(jPanel15, java.awt.BorderLayout.LINE_END);

        tbltransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Karyawan", "ID Proyek", "Peran"
            }
        ));
        jScrollPane3.setViewportView(tbltransaksi);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel16, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Transaksi", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatActionPerformed
        tambahData();                   
    }//GEN-LAST:event_buatActionPerformed

    private void buat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buat2ActionPerformed
        tambahData1();
    }//GEN-LAST:event_buat2ActionPerformed

    private void edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit2ActionPerformed
        editData1();
    }//GEN-LAST:event_edit2ActionPerformed

    private void buat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buat1ActionPerformed
        tambahData2();// TODO add your handling code here:
    }//GEN-LAST:event_buat1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editData();
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        hapusData();
    }//GEN-LAST:event_hapusActionPerformed
    
    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
        hapusData1();
    }//GEN-LAST:event_hapus2ActionPerformed

    private void edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit1ActionPerformed
        editData2();// TODO add your handling code here:
    }//GEN-LAST:event_edit1ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        hapusData2();// TODO add your handling code here:
    }//GEN-LAST:event_hapus1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(iniiiiterakhirryaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniiiiterakhirryaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniiiiterakhirryaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniiiiterakhirryaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniiiiterakhirryaaa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buat;
    private javax.swing.JButton buat1;
    private javax.swing.JButton buat2;
    private javax.swing.JComboBox<String> cbxkaryawan;
    private javax.swing.JComboBox<String> cbxproyek;
    private javax.swing.JTextField durasipengerjaan;
    private javax.swing.JButton edit;
    private javax.swing.JButton edit1;
    private javax.swing.JButton edit2;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton hapus2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField namaproyek;
    private javax.swing.JTextField peran;
    private javax.swing.JTable tblkaryawan;
    private javax.swing.JTable tblproyek;
    private javax.swing.JTable tbltransaksi;
    private javax.swing.JTextField tfdepartemen;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfid1;
    private javax.swing.JTextField tfjabatan;
    private javax.swing.JTextField tfnama;
    // End of variables declaration//GEN-END:variables


}
