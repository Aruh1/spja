/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Interface Editable merupakan kontrak yang mendefinisikan method-method
 * untuk melakukan modifikasi dan perubahan terhadap atribut-atribut media.
 *
 * <p>
 * Interface ini mengimplementasikan konsep <b>Polymorphism</b> dalam OOP,
 * memungkinkan berbagai class untuk melakukan perubahan data dengan cara
 * yang konsisten melalui method yang terdefinisi pada interface.
 * </p>
 *
 * <p>
 * Method-method dalam interface ini dirancang untuk operasi mutasi (mutating)
 * yang mengubah state dari objek. Implementasi interface ini menjamin bahwa
 * setiap modifikasi dilakukan melalui method yang valid dan terkontrol
 * untuk menjaga integritas data.
 * </p>
 *
 * @author Administrator
 * @version 2.0
 */
public interface Editable {

    /**
     * Mengubah/mengupdate judul media.
     * Metode ini digunakan untuk memodifikasi judul dari media yang sudah ada.
     *
     * @param judulBaru judul baru yang akan diset
     * @throws IllegalArgumentException jika judulBaru null atau kosong
     */
    void setJudul(String judulBaru);

    /**
     * Mengubah/mengupdate genre media.
     * Metode ini digunakan untuk memodifikasi genre dari media yang sudah ada.
     *
     * @param genreBaru genre baru yang akan diset
     * @throws IllegalArgumentException jika genreBaru null atau kosong
     */
    void setGenre(String genreBaru);

    /**
     * Mengubah/mengupdate status tayang media.
     * Status yang valid adalah: "Ongoing", "Completed", "Upcoming".
     * Metode ini digunakan untuk memodifikasi status tayang media.
     *
     * @param statusBaru status baru yang akan diset ("Ongoing", "Completed", "Upcoming")
     * @throws IllegalArgumentException jika statusBaru bukan salah satu dari status yang valid
     */
    void setStatus(String statusBaru);

    /**
     * Mengubah/mengupdate tahun rilis media.
     * Metode ini digunakan untuk memodifikasi tahun rilis dari media yang sudah ada.
     *
     * @param tahunBaru tahun rilis baru yang akan diset
     * @throws IllegalArgumentException jika tahunBaru < 0 atau tahunBaru > tahun sekarang
     */
    void setTahunRilis(int tahunBaru);

    /**
     * Melakukan reset/pembersihan semua atribut media ke nilai default.
     * Metode ini digunakan untuk mengembalikan objek ke kondisi awal tanpa
     * membuat objek baru.
     */
    void reset();

    /**
     * Memeriksa apakah semua atribut media valid dan terisi dengan benar.
     * Metode ini digunakan untuk validasi data sebelum menyimpan atau menggunakan
     * objek media.
     *
     * @return true jika semua atribut valid, false sebaliknya
     */
    boolean isValid();
}
