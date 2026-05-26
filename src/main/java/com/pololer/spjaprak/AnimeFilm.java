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
 * <li><b>Abstraction</b> — mengimplementasikan method abstract
 *     {@code getInfoLengkap()} dan {@code hitungNilai()} dari parent class</li>
 * <li><b>Inheritance</b> — menggunakan keyword {@code extends}</li>
 * <li><b>Overriding</b> — override method {@code getInfo()} dan
 * {@code tampilkanDetail()}</li>
 * <li><b>super()</b> — memanggil constructor parent di constructor child</li>
 * </ul>
 *
 * @author Administrator
 * @version 2.0
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
     * {@link Media} (abstract class).
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
        // Memanggil constructor parent abstract class Media menggunakan super()
        super(judul, genre, tahunRilis, status);
        this.durasiMenit = durasiMenit;
        this.tanggalRilis = tanggalRilis;
        this.distributor = distributor;
    }

    // ===== Implementasi Abstract Methods dari Media =====

    /**
     * Implementasi method abstract {@code getInfoLengkap()} dari {@link Media}.
     * Mengembalikan informasi lengkap film anime dalam format multi-baris
     * yang terstruktur, termasuk semua atribut parent dan atribut khusus film.
     *
     * @return String berisi informasi lengkap film anime yang sudah diformat
     */
    @Override
    public String getInfoLengkap() {
        return "=== INFO LENGKAP ANIME FILM ===\n"
                + "Judul         : " + getJudul() + "\n"
                + "Genre         : " + getGenre() + "\n"
                + "Tahun Rilis   : " + getTahunRilis() + "\n"
                + "Status        : " + getStatus() + "\n"
                + "Durasi        : " + getFormatDurasi() + " (" + durasiMenit + " menit)\n"
                + "Tanggal Rilis : " + tanggalRilis + "\n"
                + "Distributor   : " + distributor + "\n"
                + "Sudah Tayang  : " + (sudahTayang() ? "Ya" : "Belum") + "\n"
                + "================================";
    }

    /**
     * Implementasi method abstract {@code hitungNilai()} dari {@link Media}.
     * Menghitung skor prioritas film anime berdasarkan durasi dan status rilis.
     *
     * <p>
     * Logika perhitungan:
     * </p>
     * <ul>
     * <li>Skor dasar = durasi (menit) × 0.5</li>
     * <li>Bonus jika sudah tayang = +15 poin</li>
     * <li>Bonus status "Upcoming" = +25 poin (prioritas tinggi karena belum rilis)</li>
     * <li>Bonus status "Completed" = +10 poin</li>
     * </ul>
     *
     * @return skor prioritas film anime dalam bentuk double
     */
    @Override
    public double hitungNilai() {
        // Skor dasar berdasarkan durasi film
        double skor = durasiMenit * 0.5;

        // Bonus berdasarkan status rilis
        if (sudahTayang()) {
            skor += 15.0; // Film yang sudah tayang mendapat bonus
        }

        // Bonus tambahan berdasarkan status
        switch (getStatus().toLowerCase()) {
            case "upcoming":
                skor += 25.0; // Prioritas tinggi karena ditunggu-tunggu
                break;
            case "completed":
                skor += 10.0; // Sudah selesai
                break;
            default:
                break;
        }

        return skor;
    }

    // ===== Methods Khusus AnimeFilm =====

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

    // ===== Override Methods dari Media =====

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

    // ===== Implementasi Interface Calculable (Override) =====

    /**
     * Override method {@code hitungProgress()} dari interface {@link Calculable}.
     * Menghitung persentase progress film berdasarkan tingkat tayang.
     *
     * <p>
     * Logika: Jika film sudah tayang, return 100.0. Jika belum, return 0.0.
     * </p>
     *
     * @return persentase progress (0.0 jika belum tayang, 100.0 jika sudah tayang)
     */
    @Override
    public double hitungProgress() {
        return sudahTayang() ? 100.0 : 0.0;
    }

    // ===== Implementasi Interface Editable (Override) =====

    /**
     * Override method {@code reset()} dari interface {@link Editable}.
     * Reset semua atribut film anime ke nilai default (null atau 0).
     */
    @Override
    public void reset() {
        // Reset atribut parent class
        super.reset();

        // Reset atribut khusus AnimeFilm
        this.durasiMenit = 0;
        this.tanggalRilis = null;
        this.distributor = null;
    }

    /**
     * Override method {@code isValid()} dari interface {@link Editable}.
     * Memeriksa validitas semua atribut film anime termasuk atribut parent.
     *
     * <p>
     * Validasi tambahan untuk AnimeFilm:
     * </p>
     * <ul>
     * <li>Durasi menit > 0</li>
     * <li>Tanggal rilis tidak null dan format valid (DD-MM-YYYY)</li>
     * <li>Distributor tidak null dan tidak kosong</li>
     * </ul>
     *
     * @return true jika semua atribut valid, false sebaliknya
     */
    @Override
    public boolean isValid() {
        // Validasi parent class terlebih dahulu
        if (!super.isValid()) {
            return false;
        }

        // Validasi durasi
        if (durasiMenit <= 0) {
            return false;
        }

        // Validasi tanggal rilis (format DD-MM-YYYY)
        if (tanggalRilis == null || tanggalRilis.trim().isEmpty()) {
            return false;
        }

        try {
            LocalDate.parse(tanggalRilis, FORMATTER);
        } catch (DateTimeParseException e) {
            return false;
        }

        // Validasi distributor
        if (distributor == null || distributor.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    // ===== Implementasi Interface Serialisable (Override) =====

    /**
     * Override method {@code toCSV()} dari interface {@link Serialisable}.
     * Mengkonversi film anime ke format CSV dengan semua atribut.
     *
     * @return String data film anime dalam format CSV
     */
    @Override
    public String toCSV() {
        return "\"" + getJudul() + "\",\"" + getGenre() + "\",\"" + getTahunRilis()
                + "\",\"" + getStatus() + "\",\"" + durasiMenit + "\",\"" + tanggalRilis
                + "\",\"" + distributor + "\"";
    }

    /**
     * Override method {@code toJSON()} dari interface {@link Serialisable}.
     * Mengkonversi film anime ke format JSON dengan semua atribut.
     *
     * @return String data film anime dalam format JSON
     */
    @Override
    public String toJSON() {
        return "{\"judul\":\"" + getJudul() + "\",\"genre\":\"" + getGenre()
                + "\",\"tahunRilis\":" + getTahunRilis() + ",\"status\":\"" + getStatus()
                + "\",\"durasiMenit\":" + durasiMenit + ",\"tanggalRilis\":\"" + tanggalRilis
                + "\",\"distributor\":\"" + distributor + "\"}";
    }

    /**
     * Override method {@code toXML()} dari interface {@link Serialisable}.
     * Mengkonversi film anime ke format XML dengan semua atribut.
     *
     * @return String data film anime dalam format XML
     */
    @Override
    public String toXML() {
        return "<animeFilm>\n"
                + "  <judul>" + getJudul() + "</judul>\n"
                + "  <genre>" + getGenre() + "</genre>\n"
                + "  <tahunRilis>" + getTahunRilis() + "</tahunRilis>\n"
                + "  <status>" + getStatus() + "</status>\n"
                + "  <durasiMenit>" + durasiMenit + "</durasiMenit>\n"
                + "  <tanggalRilis>" + tanggalRilis + "</tanggalRilis>\n"
                + "  <distributor>" + distributor + "</distributor>\n"
                + "</animeFilm>";
    }

    /**
     * Override method {@code toFormattedString()} dari interface {@link Serialisable}.
     * Mengkonversi film anime ke String terformat yang sama dengan {@link #getInfoLengkap()}.
     *
     * @return String data film anime dalam format terformat
     */
    @Override
    public String toFormattedString() {
        return getInfoLengkap();
    }

    /**
     * Override method {@code fromCSV()} dari interface {@link Serialisable}.
     * Mengonversi string CSV ke dalam objek film anime (update).
     *
     * @param csvString string dalam format CSV
     * @throws IllegalArgumentException jika format CSV tidak valid
     */
    @Override
    public void fromCSV(String csvString) {
        // Parsing CSV: "judul","genre","tahunRilis","status","durasiMenit","tanggalRilis","distributor"
        String[] parts = csvString.split("\",\"");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Format CSV AnimeFilm tidak valid. Diharapkan 7 field.");
        }

        try {
            // Gunakan parent method untuk basic fields
            StringBuilder baseCsv = new StringBuilder();
            baseCsv.append(parts[0]).append("\",\"")
                    .append(parts[1]).append("\",\"")
                    .append(parts[2]).append("\",\"")
                    .append(parts[3]).append("\"");
            super.fromCSV(baseCsv.toString());

            // Parse atribut khusus AnimeFilm
            this.durasiMenit = Integer.parseInt(parts[4].replaceAll("^\"|\"$", ""));
            this.tanggalRilis = parts[5].replaceAll("^\"|\"$", "");
            this.distributor = parts[6].replaceAll("^\"|\"$", "");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format data tidak valid: " + e.getMessage());
        }
    }

    /**
     * Override method {@code fromJSON()} dari interface {@link Serialisable}.
     * Mengonversi string JSON ke dalam objek film anime (update).
     *
     * @param jsonString string dalam format JSON
     * @throws IllegalArgumentException jika format JSON tidak valid
     */
    @Override
    public void fromJSON(String jsonString) {
        try {
            // Parse tipe dasar menggunakan parent method terlebih dahulu
            // Extract hanya basic fields untuk parent
            int durasiStart = jsonString.indexOf("\"durasiMenit\":");
            String basicJson = jsonString.substring(0, durasiStart) + "}";
            super.fromJSON(basicJson);

            // Extract durasiMenit
            int durasiFieldStart = jsonString.indexOf("\"durasiMenit\":") + 14;
            int durasiFieldEnd = jsonString.indexOf(",", durasiFieldStart);
            if (durasiFieldEnd == -1) {
                durasiFieldEnd = jsonString.indexOf("}", durasiFieldStart);
            }
            this.durasiMenit = Integer.parseInt(jsonString.substring(durasiFieldStart, durasiFieldEnd).trim());

            // Extract tanggalRilis
            int tanggalStart = jsonString.indexOf("\"tanggalRilis\":\"") + 15;
            int tanggalEnd = jsonString.indexOf("\"", tanggalStart);
            this.tanggalRilis = jsonString.substring(tanggalStart, tanggalEnd);

            // Extract distributor
            int distStart = jsonString.indexOf("\"distributor\":\"") + 14;
            int distEnd = jsonString.indexOf("\"", distStart);
            this.distributor = jsonString.substring(distStart, distEnd);
        } catch (Exception e) {
            throw new IllegalArgumentException("Format JSON AnimeFilm tidak valid: " + e.getMessage());
        }
    }
}
