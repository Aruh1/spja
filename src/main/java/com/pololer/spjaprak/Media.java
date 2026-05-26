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
 * Class ini mengimplementasikan beberapa interface untuk memberikan
 * fleksibilitas dan polymorphism:
 * </p>
 * <ul>
 * <li>{@link Informasi} — untuk operasi menampilkan informasi media</li>
 * <li>{@link Calculable} — untuk operasi perhitungan nilai dan validasi</li>
 * <li>{@link Editable} — untuk operasi modifikasi atribut media</li>
 * <li>{@link Comparable} — untuk operasi perbandingan antar media</li>
 * <li>{@link Serialisable} — untuk konversi ke berbagai format string</li>
 * </ul>
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
 * <li><b>Interface Implementation</b> — mengimplementasikan multiple interfaces
 *     untuk polymorphism dan kontrak method yang jelas</li>
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
public abstract class Media implements Informasi, Calculable, Editable, Comparable, Serialisable {

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

    // ===== Implementasi Interface Calculable =====

    /**
     * Memeriksa apakah media saat ini sedang tayang (status "Ongoing").
     *
     * @return true jika status media adalah "Ongoing", false sebaliknya
     */
    @Override
    public boolean isSedangTayang() {
        return status != null && status.equalsIgnoreCase("Ongoing");
    }

    /**
     * Memeriksa apakah media sudah selesai tayang (status "Completed").
     *
     * @return true jika status media adalah "Completed", false sebaliknya
     */
    @Override
    public boolean isSudahSelesai() {
        return status != null && status.equalsIgnoreCase("Completed");
    }

    /**
     * Memeriksa apakah media akan datang (status "Upcoming").
     *
     * @return true jika status media adalah "Upcoming", false sebaliknya
     */
    @Override
    public boolean isAkanDatang() {
        return status != null && status.equalsIgnoreCase("Upcoming");
    }

    /**
     * Menghitung persentase kelengkapan atau progress dari media.
     * Dalam Media class dasar, method ini mengembalikan 0.0.
     * Subclass dapat override method ini untuk perhitungan yang lebih spesifik.
     *
     * @return persentase progress (default 0.0, override di subclass)
     */
    @Override
    public double hitungProgress() {
        return 0.0;
    }

    // ===== Implementasi Interface Editable =====

    /**
     * Melakukan reset/pembersihan semua atribut media ke nilai default.
     * Setelah reset, semua field akan kosong (null atau 0).
     */
    @Override
    public void reset() {
        this.judul = null;
        this.genre = null;
        this.tahunRilis = 0;
        this.status = null;
    }

    /**
     * Memeriksa apakah semua atribut media valid dan terisi dengan benar.
     *
     * <p>
     * Validasi mencakup:
     * </p>
     * <ul>
     * <li>Judul tidak null dan tidak kosong</li>
     * <li>Genre tidak null dan tidak kosong</li>
     * <li>Tahun rilis > 0 dan <= tahun sekarang</li>
     * <li>Status harus salah satu dari: "Ongoing", "Completed", "Upcoming"</li>
     * </ul>
     *
     * @return true jika semua atribut valid, false sebaliknya
     */
    @Override
    public boolean isValid() {
        // Validasi judul
        if (judul == null || judul.trim().isEmpty()) {
            return false;
        }

        // Validasi genre
        if (genre == null || genre.trim().isEmpty()) {
            return false;
        }

        // Validasi tahun rilis
        int tahunSekarang = java.time.Year.now().getValue();
        if (tahunRilis <= 0 || tahunRilis > tahunSekarang) {
            return false;
        }

        // Validasi status
        if (status == null || status.trim().isEmpty()) {
            return false;
        }

        String statusLower = status.toLowerCase();
        if (!statusLower.equals("ongoing") && !statusLower.equals("completed") 
                && !statusLower.equals("upcoming")) {
            return false;
        }

        return true;
    }

    // ===== Implementasi Interface Comparable =====

    /**
     * Membandingkan nilai (skor prioritas) dari media ini dengan media lain.
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan nilai prioritas
     */
    @Override
    public int compareByNilai(Object other) {
        if (!(other instanceof Calculable)) {
            return 0;
        }

        double nilaiIni = this.hitungNilai();
        double nilaiOther = ((Calculable) other).hitungNilai();

        if (nilaiIni < nilaiOther) {
            return -1;
        } else if (nilaiIni > nilaiOther) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Membandingkan judul dari media ini dengan media lain secara alfabetis.
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan judul secara alfabetis
     */
    @Override
    public int compareByJudul(Object other) {
        if (!(other instanceof Informasi)) {
            return 0;
        }

        String judulOther = ((Informasi) other).getJudul();
        if (judulOther == null) {
            judulOther = "";
        }

        return this.judul.compareToIgnoreCase(judulOther);
    }

    /**
     * Membandingkan tahun rilis dari media ini dengan media lain.
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan tahun rilis
     */
    @Override
    public int compareByTahunRilis(Object other) {
        if (!(other instanceof Informasi)) {
            return 0;
        }

        int tahunOther = ((Informasi) other).getTahunRilis();

        if (this.tahunRilis < tahunOther) {
            return -1;
        } else if (this.tahunRilis > tahunOther) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Membandingkan status tayang dari media ini dengan media lain.
     * Urutan prioritas: "Ongoing" > "Upcoming" > "Completed"
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan status
     */
    @Override
    public int compareByStatus(Object other) {
        if (!(other instanceof Informasi)) {
            return 0;
        }

        String statusOther = ((Informasi) other).getStatus();
        if (statusOther == null) {
            statusOther = "";
        }

        int prioritasIni = getStatusPriority(this.status);
        int prioritasOther = getStatusPriority(statusOther);

        if (prioritasIni < prioritasOther) {
            return -1;
        } else if (prioritasIni > prioritasOther) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Helper method untuk mendapatkan prioritas dari status.
     * Urutan: Ongoing (3) > Upcoming (2) > Completed (1) > Unknown (0)
     *
     * @param status status yang akan diubah menjadi prioritas
     * @return nilai prioritas (0-3)
     */
    private int getStatusPriority(String status) {
        if (status == null || status.isEmpty()) {
            return 0;
        }

        switch (status.toLowerCase()) {
            case "ongoing":
                return 3;
            case "upcoming":
                return 2;
            case "completed":
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Memeriksa apakah media ini memiliki genre yang sama dengan media lain.
     *
     * @param other media lain untuk dibandingkan
     * @return true jika genre sama, false sebaliknya
     */
    @Override
    public boolean hasSameGenre(Object other) {
        if (!(other instanceof Informasi)) {
            return false;
        }

        String genreOther = ((Informasi) other).getGenre();
        if (genreOther == null) {
            genreOther = "";
        }

        return this.genre.equalsIgnoreCase(genreOther);
    }

    /**
     * Memeriksa apakah media ini memiliki tahun rilis yang sama dengan media lain.
     *
     * @param other media lain untuk dibandingkan
     * @return true jika tahun rilis sama, false sebaliknya
     */
    @Override
    public boolean hasSameTahunRilis(Object other) {
        if (!(other instanceof Informasi)) {
            return false;
        }

        int tahunOther = ((Informasi) other).getTahunRilis();
        return this.tahunRilis == tahunOther;
    }

    // ===== Implementasi Interface Serialisable =====

    /**
     * Mengkonversi media ke format CSV (Comma-Separated Values).
     *
     * @return String data media dalam format CSV
     */
    @Override
    public String toCSV() {
        return "\"" + judul + "\",\"" + genre + "\",\"" + tahunRilis + "\",\"" + status + "\"";
    }

    /**
     * Mengkonversi media ke format JSON (JavaScript Object Notation).
     *
     * @return String data media dalam format JSON
     */
    @Override
    public String toJSON() {
        return "{\"judul\":\"" + judul + "\",\"genre\":\"" + genre 
                + "\",\"tahunRilis\":" + tahunRilis + ",\"status\":\"" + status + "\"}";
    }

    /**
     * Mengkonversi media ke format XML (eXtensible Markup Language).
     *
     * @return String data media dalam format XML
     */
    @Override
    public String toXML() {
        return "<media>\n"
                + "  <judul>" + judul + "</judul>\n"
                + "  <genre>" + genre + "</genre>\n"
                + "  <tahunRilis>" + tahunRilis + "</tahunRilis>\n"
                + "  <status>" + status + "</status>\n"
                + "</media>";
    }

    /**
     * Mengkonversi media ke format String yang sudah diformat dengan rapi.
     *
     * @return String data media dalam format yang terformat dengan indentasi
     */
    @Override
    public String toFormattedString() {
        return getInfoLengkap();
    }

    /**
     * Mengonversi string CSV ke dalam objek media yang sudah ada (update).
     *
     * @param csvString string dalam format CSV
     * @throws IllegalArgumentException jika format CSV tidak valid
     */
    @Override
    public void fromCSV(String csvString) {
        // Parsing CSV: "judul","genre","tahunRilis","status"
        String[] parts = csvString.split("\",\"");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Format CSV tidak valid. Diharapkan 4 field.");
        }

        try {
            this.judul = parts[0].replaceAll("^\"|\"$", "");
            this.genre = parts[1].replaceAll("^\"|\"$", "");
            this.tahunRilis = Integer.parseInt(parts[2].replaceAll("^\"|\"$", ""));
            this.status = parts[3].replaceAll("^\"|\"$", "");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tahun rilis harus berupa angka: " + e.getMessage());
        }
    }

    /**
     * Mengonversi string JSON ke dalam objek media yang sudah ada (update).
     *
     * @param jsonString string dalam format JSON
     * @throws IllegalArgumentException jika format JSON tidak valid
     */
    @Override
    public void fromJSON(String jsonString) {
        // Simple JSON parsing (untuk implementasi sederhana)
        // Dalam praktik real, gunakan JSON library seperti Jackson atau Gson
        try {
            // Extract judul
            int judulStart = jsonString.indexOf("\"judul\":\"") + 9;
            int judulEnd = jsonString.indexOf("\"", judulStart);
            this.judul = jsonString.substring(judulStart, judulEnd);

            // Extract genre
            int genreStart = jsonString.indexOf("\"genre\":\"") + 8;
            int genreEnd = jsonString.indexOf("\"", genreStart);
            this.genre = jsonString.substring(genreStart, genreEnd);

            // Extract tahunRilis
            int tahunStart = jsonString.indexOf("\"tahunRilis\":") + 13;
            int tahunEnd = jsonString.indexOf(",", tahunStart);
            if (tahunEnd == -1) {
                tahunEnd = jsonString.indexOf("}", tahunStart);
            }
            this.tahunRilis = Integer.parseInt(jsonString.substring(tahunStart, tahunEnd).trim());

            // Extract status
            int statusStart = jsonString.indexOf("\"status\":\"") + 9;
            int statusEnd = jsonString.indexOf("\"", statusStart);
            this.status = jsonString.substring(statusStart, statusEnd);
        } catch (Exception e) {
            throw new IllegalArgumentException("Format JSON tidak valid: " + e.getMessage());
        }
    }
}
