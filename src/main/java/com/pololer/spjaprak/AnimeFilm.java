/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class AnimeFilm merupakan child class (subclass) dari {@link Media} yang
 * merepresentasikan sebuah film anime (movie) dalam Sistem Penjadwalan Tayang
 * Anime (SPJA).
 *
 * <p>
 * Class ini mewarisi semua atribut dan method dari {@link Media}, serta
 * menambahkan atribut dan method khusus untuk film anime seperti durasi,
 * tanggal rilis, dan distributor.
 * </p>
 *
 * <p>
 * Konsep OOP yang diterapkan:
 * </p>
 * <ul>
 * <li><b>Inheritance</b> — menggunakan keyword {@code extends}</li>
 * <li><b>Overriding</b> — override method {@code getInfo()} dan
 * {@code tampilkanDetail()}</li>
 * <li><b>super()</b> — memanggil constructor parent di constructor child</li>
 * </ul>
 *
 * @author Administrator
 * @version 1.0
 * @see Media
 */
public class AnimeFilm extends Media {

    /** Durasi film dalam menit. */
    private int durasiMenit;

    /** Tanggal rilis film dalam format "DD-MM-YYYY". */
    private String tanggalRilis;

    /** Nama distributor film. */
    private String distributor;

    /** Format tanggal yang digunakan untuk parsing (DD-MM-YYYY). */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Constructor untuk membuat objek AnimeFilm baru.
     * Menggunakan {@code super()} untuk memanggil constructor parent class
     * {@link Media}.
     *
     * @param judul judul film anime
     * @param genre genre film
     * @param tahunRilis tahun rilis film
     * @param status status tayang ("Ongoing", "Completed", "Upcoming")
     * @param durasiMenit durasi film dalam menit
     * @param tanggalRilis tanggal rilis dalam format "DD-MM-YYYY"
     * @param distributor nama distributor film
     */
    public AnimeFilm(String judul, String genre, int tahunRilis, String status,
            int durasiMenit, String tanggalRilis, String distributor) {
        // Memanggil constructor parent class Media menggunakan super()
        super(judul, genre, tahunRilis, status);
        this.durasiMenit = durasiMenit;
        this.tanggalRilis = tanggalRilis;
        this.distributor = distributor;
    }

    /**
     * Mengubah durasi dari menit ke format "Xj Ym".
     * Contoh: 114 menit → "1j 54m"
     *
     * @return String durasi dalam format "Xj Ym"
     */
    public String getFormatDurasi() {
        int jam = durasiMenit / 60;
        int menit = durasiMenit % 60;
        return jam + "j " + menit + "m";
    }

    /**
     * Mengecek apakah film sudah tayang berdasarkan tanggal rilis.
     * Membandingkan {@code tanggalRilis} dengan tanggal hari ini.
     *
     * @return {@code true} jika film sudah tayang (tanggal rilis &le; hari
     *         ini), {@code false} jika belum tayang atau format tanggal tidak
     *         valid
     */
    public boolean sudahTayang() {
        try {
            LocalDate rilisDate = LocalDate.parse(tanggalRilis, FORMATTER);
            LocalDate today = LocalDate.now();
            return !rilisDate.isAfter(today);
        } catch (DateTimeParseException e) {
            // Jika format tanggal tidak valid, anggap belum tayang
            return false;
        }
    }

    /**
     * Override method {@code getInfo()} dari parent class {@link Media}.
     * Menambahkan informasi durasi, tanggal rilis, dan distributor.
     *
     * @return String berisi ringkasan info film anime lengkap
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " | Durasi: " + getFormatDurasi()
                + " | Rilis: " + tanggalRilis + " | Distributor: " + distributor;
    }

    /**
     * Override method {@code tampilkanDetail()} dari parent class {@link Media}.
     * Mencetak detail lengkap film anime ke konsol.
     */
    @Override
    public void tampilkanDetail() {
        System.out.println("======== Detail Anime Film ========");
        System.out.println("Judul         : " + getJudul());
        System.out.println("Genre         : " + getGenre());
        System.out.println("Tahun Rilis   : " + getTahunRilis());
        System.out.println("Status        : " + getStatus());
        System.out.println("Durasi        : " + getFormatDurasi() + " (" + durasiMenit + " menit)");
        System.out.println("Tanggal Rilis : " + tanggalRilis);
        System.out.println("Distributor   : " + distributor);
        System.out.println("Sudah Tayang  : " + (sudahTayang() ? "Ya" : "Belum"));
        System.out.println("====================================");
    }

    // ===== Overloading Methods (AnimeFilm-specific) =====

    /**
     * Overloading getFormatDurasi() — mengembalikan durasi dengan format custom.
     *
     * @param format format durasi ("FULL", "SHORT", "MENIT")
     * @return String durasi dengan format yang diminta
     */
    public String getFormatDurasi(String format) {
        if ("SHORT".equalsIgnoreCase(format)) {
            // Format singkat: "1j 54m"
            return getFormatDurasi();
        } else if ("MENIT".equalsIgnoreCase(format)) {
            // Hanya dalam menit
            return durasiMenit + " menit";
        } else {
            // Format penuh: "1 jam 54 menit"
            int jam = durasiMenit / 60;
            int menit = durasiMenit % 60;
            return jam + " jam " + menit + " menit";
        }
    }

    /**
     * Overloading getFormatDurasi() — mengembalikan durasi dengan durasi custom.
     *
     * @param durasiCustom durasi dalam menit yang akan diformat (berbeda dari durasiMenit)
     * @return String durasi custom dalam format "Xj Ym"
     */
    public String getFormatDurasi(int durasiCustom) {
        int jam = durasiCustom / 60;
        int menit = durasiCustom % 60;
        return jam + "j " + menit + "m";
    }

    /**
     * Overloading sudahTayang() — mengecek status tayang berdasarkan tanggal custom.
     *
     * @param tanggalCek tanggal untuk pengecekan (format "DD-MM-YYYY")
     * @return true jika tanggalRilis &le; tanggalCek
     */
    public boolean sudahTayang(String tanggalCek) {
        try {
            LocalDate rilisDate = LocalDate.parse(tanggalRilis, FORMATTER);
            LocalDate checkDate = LocalDate.parse(tanggalCek, FORMATTER);
            return !rilisDate.isAfter(checkDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Overloading sudahTayang() — mengecek status tayang berdasarkan hari offset.
     *
     * @param hariOffset jumlah hari dari hari ini (negatif = masa lalu, positif = masa depan)
     * @return true jika tanggalRilis &le; (hari ini + hariOffset)
     */
    public boolean sudahTayang(int hariOffset) {
        try {
            LocalDate rilisDate = LocalDate.parse(tanggalRilis, FORMATTER);
            LocalDate checkDate = LocalDate.now().plusDays(hariOffset);
            return !rilisDate.isAfter(checkDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Overloading getInfo() — mengembalikan info dengan distributor dan rilis date.
     *
     * @param withDistributor jika true, tampilkan distributor dalam info
     * @param withReleaseDate jika true, tampilkan tanggal rilis dalam info
     * @return String berisi info film dengan filter
     */
    public String getInfo(boolean withDistributor, boolean withReleaseDate) {
        StringBuilder info = new StringBuilder(getJudul());
        info.append(" | ").append(getFormatDurasi());
        if (withDistributor) {
            info.append(" | Distributor: ").append(distributor);
        }
        if (withReleaseDate) {
            info.append(" | Rilis: ").append(tanggalRilis);
        }
        return info.toString();
    }

    /**
     * Overloading getInfo() — mengembalikan info dengan filter field spesifik.
     *
     * @param fieldFilter field mana yang ditampilkan ("DURASI", "DISTRIBUTOR", "RILIS", "ALL")
     * @return String berisi info film sesuai filter
     */
    public String getInfo(String fieldFilter) {
        switch (fieldFilter.toUpperCase()) {
            case "DURASI":
                return getJudul() + " | Durasi: " + getFormatDurasi();
            case "DISTRIBUTOR":
                return getJudul() + " | Distributor: " + distributor;
            case "RILIS":
                return getJudul() + " | Rilis: " + tanggalRilis + " | Status: " + (sudahTayang() ? "Sudah Tayang" : "Belum Tayang");
            case "ALL":
            default:
                return getInfo();
        }
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan informasi status tayang.
     *
     * @param withStatusDetail jika true, tampilkan detail status tayang
     */
    public void tampilkanDetail(boolean withStatusDetail) {
        tampilkanDetail();
        if (withStatusDetail) {
            System.out.println("Status Tayang Detail:");
            System.out.println("  - Hari Ini    : " + (sudahTayang() ? "Sudah Tayang" : "Belum Tayang"));
            System.out.println("  - 1 Minggu KD : " + (sudahTayang(7) ? "Sudah Tayang" : "Belum Tayang"));
            System.out.println("  - 1 Bulan KD  : " + (sudahTayang(30) ? "Sudah Tayang" : "Belum Tayang"));
        }
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan info durasi custom.
     *
     * @param durationFormat format durasi yang ingin ditampilkan ("FULL", "SHORT", "MENIT")
     */
    public void tampilkanDetail(String durationFormat) {
        System.out.println("======== Detail Anime Film ========");
        System.out.println("Judul         : " + getJudul());
        System.out.println("Genre         : " + getGenre());
        System.out.println("Tahun Rilis   : " + getTahunRilis());
        System.out.println("Status        : " + getStatus());
        System.out.println("Durasi        : " + getFormatDurasi(durationFormat));
        System.out.println("Tanggal Rilis : " + tanggalRilis);
        System.out.println("Distributor   : " + distributor);
        System.out.println("Sudah Tayang  : " + (sudahTayang() ? "Ya" : "Belum"));
        System.out.println("====================================");
    }

    // ===== Getter & Setter =====

    /**
     * Mendapatkan durasi film dalam menit.
     *
     * @return durasi dalam menit
     */
    public int getDurasiMenit() {
        return durasiMenit;
    }

    /**
     * Mengubah durasi film.
     *
     * @param durasiMenit durasi baru dalam menit
     */
    public void setDurasiMenit(int durasiMenit) {
        this.durasiMenit = durasiMenit;
    }

    /**
     * Mendapatkan tanggal rilis film.
     *
     * @return tanggal rilis dalam format "DD-MM-YYYY"
     */
    public String getTanggalRilis() {
        return tanggalRilis;
    }

    /**
     * Mengubah tanggal rilis film.
     *
     * @param tanggalRilis tanggal rilis baru (format "DD-MM-YYYY")
     */
    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    /**
     * Mendapatkan nama distributor.
     *
     * @return nama distributor
     */
    public String getDistributor() {
        return distributor;
    }

    /**
     * Mengubah nama distributor.
     *
     * @param distributor nama distributor baru
     */
    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }
}
