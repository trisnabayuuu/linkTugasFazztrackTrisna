package cashierapp;

import java.util.List;
import java.util.Scanner;

import cashierapp.dao.MakananDao;
import cashierapp.dao.MinumanDao;
import cashierapp.dao.PaketDao;
import cashierapp.dao.PembayaranDao;
import cashierapp.dao.PemesananDao;
import cashierapp.models.Makanan;
import cashierapp.models.Minuman;
import cashierapp.models.Paket;
import cashierapp.models.Pembayaran;
import cashierapp.models.Pesan;
import cashierapp.services.makanan.MakananImpl;
import cashierapp.services.makanan.MakananService;
import cashierapp.services.minuman.MinumanImpl;
import cashierapp.services.minuman.MinumanService;
import cashierapp.services.paket.PaketImpl;
import cashierapp.services.paket.PaketService;
import cashierapp.services.pembayaran.PembayaranImpl;
import cashierapp.services.pembayaran.PembayranService;
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
    // pembayaran
    static PembayaranDao pembayaranDao = new PembayaranDao();
    static PembayranService pembayranService = new PembayaranImpl(pembayaranDao);

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

    private static void pembayaran() {
        Pembayaran pembayaran = new Pembayaran();
        pembayranService.createPembayaran(pembayaran);
        System.out.println("");
        listPesanan();

        Double total = 0.0;
        List<Pesan> listPesanan = pemesananService.getPesan();
        for (Pesan pesan : listPesanan) {
            total += pesan.getTotal();
        }
        System.out.println("Total Harga: " + total);
    }

    private static void updatePesanan() {
        System.out.print("Silahkan input nomor pesanan : ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input jumlah pesanan : ");
        Integer ubahQty = Integer.valueOf(scanner.nextLine());

        Pesan pesanUpdate = new Pesan();
        pesanUpdate.setQty(ubahQty);

        pemesananDao.update(nomor, pesanUpdate);

    }

    private static void tax() {
        Double total = 0.0;
        List<Pesan> listPesanan = pemesananService.getPesan();
        for (Pesan pesan : listPesanan) {
            total += pesan.getTotal();
        }
        Double withTax = ((total * 11) / 100);
        Double totalBayar = withTax + total;
        System.out.println("Total harga setelah PPN (11%): " + totalBayar);
    }

    private static void listPesanan() {
        System.out.println("========== PESANAN ANDA ==========");
        List<Pesan> listPesanan = pemesananService.getPesan();
        for (int i = 0; i < listPesanan.size(); i++) {
            System.out.println((i + 1) + ". " + listPesanan.get(i));
        }

    }

    private static void pesanMakan() {

        System.out.print("Silahkan input nomor pesanan makanan: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Integer qty = Integer.valueOf(scanner.nextLine());

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

        System.out.print("Silahkan input nomor pesanan minuman: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Integer qty = Integer.valueOf(scanner.nextLine());

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

        System.out.print("Silahkan input nomor pesanan paket: ");
        Integer nomor = Integer.valueOf(scanner.nextLine());

        System.out.print("Silahkan input banyaknya pesanan: ");
        Integer qty = Integer.valueOf(scanner.nextLine());

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

    private static void tanggal() {
        System.out.println("========== BUKTI PEMBAYARAN ==========");
        Pembayaran pembayaran = new Pembayaran();
        pembayranService.createPembayaran(pembayaran);
        List<Pembayaran> listPembayaran = pembayranService.getPembayaran();
        for (int i = 0; i < listPembayaran.size(); i++) {
            System.out.println((i + 1) + ". " + listPembayaran.get(i));
        }
    }

    private static void menuPaket() {
        System.out.println("========== MENU PAKET ==========");

        List<Paket> daftarPaket = paketService.getPaket();
        for (int i = 0; i < daftarPaket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPaket.get(i));
        }

    }

    private static void pesan() {
        System.out.println("""
                ========== PESAN ==========
                1. Makanan
                2. Minuman
                3. Paket
                    """);
    }

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

                    System.out.print("pilihan: ");
                    String pilih1 = "";
                    pilih1 = scanner.nextLine();
                    switch (pilih1) {
                        case "1":
                            menuMakanan();
                            pesanMakan();
                            listPesanan();
                            tax();
                            Boolean ulangMakanan = true;
                            while (ulangMakanan) {
                                System.out.print("Ingin menambah / mengubah pesanan? (tambah/ubah/kembali):");
                                String pesanMakan = scanner.nextLine();

                                if ("tambah".equalsIgnoreCase(pesanMakan)) {
                                    pesanMakan();
                                    listPesanan();
                                    tax();
                                    ulangMakanan = true;
                                    // break;
                                } else if ("ubah".equalsIgnoreCase(pesanMakan)) {
                                    updatePesanan();
                                    listPesanan();
                                    tax();
                                    ulangMakanan = true;
                                    // break;
                                } else if ("kembali".equalsIgnoreCase(pesanMakan)) {
                                    break;
                                } else {
                                    System.out.println("Input salah!");

                                }
                            }
                            break;

                        case "2":
                            menuMinuman();
                            pesanMinum();
                            listPesanan();
                            tax();
                            System.out.print("Ingin menambah / mengubah pesanan? (tambah/ubah/kembali):");
                            String pesanMinuman = scanner.nextLine();

                            Boolean ulangMinuman = true;
                            while (ulangMinuman) {
                                if ("tambah".equalsIgnoreCase(pesanMinuman)) {
                                    pesanMinum();
                                    listPesanan();
                                    tax();
                                    ulangMinuman = true;
                                    break;
                                } else if ("ubah".equalsIgnoreCase(pesanMinuman)) {
                                    updatePesanan();
                                    listPesanan();
                                    tax();
                                    ulangMinuman = true;
                                } else if ("kembali".equalsIgnoreCase(pesanMinuman)) {
                                    break;
                                } else {
                                    System.out.println("Input salah!");
                                    ulangMinuman = true;
                                }
                            }
                            break;

                        case "3":
                            menuPaket();
                            pesanPaket();
                            listPesanan();
                            Boolean ulangPaket = true;
                            while (ulangPaket) {
                                System.out.print("Ingin menambah / mengubah pesanan? (tambah/ubah/kembali):");
                                String pesanPaket = scanner.nextLine();
                                if ("tambah".equalsIgnoreCase(pesanPaket)) {
                                    pesanPaket();
                                    listPesanan();
                                    ulangPaket = true;
                                } else if ("ubah".equalsIgnoreCase(pesanPaket)) {
                                    updatePesanan();
                                    listPesanan();
                                    ulangPaket = true;
                                } else if ("kembali".equalsIgnoreCase(pesanPaket)) {
                                    break;
                                } else {
                                    System.out.println("Input salah!");
                                    ulangPaket = true;
                                }
                            }
                        default:
                            System.out.println("input salah!");
                            break;
                    }
                    break;
                case "3":
                    listPesanan();
                    tax();
                    Double totaltax = 0.0;
                    List<Pesan> listPesanan = pemesananService.getPesan();
                    for (Pesan pesan : listPesanan) {
                        totaltax += pesan.getTotal();
                    }
                    Double withTax = ((totaltax * 11) / 100);
                    Double totalBayar = withTax + totaltax;
                    Boolean pembayaran = true;
                    while (pembayaran) {
                        System.out.print("cash: ");
                        Double cash = Double.valueOf(scanner.nextLine());
                        Double kembalian = cash - totalBayar;
                        if (cash < totalBayar) {
                            System.out.println("Cash tidak cukup, masukkak cash yang cukup");
                            pembayaran = true;

                        } else {
                            tanggal();
                            pembayaran();
                            tax();
                            System.out.println("Biaya PPN (11%) " + withTax);
                            System.out.println("Total Harga Pembelian: " + totalBayar);
                            System.out.println("Total Harga: " + cash);
                            System.out.println("Kembalian: " + kembalian);
                            System.out.println("Terima kasih. Silahkan datang kembali~");

                            pembayaran = false;

                        }
                    }

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
