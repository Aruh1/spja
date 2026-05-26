/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Class Anime merupakan child class (subclass) dari {@link Media} yang
 * merepresentasikan sebuah anime series dalam Sistem Penjadwalan Tayang Anime
 * (SPJA).
 *
 * <p>
 * Class ini mewarisi semua atribut dan method dari {@link Media}, serta
 * menambahkan atribut dan method khusus untuk anime series seperti studio,
 * jumlah episode, musim tayang, dan hari tayang.
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
public class Anime extends Media {

    /** Nama studio produksi anime. */
    private String studio;

    /** Total jumlah episode anime. */
    private int totalEpisode;

    /** Musim tayang anime (contoh: "Spring 2025", "Fall 2024"). */
    private String musim;

    /** Hari tayang anime (contoh: "Senin", "Sabtu"). */
    private String hariTayang;

    /**
     * Constructor untuk membuat objek Anime baru.
     * Menggunakan {@code super()} untuk memanggil constructor parent class
     * {@link Media} (abstract class).
     *
     * @param judul judul anime
     * @param genre genre anime
     * @param tahunRilis tahun rilis anime
     * @param status status tayang ("Ongoing", "Completed", "Upcoming")
     * @param studio nama studio produksi
     * @param totalEpisode total jumlah episode
     * @param musim musim tayang (contoh: "Spring 2025")
     * @param hariTayang hari tayang (contoh: "Senin")
     */
    public Anime(String judul, String genre, int tahunRilis, String status,
            String studio, int totalEpisode, String musim, String hariTayang) {
        // Memanggil constructor parent abstract class Media menggunakan super()
        super(judul, genre, tahunRilis, status);
        this.studio = studio;
        this.totalEpisode = totalEpisode;
        this.musim = musim;
        this.hariTayang = hariTayang;
    }

    // ===== Implementasi Abstract Methods dari Media =====

    /**
     * Implementasi method abstract {@code getInfoLengkap()} dari {@link Media}.
     * Mengembalikan informasi lengkap anime series dalam format multi-baris
     * yang terstruktur, termasuk semua atribut parent dan atribut khusus anime.
     *
     * @return String berisi informasi lengkap anime series yang sudah diformat
     */
    @Override
    public String getInfoLengkap() {
        return "=== INFO LENGKAP ANIME SERIES ===\n"
                + "Judul         : " + getJudul() + "\n"
                + "Genre         : " + getGenre() + "\n"
                + "Tahun Rilis   : " + getTahunRilis() + "\n"
                + "Status        : " + getStatus() + "\n"
                + "Studio        : " + studio + "\n"
                + "Total Episode : " + totalEpisode + "\n"
                + "Musim         : " + musim + "\n"
                + "Hari Tayang   : " + hariTayang + "\n"
                + "==================================";
    }

    /**
     * Implementasi method abstract {@code hitungNilai()} dari {@link Media}.
     * Menghitung skor prioritas anime berdasarkan total episode dan status tayang.
     *
     * <p>
     * Logika perhitungan:
     * </p>
     * <ul>
     * <li>Skor dasar = total episode × 1.5</li>
     * <li>Bonus status "Ongoing" = +20 poin (prioritas tinggi karena masih tayang)</li>
     * <li>Bonus status "Upcoming" = +10 poin (akan datang)</li>
     * <li>Bonus status "Completed" = +5 poin (sudah selesai)</li>
     * </ul>
     *
     * @return skor prioritas anime dalam bentuk double
     */
    @Override
    public double hitungNilai() {
        // Skor dasar berdasarkan jumlah episode
        double skor = totalEpisode * 1.5;

        // Bonus berdasarkan status tayang
        switch (getStatus().toLowerCase()) {
            case "ongoing":
                skor += 20.0; // Prioritas tinggi karena masih tayang
                break;
            case "upcoming":
                skor += 10.0; // Prioritas menengah, akan datang
                break;
            case "completed":
                skor += 5.0;  // Prioritas rendah, sudah selesai
                break;
            default:
                break;
        }

        return skor;
    }

    // ===== Methods Khusus Anime =====

    /**
     * Menghitung persentase progress tayang anime berdasarkan episode saat ini.
     *
     * @param episodeSaatIni jumlah episode yang sudah tayang
     * @return persentase progress dalam bentuk double (0.0 - 100.0)
     */
    public double getProgressTayang(int episodeSaatIni) {
        if (totalEpisode <= 0) {
            return 0.0;
        }
        return ((double) episodeSaatIni / totalEpisode) * 100.0;
    }

    /**
     * Mengembalikan string jadwal lengkap anime, termasuk judul, musim,
     * hari tayang, dan status.
     *
     * @return String berisi jadwal lengkap anime
     */
    public String getJadwalLengkap() {
        return getJudul() + " | Musim: " + musim + " | Hari: " + hariTayang
                + " | Episode: " + totalEpisode + " | Status: " + getStatus();
    }

    // ===== Override Methods dari Media =====

    /**
     * Override method {@code getInfo()} dari parent class {@link Media}.
     * Menambahkan informasi studio, total episode, musim, dan hari tayang.
     *
     * @return String berisi ringkasan info anime lengkap
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " | Studio: " + studio
                + " | Episode: " + totalEpisode + " | Musim: " + musim
                + " | Hari: " + hariTayang;
    }

    /**
     * Override method {@code tampilkanDetail()} dari parent class {@link Media}.
     * Mencetak detail lengkap anime series ke konsol.
     */
    @Override
    public void tampilkanDetail() {
        System.out.println("======= Detail Anime Series =======");
        System.out.println("Judul         : " + getJudul());
        System.out.println("Genre         : " + getGenre());
        System.out.println("Tahun Rilis   : " + getTahunRilis());
        System.out.println("Status        : " + getStatus());
        System.out.println("Studio        : " + studio);
        System.out.println("Total Episode : " + totalEpisode);
        System.out.println("Musim         : " + musim);
        System.out.println("Hari Tayang   : " + hariTayang);
        System.out.println("====================================");
    }

    // ===== Overloading Methods (Anime-specific) =====

    /**
     * Overloading getProgressTayang() — menghitung progress dengan episode range.
     *
     * @param episodeSaatIni episode yang sudah tayang
     * @param episodeTarget target episode (jika berbeda dari totalEpisode)
     * @return persentase progress terhadap target
     */
    public double getProgressTayang(int episodeSaatIni, int episodeTarget) {
        if (episodeTarget <= 0) {
            return 0.0;
        }
        return ((double) episodeSaatIni / episodeTarget) * 100.0;
    }

    /**
     * Overloading getInfo() — mengembalikan info hanya jadwal tayang anime.
     *
     * @param scheduleOnly jika true, hanya tampilkan jadwal (musim, hari, episode)
     * @return String berisi informasi jadwal anime
     */
    public String getInfo(boolean scheduleOnly) {
        if (scheduleOnly) {
            return getJudul() + " | Musim: " + musim + " | Hari: " + hariTayang
                    + " | Episode: " + totalEpisode;
        } else {
            return getInfo();
        }
    }

    /**
     * Overloading getInfo() — mengembalikan info dengan studio dan genre filter.
     *
     * @param studioOnly jika true, hanya tampilkan nama studio dan judul
     * @param withGenre jika true, tambahkan genre dalam info
     * @return String berisi info anime dengan filter
     */
    public String getInfo(boolean studioOnly, boolean withGenre) {
        StringBuilder info = new StringBuilder();
        info.append(getJudul());
        if (studioOnly) {
            info.append(" | Studio: ").append(studio);
        }
        if (withGenre) {
            info.append(" | Genre: ").append(getGenre());
        }
        return info.toString();
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan format anime-spesifik.
     *
     * @param withProgress jika true, tampilkan progress calculator
     * @param episodeSaatIni episode untuk perhitungan progress (hanya jika withProgress true)
     */
    public void tampilkanDetail(boolean withProgress, int episodeSaatIni) {
        tampilkanDetail();
        if (withProgress) {
            double progress = getProgressTayang(episodeSaatIni);
            System.out.println("Progress     : " + String.format("%.2f%%", progress)
                    + " (Episode " + episodeSaatIni + " dari " + totalEpisode + ")");
        }
    }

    /**
     * Overloading tampilkanDetail() — menampilkan detail dengan filter field.
     *
     * @param includeStudio tampilkan studio
     * @param includeMusim tampilkan musim
     * @param includeHari tampilkan hari tayang
     */
    public void tampilkanDetail(boolean includeStudio, boolean includeMusim, boolean includeHari) {
        System.out.println("======= Detail Anime Series (Filtered) =======");
        System.out.println("Judul         : " + getJudul());
        System.out.println("Genre         : " + getGenre());
        System.out.println("Tahun Rilis   : " + getTahunRilis());
        System.out.println("Status        : " + getStatus());
        if (includeStudio) {
            System.out.println("Studio        : " + studio);
        }
        System.out.println("Total Episode : " + totalEpisode);
        if (includeMusim) {
            System.out.println("Musim         : " + musim);
        }
        if (includeHari) {
            System.out.println("Hari Tayang   : " + hariTayang);
        }
        System.out.println("===============================================");
    }

    // ===== Getter & Setter =====

    /**
     * Mendapatkan nama studio produksi.
     *
     * @return nama studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Mengubah nama studio produksi.
     *
     * @param studio nama studio baru
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Mendapatkan total jumlah episode.
     *
     * @return total episode
     */
    public int getTotalEpisode() {
        return totalEpisode;
    }

    /**
     * Mengubah total jumlah episode.
     *
     * @param totalEpisode total episode baru
     */
    public void setTotalEpisode(int totalEpisode) {
        this.totalEpisode = totalEpisode;
    }

    /**
     * Mendapatkan musim tayang.
     *
     * @return musim tayang
     */
    public String getMusim() {
        return musim;
    }

    /**
     * Mengubah musim tayang.
     *
     * @param musim musim tayang baru
     */
    public void setMusim(String musim) {
        this.musim = musim;
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

    // ===== Implementasi Interface Calculable (Override) =====

    /**
     * Override method {@code hitungProgress()} dari interface {@link Calculable}.
     * Menghitung persentase progress default untuk anime (0.0).
     * Untuk perhitungan guna episode spesifik, gunakan {@link #getProgressTayang(int)}.
     *
     * @return persentase progress (default 0.0)
     */
    @Override
    public double hitungProgress() {
        // Mengembalikan 0 karena progress anime bergantung pada episode saat ini
        // yang tidak disimpan sebagai atribut. Gunakan getProgressTayang(episodeSaatIni) untuk nilai actual.
        return 0.0;
    }

    // ===== Implementasi Interface Editable (Override) =====

    /**
     * Override method {@code reset()} dari interface {@link Editable}.
     * Reset semua atribut anime ke nilai default (null atau 0).
     */
    @Override
    public void reset() {
        // Reset atribut parent class
        super.reset();

        // Reset atribut khusus Anime
        this.studio = null;
        this.totalEpisode = 0;
        this.musim = null;
        this.hariTayang = null;
    }

    /**
     * Override method {@code isValid()} dari interface {@link Editable}.
     * Memeriksa validitas semua atribut anime termasuk atribut parent.
     *
     * <p>
     * Validasi tambahan untuk Anime:
     * </p>
     * <ul>
     * <li>Studio tidak null dan tidak kosong</li>
     * <li>Total episode > 0</li>
     * <li>Musim tidak null dan tidak kosong</li>
     * <li>Hari tayang tidak null dan tidak kosong</li>
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

        // Validasi studio
        if (studio == null || studio.trim().isEmpty()) {
            return false;
        }

        // Validasi total episode
        if (totalEpisode <= 0) {
            return false;
        }

        // Validasi musim
        if (musim == null || musim.trim().isEmpty()) {
            return false;
        }

        // Validasi hari tayang
        if (hariTayang == null || hariTayang.trim().isEmpty()) {
            return false;
        }

        return true;
    }

    // ===== Implementasi Interface Serialisable (Override) =====

    /**
     * Override method {@code toCSV()} dari interface {@link Serialisable}.
     * Mengkonversi anime ke format CSV dengan semua atribut.
     *
     * @return String data anime dalam format CSV
     */
    @Override
    public String toCSV() {
        return "\"" + getJudul() + "\",\"" + getGenre() + "\",\"" + getTahunRilis()
                + "\",\"" + getStatus() + "\",\"" + studio + "\",\"" + totalEpisode
                + "\",\"" + musim + "\",\"" + hariTayang + "\"";
    }

    /**
     * Override method {@code toJSON()} dari interface {@link Serialisable}.
     * Mengkonversi anime ke format JSON dengan semua atribut.
     *
     * @return String data anime dalam format JSON
     */
    @Override
    public String toJSON() {
        return "{\"judul\":\"" + getJudul() + "\",\"genre\":\"" + getGenre()
                + "\",\"tahunRilis\":" + getTahunRilis() + ",\"status\":\"" + getStatus()
                + "\",\"studio\":\"" + studio + "\",\"totalEpisode\":" + totalEpisode
                + ",\"musim\":\"" + musim + "\",\"hariTayang\":\"" + hariTayang + "\"}";
    }

    /**
     * Override method {@code toXML()} dari interface {@link Serialisable}.
     * Mengkonversi anime ke format XML dengan semua atribut.
     *
     * @return String data anime dalam format XML
     */
    @Override
    public String toXML() {
        return "<anime>\n"
                + "  <judul>" + getJudul() + "</judul>\n"
                + "  <genre>" + getGenre() + "</genre>\n"
                + "  <tahunRilis>" + getTahunRilis() + "</tahunRilis>\n"
                + "  <status>" + getStatus() + "</status>\n"
                + "  <studio>" + studio + "</studio>\n"
                + "  <totalEpisode>" + totalEpisode + "</totalEpisode>\n"
                + "  <musim>" + musim + "</musim>\n"
                + "  <hariTayang>" + hariTayang + "</hariTayang>\n"
                + "</anime>";
    }

    /**
     * Override method {@code toFormattedString()} dari interface {@link Serialisable}.
     * Mengkonversi anime ke String terformat yang sama dengan {@link #getInfoLengkap()}.
     *
     * @return String data anime dalam format terformat
     */
    @Override
    public String toFormattedString() {
        return getInfoLengkap();
    }

    /**
     * Override method {@code fromCSV()} dari interface {@link Serialisable}.
     * Mengonversi string CSV ke dalam objek anime (update).
     *
     * @param csvString string dalam format CSV
     * @throws IllegalArgumentException jika format CSV tidak valid
     */
    @Override
    public void fromCSV(String csvString) {
        // Parsing CSV: "judul","genre","tahunRilis","status","studio","totalEpisode","musim","hariTayang"
        String[] parts = csvString.split("\",\"");
        if (parts.length != 8) {
            throw new IllegalArgumentException("Format CSV Anime tidak valid. Diharapkan 8 field.");
        }

        try {
            // Gunakan parent method untuk basic fields
            StringBuilder baseCsv = new StringBuilder();
            baseCsv.append(parts[0]).append("\",\"")
                    .append(parts[1]).append("\",\"")
                    .append(parts[2]).append("\",\"")
                    .append(parts[3]).append("\"");
            super.fromCSV(baseCsv.toString());

            // Parse atribut khusus Anime
            this.studio = parts[4].replaceAll("^\"|\"$", "");
            this.totalEpisode = Integer.parseInt(parts[5].replaceAll("^\"|\"$", ""));
            this.musim = parts[6].replaceAll("^\"|\"$", "");
            this.hariTayang = parts[7].replaceAll("^\"|\"$", "");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format data tidak valid: " + e.getMessage());
        }
    }

    /**
     * Override method {@code fromJSON()} dari interface {@link Serialisable}.
     * Mengonversi string JSON ke dalam objek anime (update).
     *
     * @param jsonString string dalam format JSON
     * @throws IllegalArgumentException jika format JSON tidak valid
     */
    @Override
    public void fromJSON(String jsonString) {
        try {
            // Parse tipe dasar menggunakan parent method terlebih dahulu
            // Extract hanya basic fields untuk parent
            int studioStart = jsonString.indexOf("\"studio\":");
            String basicJson = jsonString.substring(0, studioStart) + "}";
            super.fromJSON(basicJson);

            // Extract studio
            int studioFieldStart = jsonString.indexOf("\"studio\":\"") + 9;
            int studioFieldEnd = jsonString.indexOf("\"", studioFieldStart);
            this.studio = jsonString.substring(studioFieldStart, studioFieldEnd);

            // Extract totalEpisode
            int episodeStart = jsonString.indexOf("\"totalEpisode\":") + 15;
            int episodeEnd = jsonString.indexOf(",", episodeStart);
            if (episodeEnd == -1) {
                episodeEnd = jsonString.indexOf("}", episodeStart);
            }
            this.totalEpisode = Integer.parseInt(jsonString.substring(episodeStart, episodeEnd).trim());

            // Extract musim
            int musimStart = jsonString.indexOf("\"musim\":\"") + 8;
            int musimEnd = jsonString.indexOf("\"", musimStart);
            this.musim = jsonString.substring(musimStart, musimEnd);

            // Extract hariTayang
            int hariStart = jsonString.indexOf("\"hariTayang\":\"") + 13;
            int hariEnd = jsonString.indexOf("\"", hariStart);
            this.hariTayang = jsonString.substring(hariStart, hariEnd);
        } catch (Exception e) {
            throw new IllegalArgumentException("Format JSON Anime tidak valid: " + e.getMessage());
        }
    }
}
