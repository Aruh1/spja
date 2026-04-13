# Tabel Properti Desain GUI SPJA

Berikut adalah rincian komponen GUI yang terdapat pada proyek SPJA (Sistem Penjadwalan Tayang Anime).

### 1. Tabel Properti Desain `GUI_Anime.java`

|  No   | Nama Komponen     | Properti      | Value                                                                            |
| :---: | :---------------- | :------------ | :------------------------------------------------------------------------------- |
|   1   | `JLabel` (anonim) | Text          | Judul:                                                                           |
|   2   | `JLabel` (anonim) | Text          | Genre:                                                                           |
|   3   | `JLabel` (anonim) | Text          | Tahun Rilis:                                                                     |
|   4   | `JLabel` (anonim) | Text          | Status:                                                                          |
|   5   | `JLabel` (anonim) | Text          | Studio:                                                                          |
|   6   | `JLabel` (anonim) | Text          | Total Episode:                                                                   |
|   7   | `JLabel` (anonim) | Text          | Musim:                                                                           |
|   8   | `JLabel` (anonim) | Text          | Hari Tayang:                                                                     |
|   9   | `tfJudul`         | Name<br>Text  | tfJudul<br>*(kosong)*                                                            |
|  10   | `tfGenre`         | Name<br>Text  | tfGenre<br>*(kosong)*                                                            |
|  11   | `tfTahun`         | Name<br>Text  | tfTahun<br>*(kosong)*                                                            |
|  12   | `tfStatus`        | Name<br>Text  | tfStatus<br>*(kosong)*                                                           |
|  13   | `tfStudio`        | Name<br>Text  | tfStudio<br>*(kosong)*                                                           |
|  14   | `tfEpisode`       | Name<br>Text  | tfEpisode<br>*(kosong)*                                                          |
|  15   | `tfMusim`         | Name<br>Text  | tfMusim<br>*(kosong)*                                                            |
|  16   | `tfHari`          | Name<br>Text  | tfHari<br>*(kosong)*                                                             |
|  17   | `btnTambah`       | Name<br>Text  | btnTambah<br>Tambah Anime                                                        |
|  18   | `btnProgress`     | Name<br>Text  | btnProgress<br>Hitung Progress                                                   |
|  19   | `lblProgress`     | Name<br>Text  | lblProgress<br>Progress: -                                                       |
|  20   | `btnInfo`         | Name<br>Text  | btnInfo<br>Tampilkan Info                                                        |
|  21   | `lblInfo`         | Name<br>Text  | lblInfo<br>Pilih anime dari tabel, lalu klik Tampilkan Info.                     |
|  22   | `tableAnime`      | Name<br>Model | tableAnime<br>[Judul, Genre, Tahun, Status, Studio, Episode, Musim, Hari Tayang] |

### 2. Tabel Properti Desain `GUI_AnimeFilm.java`

|  No   | Nama Komponen     | Properti      | Value                                                                          |
| :---: | :---------------- | :------------ | :----------------------------------------------------------------------------- |
|   1   | `JLabel` (anonim) | Text          | Judul:                                                                         |
|   2   | `JLabel` (anonim) | Text          | Genre:                                                                         |
|   3   | `JLabel` (anonim) | Text          | Tahun Rilis:                                                                   |
|   4   | `JLabel` (anonim) | Text          | Status:                                                                        |
|   5   | `JLabel` (anonim) | Text          | Durasi (menit):                                                                |
|   6   | `JLabel` (anonim) | Text          | Tanggal Rilis (DD-MM-YYYY):                                                    |
|   7   | `JLabel` (anonim) | Text          | Distributor:                                                                   |
|   8   | `tfJudul`         | Name<br>Text  | tfJudul<br>*(kosong)*                                                          |
|   9   | `tfGenre`         | Name<br>Text  | tfGenre<br>*(kosong)*                                                          |
|  10   | `tfTahun`         | Name<br>Text  | tfTahun<br>*(kosong)*                                                          |
|  11   | `tfStatus`        | Name<br>Text  | tfStatus<br>*(kosong)*                                                         |
|  12   | `tfDurasi`        | Name<br>Text  | tfDurasi<br>*(kosong)*                                                         |
|  13   | `tfTanggal`       | Name<br>Text  | tfTanggal<br>*(kosong)*                                                        |
|  14   | `tfDistributor`   | Name<br>Text  | tfDistributor<br>*(kosong)*                                                    |
|  15   | `lblStatusTayang` | Name<br>Text  | lblStatusTayang<br>Status Tayang: -                                            |
|  16   | `btnTambah`       | Name<br>Text  | btnTambah<br>Tambah Film                                                       |
|  17   | `btnInfo`         | Name<br>Text  | btnInfo<br>Tampilkan Info                                                      |
|  18   | `lblInfo`         | Name<br>Text  | lblInfo<br>Pilih film dari tabel, lalu klik Tampilkan Info.                    |
|  19   | `tableFilm`       | Name<br>Model | tableFilm<br>[Judul, Genre, Tahun, Status, Durasi, Tanggal Rilis, Distributor] |

### 3. Tabel Properti Desain `Spjaprak.java` (Menu Utama)

|  No   | Nama Komponen    | Properti      | Value                                           |
| :---: | :--------------- | :------------ | :---------------------------------------------- |
|   1   | `frame` (JFrame) | Name<br>Title | frame<br>SPJA — Sistem Penjadwalan Tayang Anime |
|   2   | `lblTitle`       | Name<br>Text  | lblTitle<br>Sistem Penjadwalan Tayang Anime     |
|   3   | `btnAnime`       | Name<br>Text  | btnAnime<br>Kelola Anime Series                 |
|   4   | `btnFilm`        | Name<br>Text  | btnFilm<br>Kelola Anime Film                    |
|   5   | `btnExit`        | Name<br>Text  | btnExit<br>Keluar                               |

---

## Class Diagrams

### Class diagram (Class Media.java):

| Media                                                                                                                                                                                                                                                                                                                                                                                        |
| :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| # judul : String<br># genre : String<br># tahunRilis : int<br># status : String                                                                                                                                                                                                                                                                                                              |
| + Media(judul: String, genre: String, tahunRilis: int, status: String)<br>+ getInfo() : String<br>+ tampilkanDetail() : void<br>+ getJudul() : String<br>+ setJudul(judul: String) : void<br>+ getGenre() : String<br>+ setGenre(genre: String) : void<br>+ getTahunRilis() : int<br>+ setTahunRilis(tahunRilis: int) : void<br>+ getStatus() : String<br>+ setStatus(status: String) : void |

### Class diagram (Class Anime.java):

| Anime                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - studio : String<br>- totalEpisode : int<br>- musim : String<br>- hariTayang : String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| + Anime(judul: String, genre: String, tahunRilis: int, status: String, studio: String, totalEpisode: int, musim: String, hariTayang: String)<br>+ getProgressTayang(episodeSaatIni: int) : double<br>+ getJadwalLengkap() : String<br>+ getInfo() : String<br>+ tampilkanDetail() : void<br>+ getStudio() : String<br>+ setStudio(studio: String) : void<br>+ getTotalEpisode() : int<br>+ setTotalEpisode(totalEpisode: int) : void<br>+ getMusim() : String<br>+ setMusim(musim: String) : void<br>+ getHariTayang() : String<br>+ setHariTayang(hariTayang: String) : void |

### Class diagram (Class AnimeFilm.java):

| AnimeFilm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - durasiMenit : int<br>- tanggalRilis : String<br>- distributor : String<br>- FORMATTER : DateTimeFormatter                                                                                                                                                                                                                                                                                                                                                                                          |
| + AnimeFilm(judul: String, genre: String, tahunRilis: int, status: String, durasiMenit: int, tanggalRilis: String, distributor: String)<br>+ getFormatDurasi() : String<br>+ sudahTayang() : boolean<br>+ getInfo() : String<br>+ tampilkanDetail() : void<br>+ getDurasiMenit() : int<br>+ setDurasiMenit(durasiMenit: int) : void<br>+ getTanggalRilis() : String<br>+ setTanggalRilis(tanggalRilis: String) : void<br>+ getDistributor() : String<br>+ setDistributor(distributor: String) : void |

### Class diagram (Class GUI_Anime.java):

| GUI_Anime                                                                                                                                                                                                                                                                                                                                                            |
| :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - listAnime : ArrayList&lt;Anime&gt;<br>- tfJudul : JTextField<br>- tfGenre : JTextField<br>- tfTahun : JTextField<br>- tfStatus : JTextField<br>- tfStudio : JTextField<br>- tfEpisode : JTextField<br>- tfMusim : JTextField<br>- tfHari : JTextField<br>- tableAnime : JTable<br>- modelAnime : DefaultTableModel<br>- lblProgress : JLabel<br>- lblInfo : JLabel |
| + GUI_Anime()<br>- initComponents() : void<br>- addFormField(panel: JPanel, gbc: GridBagConstraints, label: String, row: int) : JTextField<br>- tambahAnime() : void<br>- clearFields() : void<br>- hitungProgress() : void<br>- tampilkanInfo() : void<br>+ main(args: String[]) : void                                                                             |

### Class diagram (Class GUI_AnimeFilm.java):

| GUI_AnimeFilm                                                                                                                                                                                                                                                                                                                                          |
| :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - listFilm : ArrayList&lt;AnimeFilm&gt;<br>- tfJudul : JTextField<br>- tfGenre : JTextField<br>- tfTahun : JTextField<br>- tfStatus : JTextField<br>- tfDurasi : JTextField<br>- tfTanggal : JTextField<br>- tfDistributor : JTextField<br>- tableFilm : JTable<br>- modelFilm : DefaultTableModel<br>- lblStatusTayang : JLabel<br>- lblInfo : JLabel |
| + GUI_AnimeFilm()<br>- initComponents() : void<br>- addFormField(panel: JPanel, gbc: GridBagConstraints, label: String, row: int) : JTextField<br>- updateStatusTayang() : void<br>- tambahFilm() : void<br>- clearFields() : void<br>- tampilkanInfo() : void<br>+ main(args: String[]) : void                                                        |

### Class diagram (Class Spjaprak.java):

| Spjaprak                      |
| :---------------------------- |
| *(tidak ada atribut)*         |
| + main(args: String[]) : void |
