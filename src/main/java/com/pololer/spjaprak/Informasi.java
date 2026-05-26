/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Interface Informasi merupakan kontrak yang mendefinisikan method-method
 * untuk menampilkan dan mengakses informasi dari sebuah media.
 *
 * <p>
 * Interface ini mengimplementasikan konsep <b>Polymorphism</b> dalam OOP,
 * memungkinkan berbagai class yang mengimplementasikan interface ini untuk
 * menampilkan informasi dengan cara yang berbeda-beda sesuai kebutuhan.
 * </p>
 *
 * <p>
 * Method-method dalam interface ini dirancang untuk operasi baca (read-only)
 * dan tidak mengubah state dari objek. Implementasi interface ini dapat dilakukan
 * oleh class yang berbeda jenis untuk memberikan fleksibilitas dalam
 * menampilkan informasi.
 * </p>
 *
 * @author Administrator
 * @version 2.0
 */
public interface Informasi {

    /**
     * Mengembalikan ringkasan informasi media dalam format String sederhana.
     * Metode ini digunakan untuk mendapatkan informasi dasar dari media.
     *
     * <p>
     * Contoh output: "Judul: Attack on Titan | Genre: Action | Tahun: 2013 | Status: Completed"
     * </p>
     *
     * @return String berisi ringkasan informasi media
     */
    String getInfo();

    /**
     * Mengembalikan informasi lengkap media dalam format String yang lebih detail.
     * Metode ini digunakan untuk mendapatkan semua atribut media dalam format
     * yang terstruktur dan mudah dibaca.
     *
     * <p>
     * Berbeda dengan {@link #getInfo()}, method ini mengembalikan detail
     * yang lebih komprehensif termasuk atribut-atribut khusus yang relevan.
     * </p>
     *
     * @return String berisi informasi lengkap media yang sudah diformat dengan rapi
     */
    String getInfoLengkap();

    /**
     * Mencetak detail informasi media ke konsol atau sistem output lainnya.
     * Metode ini digunakan untuk menampilkan informasi media secara visual
     * dengan format yang menarik.
     *
     * <p>
     * Implementasi dapat menggunakan System.out.println() atau mekanisme
     * logging lainnya sesuai kebutuhan aplikasi.
     * </p>
     */
    void tampilkanDetail();

    /**
     * Mengembalikan judul dari media.
     *
     * @return String judul media
     */
    String getJudul();

    /**
     * Mengembalikan genre dari media.
     *
     * @return String genre media
     */
    String getGenre();

    /**
     * Mengembalikan tahun rilis dari media.
     *
     * @return int tahun rilis media
     */
    int getTahunRilis();

    /**
     * Mengembalikan status tayang dari media.
     *
     * @return String status tayang media ("Ongoing", "Completed", "Upcoming")
     */
    String getStatus();
}
