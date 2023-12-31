import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi extends Barang implements TotalBayar{
    private Integer noFaktur;
    private String namaPelanggan;
    private int jumlahBarang;
    private double totalBayar;
    private String noHp;
    private String alamat;
    private String kasir;


    public Transaksi(Integer noFaktur, String namaPelanggan, String noHp, String alamat, String namaBarang, double hargaBarang, int jumlahBarang, String kasir) {
        super(namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
        this.alamat = alamat;
        this.jumlahBarang = jumlahBarang;
        this.kasir = kasir;
    }

    @Override   //polimorphism
    public double hitungTotalBayar(double harga, int jumlah) {
        return harga * jumlah;
    }

    public void tampilkanDetailTransaksi() {
        Date date = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("'Tanggal Transaksi\t: 'EEEE',' dd MMMM yyyy");
        SimpleDateFormat jam = new SimpleDateFormat("'Waktu\t\t\t: 'hh:mm:ss a zzz");
        String a = new String("data pelanggan");
        String b = new String("data pembelian barang");
        String c = new String("Total Bayar\t: ");
        String d = new String("\t\tindomaret");
        String e = new String("Kasir\t\t: ");

        System.out.println(d.toUpperCase()  );
        System.out.println(tanggal.format(date));
        System.out.println(jam.format(date));
        System.out.println("===============================================");

        System.out.println(a.toUpperCase());
        System.out.println("-----------------------------------------------");
        System.out.println("No. Faktur\t: " + noFaktur);
        System.out.println("Nama Pelanggan\t: " + namaPelanggan.toUpperCase());
        System.out.println("No. HP\t\t: " + noHp);
        System.out.println("Alamat\t\t: " + alamat);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(b.toUpperCase());
         System.out.println("-----------------------------------------------");
        System.out.println("Nama Barang\t: " + getNamaBarang().toUpperCase());
        System.out.println("Harga Barang\t: " + getHargaBarang());
        System.out.println("Jumlah Barang\t: " + jumlahBarang);
        totalBayar = hitungTotalBayar(getHargaBarang(), jumlahBarang);
        System.out.println(c.toUpperCase() + totalBayar);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(e.toUpperCase() + kasir);
    }
     
}
