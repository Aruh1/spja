/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Interface Comparable merupakan kontrak yang mendefinisikan method-method
 * untuk membandingkan dua objek media berdasarkan berbagai kriteria.
 *
 * <p>
 * Interface ini mengimplementasikan konsep <b>Polymorphism</b> dalam OOP,
 * memungkinkan berbagai class untuk membandingkan objek dengan kriteria
 * yang berbeda-beda sesuai dengan jenis media masing-masing.
 * </p>
 *
 * <p>
 * Method-method dalam interface ini dirancang untuk perbandingan (comparison)
 * antar objek media, sehingga dapat digunakan untuk sorting, filtering,
 * dan operasi lainnya yang memerlukan perbandingan.
 * </p>
 *
 * @author Administrator
 * @version 2.0
 */
public interface Comparable {

    /**
     * Membandingkan nilai (skor prioritas) dari media ini dengan media lain.
     * Metode ini digunakan untuk mengurutkan media berdasarkan prioritas.
     *
     * <p>
     * Return value:
     * </p>
     * <ul>
     * <li>Negatif jika nilai media ini lebih kecil dari media yang dibandingkan</li>
     * <li>Nol jika nilai kedua media sama</li>
     * <li>Positif jika nilai media ini lebih besar dari media yang dibandingkan</li>
     * </ul>
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan nilai prioritas
     */
    int compareByNilai(Object other);

    /**
     * Membandingkan judul dari media ini dengan media lain secara alfabetis.
     * Metode ini digunakan untuk mengurutkan media berdasarkan judul.
     *
     * <p>
     * Perbandingan dilakukan secara case-insensitive (tidak membedakan besar/kecil).
     * </p>
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan judul secara alfabetis
     */
    int compareByJudul(Object other);

    /**
     * Membandingkan tahun rilis dari media ini dengan media lain.
     * Metode ini digunakan untuk mengurutkan media berdasarkan tahun rilis.
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan tahun rilis (negatif jika lebih lama, positif jika lebih baru)
     */
    int compareByTahunRilis(Object other);

    /**
     * Membandingkan status tayang dari media ini dengan media lain.
     * Urutan prioritas default: "Ongoing" > "Upcoming" > "Completed"
     * Metode ini digunakan untuk mengurutkan media berdasarkan status tayang.
     *
     * @param other media lain untuk dibandingkan
     * @return hasil perbandingan status (berdasarkan prioritas urutan)
     */
    int compareByStatus(Object other);

    /**
     * Memeriksa apakah media ini memiliki genre yang sama dengan media lain.
     * Metode ini digunakan untuk filter media dengan genre yang sama.
     *
     * @param other media lain untuk dibandingkan
     * @return true jika genre sama, false sebaliknya
     */
    boolean hasSameGenre(Object other);

    /**
     * Memeriksa apakah media ini memiliki tahun rilis yang sama dengan media lain.
     * Metode ini digunakan untuk filter media yang dirilis pada tahun yang sama.
     *
     * @param other media lain untuk dibandingkan
     * @return true jika tahun rilis sama, false sebaliknya
     */
    boolean hasSameTahunRilis(Object other);
}
