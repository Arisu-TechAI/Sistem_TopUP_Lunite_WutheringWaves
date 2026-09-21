import java.util.ArrayList;

public class Akun {
    private String username;
    private String password;
    private double totalPengeluaran;
    private ArrayList<Transaksi> riwayatTransaksi;

    public Akun(String username, String password) {
        this.username = username;
        this.password = password;
        this.totalPengeluaran = 0.0;
        this.riwayatTransaksi = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean cekPassword(String password) {
        return this.password.equals(password);
    }

    public String getStatusMember() {
        if (totalPengeluaran >= 150000) return "Platinum";
        if (totalPengeluaran >= 50000) return "Gold";
        if (totalPengeluaran >= 19000) return "Silver";
        return "Bronze"; 
    }

    public void tambahTransaksi(Transaksi trx) {
        riwayatTransaksi.add(trx);
        totalPengeluaran += trx.getTotalBayar();
    }

    public void cekAkun() {
        System.out.println("\n=== INFORMASI AKUN ===");
        System.out.println("Username       : " + username);
        System.out.println("Status Member  : " + getStatusMember());
        System.out.printf("Total Top Up   : Rp %,.2f\n", totalPengeluaran);
    }

    public void lihatRiwayat() {
        System.out.println("\n=== RIWAYAT PEMBELIAN ===");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaksi trx : riwayatTransaksi) {
                trx.cetakInvoice(this.username);
            }
        }
    }
}