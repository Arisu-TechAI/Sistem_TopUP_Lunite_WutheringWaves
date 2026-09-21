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
