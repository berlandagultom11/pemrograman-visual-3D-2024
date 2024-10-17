/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul3;

import javax.swing.JOptionPane;


public class apotek extends javax.swing.JFrame {

   
    public apotek() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        gejala = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(151, 196, 18));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(2, 5));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tambah darah.jpg"))); // NOI18N
        jPanel3.add(jLabel5);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/asam lambung.jpg"))); // NOI18N
        jPanel3.add(jLabel6);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/batuk.jpg"))); // NOI18N
        jPanel3.add(jLabel7);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/demam.png"))); // NOI18N
        jPanel3.add(jLabel9);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diare.jpg"))); // NOI18N
        jPanel3.add(jLabel11);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sakit mata.jpg"))); // NOI18N
        jPanel3.add(jLabel10);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gatal dan ruam.jpg"))); // NOI18N
        jPanel3.add(jLabel13);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/luka.jpg"))); // NOI18N
        jPanel3.add(jLabel12);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rambut rontok.jpg"))); // NOI18N
        jPanel3.add(jLabel8);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sakit gigi.jpg"))); // NOI18N
        jPanel3.add(jLabel4);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Deskripsi");
        jPanel4.add(jLabel17);

        deskripsi.setEditable(false);
        deskripsi.setColumns(20);
        deskripsi.setRows(5);
        deskripsi.setPreferredSize(new java.awt.Dimension(400, 400));
        jScrollPane1.setViewportView(deskripsi);

        jPanel4.add(jScrollPane1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel5.setBackground(new java.awt.Color(0, 153, 51));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nama  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jLabel15, gridBagConstraints);

        nama.setPreferredSize(new java.awt.Dimension(180, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(17, 56, 17, 56);
        jPanel5.add(nama, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gejala");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jLabel16, gridBagConstraints);

        gejala.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Kurang Darah", "Asam Lambung", "Batuk", "Demam", "Diare", "Sakit Mata", "Gatal & Ruam", "Luka", "Rambut Rontok", "Sakit Gigi" }));
        gejala.setPreferredSize(new java.awt.Dimension(180, 22));
        gejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gejalaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(17, 56, 17, 56);
        jPanel5.add(gejala, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tersedia :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Apotek Mitra Sehat");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Jl. Raya Darmo No.49, Keputran, Kec. Tegalsari, Surabaya, Jawa Timur ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Telp.0852-7098-0000 Email:apotekmitrasehat66@gmail.com");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String namaInput = nama.getText();
        String gejalaSelected = (String) gejala.getSelectedItem();

         if (namaInput.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong! Mohon isi nama dengan benar.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
     }
              if (gejalaSelected.equals("")) {
        JOptionPane.showMessageDialog(this, "Pilih gejala .", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
     }
        deskripsi.setText("Nama: " + namaInput + "\nGejala: " + gejalaSelected + "\n");
        switch (gejalaSelected) {
            case "--Gejala yang dirasakan":   
            case "Kurang Darah":
                deskripsi.append("Rekomendasi Obat: Sangobion\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul per hari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan untuk mengurangi efek samping\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Mual\n");
                deskripsi.append("  - Diare\n");
                deskripsi.append("  - Warna tinja menjadi lebih gelap\n");
                deskripsi.append("  - Alergi (meskipun jarang), seperti ruam dan gatal\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh ibu hamil atau menyusui tanpa konsultasi dokter\n");
                deskripsi.append("  - Hati-hati pada penderita penyakit ginjal atau hati, konsultasikan dengan dokter sebelum penggunaan\n");
                break;
            case "Asam Lambung":
                deskripsi.append("Rekomendasi Obat: Mylanta\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 2-4 tablet setelah makan dan sebelum tidur\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan atau saat gejala muncul\n");
                deskripsi.append("  - Konsumsi tablet secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Sakit Kepala\n");
                deskripsi.append("  - Diare\n");
                deskripsi.append("  - Mual\n");
                deskripsi.append("  - Alergi (meskipun jarang), seperti ruam dan gatal\n");
                deskripsi.append("  - Kembung atau gas berlebih\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh orang dengan penyakit ginjal atau hati tanpa konsultasi dokter\n");
                deskripsi.append("  - Hati-hati penggunaan pada ibu hamil atau menyusui, konsultasikan dengan dokter terlebih dahulu\n");
                break;
            case "Batuk":
                deskripsi.append("Rekomendasi Obat: Decadryl\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1-2 kapsul per hari, sesuai kebutuhan\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan untuk mengurangi efek samping\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Sakit Kepala\n");
                deskripsi.append("  - Mual\n");
                deskripsi.append("  - Diare\n");
                deskripsi.append("  - Sakit Tenggorokan\n");
                deskripsi.append("  - Alergi (meskipun jarang), seperti ruam dan gatal\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh orang dengan penyakit ginjal atau hati tanpa konsultasi dokter\n");
                deskripsi.append("  - Hati-hati penggunaan pada ibu hamil atau menyusui; konsultasikan dengan dokter terlebih dahulu\n");
                break;

            case "Demam":
                deskripsi.append("Rekomendasi Obat: Paracetamol\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 500-1000 mg setiap 4-6 jam sesuai kebutuhan, tidak lebih dari 4000 mg per hari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter, umumnya 10-15 mg/kg berat badan setiap 4-6 jam\n");
                deskripsi.append("  - Diminum setelah makan untuk mengurangi iritasi lambung\n");
                deskripsi.append("  - Konsumsi tablet secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Sakit Kepala (jarang)\n");
                deskripsi.append("  - Mual (jarang)\n");
                deskripsi.append("  - Reaksi alergi, seperti ruam dan gatal (jarang)\n");
                deskripsi.append("  - Kerusakan hati jika overdosis\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Hati-hati penggunaan pada orang dengan penyakit hati\n");
                deskripsi.append("  - Sebaiknya konsultasikan dengan dokter sebelum penggunaan pada ibu hamil atau menyusui\n");
                break;

            case "Diare":
                deskripsi.append("Rekomendasi Obat: Cotrimoksazole\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul per hari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan untuk mengurangi iritasi lambung\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah atau dihancurkan\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Mual atau muntah\n");
                deskripsi.append("  - Ruam kulit\n");
                deskripsi.append("  - Reaksi alergi (jarang terjadi)\n");
                deskripsi.append("  - Gangguan fungsi hati (jarang)\n");
                deskripsi.append("\n");
                deskripsi.append("Penting: Jika mengalami efek samping yang serius, segera konsultasikan ke dokter.\n");
                break;

            case "Sakit Mata":
                deskripsi.append("Rekomendasi Obat: Insto\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1-2 tetes di setiap mata, sesuai kebutuhan\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Gunakan sesuai kebutuhan, dapat digunakan beberapa kali sehari\n");
                deskripsi.append("  - Pastikan tangan bersih sebelum mengaplikasikan\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Sensasi terbakar atau perih sementara setelah penggunaan\n");
                deskripsi.append("  - Reaksi alergi (jarang terjadi)\n");
                deskripsi.append("\n");
                deskripsi.append("Penting: Jika efek samping berlanjut atau memburuk, segera konsultasikan ke dokter.\n");
                break;

            case "Gatal & Ruam":
                deskripsi.append("Rekomendasi Obat: Levocetirizine\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul perhari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("  - Sakit Kepala\n");
                deskripsi.append("  - Diare\n");
                deskripsi.append("  - Mual\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh orang dengan penyakit ginjal atau hati\n");
                deskripsi.append("  - Jangan diminum oleh ibu hamil atau menyusui\n");
                break;

            case "Luka":
                deskripsi.append("Rekomendasi Obat: Betadine\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul perhari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append ("Tidak ada\n");
                break;

            case "Sakit Gigi":
                deskripsi.append("Rekomendasi Obat: Ponstan\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul perhari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("Tidak ada\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh orang dengan penyakit ginjal atau hati\n");
                deskripsi.append("  - Jangan diminum oleh ibu hamil atau menyusui\n");
                break;

            case "Rambut Rontok":
                deskripsi.append("Rekomendasi Obat: spirola\n");
                deskripsi.append("\n");
                deskripsi.append("Detail Penggunaan Obat:\n");
                deskripsi.append("  - Dewasa: 1 kapsul perhari\n");
                deskripsi.append("  - Anak-anak: dosis sesuai anjuran dokter\n");
                deskripsi.append("  - Diminum setelah makan\n");
                deskripsi.append("  - Konsumsi kapsul secara utuh, jangan dikunyah\n");
                deskripsi.append("\n");
                deskripsi.append("Efek Samping Obat:\n");
                deskripsi.append("Tidak ada\n");
                deskripsi.append("\n");
                deskripsi.append("Peringatan:\n");
                deskripsi.append("  - Jangan diminum oleh orang dengan penyakit ginjal atau hati\n");
                deskripsi.append("  - Jangan diminum oleh ibu hamil atau menyusui\n");
                break;
            default:
                deskripsi.append("Maaf, detail obat untuk gejala ini belum tersedia.");
                break;
        }                                   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void gejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gejalaActionPerformed
       
    }//GEN-LAST:event_gejalaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            nama.setText("");
            gejala.setSelectedIndex(0);
            deskripsi.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apotek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JComboBox<String> gejala;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
