import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Menyimpan data secara sementara selama program berjalan
    private static ArrayList<Akun> databaseAkun = new ArrayList<>();
    private static ArrayList<Produk> katalogProduk = new ArrayList<>();
    private static Akun akunAktif = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inisialisasiProduk();

        boolean isRunning = true;
        while (isRunning) {
            if (akunAktif == null) {
                // Menu Awal
                System.out.println("\n===========================================");
                System.out.println(" WUTHERING WAVES - LUNITE TOP UP SYSTEM");
                System.out.println("===========================================");
                System.out.println("1. Login");
                System.out.println("2. Registrasi");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");
                
                String pilihan = scanner.nextLine();
                switch (pilihan) {
                    case "1":
                        login(scanner);
                        break;
                    case "2":
                        registrasi(scanner);
                        break;
                    case "3":
                        System.out.println("Terima kasih telah bermain Wuthering Waves. Semoga Pity mu Rate on selalu >-<");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                // Menu Utama
                System.out.println("\n===========================================");
                System.out.println(" Selamat Datang, " + akunAktif.getUsername() + " [" + akunAktif.getStatusMember() + "]");
                System.out.println("===========================================");
                System.out.println("1. Cek Akun");
                System.out.println("2. Top Up Lunite & Paket");
                System.out.println("3. Riwayat Pembelian (Invoice)");
                System.out.println("4. Logout");
                System.out.print("Pilih menu (1-4): ");
                
                String pilihan = scanner.nextLine();
                switch (pilihan) {
                    case "1":
                        akunAktif.cekAkun();
                        break;
                    case "2":
                        menuTopUp(scanner);
                        break;
                    case "3":
                        akunAktif.lihatRiwayat();
                        break;
                    case "4":
                        akunAktif = null;
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
        scanner.close();
    }

    private static void inisialisasiProduk() {
        katalogProduk.add(new TopUpLunite("L-01", "60 Lunites", 15000, 0));
        katalogProduk.add(new TopUpLunite("L-02", "300 Lunites", 79000, 30));
        katalogProduk.add(new TopUpLunite("L-03", "980 Lunites", 249000, 110));
        katalogProduk.add(new Subscription("S-01", "Lunite Subscription (Monthly)", 79000, 30));
        katalogProduk.add(new Subscription("S-02", "Newbie Bundle Package", 19000, 7));
    }

    private static void registrasi(Scanner scanner) {
        System.out.println("\n--- REGISTRASI AKUN ---");
        System.out.print("Masukkan Username baru : ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password baru : ");
        String password = scanner.nextLine();

        databaseAkun.add(new Akun(username, password));
        System.out.println("Registrasi berhasil! Silakan Login.");
    }

    private static void login(Scanner scanner) {
        System.out.println("\n--- LOGIN ---");
        System.out.print("Username : ");
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();

        for (Akun akun : databaseAkun) {
            if (akun.getUsername().equals(username) && akun.cekPassword(password)) {
                akunAktif = akun;
                System.out.println("Login Sukses!");
                return;
            }
        }
        System.out.println("Login Gagal! Username atau Password salah.");
    }

    private static void menuTopUp(Scanner scanner) {
        System.out.println("\n=== KATALOG PRODUK WUTHERING WAVES ===");
        for (int i = 0; i < katalogProduk.size(); i++) {
            System.out.print((i + 1) + ". ");
            katalogProduk.get(i).tampilkanDetail();
        }
        System.out.println("0. Batal / Kembali");
        System.out.print("Pilih produk yang ingin dibeli: ");
        
        try {
            int pilihan = Integer.parseInt(scanner.nextLine());
            if (pilihan == 0) return;

            if (pilihan > 0 && pilihan <= katalogProduk.size()) {
                Produk produkDipilih = katalogProduk.get(pilihan - 1);
                
                Transaksi trxBaru = new Transaksi(produkDipilih);
                akunAktif.tambahTransaksi(trxBaru);
                
                System.out.println("\nTransaksi Berhasil! Tagihan telah dibayar.");
                trxBaru.cetakInvoice(akunAktif.getUsername());
                
                System.out.println("Status member Anda : " + akunAktif.getStatusMember());
            } else {
                System.out.println("Produk tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        }
    }
}

