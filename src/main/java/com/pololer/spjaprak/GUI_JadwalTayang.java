/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Class GUI_JadwalTayang merupakan class GUI berbasis Java Swing yang
 * menyediakan antarmuka grafis untuk mengelola data Jadwal Tayang Anime
 * dalam Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * GUI ini mendemonstrasikan penggunaan <b>Enkapsulasi</b> dimana seluruh
 * interaksi terhadap atribut objek {@link JadwalTayang} dilakukan melalui
 * method <b>getter</b> dan <b>setter</b>, bukan akses langsung ke atribut.
 * </p>
 *
 * <p>
 * Data disimpan menggunakan {@link ArrayList} dari objek
 * {@link JadwalTayang}.
 * </p>
 *
 * @author Administrator
 * @version 1.0
 * @see JadwalTayang
 */
public class GUI_JadwalTayang extends JFrame {

    /** List untuk menyimpan data jadwal tayang. */
    private final ArrayList<JadwalTayang> listJadwal = new ArrayList<>();

    /** Field input judul anime. */
    private JTextField tfJudul;

    /** Field input genre anime. */
    private JTextField tfGenre;

    /** Field input hari tayang. */
    private JTextField tfHari;

    /** Field input jam tayang. */
    private JTextField tfJam;

    /** Field input stasiun/platform. */
    private JTextField tfStasiun;

    /** Field input durasi per episode (menit). */
    private JTextField tfDurasi;

    /** Field input status tayang. */
    private JTextField tfStatus;

    /** Tabel untuk menampilkan data jadwal tayang. */
    private JTable tableJadwal;

    /** Model tabel jadwal tayang. */
    private DefaultTableModel modelJadwal;

    /** Label untuk menampilkan hasil hitung jam selesai. */
    private JLabel lblJamSelesai;

    /** Label untuk menampilkan info dari getInfo(). */
    private JLabel lblInfo;

    /**
     * Constructor GUI_JadwalTayang.
     * Menginisialisasi seluruh komponen GUI dan menampilkan JFrame.
     */
    public GUI_JadwalTayang() {
        setTitle("SPJA — Kelola Jadwal Tayang (BAB 4 Enkapsulasi)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(950, 620);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    /**
     * Menginisialisasi semua komponen GUI pada frame.
     */
    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        // ===== PANEL FORM INPUT =====
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(
                "Input Data Jadwal Tayang (Enkapsulasi: private + getter/setter)"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tfJudul = addFormField(formPanel, gbc, "Judul:", 0);
        tfGenre = addFormField(formPanel, gbc, "Genre:", 1);
        tfHari = addFormField(formPanel, gbc, "Hari Tayang:", 2);
        tfJam = addFormField(formPanel, gbc, "Jam Tayang (HH:mm):", 3);
        tfStasiun = addFormField(formPanel, gbc, "Stasiun/Platform:", 4);
        tfDurasi = addFormField(formPanel, gbc, "Durasi (menit):", 5);
        tfStatus = addFormField(formPanel, gbc, "Status Tayang:", 6);

        // Tombol Tambah Jadwal
        JButton btnTambah = new JButton("Tambah Jadwal");
        btnTambah.addActionListener(e -> tambahJadwal());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(btnTambah, gbc);

        add(formPanel, BorderLayout.NORTH);

        // ===== JTABLE =====
        String[] kolom = { "Judul", "Genre", "Hari", "Jam Mulai",
            "Jam Selesai", "Durasi", "Stasiun", "Status" };
        modelJadwal = new DefaultTableModel(kolom, 0) {
            /** Mencegah sel tabel diedit langsung oleh pengguna. */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableJadwal = new JTable(modelJadwal);
        JScrollPane scrollPane = new JScrollPane(tableJadwal);
        add(scrollPane, BorderLayout.CENTER);

        // ===== PANEL BAWAH (Jam Selesai + Info) =====
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // Panel Jam Selesai
        JPanel jamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jamPanel.setBorder(BorderFactory.createTitledBorder(
                "Hitung Jam Selesai Tayang"));
        JButton btnHitung = new JButton("Hitung Jam Selesai");
        btnHitung.addActionListener(e -> hitungJamSelesai());
        lblJamSelesai = new JLabel("Jam Selesai: -");
        lblJamSelesai.setFont(lblJamSelesai.getFont().deriveFont(Font.BOLD));
        jamPanel.add(btnHitung);
        jamPanel.add(Box.createHorizontalStrut(10));
        jamPanel.add(lblJamSelesai);

        // Panel Info (menampilkan getInfo dari JadwalTayang)
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBorder(BorderFactory.createTitledBorder(
                "Info Jadwal (getInfo via Getter)"));
        JButton btnInfo = new JButton("Tampilkan Info");
        btnInfo.addActionListener(e -> tampilkanInfo());
        lblInfo = new JLabel(
                "Pilih jadwal dari tabel, lalu klik Tampilkan Info.");
        infoPanel.add(btnInfo);
        infoPanel.add(Box.createHorizontalStrut(10));
        infoPanel.add(lblInfo);

        bottomPanel.add(jamPanel, BorderLayout.NORTH);
        bottomPanel.add(infoPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Menambahkan field form (JLabel + JTextField) ke panel dengan
     * GridBagLayout.
     *
     * @param panel panel tujuan
     * @param gbc   GridBagConstraints yang digunakan
     * @param label teks label
     * @param row   baris posisi
     * @return JTextField yang dibuat
     */
    private JTextField addFormField(JPanel panel, GridBagConstraints gbc,
            String label, int row) {
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.0;
        panel.add(new JLabel(label), gbc);

        JTextField tf = new JTextField(20);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(tf, gbc);

        return tf;
    }

    /**
     * Aksi tombol "Tambah Jadwal". Memvalidasi input, membuat objek
     * {@link JadwalTayang} menggunakan <b>konstruktor</b>, menyimpan ke list,
     * dan menampilkan di JTable menggunakan <b>getter</b>.
     */
    private void tambahJadwal() {
        String judul = tfJudul.getText().trim();
        String genre = tfGenre.getText().trim();
        String hari = tfHari.getText().trim();
        String jam = tfJam.getText().trim();
        String stasiun = tfStasiun.getText().trim();
        String sDurasi = tfDurasi.getText().trim();
        String status = tfStatus.getText().trim();

        // Validasi: cek field tidak kosong
        if (judul.isEmpty() || genre.isEmpty() || hari.isEmpty()
                || jam.isEmpty() || stasiun.isEmpty() || sDurasi.isEmpty()
                || status.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Semua field harus diisi!",
                    "Validasi Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi: durasi harus angka
        int durasi;
        try {
            durasi = Integer.parseInt(sDurasi);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Durasi (menit) harus berupa angka!",
                    "Validasi Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buat objek JadwalTayang menggunakan konstruktor (enkapsulasi)
        JadwalTayang jadwal = new JadwalTayang(judul, genre, hari, jam,
                stasiun, durasi, status);
        listJadwal.add(jadwal);

        // Tambahkan ke tabel menggunakan getter (enkapsulasi)
        modelJadwal.addRow(new Object[] {
            jadwal.getJudul(),
            jadwal.getGenre(),
            jadwal.getHariTayang(),
            jadwal.getJamTayang(),
            jadwal.hitungJamSelesai(),
            jadwal.getFormatDurasi(),
            jadwal.getStasiun(),
            jadwal.getStatusTayang()
        });

        // Reset fields
        clearFields();

        JOptionPane.showMessageDialog(this,
                "Jadwal \"" + judul + "\" berhasil ditambahkan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Membersihkan semua field input.
     */
    private void clearFields() {
        tfJudul.setText("");
        tfGenre.setText("");
        tfHari.setText("");
        tfJam.setText("");
        tfStasiun.setText("");
        tfDurasi.setText("");
        tfStatus.setText("");
    }

    /**
     * Aksi tombol "Hitung Jam Selesai". Meminta user memilih baris di JTable,
     * lalu menampilkan hasil method {@code hitungJamSelesai()} yang diakses
     * melalui <b>getter</b> (enkapsulasi).
     */
    private void hitungJamSelesai() {
        int selectedRow = tableJadwal.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih jadwal dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JadwalTayang jadwal = listJadwal.get(selectedRow);
        String jamMulai = jadwal.getJamTayang();
        String jamSelesai = jadwal.hitungJamSelesai();
        lblJamSelesai.setText(String.format(
                "Jam Selesai: %s → %s (%s)",
                jamMulai, jamSelesai, jadwal.getFormatDurasi()));
        lblJamSelesai.setForeground(new Color(0, 128, 0));
    }

    /**
     * Aksi tombol "Tampilkan Info". Menampilkan hasil method
     * {@code getInfo()} dari objek JadwalTayang yang dipilih di JTable,
     * serta memanggil {@code tampilkanDetail()} ke konsol.
     */
    private void tampilkanInfo() {
        int selectedRow = tableJadwal.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih jadwal dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JadwalTayang jadwal = listJadwal.get(selectedRow);
        lblInfo.setText(jadwal.getInfo());

        // Juga cetak ke konsol menggunakan tampilkanDetail()
        jadwal.tampilkanDetail();
    }

    /**
     * Method main untuk menjalankan GUI JadwalTayang secara standalone.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI_JadwalTayang());
    }
}
