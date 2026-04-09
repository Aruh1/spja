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
        System.out.println("Judul         : " + judul);
        System.out.println("Genre         : " + genre);
        System.out.println("Tahun Rilis   : " + tahunRilis);
        System.out.println("Status        : " + status);
        System.out.println("Durasi        : " + getFormatDurasi() + " (" + durasiMenit + " menit)");
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
