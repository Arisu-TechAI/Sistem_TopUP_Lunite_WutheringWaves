// Super-Class
public class Produk {
    protected String idProduk;
    protected String namaProduk;
    protected double harga;

    public Produk(String idProduk, String namaProduk, double harga) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    // Method yang di-override oleh sub-class
    public void tampilkanDetail() {
        System.out.printf("[%s] %-25s : Rp %,.2f\n", idProduk, namaProduk, harga);
    }
}

