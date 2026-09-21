// Sub-Class Produk.java

public class Subscription extends Produk {
    private int durasiHari;

    public Subscription(String idProduk, String namaProduk, double harga, int durasiHari) {
        super(idProduk, namaProduk, harga);
        this.durasiHari = durasiHari;
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("[%s] %-25s (Durasi %d Hari)   : Rp %,.2f\n", idProduk, namaProduk, durasiHari, harga);
    }
}