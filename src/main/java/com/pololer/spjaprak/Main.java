package com.pololer.spjaprak;

import java.util.ArrayList;

/**
 * Class Main untuk mendemonstrasikan Polimorfisme Casting (Upcasting & Downcasting).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== TUGAS 7: POLIMORFISME CASTING ==========");
        
        ArrayList<Media> listMedia = new ArrayList<>();
        
        // 1. UPCASTING
        // Objek dari subclass (Anime dan AnimeFilm) dimasukkan ke referensi superclass (Media).
        // Hal ini aman dan terjadi secara otomatis.
        Media anime1 = new Anime("Frieren: Beyond Journey's End", "Fantasy", 2023, "Selesai", "Madhouse", 28, "Fall", "Jumat");
        Media film1 = new AnimeFilm("Your Name", "Romance", 2016, "Selesai", 112, "26-08-2016", "Toho");
        
        listMedia.add(anime1);
        listMedia.add(film1);
        
        System.out.println("\n[Upcasting] Data Media berhasil ditambahkan ke dalam list:");
        for (Media m : listMedia) {
            // Meskipun referensinya Media, Java tetap tahu tipe aslinya saat runtime.
            System.out.println("- " + m.getJudul() + " -> " + m.getClass().getSimpleName());
        }
        
        System.out.println("\n[Downcasting] Mengembalikan Media ke bentuk aslinya untuk mengakses method spesifik:");
        // 2. DOWNCASTING
        // Karena Media tidak memiliki method getProgressTayang() atau getFormatDurasi(),
        // kita perlu melakukan downcasting setelah mengecek tipe aslinya dengan "instanceof".
        for (Media m : listMedia) {
            if (m instanceof Anime) {
                // Downcast ke Anime
                Anime a = (Anime) m;
                System.out.println("\nMemanggil method milik Anime: " + a.getJudul());
                System.out.println("-> Progress Tayang (eps 10): " + String.format("%.2f", a.getProgressTayang(10)) + "%");
                
            } else if (m instanceof AnimeFilm) {
                // Downcast ke AnimeFilm
                AnimeFilm af = (AnimeFilm) m;
                System.out.println("\nMemanggil method milik AnimeFilm: " + af.getJudul());
                System.out.println("-> Durasi Format: " + af.getFormatDurasi());
            }
        }
        
        System.out.println("\n===================================================");
    }
}
