public class Transaksi extends Barang implements TotalBayar{
    private Integer noFaktur;
    private String namaPelanggan;
    private int jumlahBarang;
    private double totalBayar;

    public Transaksi(Integer noFaktur, String namaPelanggan, String namaBarang, double hargaBarang, int jumlahBarang) {
        super(namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
        this.jumlahBarang = jumlahBarang;
    }

    @Override   //polimorphism
    public double hitungTotalBayar(double harga, int jumlah) {
        return harga * jumlah;
    }

    public void tampilkanDetailTransaksi() {
        System.out.println("No. Faktur: " + noFaktur);
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Nama Barang: " + getNamaBarang());
        System.out.println("Harga Barang: " + getHargaBarang());
        System.out.println("Jumlah Barang: " + jumlahBarang);

        totalBayar = hitungTotalBayar(getHargaBarang(), jumlahBarang);
        System.out.println("Total Bayar: " + totalBayar);
    }
     
}
