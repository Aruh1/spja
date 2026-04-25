/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Class Media merupakan parent class (superclass) yang merepresentasikan
 * sebuah entitas media secara umum dalam Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * Class ini menyimpan informasi dasar seperti judul, genre, tahun rilis,
 * dan status tayang. Class ini dirancang untuk di-extend oleh class turunan
 * seperti {@link Anime} dan {@link AnimeFilm}.
 * </p>
 *
 * <h2>Class Diagram (Inheritance)</h2>
 * <pre>
 *         ┌──────────────────┐
 *         │      Media       │  ← Parent (Superclass)
 *         ├──────────────────┤
 *         │ - judul: String  │
 *         │ - genre: String  │
 *         │ - tahunRilis: int│
 *         │ - status: String │
 *         ├──────────────────┤
 *         │ + getInfo()      │
 *         │ + tampilkanDetail│
 *         └────────┬─────────┘
 *            ┌─────┴──────┐
 *    ┌───────┴──┐   ┌─────┴───────┐
 *    │  Anime   │   │  AnimeFilm  │  ← Child (Subclass)
 *    └──────────┘   └─────────────┘
 * </pre>
 *
 * @author Administrator
 * @version 1.0
 */
public class Media {

    /** Judul dari media. */
    private String judul;

    /** Genre dari media (contoh: "Action", "Romance", "Fantasy"). */
    private String genre;

    /** Tahun rilis media. */
    private int tahunRilis;

    /** Status tayang media (contoh: "Ongoing", "Completed", "Upcoming"). */
    private String status;

    /**
     * Constructor untuk membuat objek Media baru.
     *
     * @param judul judul media
     * @param genre genre media
     * @param tahunRilis tahun rilis media
     * @param status status tayang media ("Ongoing", "Completed", "Upcoming")
     */
    public Media(String judul, String genre, int tahunRilis, String status) {
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.status = status;
    }

    /**
     * Mengembalikan ringkasan informasi media dalam format String.
     *
     * @return String berisi ringkasan info media
     */
    public String getInfo() {
        return "Judul: " + judul + " | Genre: " + genre
                + " | Tahun: " + tahunRilis + " | Status: " + status;
    }

    /**
     * Mencetak detail informasi media ke konsol.
     */
    public void tampilkanDetail() {
        System.out.println("========== Detail Media ==========");
        System.out.println("Judul       : " + judul);
        System.out.println("Genre       : " + genre);
        System.out.println("Tahun Rilis : " + tahunRilis);
        System.out.println("Status      : " + status);
        System.out.println("==================================");
    }

    // ===== Overloading Methods =====

    /**
     * Overloading getInfo() — mengembalikan info hanya judul dan genre.
     *
     * @param showGenre jika true, tampilkan genre dalam info
     * @return String berisi judul dan genre media
     */
    public String getInfo(boolean showGenre) {
        if (showGenre) {
            return "Judul: " + judul + " | Genre: " + genre;
        } else {
            return "Judul: " + judul;
        }
    }

    /**
     * Overloading getInfo() — mengembalikan info dengan delimiter kustom.
     *
     * @param delimiter pemisah custom untuk setiap field
     * @return String berisi info media dengan delimiter kustom
     */
    public String getInfo(String delimiter) {
        return "Judul: " + judul + delimiter + "Genre: " + genre
                + delimiter + "Tahun: " + tahunRilis + delimiter + "Status: " + status;
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan limit field.
     *
     * @param limit jumlah field yang akan ditampilkan (1-4, dimulai dari judul)
     */
    public void tampilkanDetail(int limit) {
        System.out.println("========== Detail Media (Limited) ==========");
        if (limit >= 1) {
            System.out.println("Judul       : " + judul);
        }
        if (limit >= 2) {
            System.out.println("Genre       : " + genre);
        }
        if (limit >= 3) {
            System.out.println("Tahun Rilis : " + tahunRilis);
        }
        if (limit >= 4) {
            System.out.println("Status      : " + status);
        }
        System.out.println("===========================================");
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan format custom.
     *
     * @param format format display ("SIMPLE", "FULL", "COMPACT")
     */
    public void tampilkanDetail(String format) {
        if ("SIMPLE".equalsIgnoreCase(format)) {
            System.out.println(">> " + judul);
        } else if ("COMPACT".equalsIgnoreCase(format)) {
            System.out.println(judul + " (" + tahunRilis + ") - " + status);
        } else {
            // Default FULL format
            tampilkanDetail();
        }
    }

    // ===== Getter & Setter =====

    /**
     * Mendapatkan judul media.
     *
     * @return judul media
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Mengubah judul media.
     *
     * @param judul judul baru
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * Mendapatkan genre media.
     *
     * @return genre media
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Mengubah genre media.
     *
     * @param genre genre baru
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Mendapatkan tahun rilis media.
     *
     * @return tahun rilis
     */
    public int getTahunRilis() {
        return tahunRilis;
    }

    /**
     * Mengubah tahun rilis media.
     *
     * @param tahunRilis tahun rilis baru
     */
    public void setTahunRilis(int tahunRilis) {
        this.tahunRilis = tahunRilis;
    }

    /**
     * Mendapatkan status tayang media.
     *
     * @return status tayang
     */
    public String getStatus() {
        return status;
    }

    /**
     * Mengubah status tayang media.
     *
     * @param status status baru
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
