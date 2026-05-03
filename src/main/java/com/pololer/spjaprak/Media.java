/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Abstract class Media merupakan parent class (superclass) yang merepresentasikan
 * sebuah entitas media secara umum dalam Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * Class ini menggunakan konsep <b>Abstraksi (Abstraction)</b> dalam OOP.
 * Sebuah abstract class tidak dapat diinstansiasi secara langsung, melainkan
 * harus di-extend oleh class turunan (subclass) yang mengimplementasikan
 * seluruh method abstract yang didefinisikan di class ini.
 * </p>
 *
 * <p>
 * Class ini menyimpan informasi dasar seperti judul, genre, tahun rilis,
 * dan status tayang. Class ini dirancang untuk di-extend oleh class turunan
 * seperti {@link Anime} dan {@link AnimeFilm}.
 * </p>
 *
 * <p>
 * Konsep OOP yang diterapkan:
 * </p>
 * <ul>
 * <li><b>Abstraction</b> — class dideklarasikan sebagai {@code abstract},
 *     memiliki method abstract yang wajib diimplementasikan oleh subclass</li>
 * <li><b>Inheritance</b> — menjadi parent class dari {@link Anime} dan
 *     {@link AnimeFilm}</li>
 * <li><b>Encapsulation</b> — atribut menggunakan akses {@code private}
 *     dengan getter dan setter</li>
 * </ul>
 *
 * <h2>Class Diagram (Abstract Inheritance)</h2>
 * <pre>
 *       ┌────────────────────────────────┐
 *       │    «abstract» Media            │  ← Abstract Parent Class
 *       ├────────────────────────────────┤
 *       │ - judul: String               │
 *       │ - genre: String               │
 *       │ - tahunRilis: int             │
 *       │ - status: String              │
 *       ├────────────────────────────────┤
 *       │ + getInfo(): String           │  (concrete)
 *       │ + tampilkanDetail(): void     │  (concrete)
 *       │ «abstract» getInfoLengkap()   │  → wajib diimplementasi
 *       │ «abstract» hitungNilai()      │  → wajib diimplementasi
 *       └───────────────┬────────────────┘
 *               ┌───────┴────────┐
 *       ┌───────┴──┐      ┌─────┴───────┐
 *       │  Anime   │      │  AnimeFilm  │  ← Concrete Subclass
 *       └──────────┘      └─────────────┘
 * </pre>
 *
 * @author Administrator
 * @version 2.0
 */
public abstract class Media {

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
     * Karena Media adalah abstract class, constructor ini hanya bisa
     * dipanggil melalui {@code super()} dari constructor subclass.
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

    // ===== Abstract Methods (wajib diimplementasi oleh subclass) =====

    /**
     * Method abstract yang mengembalikan informasi lengkap media dalam format
     * String yang terstruktur. Setiap subclass wajib mengimplementasikan
     * method ini sesuai dengan jenis media masing-masing.
     *
     * <p>
     * Berbeda dengan {@link #getInfo()} yang hanya menampilkan ringkasan,
     * method ini mengembalikan detail yang lebih komprehensif termasuk
     * atribut-atribut khusus subclass.
     * </p>
     *
     * @return String berisi informasi lengkap media yang sudah diformat
     */
    public abstract String getInfoLengkap();

    /**
     * Method abstract yang menghitung nilai/skor prioritas media.
     * Setiap subclass wajib mengimplementasikan logika perhitungan
     * yang sesuai dengan jenis media masing-masing.
     *
     * <p>
     * Untuk Anime series, nilai bisa dihitung berdasarkan jumlah episode
     * dan status tayang. Untuk AnimeFilm, nilai bisa dihitung berdasarkan
     * durasi dan status rilis.
     * </p>
     *
     * @return nilai prioritas media dalam bentuk double
     */
    public abstract double hitungNilai();

    // ===== Concrete Methods (sudah memiliki implementasi) =====

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
