/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pololer.spjaprak;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {
    static ArrayList<String[]> jadwalAnime = new ArrayList<>();

    public static void main(String[] args) {
        // Inisialisasi data dummy awal
        jadwalAnime.add(new String[] { "Frieren: Beyond Journey's End", "Jumat", "21:00" });
        jadwalAnime.add(new String[] { "Jujutsu Kaisen", "Kamis", "22:00" });
        jadwalAnime.add(new String[] { "Spy x Family", "Sabtu", "21:30" });

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Sistem Penjadwalan Tayang Anime");
            System.out.println("1. Lihat Jadwal Tayang");
            System.out.println("2. Tambah Jadwal Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3):");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    lihatJadwal();
                    break;
                case "2":
                    tambahJadwal(scanner);
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nPilihan enggak valid, masukkan angka 1, 2, atau 3.");
            }
            System.out.println();
        }
        scanner.close();
    }

    // Method untuk menampilkan jadwal
    static void lihatJadwal() {
        System.out.println("\nDaftar Jadwal Tayang");
        if (jadwalAnime.isEmpty()) {
            System.out.println("Belum ada jadwal anime terdaftar");
        } else {
            for (int i = 0; i < jadwalAnime.size(); i++) {
                String[] anime = jadwalAnime.get(i);
                System.out.println((i + 1) + ". " + anime[0] + " | Hari: " + anime[1] + " | Jam: " + anime[2]);
            }
        }
    }

    // Method untuk menambah jadwal ke ArrayList dummy
    static void tambahJadwal(Scanner scanner) {
        System.out.println("\nTambah Jadwal Baru");

        System.out.print("Input Judul Anime:");
        String judul = scanner.nextLine();

        System.out.print("Input Hari Tayang:");
        String hari = scanner.nextLine();

        System.out.print("Input Jam Tayang (contoh: 20:00): ");
        String jam = scanner.nextLine();

        // Memasukkan input ke dalam ArrayList
        jadwalAnime.add(new String[] { judul, hari, jam });
        System.out.println("=> Berhasil! '" + judul + "' telah ditambahkan ke jadwal.");
    }
}
