// Sub-Class Produk.java
public class TopUpLunite extends Produk {
    private int bonusLunite;

    public TopUpLunite(String idProduk, String namaProduk, double harga, int bonusLunite) {
        super(idProduk, namaProduk, harga);
        this.bonusLunite = bonusLunite;
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("[%s] %-25s (Bonus %d Lunite) : Rp %,.2f\n", idProduk, namaProduk, bonusLunite, harga);
    }
}