/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Class JadwalTayang merupakan class model yang merepresentasikan jadwal
 * tayang sebuah anime dalam Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * Class ini mendemonstrasikan konsep <b>Enkapsulasi</b> (Encapsulation)
 * pada OOP, dimana seluruh atribut dideklarasikan sebagai {@code private}
 * dan hanya dapat diakses melalui method <b>getter</b> dan <b>setter</b>.
 * </p>
 *
 * <p>
 * Konsep OOP yang diterapkan:
 * </p>
 * <ul>
 * <li><b>Enkapsulasi</b> — seluruh atribut bersifat {@code private}</li>
 * <li><b>Getter/Setter</b> — akses atribut melalui method publik</li>
 * <li><b>Konstruktor</b> — inisialisasi atribut melalui parameter</li>
 * <li><b>Information Hiding</b> — detail implementasi disembunyikan</li>
 * </ul>
 *
 * <h2>Jenis Hak Akses yang Didemonstrasikan:</h2>
 * <table border="1">
 * <tr><th>Hak Akses</th><th>Symbol</th><th>Contoh di Class Ini</th></tr>
 * <tr><td>public</td><td>+</td><td>getter, setter, method kalkulasi</td></tr>
 * <tr><td>private</td><td>-</td><td>semua atribut (judul, hari, jam, dll)</td></tr>
 * </table>
 *
 * @author Administrator
 * @version 1.0
 */
public class JadwalTayang {

    /** Judul anime. */
    private String judul;

    /** Genre anime (contoh: "Action", "Romance", "Fantasy"). */
    private String genre;

    /** Hari tayang anime (contoh: "Senin", "Sabtu"). */
    private String hariTayang;

    /** Jam tayang anime dalam format "HH:mm" (contoh: "21:00"). */
    private String jamTayang;

    /** Stasiun TV atau platform streaming. */
    private String stasiun;

    /** Durasi per episode dalam menit. */
    private int durasiMenit;

    /** Status tayang (contoh: "Ongoing", "Completed", "Upcoming"). */
    private String statusTayang;

    /**
     * Konstruktor untuk membuat objek JadwalTayang baru.
     * Menginisialisasi semua atribut melalui parameter.
     *
     * @param judul        judul anime
     * @param genre        genre anime
     * @param hariTayang   hari tayang
     * @param jamTayang    jam tayang dalam format "HH:mm"
     * @param stasiun      stasiun TV atau platform streaming
     * @param durasiMenit  durasi per episode dalam menit
     * @param statusTayang status tayang anime
     */
    public JadwalTayang(String judul, String genre, String hariTayang,
            String jamTayang, String stasiun, int durasiMenit,
            String statusTayang) {
        this.judul = judul;
        this.genre = genre;
        this.hariTayang = hariTayang;
        this.jamTayang = jamTayang;
        this.stasiun = stasiun;
        this.durasiMenit = durasiMenit;
        this.statusTayang = statusTayang;
    }

    /**
     * Menghitung jam selesai tayang berdasarkan jam mulai dan durasi.
     * Contoh: jam mulai "21:00" dengan durasi 24 menit → "21:24".
     *
     * @return String jam selesai dalam format "HH:mm"
     */
    public String hitungJamSelesai() {
        try {
            String[] parts = jamTayang.split(":");
            int jam = Integer.parseInt(parts[0]);
            int menit = Integer.parseInt(parts[1]);

            menit += durasiMenit;
            jam += menit / 60;
            menit = menit % 60;
            jam = jam % 24;

            return String.format("%02d:%02d", jam, menit);
        } catch (Exception e) {
            return "Format tidak valid";
        }
    }

    /**
     * Memformat durasi dari menit ke format "Xj Ym".
     * Contoh: 90 menit → "1j 30m".
     *
     * @return String durasi dalam format "Xj Ym"
     */
    public String getFormatDurasi() {
        int jam = durasiMenit / 60;
        int menit = durasiMenit % 60;
        if (jam > 0) {
            return jam + "j " + menit + "m";
        }
        return menit + "m";
    }

    /**
     * Mengembalikan ringkasan informasi jadwal tayang dalam format String.
     *
     * @return String berisi ringkasan info jadwal tayang
     */
    public String getInfo() {
        return judul + " | " + hariTayang + " " + jamTayang
                + " - " + hitungJamSelesai() + " | " + stasiun
                + " | " + statusTayang;
    }

    /**
     * Mencetak detail lengkap jadwal tayang ke konsol.
     */
    public void tampilkanDetail() {
        System.out.println("======= Detail Jadwal Tayang =======");
        System.out.println("Judul          : " + judul);
        System.out.println("Genre          : " + genre);
        System.out.println("Hari Tayang    : " + hariTayang);
        System.out.println("Jam Tayang     : " + jamTayang);
        System.out.println("Jam Selesai    : " + hitungJamSelesai());
        System.out.println("Durasi         : " + getFormatDurasi()
                + " (" + durasiMenit + " menit)");
        System.out.println("Stasiun        : " + stasiun);
        System.out.println("Status Tayang  : " + statusTayang);
        System.out.println("====================================");
    }

    // ===== Getter & Setter =====

    /**
     * Mendapatkan judul anime.
     *
     * @return judul anime
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Mengubah judul anime.
     *
     * @param judul judul baru
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * Mendapatkan genre anime.
     *
     * @return genre anime
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Mengubah genre anime.
     *
     * @param genre genre baru
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Mendapatkan hari tayang.
     *
     * @return hari tayang
     */
    public String getHariTayang() {
        return hariTayang;
    }

    /**
     * Mengubah hari tayang.
     *
     * @param hariTayang hari tayang baru
     */
    public void setHariTayang(String hariTayang) {
        this.hariTayang = hariTayang;
    }

    /**
     * Mendapatkan jam tayang.
     *
     * @return jam tayang dalam format "HH:mm"
     */
    public String getJamTayang() {
        return jamTayang;
    }

    /**
     * Mengubah jam tayang.
     *
     * @param jamTayang jam tayang baru dalam format "HH:mm"
     */
    public void setJamTayang(String jamTayang) {
        this.jamTayang = jamTayang;
    }

    /**
     * Mendapatkan stasiun TV/platform streaming.
     *
     * @return stasiun
     */
    public String getStasiun() {
        return stasiun;
    }

    /**
     * Mengubah stasiun TV/platform streaming.
     *
     * @param stasiun stasiun baru
     */
    public void setStasiun(String stasiun) {
        this.stasiun = stasiun;
    }

    /**
     * Mendapatkan durasi per episode dalam menit.
     *
     * @return durasi dalam menit
     */
    public int getDurasiMenit() {
        return durasiMenit;
    }

    /**
     * Mengubah durasi per episode.
     *
     * @param durasiMenit durasi baru dalam menit
     */
    public void setDurasiMenit(int durasiMenit) {
        this.durasiMenit = durasiMenit;
    }

    /**
     * Mendapatkan status tayang.
     *
     * @return status tayang
     */
    public String getStatusTayang() {
        return statusTayang;
    }

    /**
     * Mengubah status tayang.
     *
     * @param statusTayang status tayang baru
     */
    public void setStatusTayang(String statusTayang) {
        this.statusTayang = statusTayang;
    }
}
