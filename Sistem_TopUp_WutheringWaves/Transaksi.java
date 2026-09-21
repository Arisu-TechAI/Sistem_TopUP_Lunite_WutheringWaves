public class Transaksi {
    private static int counter = 1;
    private String idTransaksi;
    private Produk produk;
    private double totalBayar;

    public Transaksi(Produk produk) {
        this.idTransaksi = "TRX-WW-" + counter++;
        this.produk = produk;
        this.totalBayar = produk.getHarga();
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void cetakInvoice(String username) {
        System.out.println("\n==================================");
        System.out.println("          INVOICE PEMBELIAN       ");
        System.out.println("==================================");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Akun Pembeli : " + username);
        System.out.println("Produk       : " + produk.getNamaProduk());
        System.out.printf("Total Bayar  : Rp %,.2f\n", totalBayar);
        System.out.println("Status       : BERHASIL");
        System.out.println("==================================");
    }
}