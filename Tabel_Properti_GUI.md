# Tabel Properti Desain GUI SPJA

Berikut adalah rincian komponen GUI yang terdapat pada proyek SPJA (Sistem Penjadwalan Tayang Anime), diformat sesuai standar screenshot NetBeans.

### 1. Tabel Properti Desain `GUI_Anime.java`

|  No   | Nama Komponen     | Properti      | Value                                                                            |
| :---: | :---------------- | :------------ | :------------------------------------------------------------------------------- |
|   1   | `JLabel1`         | Text          | Judul:                                                                           |
|   2   | `JLabel2`         | Text          | Genre:                                                                           |
|   3   | `JLabel3`         | Text          | Tahun Rilis:                                                                     |
|   4   | `JLabel4`         | Text          | Status:                                                                          |
|   5   | `JLabel5`         | Text          | Studio:                                                                          |
|   6   | `JLabel6`         | Text          | Total Episode:                                                                   |
|   7   | `JLabel7`         | Text          | Musim:                                                                           |
|   8   | `JLabel8`         | Text          | Hari Tayang:                                                                     |
|   9   | `jTextField1`     | Name<br>Text  | tfJudul<br>*(kosong)*                                                            |
|  10   | `jTextField2`     | Name<br>Text  | tfGenre<br>*(kosong)*                                                            |
|  11   | `jTextField3`     | Name<br>Text  | tfTahun<br>*(kosong)*                                                            |
|  12   | `jTextField4`     | Name<br>Text  | tfStatus<br>*(kosong)*                                                           |
|  13   | `jTextField5`     | Name<br>Text  | tfStudio<br>*(kosong)*                                                           |
|  14   | `jTextField6`     | Name<br>Text  | tfEpisode<br>*(kosong)*                                                          |
|  15   | `jTextField7`     | Name<br>Text  | tfMusim<br>*(kosong)*                                                            |
|  16   | `jTextField8`     | Name<br>Text  | tfHari<br>*(kosong)*                                                             |
|  17   | `jButton1`        | Name<br>Text  | btnTambah<br>Tambah Anime                                                        |
|  18   | `jButton2`        | Name<br>Text  | btnSimpan<br>Simpan                                                              |
|  19   | `jButton3`        | Name<br>Text  | btnHapus<br>Hapus                                                                |
|  20   | `jButton4`        | Name<br>Text  | btnBatal<br>Batal                                                                |
|  21   | `jButton5`        | Name<br>Text  | btnClose<br>Close                                                                |
|  22   | `jButton6`        | Name<br>Text  | btnProgress<br>Hitung Progress                                                   |
|  23   | `JLabel9`         | Name<br>Text  | lblProgress<br>Progress: -                                                       |
|  24   | `jButton7`        | Name<br>Text  | btnInfo<br>Tampilkan Info                                                        |
|  25   | `JLabel10`        | Name<br>Text  | lblInfo<br>Pilih anime dari tabel, lalu klik Tampilkan Info.                     |
|  26   | `jTable1`         | Name<br>Model | tableAnime<br>[Judul, Genre, Tahun, Status, Studio, Episode, Musim, Hari Tayang] |

### 2. Tabel Properti Desain `GUI_AnimeFilm.java`

|  No   | Nama Komponen     | Properti      | Value                                                                          |
| :---: | :---------------- | :------------ | :----------------------------------------------------------------------------- |
|   1   | `JLabel1`         | Text          | Judul:                                                                         |
|   2   | `JLabel2`         | Text          | Genre:                                                                         |
|   3   | `JLabel3`         | Text          | Tahun Rilis:                                                                   |
|   4   | `JLabel4`         | Text          | Status:                                                                        |
|   5   | `JLabel5`         | Text          | Durasi (menit):                                                                |
|   6   | `JLabel6`         | Text          | Tanggal Rilis (DD-MM-YYYY):                                                    |
|   7   | `JLabel7`         | Text          | Distributor:                                                                   |
|   8   | `jTextField1`     | Name<br>Text  | tfJudul<br>*(kosong)*                                                          |
|   9   | `jTextField2`     | Name<br>Text  | tfGenre<br>*(kosong)*                                                          |
|  10   | `jTextField3`     | Name<br>Text  | tfTahun<br>*(kosong)*                                                          |
|  11   | `jTextField4`     | Name<br>Text  | tfStatus<br>*(kosong)*                                                         |
|  12   | `jTextField5`     | Name<br>Text  | tfDurasi<br>*(kosong)*                                                         |
|  13   | `jTextField6`     | Name<br>Text  | tfTanggal<br>*(kosong)*                                                        |
|  14   | `jTextField7`     | Name<br>Text  | tfDistributor<br>*(kosong)*                                                    |
|  15   | `JLabel8`         | Name<br>Text  | lblStatusTayang<br>Status Tayang: -                                            |
|  16   | `jButton1`        | Name<br>Text  | btnTambah<br>Tambah Film                                                       |
|  17   | `jButton2`        | Name<br>Text  | btnSimpan<br>Simpan                                                            |
|  18   | `jButton3`        | Name<br>Text  | btnHapus<br>Hapus                                                              |
|  19   | `jButton4`        | Name<br>Text  | btnBatal<br>Batal                                                              |
|  20   | `jButton5`        | Name<br>Text  | btnClose<br>Close                                                              |
|  21   | `jButton6`        | Name<br>Text  | btnInfo<br>Tampilkan Info                                                      |
|  22   | `JLabel9`         | Name<br>Text  | lblInfo<br>Pilih film dari tabel, lalu klik Tampilkan Info.                    |
|  23   | `jTable1`         | Name<br>Model | tableFilm<br>[Judul, Genre, Tahun, Status, Durasi, Tanggal Rilis, Distributor] |

### 3. Tabel Properti Desain `Spjaprak.java` (Menu Utama)

|  No   | Nama Komponen     | Properti      | Value                                           |
| :---: | :---------------- | :------------ | :---------------------------------------------- |
|   1   | `JFrame`          | Name<br>Title | frame<br>SPJA — Sistem Penjadwalan Tayang Anime |
|   2   | `JLabel1`         | Name<br>Text  | lblTitle<br>Sistem Penjadwalan Tayang Anime     |
|   3   | `jButton1`        | Name<br>Text  | btnAnime<br>Kelola Anime Series                 |
|   4   | `jButton2`        | Name<br>Text  | btnFilm<br>Kelola Anime Film                    |
|   5   | `jButton3`        | Name<br>Text  | btnExit<br>Keluar                               |

---

## Class Diagrams

### Class diagram (Class Media.java):

| Media                                                                                                                                                                                                                                                                                                                                                                                        |
| :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| # judul : String<br># genre : String<br># tahunRilis : int<br># status : String                                                                                                                                                                                                                                                                                                              |
| + Media(judul: String, genre: String, tahunRilis: int, status: String)<br>+ getInfo() : String<br>+ getInfo(showGenre: boolean) : String<br>+ getInfo(delimiter: String) : String<br>+ tampilkanDetail() : void<br>+ tampilkanDetail(limit: int) : void<br>+ tampilkanDetail(format: String) : void<br>+ getJudul() : String<br>+ setJudul(judul: String) : void<br>+ getGenre() : String<br>+ setGenre(genre: String) : void<br>+ getTahunRilis() : int<br>+ setTahunRilis(tahunRilis: int) : void<br>+ getStatus() : String<br>+ setStatus(status: String) : void |

### Class diagram (Class Anime.java):

| Anime                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - studio : String<br>- totalEpisode : int<br>- musim : String<br>- hariTayang : String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| + Anime(judul: String, genre: String, tahunRilis: int, status: String, studio: String, totalEpisode: int, musim: String, hariTayang: String)<br>+ getProgressTayang(episodeSaatIni: int) : double<br>+ getProgressTayang(episodeSaatIni: int, episodeTarget: int) : double<br>+ getJadwalLengkap() : String<br>+ getInfo() : String<br>+ getInfo(scheduleOnly: boolean) : String<br>+ getInfo(studioOnly: boolean, withGenre: boolean) : String<br>+ tampilkanDetail() : void<br>+ tampilkanDetail(withProgress: boolean, episodeSaatIni: int) : void<br>+ tampilkanDetail(includeStudio: boolean, includeMusim: boolean, includeHari: boolean) : void<br>+ getStudio() : String<br>+ setStudio(studio: String) : void<br>+ getTotalEpisode() : int<br>+ setTotalEpisode(totalEpisode: int) : void<br>+ getMusim() : String<br>+ setMusim(musim: String) : void<br>+ getHariTayang() : String<br>+ setHariTayang(hariTayang: String) : void |

### Class diagram (Class AnimeFilm.java):

| AnimeFilm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - durasiMenit : int<br>- tanggalRilis : String<br>- distributor : String<br>- FORMATTER : DateTimeFormatter                                                                                                                                                                                                                                                                                                                                                                                          |
| + AnimeFilm(judul: String, genre: String, tahunRilis: int, status: String, durasiMenit: int, tanggalRilis: String, distributor: String)<br>+ getFormatDurasi() : String<br>+ getFormatDurasi(format: String) : String<br>+ getFormatDurasi(durasiCustom: int) : String<br>+ sudahTayang() : boolean<br>+ sudahTayang(tanggalCek: String) : boolean<br>+ sudahTayang(hariOffset: int) : boolean<br>+ getInfo() : String<br>+ getInfo(withDistributor: boolean, withReleaseDate: boolean) : String<br>+ getInfo(fieldFilter: String) : String<br>+ tampilkanDetail() : void<br>+ tampilkanDetail(withStatusDetail: boolean) : void<br>+ tampilkanDetail(durationFormat: String) : void<br>+ getDurasiMenit() : int<br>+ setDurasiMenit(durasiMenit: int) : void<br>+ getTanggalRilis() : String<br>+ setTanggalRilis(tanggalRilis: String) : void<br>+ getDistributor() : String<br>+ setDistributor(distributor: String) : void |

### Class diagram (Class GUI_Anime.java):

| GUI_Anime                                                                                                                                                                                                                                                                                                                                                            |
| :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - listAnime : ArrayList&lt;Anime&gt;<br>- tfJudul : JTextField<br>- tfGenre : JTextField<br>- tfTahun : JTextField<br>- tfStatus : JTextField<br>- tfStudio : JTextField<br>- tfEpisode : JTextField<br>- tfMusim : JTextField<br>- tfHari : JTextField<br>- btnTambah : JButton<br>- btnSimpan : JButton<br>- btnHapus : JButton<br>- btnBatal : JButton<br>- btnClose : JButton<br>- tableAnime : JTable<br>- modelAnime : DefaultTableModel<br>- lblProgress : JLabel<br>- lblInfo : JLabel |
| + GUI_Anime()<br>- initComponents() : void<br>- tambahAnime() : void<br>- clearFields() : void<br>- simpanData() : void<br>- hapusAnime() : void<br>- hitungProgress() : void<br>- tampilkanInfo() : void<br>+ main(args: String[]) : void                                                                                                    |

### Class diagram (Class GUI_AnimeFilm.java):

| GUI_AnimeFilm                                                                                                                                                                                                                                                                                                                                          |
| :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| - listFilm : ArrayList&lt;AnimeFilm&gt;<br>- tfJudul : JTextField<br>- tfGenre : JTextField<br>- tfTahun : JTextField<br>- tfStatus : JTextField<br>- tfDurasi : JTextField<br>- tfTanggal : JTextField<br>- tfDistributor : JTextField<br>- btnTambah : JButton<br>- btnSimpan : JButton<br>- btnHapus : JButton<br>- btnBatal : JButton<br>- btnClose : JButton<br>- tableFilm : JTable<br>- modelFilm : DefaultTableModel<br>- lblStatusTayang : JLabel<br>- lblInfo : JLabel |
| + GUI_AnimeFilm()<br>- initComponents() : void<br>- updateStatusTayang() : void<br>- tambahFilm() : void<br>- clearFields() : void<br>- simpanData() : void<br>- hapusFilm() : void<br>- tampilkanInfo() : void<br>+ main(args: String[]) : void                                                                                                    |

### Class diagram (Class Spjaprak.java):

| Spjaprak                      |
| :---------------------------- |
| *(tidak ada atribut)*         |
| + main(args: String[]) : void |
