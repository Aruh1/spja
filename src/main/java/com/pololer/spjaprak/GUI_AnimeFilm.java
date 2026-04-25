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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Class GUI_AnimeFilm merupakan class GUI berbasis Java Swing yang menyediakan
 * antarmuka grafis khusus untuk mengelola data Anime Film (movie) dalam Sistem
 * Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * GUI ini menampilkan form input untuk data film anime, JTable untuk daftar
 * film, status tayang otomatis, dan fitur format durasi.
 * </p>
 *
 * <p>
 * Data disimpan menggunakan {@link ArrayList} dari objek {@link AnimeFilm}.
 * </p>
 *
 * @author Administrator
 * @version 1.0
 * @see AnimeFilm
 * @see Media
 */
public class GUI_AnimeFilm extends JFrame {

    /** List untuk menyimpan data anime film. */
    private final ArrayList<AnimeFilm> listFilm = new ArrayList<>();

    /** Field input judul film. */
    private JTextField tfJudul;

    /** Field input genre film. */
    private JTextField tfGenre;

    /** Field input tahun rilis film. */
    private JTextField tfTahun;

    /** Field input status film. */
    private JTextField tfStatus;

    /** Field input durasi film (menit). */
    private JTextField tfDurasi;

    /** Field input tanggal rilis film (DD-MM-YYYY). */
    private JTextField tfTanggal;

    /** Field input distributor film. */
    private JTextField tfDistributor;

    /** Tombol Tambah Film. */
    private JButton btnTambah;

    /** Tombol Hapus Film. */
    private JButton btnHapus;

    /** Tombol Simpan. */
    private JButton btnSimpan;

    /** Tombol Batal. */
    private JButton btnBatal;

    /** Tombol Close. */
    private JButton btnClose;

    /** Tabel untuk menampilkan data anime film. */
    private JTable tableFilm;

    /** Model tabel anime film. */
    private DefaultTableModel modelFilm;

    /** Label untuk menampilkan status tayang otomatis. */
    private JLabel lblStatusTayang;

    /** Label untuk menampilkan info dari getInfo(). */
    private JLabel lblInfo;

    /**
     * Constructor GUI_AnimeFilm.
     * Menginisialisasi seluruh komponen GUI dan menampilkan JFrame.
     */
    public GUI_AnimeFilm() {
        setTitle("SPJA — Kelola Anime Film");
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
        formPanel.setBorder(BorderFactory.createTitledBorder("Input Data Anime Film"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tfJudul = addFormField(formPanel, gbc, "Judul:", 0);
        tfGenre = addFormField(formPanel, gbc, "Genre:", 1);
        tfTahun = addFormField(formPanel, gbc, "Tahun Rilis:", 2);
        tfStatus = addFormField(formPanel, gbc, "Status:", 3);
        tfDurasi = addFormField(formPanel, gbc, "Durasi (menit):", 4);
        tfTanggal = addFormField(formPanel, gbc, "Tanggal Rilis (DD-MM-YYYY):", 5);
        tfDistributor = addFormField(formPanel, gbc, "Distributor:", 6);

        // Label Status Tayang (otomatis update saat input tanggal)
        lblStatusTayang = new JLabel("Status Tayang: -");
        lblStatusTayang.setFont(lblStatusTayang.getFont().deriveFont(Font.BOLD));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(lblStatusTayang, gbc);

        // DocumentListener untuk auto-update status tayang
        tfTanggal.getDocument().addDocumentListener(new DocumentListener() {
            /** Dipanggil saat teks di-insert. */
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStatusTayang();
            }

            /** Dipanggil saat teks dihapus. */
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStatusTayang();
            }

            /** Dipanggil saat atribut teks berubah. */
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStatusTayang();
            }
        });

        // Tombol Tambah Film
        btnTambah = new JButton("Tambah Film");
        btnTambah.addActionListener(e -> tambahFilm());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        formPanel.add(btnTambah, gbc);

        add(formPanel, BorderLayout.NORTH);

        // ===== JTABLE =====
        String[] kolom = { "Judul", "Genre", "Tahun", "Status", "Durasi",
            "Tanggal Rilis", "Distributor" };
        modelFilm = new DefaultTableModel(kolom, 0) {
            /** Mencegah sel tabel diedit langsung oleh pengguna. */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableFilm = new JTable(modelFilm);
        JScrollPane scrollPane = new JScrollPane(tableFilm);

        // ===== PANEL TOMBOL AKSI (Simpan, Hapus, Batal, Close) =====
        JPanel buttonActionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonActionPanel.setBorder(BorderFactory.createTitledBorder("Aksi"));

        btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(e -> simpanData());
        buttonActionPanel.add(btnSimpan);

        btnHapus = new JButton("Hapus");
        btnHapus.addActionListener(e -> hapusFilm());
        buttonActionPanel.add(btnHapus);

        btnBatal = new JButton("Batal");
        btnBatal.addActionListener(e -> clearFields());
        buttonActionPanel.add(btnBatal);

        btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());
        buttonActionPanel.add(btnClose);

        // ===== PANEL WRAPPER (Tabel + Tombol Aksi) =====
        JPanel centerWrapperPanel = new JPanel(new BorderLayout(5, 5));
        centerWrapperPanel.add(scrollPane, BorderLayout.CENTER);
        centerWrapperPanel.add(buttonActionPanel, BorderLayout.SOUTH);
        add(centerWrapperPanel, BorderLayout.CENTER);

        // ===== PANEL BAWAH (Info) =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Info Film (getInfo)"));
        JButton btnInfo = new JButton("Tampilkan Info");
        btnInfo.addActionListener(e -> tampilkanInfo());
        lblInfo = new JLabel("Pilih film dari tabel, lalu klik Tampilkan Info.");
        bottomPanel.add(btnInfo);
        bottomPanel.add(Box.createHorizontalStrut(10));
        bottomPanel.add(lblInfo);
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
     * Mengupdate label status tayang secara otomatis berdasarkan input tanggal
     * rilis. Membuat objek {@link AnimeFilm} sementara untuk memanfaatkan
     * method {@code sudahTayang()}.
     */
    private void updateStatusTayang() {
        String tanggal = tfTanggal.getText().trim();
        if (tanggal.length() == 10) {
            // Buat objek sementara untuk mengecek status tayang
            AnimeFilm temp = new AnimeFilm("", "", 0, "", 0, tanggal, "");
            if (temp.sudahTayang()) {
                lblStatusTayang.setText("Status Tayang: ✅ Sudah Tayang");
                lblStatusTayang.setForeground(new Color(0, 128, 0));
            } else {
                lblStatusTayang.setText("Status Tayang: ⏳ Belum Tayang");
                lblStatusTayang.setForeground(new Color(200, 100, 0));
            }
        } else {
            lblStatusTayang.setText("Status Tayang: -");
            lblStatusTayang.setForeground(Color.BLACK);
        }
    }

    /**
     * Aksi tombol "Tambah Film". Memvalidasi input, membuat objek
     * {@link AnimeFilm}, menyimpan ke list, dan menampilkan di JTable.
     */
    private void tambahFilm() {
        String judul = tfJudul.getText().trim();
        String genre = tfGenre.getText().trim();
        String sTahun = tfTahun.getText().trim();
        String status = tfStatus.getText().trim();
        String sDurasi = tfDurasi.getText().trim();
        String tanggal = tfTanggal.getText().trim();
        String distro = tfDistributor.getText().trim();

        // Validasi: cek field tidak kosong
        if (judul.isEmpty() || genre.isEmpty() || sTahun.isEmpty()
                || status.isEmpty() || sDurasi.isEmpty() || tanggal.isEmpty()
                || distro.isEmpty()) {
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

        // Buat objek AnimeFilm (child dari Media) dan simpan
        AnimeFilm film = new AnimeFilm(judul, genre, tahun, status, durasi, tanggal, distro);
        listFilm.add(film);

        // Tambahkan ke tabel (durasi ditampilkan dalam format "Xj Ym")
        modelFilm.addRow(new Object[] {
            judul, genre, tahun, status, film.getFormatDurasi(), tanggal, distro
        });

        // Reset fields
        clearFields();

        JOptionPane.showMessageDialog(this,
                "Film \"" + judul + "\" berhasil ditambahkan!",
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
        tfDurasi.setText("");
        tfTanggal.setText("");
        tfDistributor.setText("");
        lblStatusTayang.setText("Status Tayang: -");
        lblStatusTayang.setForeground(Color.BLACK);
    }

    /**
     * Aksi tombol "Simpan". Menyimpan data dari list ke konsol dan menampilkan
     * pesan bahwa data telah disimpan.
     */
    private void simpanData() {
        if (listFilm.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Tidak ada data untuk disimpan!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        System.out.println("\n========== SIMPAN DATA ANIME FILM ==========");
        System.out.println("Total Film: " + listFilm.size());
        for (int i = 0; i < listFilm.size(); i++) {
            System.out.println((i + 1) + ". " + listFilm.get(i).getInfo());
        }
        System.out.println("===========================================\n");

        JOptionPane.showMessageDialog(this,
                "Data disimpan! Total: " + listFilm.size() + " film.\n"
                + "Lihat console untuk detail.",
                "Simpan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Aksi tombol "Hapus". Menghapus film yang dipilih dari tabel dan list.
     */
    private void hapusFilm() {
        int selectedRow = tableFilm.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih film dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String judul = listFilm.get(selectedRow).getJudul();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus film \"" + judul + "\"?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            listFilm.remove(selectedRow);
            modelFilm.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this,
                    "Film \"" + judul + "\" berhasil dihapus!",
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Aksi tombol "Tampilkan Info". Menampilkan hasil method
     * {@code getInfo()} dari objek AnimeFilm yang dipilih di JTable, serta
     * memanggil {@code tampilkanDetail()} ke konsol.
     */
    private void tampilkanInfo() {
        int selectedRow = tableFilm.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih film dari tabel terlebih dahulu!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        AnimeFilm film = listFilm.get(selectedRow);
        lblInfo.setText(film.getInfo());

        // Juga cetak ke konsol menggunakan tampilkanDetail()
        film.tampilkanDetail();
    }

    /**
     * Method main untuk menjalankan GUI AnimeFilm secara standalone.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI_AnimeFilm());
    }
}
