# <b>Sistem TopUp Lunite WutheringWaves</b>
<b>Tugas Individu Mata Kuliah Pemrograman Berorientasi Objek</b>  
<b>Oleh :  
Arizky Saputra  
2509116088  
Kelas C 2025  
Sistem Informasi</b>  

## <b>Latar Belakang</b>  
<b>Wuthering Waves</b> 
adalah game bergenre action RPG open-world gratis (free-to-play) yang menggunakan sistem gacha dan transaksi mikro dalam aplikasinya. Di dalam game ini, pemain menggunakan berbagai mata uang (currency) seperti Lunite dan Asterite untuk melakukan konversi atau penarikan item premium.

Pada studi kasus ini, Program CLI (Command Line Interface) berbasis Java ini dikembangkan untuk mensimulasikan sistem transaksi jual-beli digital (top-up) pada platform pihak ketiga/penyedia jasa top-up. Program bertujuan untuk memproses pembelian item game secara cepat, menghitung tagihan, mencetak riwayat transaksi (invoice), serta mengelola tingkat keanggotaan pengguna (Membership Tier).  

## Deskripsi Katalog Produk  
Pada program aplikasi ini menyediakan dua kategori utama pada game Wuthering Waves, yaitu :  
1. <b>Top Up Lunite (Mata Uang Berbayar Premium)</b>  
   Lunite adalah mata uang premium utama yang dibeli menggunakan uang asli. Dalam sistem ini, setiap pembelian paket Lunite tertentu dapat memberikan nominal dasar serta Bonus Lunite tambahan bagi pengguna.  
2. <b>Lunite Subscription (Paket Langganan)</b>
   Paket langganan (subscription) bernilai ekonomis tinggi bagi pemain harian. Berbeda dari top-up biasa, paket ini memiliki durasi masa aktif (seperti 30 hari) yang mewajibkan pemain melakukan login harian untuk mengklaim total 90 Asterites per hari selama masa berlangganan berlangsung.

## Alur Sistem & Perancangan Class  
Pada program ini, Sistem membagi tugas ke dalam beberapa komponen class utama sebagai berikut :  
1. <b> Class Produk (Super-Class)</b>  
    Berfungsi sebagai objek induk (Super-class) yang merepresentasikan informasi dasar setiap barang yang dijual di toko, meliputi ID produk, nama produk, dan harga dasar.  

2. <b>Class TopUpLunite & Subscription (Sub-class / Inheritance)</b>  
    Merupakan turunan dari Produk yang memperluas atribut sesuai kategori item:
    - TopUpLunite menambahkan properti jumlah Bonus Lunite.
    - Subscription menambahkan properti Durasi Hari Masa Aktif (misalnya 30 hari klaim harian 90 Asterites).  

3. <b>Class Transaksi</b>  
    Menangani proses pembuatan pesanan saat pengguna memilih produk dari katalog. Class ini menghitung total biaya, megenerasi ID Transaksi unik, dan mencetak struk rincian (Invoice).  

4. <b>Class Akun</b>  
    Menampung data profil pengguna (username dan password), menyimpan daftar riwayat transaksi yang pernah dilakukan, serta mengkalkulasikan akumulasi pengeluaran pengguna secara otomatis untuk menentukan status Membership Tier seperti :  
    - Tier Silver : Total TopUp minimal Rp.19.000
    - Tier Gold   : Total TopUp minimal Rp.50.000
    - Tier Platinum : Total TopUp minimal Rp.150.000  

5. <b>Class Main</b>  
    Bertindak sebagai controller dan entry point aplikasi yang menyediakan menu navigasi interaktif (Registrasi, Login, Katalog Produk, Cek Akun, dan Riwayat Pembelian).

## Penerapan Inheritance  
Pada program ini, Penerapan inheritance diimplementasikan pada entitas katalog penjualan, sehingga dibuatlah satu <b>Super-class</b> yaitu <b>Produk.java</b> dan dua <b>Sub-class</b> yaitu <b>TopUpLunite.java & Subscribtion</b>  

1. <b>Super-class (Produk.java)</b>  
    <img width="663" height="258" alt="Screenshot 2026-09-22 011411" src="https://github.com/user-attachments/assets/69d564c6-99b2-4639-b75b-37e5d78e435b" />  
    Super class ini berfungsi untuk Mendefinisikan kerangka dasar(blue print). Semua produk pasti memiliki ID, nama produk, dan harga. Penggunaan access modifier protected memungkinkan atribut ini diakses langsung oleh sub-class.  

2. <b>Sub-class TopUpLunite.java</b>  
    <img width="843" height="313" alt="Screenshot 2026-09-22 011807" src="https://github.com/user-attachments/assets/0bd2a70f-45ce-49c7-89ce-eb9ba5ad655e" />  
    class ini menggunakan keyword extends untuk mewarisi Produk. Keuntungannya, class turunan tidak perlu menulis ulang logika pembuatan ID, nama, dan harga.  
    Pada class ini hanya perlu menambahkan atribut spesifik nya sendiri, seperti pada class ini menambahkan atribut <b>bonusLunite</b> untuk bonus topup tambahan dari hasil transaksi.  

3. <b>Sub-class Subscribtion.java</b> 
    <img width="811" height="362" alt="Screenshot 2026-09-22 012113" src="https://github.com/user-attachments/assets/1f95e0a0-04cd-4d80-b57e-ae8261f9b9f5" />  
    class ini menggunakan keyword extends untuk mewarisi Produk. Keuntungannya, class turunan tidak perlu menulis ulang logika pembuatan ID, nama, dan harga.  
    Pada class ini hanya perlu menambahkan atribut spesifik nya sendiri. Pada sub-class subscribtion ini menambahkan atribut <b>durasiHari</b> sebagai acuan dari sistem langganan yang bersifat bulanan/mingguan.

## Dokumentasi Program  
1. <b>Menu Awal & Registrasi Akun</b>  
<img width="567" height="669" alt="Regist   Login akun" src="https://github.com/user-attachments/assets/eebd0625-ca8e-4863-87dc-016629915b58" />

Ketika program baru dijalankan, terminal akan menampilkan Output menu utama yg berisi Judul(header), dan pilihan beberapa menu seperti Login, Registrasi, dan Keluar.  
Pada dokumentasi disini, dilakukan demo pembuatan dan login pada akun dengan nama <b>YangYang12</b> sebagai contohnya. Input untuk melakukan pilihan yang ada dalam program adalah menggunakan nomor menu yang tersedia (misal ketik "2" untuk melakukan registrasi).  
Setelah mengetik "2" untuk melakukan registrasi, selanjutnya adalah mengisi Username dan Password seperti contoh dokumentasi di atas, kemudian melakukan login dengan memilih menu "1".  

3. <b>Pilihan Menu 1. Cek Akun</b>  
<img width="458" height="255" alt="Menu 1 Cek akun" src="https://github.com/user-attachments/assets/049a8bc8-945c-485f-95ab-564314ca9e3a" />

Setelah berhasil login pada aplikasi TopUp Lunite ini, terdapat beberapa menu utama yang dapat digunakan, salah satunya Menu 1. Cek Akun.  
Menu ini berfungsi untuk menampilkan informasi akun seperti Username, status member, dan total akumulasi jumlah topup yang pernah dilakukan.  

5. <b>Pilihan Menu 2. Top Up Lunite & Paket</b>  
<img width="654" height="559" alt="Menu 2 tes topup" src="https://github.com/user-attachments/assets/ff1eec14-b6ee-4b92-b332-82b790ac79ad" />

Selanjutnya adalh pilihan Menu ke-2 yaitu Top Up & Paket. Menu ini berisi katalog dan pilihan jenis top up yang dapat dilakukan pengguna. Misal pada dokumentasi demo program pada gambar di atas, program melakukan top up pada pilihan jenis top up nomor 2 yaitu 300 Lunites dengan mengetik pilihan menu "2", maka program akan memproses input tersebut, dan jika berhasil, maka program akan menampilkan invoice hasil transaksi sebagai bukti transaksi berhasil dilakukan.  

7. <b>Pilihan Menu 3. Riwayat Pembelian</b>  
<img width="509" height="420" alt="Menu 3 Cek Invoice" src="https://github.com/user-attachments/assets/6f75815c-b43d-427b-a455-57a640cd397d" />

Pilihan menu 3 berfungsi untuk menampilkan keseluruhan riwayat transaksi yang pernah dilakukan oleh user pada akun terkait. Menu ini menampilkan invoice yang isinya berupa ID transaksi, nama akun pembeli, jenis produk, total harga yang dibayar, dan status pembelian (berhasil/gagal).  

9. <b>Pilihan Menu 4. Log out & Keluar aplikasi</b>
<img width="1290" height="344" alt="Menu 4 Log out   Keluar app" src="https://github.com/user-attachments/assets/95c31112-e3ca-4ebc-b481-27cc274b7a8a" />  
Pilihan Menu ini berfungsi untuk melakukan Log-out atau keluar dari akun pengguna. Sejalur dengan menu log-out, terdapat Menu 3 (Keluar) pada tampilan menu awal setelah pengguna log out yang berfungsi untuk menutup program aplikasi.
