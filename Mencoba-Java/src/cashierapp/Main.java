package cashierapp;

import java.util.List;
import java.util.Scanner;

import cashierapp.dao.MakananDao;
import cashierapp.dao.MinumanDao;
import cashierapp.dao.PaketDao;
import cashierapp.dao.PemesananDao;
import cashierapp.models.Makanan;
import cashierapp.models.Minuman;
import cashierapp.models.Paket;
import cashierapp.models.Pesan;
import cashierapp.services.makanan.MakananImpl;
import cashierapp.services.makanan.MakananService;
import cashierapp.services.minuman.MinumanImpl;
import cashierapp.services.minuman.MinumanService;
import cashierapp.services.paket.PaketImpl;
import cashierapp.services.paket.PaketService;
import cashierapp.services.pesan.PemesananImpl;
import cashierapp.services.pesan.PemesananService;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    // makanan
    static MakananDao makananDao = new MakananDao();
    static MakananService makananService = new MakananImpl(makananDao);
    // minuman
    static MinumanDao minumanDao = new MinumanDao();
    static MinumanService minumanService = new MinumanImpl(minumanDao);
    // paket
    static PaketDao paketDao = new PaketDao();
    static PaketService paketService = new PaketImpl(paketDao);
    // pesan
    static PemesananDao pemesananDao = new PemesananDao();
    static PemesananService pemesananService = new PemesananImpl(pemesananDao);

    private static void restoran() {
        System.out.println("""
                ========== SELAMAT DATANG DI RESTORAN ==========
                1. Lihat Daftar Menu
                2. Input Pemesanan
                3. Pembayaran

                """);

    }

    private static void menuMakanan() {

        System.out.println("========== MENU MAKANAN ==========");

        List<Makanan> daftarMakanan = makananService.getAll();
        for (int i = 0; i < daftarMakanan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMakanan.get(i));
        }

    }

    // private static void validasi() {
        // System.out.print("Ingin menambah / mengubah pesanan?
        // (tambah/ubah/kembali):");
        // String pesanMakan = scanner.nextLine();
        // while (true) {
        // if ("tambah".equalsIgnoreCase(pesanMakan)) {
        // System.out.println("Silahkan input banyaknya pesanan: ");
        // Integer qty = Integer.valueOf(scanner.nextLine());

        // break;
        // } else if ("ubah".equalsIgnoreCase(pesanMakan)) {
        // System.out.println("ini ubah");
        // break;
        // } else if ("kembali".equalsIgnoreCase(pesanMakan)) {
        // System.out.println("ini kembali");
        // break;
        // } else {
        // System.out.println("Input salah!");
        // continue;
        // }
        // }
//    }

    private static void listPesanan() {
        System.out.println("========== PESANAN ANDA ==========");
        List<Pesan> listPesanan = pemesananService.getPesan();
        for (int i = 0; i < listPesanan.size(); i++) {
            System.out.println((i + 1) + ". " + listPesanan.get(i));
        }
        Double totaltax = 0.0;
        for (Pesan pesan : listPesanan){
            totaltax += pesan.getTotal();
        }
        Double withTax = ((totaltax * 11)/100);
        System.out.println("Total harga setelah PPN (11%): " + (withTax + totaltax));
    }

    private static void pesanMakan() {

        System.out.print("Silahkan input nomor pesanan makanan: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Double qty = Double.valueOf(scanner.nextLine());

        Makanan makanan = makananService.getByIdMakanan(nomor);
        String namaMakanan = makanan.getMakanan();
        Double hargaMakanan = makanan.getHarga();

        Pesan pesanmakan = new Pesan();
        pesanmakan.setQty(qty);
        pesanmakan.setHarga(hargaMakanan);
        pesanmakan.setNamaBarang(namaMakanan);

        pemesananService.createPesan(pesanmakan);

    }
    private static void pesanMinum() {

        System.out.print("Silahkan input nomor pesanan makanan: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Double qty = Double.valueOf(scanner.nextLine());

        Minuman minuman = minumanService.getByIdMimuman(nomor);
        String namaMinuman = minuman.getMinuman();
        Double hargaMinuman = minuman.getHargaMinuman();

        Pesan pesanMinum = new Pesan();
        pesanMinum.setQty(qty);
        pesanMinum.setHarga(hargaMinuman);
        pesanMinum.setNamaBarang(namaMinuman);

        pemesananService.createPesan(pesanMinum);

    }
    private static void pesanPaket() {

        System.out.print("Silahkan input nomor pesanan makanan: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Double qty = Double.valueOf(scanner.nextLine());

        Paket paket = paketService.getByIdPaket(nomor);
        String namaPaket = paket.getPaket();
        Double hargaPaket = paket.getHargaPaket();

        Pesan pesanPaket = new Pesan();
        pesanPaket.setQty(qty);
        pesanPaket.setHarga(hargaPaket);
        pesanPaket.setNamaBarang(namaPaket);

        pemesananService.createPesan(pesanPaket);

    }

    private static void menuMinuman() {
        System.out.println("========== MENU MINUMAN ==========");

        List<Minuman> daftarMinuman = minumanService.getMinuman();
        for (int i = 0; i < daftarMinuman.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMinuman.get(i));
        }
    }

    private static void menuPaket() {
        System.out.println("========== MENU PAKET ==========");

        List<Paket> daftarPaket = paketService.getPaket();
        for (int i = 0; i < daftarPaket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPaket.get(i));
        }

    }

    private static void total() {
        System.out.println("========== PESANAN ANDA ==========");
    }

    private static void pesan() {
        System.out.println("""
                ========== PESAN ==========
                1. Makanan
                2. Minuman
                3. Paket
                    """);
    }

    // private static void pemesanan() {
    //     System.out.println("pemesanan");
    // }

    // private static void pembayaran() {

    //     System.out.println("pembayaran");
    // }

    public static void main(String[] args) {
        Boolean ulang = true;
        String pilih = "";

        while (ulang) {
            restoran();
            System.out.print("pilihan: ");
            pilih = scanner.nextLine();
            switch (pilih) {
                case "1":

                    menuMakanan();
                    menuMinuman();
                    menuPaket();

                    break;
                case "2":
                    pesan();

                    String pilih1 = "";
                    pilih1 = scanner.nextLine();
                    switch (pilih1) {
                        case "1":
                            menuMakanan();
                            pesanMakan();
                            listPesanan();
                            break;

                        case "2":
                            menuMinuman();
                            pesanMinum();
                            listPesanan();
                            break;

                        case "3":
                            menuPaket();
                            pesanPaket();
                            listPesanan();
                            break;
                        default:
                            break;
                    }
                    break;
                case "3":
                    total();
                    break;

                default:
                    System.out.println("input salah");
                    break;
            }
            while (true) {
                System.out.print("Ingin melanjutkan ke pembayaran / pemesanan? (y|n) ");
                String again = scanner.nextLine();
                if ("y".equalsIgnoreCase(again)) {
                    ulang = true;
                    break;
                } else if ("n".equalsIgnoreCase(again)) {
                    ulang = false;
                    break;
                } else {
                    System.out.println("Input salah!");
                    continue;
                }
            }
        }
        scanner.close();
    }
}
