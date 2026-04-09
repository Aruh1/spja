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
    protected String judul;

    /** Genre dari media (contoh: "Action", "Romance", "Fantasy"). */
    protected String genre;

    /** Tahun rilis media. */
    protected int tahunRilis;

    /** Status tayang media (contoh: "Ongoing", "Completed", "Upcoming"). */
    protected String status;

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
