/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.pololer.spjaprak;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Class Spjaprak merupakan class utama (main entry point) dari aplikasi
 * Sistem Penjadwalan Tayang Anime (SPJA).
 *
 * <p>
 * Class ini menampilkan menu utama berupa JFrame dengan tombol-tombol
 * untuk membuka GUI pengelolaan Anime Series ({@link GUI_Anime}) dan
 * Anime Film ({@link GUI_AnimeFilm}).
 * </p>
 *
 * @author Administrator
 * @version 1.0
 */
public class Spjaprak {

    /**
     * Method main — entry point aplikasi SPJA.
     * Menampilkan menu utama dengan pilihan membuka GUI Anime Series
     * atau GUI Anime Film.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("SPJA — Sistem Penjadwalan Tayang Anime");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 380);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 10, 8, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;

            // Judul
            JLabel lblTitle = new JLabel("Sistem Penjadwalan Tayang Anime",
                    SwingConstants.CENTER);
            lblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
            gbc.gridy = 0;
            panel.add(lblTitle, gbc);

            // Tombol 1: Kelola Anime Series
            JButton btnAnime = new JButton("Kelola Anime Series");
            btnAnime.addActionListener(e -> new GUI_Anime());
            gbc.gridy = 2;
            gbc.insets = new Insets(15, 10, 5, 10);
            panel.add(btnAnime, gbc);

            // Tombol 2: Kelola Anime Film
            JButton btnFilm = new JButton("Kelola Anime Film");
            btnFilm.addActionListener(e -> new GUI_AnimeFilm());
            gbc.gridy = 3;
            gbc.insets = new Insets(5, 10, 5, 10);
            panel.add(btnFilm, gbc);

            // Tombol 4: Keluar
            JButton btnExit = new JButton("Keluar");
            btnExit.addActionListener(e -> System.exit(0));
            gbc.gridy = 6;
            gbc.insets = new Insets(15, 10, 5, 10);
            panel.add(btnExit, gbc);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
