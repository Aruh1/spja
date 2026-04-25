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
     * {@link Media}.
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
        // Memanggil constructor parent class Media menggunakan super()
        super(judul, genre, tahunRilis, status);
        this.studio = studio;
        this.totalEpisode = totalEpisode;
        this.musim = musim;
        this.hariTayang = hariTayang;
    }

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
}
