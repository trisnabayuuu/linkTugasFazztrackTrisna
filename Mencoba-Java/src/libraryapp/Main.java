package libraryapp;

import java.util.List;
import java.util.Scanner;

import libraryapp.dao.BukuDao;
import libraryapp.dao.PeminjamanDao;
import libraryapp.dao.UserDao;
import libraryapp.models.Buku;
import libraryapp.models.Peminjaman;
import libraryapp.models.User;
import libraryapp.services.book.BookImpl;
import libraryapp.services.book.Bookservice;
import libraryapp.services.peminjaman.PeminjamanImpl;
import libraryapp.services.peminjaman.PeminjamanService;
import libraryapp.services.user.UserImpl;
import libraryapp.services.user.UserService;

public class Main {
    static BukuDao bukuDao = new BukuDao();
    static Bookservice bookService = new BookImpl(bukuDao);
    
    static UserDao userDao = new UserDao();
    static UserService userService = new UserImpl(userDao);

    static PeminjamanDao peminjamanDao = new PeminjamanDao();
    static PeminjamanService peminjamanService = new PeminjamanImpl(peminjamanDao);


    private static void menuUtama() {
        System.out.println("""
                === SISTEM MANAJEMEN PERPUSTAKAAN ===
                1. Book Management
                2. User Management
                3. Transaction Management
                """);
        System.out.print("Input pilihan: ");
    }

    public static void main(String[] args) {
        // menuUtama();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        Boolean ulang = true;

        try {
            while (ulang) {
                menuUtama();
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("=== Book Management ===");
                        System.out.println("""
                                1. Tambah buku
                                2. Daftar buku

                                """);
                        System.out.print("Input : ");

                        String bookinput;
                        bookinput = scanner.nextLine();
                        switch (bookinput) {
                            case "1":
                                System.out.println("=== Tambah Buku ===");
                                Buku buku = new Buku();
                                System.out.println("""
                                        judul:
                                        penerbit:
                                        pengarang:
                                        """);
                                buku = new Buku(
                                        scanner.nextLine(),
                                        scanner.nextLine(),
                                        scanner.nextLine());
                                bookService.createBook(buku);
                                // }

                                System.out.println("Tampilkan semua list buku? (y|n)");
                                String tampilkan = scanner.nextLine();

                                if ("y".equalsIgnoreCase(tampilkan)) {

                                    List<Buku> results = bookService.getBook();
                                    for (int i = 0; i < results.size(); i++) {
                                        System.out.println((i + 1) + ". " + results.get(i));
                                    }

                                } else if ("n".equalsIgnoreCase(tampilkan)) {
                                    ulang = false;
                                    break;
                                } else {
                                    System.out.println("input salah!");
                                    continue;
                                }

                                break;

                            case "2":
                                System.out.println("=== Daftar Buku ===");

                                List<Buku> results = bookService.getBook();
                                for (int i = 0; i < results.size(); i++) {
                                    System.out.println((i + 1) + ". " + results.get(i));
                                }
                                System.out.print("masukkan nomor ID:");

                                Integer pilihBuku = Integer.valueOf(scanner.nextLine());

                                System.out.println("=== Find Book By ID ===");
                                Buku hasil = bookService.getBookById(pilihBuku);
                                System.out.println(hasil);
                                break;
                            default:
                                System.out.println("Menu tidak tersedia!");
                                break;
                        }

                        break;

                    case "2":
                        System.out.println("=== user management ===");
                        System.out.println("""
                                1. Tambah User
                                2. Daftar list user

                                """);
                        System.out.print("Input pilihan: ");

                        String userInput;
                        userInput = scanner.nextLine();
                        switch (userInput) {
                            case "1":
                                System.out.println("===  register user  ===");
                                User user = new User();
                                System.out.println("""
                                        input username and email
                                        """);
                                user = new User(
                                        scanner.nextLine(),
                                        scanner.nextLine());
                                userService.createUser(user);

                                System.out.println("Do you want to see all User? (y|n)");
                                String tampilkan = scanner.nextLine();

                                if ("y".equalsIgnoreCase(tampilkan)) {

                                    List<User> resultsUser = userService.getUser();
                                    for (int i = 0; i < resultsUser.size(); i++) {
                                        System.out.println((i + 1) + ". " + resultsUser.get(i));
                                    }

                                } else if ("n".equalsIgnoreCase(tampilkan)) {
                                    ulang = false;
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                    continue;
                                }
                                break;
                            case "2":
                                System.out.println("Detail of user");
                                List<User> resultsUser = userService.getUser();
                                for (int i = 0; i < resultsUser.size(); i++) {
                                    System.out.println((i + 1) + ". " + resultsUser.get(i));
                                }
                                System.out.print("masukkan nomor ID:");
                                Integer pilihUser = Integer.valueOf(scanner.nextLine());
                                System.out.println("=== Find User By ID ===");
                                User user2 = userService.getUserById(pilihUser);
                                System.out.println(user2);
                                break;

                            default:
                                System.out.println("Menu tidak tersedia!");
                                break;
                        }
                        break;
                    case "3":
                        System.out.println("=== user management ===");
                        System.out.println("""
                                1. Peminjaman Buku
                                2. Pengembalian Buku
                                """);
                        System.out.print("Input pilihan: ");

                        String transaction;
                        transaction = scanner.nextLine();
                        switch (transaction) {
                            case "1":
                                System.out.println("=== Peminjaman buku ===");

                                List<Buku> results = bookService.getBook();
                                for (int i = 0; i < results.size(); i++) {
                                    System.out.println((i + 1) + ". " + results.get(i));
                                }
                                System.out.println("Masukkan ID buku:");
                                Integer pinjambuku = Integer.valueOf(scanner.nextLine());

                                List<User> resultsUser = userService.getUser();
                                    for (int i = 0; i < resultsUser.size(); i++) {
                                        System.out.println((i + 1) + ". " + resultsUser.get(i));
                                    }

                                System.out.println("Massukkan ID User:");
                                Integer pinjamUser = Integer.valueOf(scanner.nextLine());

                                Buku buku = bookService.getBookById(pinjambuku);
                                User user = userService.getUserById(pinjamUser);

                                Peminjaman peminjaman = new Peminjaman();
                                // peminjaman.setTanggalPeminjaman();///////////
                                
                                peminjaman.setBuku(buku);
                                peminjaman.setUser(user);
                                peminjamanService.createPeminjaman(peminjaman);
                                System.out.println("=== Daftar peminjaman ===");

                                List<Peminjaman> resultBorrow = peminjamanService.getPeminjaman();
                                    for (int i = 0; i < resultBorrow.size(); i++) {
                                        System.out.println((i + 1) + ". " + resultBorrow.get(i));
                                    }

                                break;
                            case "2":
                                System.out.println("pengembalian buku");

                                List<Peminjaman> result = peminjamanService.getPeminjaman();
                                    for (int i = 0; i < result.size(); i++) {
                                        System.out.println((i + 1) + ". " + result.get(i));
                                    }
                                System.out.println("masukkan ID untuk pengembalian buku:");
                                Integer returnBook = Integer.valueOf(scanner.nextLine());

                                Peminjaman pengembalian = peminjamanService.getPeminjamanById(returnBook);

                                // pengembalian.setTanggalPengembalian();
                                peminjamanService.updatePeminjaman(returnBook, pengembalian);
                                
                                List<Peminjaman> resultpengembalian = peminjamanService.getPeminjaman();
                                    for (int i = 0; i < resultpengembalian.size(); i++) {
                                        System.out.println((i + 1) + ". " + resultpengembalian.get(i));
                                    }
                                break;

                            default:
                                    System.out.println("Menu tidak tersedia!");
                                break;
                        }
                        break;

                    default:
                        System.out.println("Menu tidak tersedia!");
                        break;
                }

                while (true) {
                    System.out.print("Ingin mengulang program? (y|n) ");
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

            System.out.println("Program Selesai...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        scanner.close();
    }
}
