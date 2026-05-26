/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Interface Calculable merupakan kontrak yang mendefinisikan method-method
 * untuk melakukan perhitungan dan analisis pada sebuah media.
 *
 * <p>
 * Interface ini mengimplementasikan konsep <b>Polymorphism</b> dalam OOP,
 * memungkinkan berbagai class untuk melakukan perhitungan dengan logika
 * yang berbeda-beda sesuai dengan jenis media masing-masing.
 * </p>
 *
 * <p>
 * Method-method dalam interface ini dirancang untuk operasi kalkulasi yang
 * menghasilkan nilai numerik atau boolean berdasarkan atribut-atribut media.
 * Setiap implementasi dapat memiliki rumus perhitungan yang unik sesuai
 * dengan kebutuhan domain bisnis.
 * </p>
 *
 * @author Administrator
 * @version 2.0
 */
public interface Calculable {

    /**
     * Menghitung nilai/skor prioritas atau kepentingan dari media.
     * Metode ini digunakan untuk membandingkan dan memprioritaskan
     * berbagai media berdasarkan kriteria yang telah ditentukan.
     *
     * <p>
     * Logika perhitungan dapat berbeda untuk setiap implementasi:
     * </p>
     * <ul>
     * <li>Untuk Anime: perhitungan berdasarkan jumlah episode dan status tayang</li>
     * <li>Untuk AnimeFilm: perhitungan berdasarkan durasi dan tanggal rilis</li>
     * </ul>
     *
     * <p>
     * Nilai yang lebih besar menunjukkan prioritas yang lebih tinggi.
     * </p>
     *
     * @return nilai prioritas media dalam bentuk double
     */
    double hitungNilai();

    /**
     * Memeriksa apakah media saat ini sedang tayang (status "Ongoing").
     * Metode ini digunakan untuk filter dan query media yang sedang aktif.
     *
     * @return true jika status media adalah "Ongoing", false sebaliknya
     */
    boolean isSedangTayang();

    /**
     * Memeriksa apakah media sudah selesai tayang (status "Completed").
     * Metode ini digunakan untuk filter media yang telah selesai.
     *
     * @return true jika status media adalah "Completed", false sebaliknya
     */
    boolean isSudahSelesai();

    /**
     * Memeriksa apakah media akan datang (status "Upcoming").
     * Metode ini digunakan untuk filter media yang akan datang.
     *
     * @return true jika status media adalah "Upcoming", false sebaliknya
     */
    boolean isAkanDatang();

    /**
     * Menghitung persentase kelengkapan atau progress dari media.
     * Nilai yang dikembalikan berada dalam rentang 0.0 hingga 100.0.
     *
     * <p>
     * Logika perhitungan dapat berbeda untuk setiap implementasi:
     * </p>
     * <ul>
     * <li>Untuk Anime: persentase berdasarkan episode yang telah tayang</li>
     * <li>Untuk AnimeFilm: persentase berdasarkan durasi atau timeline</li>
     * </ul>
     *
     * @return persentase progress dalam bentuk double (0.0 - 100.0)
     */
    double hitungProgress();
}
