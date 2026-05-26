/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pololer.spjaprak;

/**
 * Interface Serialisable merupakan kontrak yang mendefinisikan method-method
 * untuk melakukan konversi data media ke berbagai format string/teks.
 *
 * <p>
 * Interface ini mengimplementasikan konsep <b>Polymorphism</b> dalam OOP,
 * memungkinkan berbagai class untuk mengkonversi objek ke format yang berbeda-beda
 * sesuai dengan kebutuhan (JSON, CSV, XML, atau format custom lainnya).
 * </p>
 *
 * <p>
 * Method-method dalam interface ini dirancang untuk export/import data,
 * penyimpanan ke file, atau transmisi data melalui jaringan dengan format
 * yang mudah diparsing dan kompatibel dengan berbagai sistem.
 * </p>
 *
 * @author Administrator
 * @version 2.0
 */
public interface Serialisable {

    /**
     * Mengkonversi media ke format CSV (Comma-Separated Values).
     * Format CSV memudahkan penyimpanan dan impor data ke spreadsheet.
     *
     * <p>
     * Contoh output CSV untuk Anime:
     * "Attack on Titan","Action","2013","Completed","WIT Studio","25","Spring 2013","Senin"
     * </p>
     *
     * @return String data media dalam format CSV
     */
    String toCSV();

    /**
     * Mengkonversi media ke format JSON (JavaScript Object Notation).
     * Format JSON memudahkan parsing dan transmisi data melalui API.
     *
     * <p>
     * Contoh output JSON untuk Anime:
     * {"judul":"Attack on Titan","genre":"Action","tahunRilis":2013,...}
     * </p>
     *
     * @return String data media dalam format JSON
     */
    String toJSON();

    /**
     * Mengkonversi media ke format XML (eXtensible Markup Language).
     * Format XML cocok untuk penyimpanan terstruktur dan pertukaran data.
     *
     * <p>
     * Contoh output XML:
     * &lt;anime&gt;&lt;judul&gt;Attack on Titan&lt;/judul&gt;...&lt;/anime&gt;
     * </p>
     *
     * @return String data media dalam format XML
     */
    String toXML();

    /**
     * Mengkonversi media ke format String yang sudah diformat dengan rapi.
     * Format ini mirip dengan output {@link Informasi#getInfoLengkap()}
     * namun lebih fokus pada representasi data lengkap.
     *
     * @return String data media dalam format yang sudah diformat dengan indentasi
     */
    String toFormattedString();

    /**
     * Mengonversi string CSV ke dalam objek media yang sudah ada (update).
     * Metode ini digunakan untuk import data dari file CSV.
     *
     * <p>
     * Format string harus sesuai dengan output dari {@link #toCSV()}.
     * Jika format tidak valid, dapat melempar exception.
     * </p>
     *
     * @param csvString string dalam format CSV
     * @throws IllegalArgumentException jika format CSV tidak valid atau field tidak sesuai
     */
    void fromCSV(String csvString);

    /**
     * Mengonversi string JSON ke dalam objek media yang sudah ada (update).
     * Metode ini digunakan untuk import data dari API response atau file JSON.
     *
     * <p>
     * Format string harus sesuai dengan output dari {@link #toJSON()}.
     * Jika format tidak valid, dapat melempar exception.
     * </p>
     *
     * @param jsonString string dalam format JSON
     * @throws IllegalArgumentException jika format JSON tidak valid atau field tidak sesuai
     */
    void fromJSON(String jsonString);
}
