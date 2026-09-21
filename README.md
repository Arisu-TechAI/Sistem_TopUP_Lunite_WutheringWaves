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
2. <b>Class TopUpLunite & Subscription (Sub-class / Inheritance)</b>
3. <b>Class Transaksi</b>
4. <b>Class Akun</b>
5. <b>Class Main</b>


