// === GUI_AnimeManager.java ===
package com.pololer.spjaprak;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * Class GUI_AnimeManager merupakan class GUI berbasis Java Swing yang
 * menyediakan antarmuka grafis untuk mengelola data Anime Series dan Anime Film
 * dalam Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * GUI ini menggunakan {@link JTabbedPane} dengan 2 tab:
 * </p>
 * <ul>
 * <li><b>Tab 1 — Anime Series</b>: Form input + JTable + Hitung Progress</li>
 * <li><b>Tab 2 — Anime Film</b>: Form input + JTable + Status Tayang
 * otomatis</li>
 * </ul>
 *
 * <p>
 * Data disimpan menggunakan {@link ArrayList} dari objek {@link Anime}
 * dan {@link AnimeFilm}.
 * </p>
 *
 * @author Administrator
 * @version 1.0
 * @see Anime
 * @see AnimeFilm
 * @see Media
 */
public class GUI_AnimeManager extends JFrame {

    // ===== Data Storage =====
    /** List untuk menyimpan data anime series. */
    private final ArrayList<Anime> listAnime = new ArrayList<>();

    /** List untuk menyimpan data anime film. */
    private final ArrayList<AnimeFilm> listFilm = new ArrayList<>();

    // ===== Tab 1 — Anime Series Components =====
    /** Field input judul anime. */
    private JTextField tfJudul, tfGenre, tfTahun, tfStatus, tfStudio, tfEpisode, tfMusim, tfHari;
    /** Tabel untuk menampilkan data anime series. */
    private JTable tableAnime;
    /** Model tabel anime series. */
    private DefaultTableModel modelAnime;
    /** Label untuk menampilkan hasil hitung progress. */
    private JLabel lblProgress;

    // ===== Tab 2 — Anime Film Components =====
    /** Field input judul film anime. */
    private JTextField tfFJudul, tfFGenre, tfFTahun, tfFStatus, tfFDurasi, tfFTanggal, tfFDistributor;
    /** Tabel untuk menampilkan data anime film. */
    private JTable tableFilm;
    /** Model tabel anime film. */
    private DefaultTableModel modelFilm;
    /** Label untuk menampilkan status tayang otomatis. */
    private JLabel lblStatusTayang;

    /**
     * Constructor GUI_AnimeManager.
     * Menginisialisasi seluruh komponen GUI dan menampilkan JFrame.
     */
    public GUI_AnimeManager() {
        setTitle("SPJA — Anime Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null);
        setResizable(true);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Anime Series", buildTabAnime());
        tabbedPane.addTab("Anime Film", buildTabFilm());

        add(tabbedPane);
        setVisible(true);
    }

    // ========================================================================
    // TAB 1 — ANIME SERIES
    // ========================================================================

    /**
     * Membangun panel untuk tab Anime Series.
     *
     * @return JPanel berisi form input, JTable, dan tombol aksi
     */
    private JPanel buildTabAnime() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ----- Form Input -----
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Input Anime Series"));
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

        // ----- Tombol Tambah -----
        JButton btnTambah = new JButton("Tambah Anime");
        btnTambah.addActionListener(e -> tambahAnime());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        formPanel.add(btnTambah, gbc);

        panel.add(formPanel, BorderLayout.NORTH);

        // ----- JTable -----
        String[] kolom = { "Judul", "Genre", "Tahun", "Status", "Studio", "Episode", "Musim", "Hari" };
        modelAnime = new DefaultTableModel(kolom, 0) {
            /** Mencegah sel tabel diedit langsung oleh pengguna. */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAnime = new JTable(modelAnime);
        JScrollPane scrollAnime = new JScrollPane(tableAnime);
        panel.add(scrollAnime, BorderLayout.CENTER);

        // ----- Progress Panel -----
        JPanel progressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        progressPanel.setBorder(BorderFactory.createTitledBorder("Hitung Progress Tayang"));
        JButton btnProgress = new JButton("Hitung Progress");
        btnProgress.addActionListener(e -> hitungProgress());
        lblProgress = new JLabel("Progress: -");
        progressPanel.add(btnProgress);
        progressPanel.add(Box.createHorizontalStrut(10));
        progressPanel.add(lblProgress);
        panel.add(progressPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Menambahkan field form (JLabel + JTextField) ke panel dengan GridBagLayout.
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
     * Aksi tombol "Tambah Anime".
     * Memvalidasi input, membuat objek {@link Anime}, menyimpan ke list,
     * dan menampilkan di JTable.
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
        if (judul.isEmpty() || genre.isEmpty() || sTahun.isEmpty() || status.isEmpty()
                || studio.isEmpty() || sEps.isEmpty() || musim.isEmpty() || hari.isEmpty()) {
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
        clearAnimeFields();

        JOptionPane.showMessageDialog(this,
                "Anime \"" + judul + "\" berhasil ditambahkan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Membersihkan semua field input pada tab Anime Series.
     */
    private void clearAnimeFields() {
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
     * Aksi tombol "Hitung Progress".
     * Meminta user memilih baris di JTable, lalu input episode saat ini,
     * dan menampilkan persentase progress tayang di JLabel.
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

        double progress = listAnime.get(selectedRow).getProgressTayang(epSaatIni);
        lblProgress.setText(String.format("Progress: %.1f%% (%d / %d episode)",
                progress, epSaatIni, listAnime.get(selectedRow).getTotalEpisode()));
    }

    // ========================================================================
    // TAB 2 — ANIME FILM
    // ========================================================================

    /**
     * Membangun panel untuk tab Anime Film.
     *
     * @return JPanel berisi form input, JTable, dan label status tayang
     */
    private JPanel buildTabFilm() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ----- Form Input -----
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Input Anime Film"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tfFJudul = addFormField(formPanel, gbc, "Judul:", 0);
        tfFGenre = addFormField(formPanel, gbc, "Genre:", 1);
        tfFTahun = addFormField(formPanel, gbc, "Tahun Rilis:", 2);
        tfFStatus = addFormField(formPanel, gbc, "Status:", 3);
        tfFDurasi = addFormField(formPanel, gbc, "Durasi (menit):", 4);
        tfFTanggal = addFormField(formPanel, gbc, "Tanggal Rilis (DD-MM-YYYY):", 5);
        tfFDistributor = addFormField(formPanel, gbc, "Distributor:", 6);

        // ----- Label Status Tayang (otomatis update) -----
        lblStatusTayang = new JLabel("Status Tayang: -");
        lblStatusTayang.setFont(lblStatusTayang.getFont().deriveFont(Font.BOLD));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        formPanel.add(lblStatusTayang, gbc);

        // Listener otomatis pada field tanggal rilis
        tfFTanggal.getDocument().addDocumentListener(new DocumentListener() {
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

        // ----- Tombol Tambah -----
        JButton btnTambahFilm = new JButton("Tambah Film");
        btnTambahFilm.addActionListener(e -> tambahFilm());
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        formPanel.add(btnTambahFilm, gbc);

        panel.add(formPanel, BorderLayout.NORTH);

        // ----- JTable -----
        String[] kolom = { "Judul", "Genre", "Tahun", "Status", "Durasi", "Tanggal Rilis", "Distributor" };
        modelFilm = new DefaultTableModel(kolom, 0) {
            /** Mencegah sel tabel diedit langsung oleh pengguna. */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableFilm = new JTable(modelFilm);
        JScrollPane scrollFilm = new JScrollPane(tableFilm);
        panel.add(scrollFilm, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Mengupdate label status tayang secara otomatis berdasarkan input tanggal
     * rilis.
     * Membuat objek {@link AnimeFilm} sementara untuk memanfaatkan method
     * {@code sudahTayang()}.
     */
    private void updateStatusTayang() {
        String tanggal = tfFTanggal.getText().trim();
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
     * Aksi tombol "Tambah Film".
     * Memvalidasi input, membuat objek {@link AnimeFilm}, menyimpan ke list,
     * dan menampilkan di JTable.
     */
    private void tambahFilm() {
        String judul = tfFJudul.getText().trim();
        String genre = tfFGenre.getText().trim();
        String sTahun = tfFTahun.getText().trim();
        String status = tfFStatus.getText().trim();
        String sDurasi = tfFDurasi.getText().trim();
        String tanggal = tfFTanggal.getText().trim();
        String distro = tfFDistributor.getText().trim();

        // Validasi: cek field tidak kosong
        if (judul.isEmpty() || genre.isEmpty() || sTahun.isEmpty() || status.isEmpty()
                || sDurasi.isEmpty() || tanggal.isEmpty() || distro.isEmpty()) {
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

        // Tambahkan ke tabel
        modelFilm.addRow(new Object[] {
                judul, genre, tahun, status, film.getFormatDurasi(), tanggal, distro
        });

        // Reset fields
        clearFilmFields();

        JOptionPane.showMessageDialog(this,
                "Film \"" + judul + "\" berhasil ditambahkan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Membersihkan semua field input pada tab Anime Film.
     */
    private void clearFilmFields() {
        tfFJudul.setText("");
        tfFGenre.setText("");
        tfFTahun.setText("");
        tfFStatus.setText("");
        tfFDurasi.setText("");
        tfFTanggal.setText("");
        tfFDistributor.setText("");
        lblStatusTayang.setText("Status Tayang: -");
        lblStatusTayang.setForeground(Color.BLACK);
    }

    // ========================================================================
    // MAIN METHOD
    // ========================================================================

    /**
     * Method main untuk menjalankan GUI Anime Manager.
     * Menggunakan {@code SwingUtilities.invokeLater} untuk thread safety.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI_AnimeManager());
    }
}
