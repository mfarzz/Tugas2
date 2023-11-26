import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int lastFakturNumber = 0;
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        boolean lanjutTransaksi = true;

        while (lanjutTransaksi) {
            Integer noFaktur = ++lastFakturNumber;
            System.out.println();
            System.out.println("No. Faktur: " + noFaktur);

            System.out.print("Nama Pelanggan: ");
            String namaPelanggan = scanner.next();

            System.out.print("Nama Barang: ");
            String namaBarang = scanner.next();

            boolean inputHargaValid = false;
            double hargaBarang = 0;
            while (!inputHargaValid) {
                try {
                    System.out.print("Harga Barang: ");
                    hargaBarang = scanner.nextDouble();
                    inputHargaValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input harga barang tidak valid. Silakan coba lagi.");
                    scanner.next(); 
                }
            }

            int jumlahBarang = 0;
            boolean inputJumlahValid = false;
            while (!inputJumlahValid) {
                try {
                    System.out.print("Jumlah Barang: ");
                    jumlahBarang = scanner.nextInt();
                    if (jumlahBarang <= 0) {
                        throw new ArithmeticException("Jumlah barang harus lebih dari 0.");
                    }
                    inputJumlahValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input jumlah barang tidak valid. Silakan coba lagi.");
                    scanner.next();
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            Transaksi transaksi = new Transaksi(noFaktur, namaPelanggan, namaBarang, hargaBarang, jumlahBarang);
            System.out.println();
            transaksi.tampilkanDetailTransaksi();

            System.out.println(); 
            System.out.print("Lanjut ke transaksi berikutnya? (ya/tidak): ");
            

            String jawaban = scanner.next().toLowerCase();
            lanjutTransaksi = jawaban.equals("ya");
        }

        System.out.println("Terima kasih telah menggunakan program ini.");
        scanner.close();
    }
    
}