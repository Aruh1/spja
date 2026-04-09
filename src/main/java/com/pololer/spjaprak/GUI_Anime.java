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
 * Class GUI_Anime merupakan class GUI berbasis Java Swing yang menyediakan
 * antarmuka grafis khusus untuk mengelola data Anime Series dalam Sistem
 * Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * GUI ini menampilkan form input untuk data anime, JTable untuk daftar anime,
 * dan fitur hitung progress tayang.
 * </p>
 *
 * <p>
 * Data disimpan menggunakan {@link ArrayList} dari objek {@link Anime}.
 * </p>
 *
 * @author Administrator
 * @version 1.0
 * @see Anime
 * @see Media
 */
public class GUI_Anime extends JFrame {

    /** List untuk menyimpan data anime series. */
    private final ArrayList<Anime> listAnime = new ArrayList<>();

    /** Field input judul anime. */
    private JTextField tfJudul;

    /** Field input genre anime. */
    private JTextField tfGenre;

    /** Field input tahun rilis anime. */
    private JTextField tfTahun;

    /** Field input status anime. */
    private JTextField tfStatus;

    /** Field input studio anime. */
    private JTextField tfStudio;

    /** Field input total episode anime. */
    private JTextField tfEpisode;

    /** Field input musim anime. */
    private JTextField tfMusim;

    /** Field input hari tayang anime. */
    private JTextField tfHari;

    /** Tabel untuk menampilkan data anime series. */
    private JTable tableAnime;

    /** Model tabel anime series. */
    private DefaultTableModel modelAnime;

    /** Label untuk menampilkan hasil hitung progress. */
    private JLabel lblProgress;

    /** Label untuk menampilkan info dari getInfo(). */
    private JLabel lblInfo;

    /**
     * Constructor GUI_Anime.
     * Menginisialisasi seluruh komponen GUI dan menampilkan JFrame.
     */
    public GUI_Anime() {
        setTitle("SPJA — Kelola Anime Series");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
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
        formPanel.setBorder(BorderFactory.createTitledBorder("Input Data Anime Series"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tfJudul = addFormField(formPanel, gbc, "Judul:", 0);
        tfGenre = addFormField(formPanel, gbc, "Genre:", 1);
        tfTahun = addFormField(formPanel, gbc, "Tahun Rilis:", 2);
        tfStatus = addFormField(formPanel, gbc, "Status:", 3);
        tfStudio = addFormField(formPanel, gbc, "Studio:", 4);
        tfEpisode = addFormField(formPanel, gbc, "Total Episode:", 5);
        tfMusim = addFormField(formPanel, gbc, "Musim:", 6);
        tfHari = addFormField(formPanel, gbc, "Hari Tayang:", 7);

        // Tombol Tambah Anime
        JButton btnTambah = new JButton("Tambah Anime");
        btnTambah.addActionListener(e -> tambahAnime());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        formPanel.add(btnTambah, gbc);

        add(formPanel, BorderLayout.NORTH);

        // ===== JTABLE =====
        String[] kolom = { "Judul", "Genre", "Tahun", "Status", "Studio",
            "Episode", "Musim", "Hari Tayang" };
        modelAnime = new DefaultTableModel(kolom, 0) {
            /** Mencegah sel tabel diedit langsung oleh pengguna. */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAnime = new JTable(modelAnime);
        JScrollPane scrollPane = new JScrollPane(tableAnime);
        add(scrollPane, BorderLayout.CENTER);

        // ===== PANEL BAWAH (Progress + Info) =====
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // Panel Progress
        JPanel progressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        progressPanel.setBorder(BorderFactory.createTitledBorder("Hitung Progress Tayang"));
        JButton btnProgress = new JButton("Hitung Progress");
        btnProgress.addActionListener(e -> hitungProgress());
        lblProgress = new JLabel("Progress: -");
        lblProgress.setFont(lblProgress.getFont().deriveFont(Font.BOLD));
        progressPanel.add(btnProgress);
        progressPanel.add(Box.createHorizontalStrut(10));
        progressPanel.add(lblProgress);

        // Panel Info (menampilkan getInfo dari Anime)
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Info Anime (getInfo)"));
        JButton btnInfo = new JButton("Tampilkan Info");
        btnInfo.addActionListener(e -> tampilkanInfo());
        lblInfo = new JLabel("Pilih anime dari tabel, lalu klik Tampilkan Info.");
        infoPanel.add(btnInfo);
        infoPanel.add(Box.createHorizontalStrut(10));
        infoPanel.add(lblInfo);

        bottomPanel.add(progressPanel, BorderLayout.NORTH);
        bottomPanel.add(infoPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Menambahkan field form (JLabel + JTextField) ke panel dengan
     * GridBagLayout.
     *
     * @param panel panel tujuan
     * @param gbc GridBagConstraints yang digunakan
     * @param label teks label
     * @param row baris posisi
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
     * Aksi tombol "Tambah Anime". Memvalidasi input, membuat objek
     * {@link Anime}, menyimpan ke list, dan menampilkan di JTable.
     */
    private void tambahAnime() {
        String judul = tfJudul.getText().trim();
        String genre = tfGenre.getText().trim();
        String sTahun = tfTahun.getText().trim();
        String status = tfStatus.getText().trim();
        String studio = tfStudio.getText().trim();
        String sEps = tfEpisode.getText().trim();
        String musim = tfMusim.getText().trim();
        String hari = tfHari.getText().trim();

        // Validasi: cek field tidak kosong
        if (judul.isEmpty() || genre.isEmpty() || sTahun.isEmpty()
                || status.isEmpty() || studio.isEmpty() || sEps.isEmpty()
                || musim.isEmpty() || hari.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Semua field harus diisi!",
                    "Validasi Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi: tahun rilis harus angka
        int tahun;
        try {
            tahun = Integer.parseInt(sTahun);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Tahun Rilis harus berupa angka!",
                    "Validasi Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi: total episode harus angka
        int totalEp;
        try {
            totalEp = Integer.parseInt(sEps);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Total Episode harus berupa angka!",
                    "Validasi Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buat objek Anime (child dari Media) dan simpan
        Anime anime = new Anime(judul, genre, tahun, status, studio, totalEp, musim, hari);
        listAnime.add(anime);

        // Tambahkan ke tabel
        modelAnime.addRow(new Object[] {
            judul, genre, tahun, status, studio, totalEp, musim, hari
        });

        // Reset fields
        clearFields();

        JOptionPane.showMessageDialog(this,
                "Anime \"" + judul + "\" berhasil ditambahkan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Membersihkan semua field input.
     */
    private void clearFields() {
        tfJudul.setText("");
        tfGenre.setText("");
        tfTahun.setText("");
        tfStatus.setText("");
        tfStudio.setText("");
        tfEpisode.setText("");
        tfMusim.setText("");
        tfHari.setText("");
    }

    /**
     * Aksi tombol "Hitung Progress". Meminta user memilih baris di JTable,
     * lalu input episode saat ini, dan menampilkan persentase progress tayang
     * di JLabel.
     */
    private void hitungProgress() {
        int selectedRow = tableAnime.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih anime dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(this,
                "Masukkan episode saat ini untuk \""
                + listAnime.get(selectedRow).getJudul() + "\":");

        if (input == null || input.trim().isEmpty()) {
            return;
        }

        int epSaatIni;
        try {
            epSaatIni = Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Input harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Anime anime = listAnime.get(selectedRow);
        double progress = anime.getProgressTayang(epSaatIni);
        lblProgress.setText(String.format("Progress: %.1f%% (%d / %d episode)",
                progress, epSaatIni, anime.getTotalEpisode()));
        lblProgress.setForeground(progress >= 100.0
                ? new Color(0, 128, 0) : new Color(0, 0, 180));
    }

    /**
     * Aksi tombol "Tampilkan Info". Menampilkan hasil method
     * {@code getInfo()} dari objek Anime yang dipilih di JTable, serta
     * memanggil {@code tampilkanDetail()} ke konsol.
     */
    private void tampilkanInfo() {
        int selectedRow = tableAnime.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih anime dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Anime anime = listAnime.get(selectedRow);
        lblInfo.setText(anime.getInfo());

        // Juga cetak ke konsol menggunakan tampilkanDetail()
        anime.tampilkanDetail();
    }

    /**
     * Method main untuk menjalankan GUI Anime secara standalone.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI_Anime());
    }
}
