package libraryapp;

import java.util.List;
import java.util.Scanner;

import libraryapp.dao.BukuDao;
import libraryapp.dao.UserDao;
import libraryapp.models.Buku;
import libraryapp.models.User;
import libraryapp.services.book.BookServiceImpl;
import libraryapp.services.book.Bookservice;
import libraryapp.services.user.UserImpl;
import libraryapp.services.user.UserService;

public class Main {
    static BukuDao bukuDao = new BukuDao();
    static Bookservice bookService = new BookServiceImpl(bukuDao);
    static UserDao userDao = new UserDao();
    static UserService userService = new UserImpl(userDao);

    // private
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
                                1. Add book
                                2. Book data

                                """);
                        System.out.print("Input : ");

                        String bookinput;
                        bookinput = scanner.nextLine();
                        switch (bookinput) {
                            case "1":
                                System.out.println("=== Add New Books ===");
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

                                System.out.println("Do you want to see all book? (y|n)");
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
                                    System.out.println("Wrong input!");
                                    continue;
                                }

                                break;

                            case "2":
                                System.out.println("=== The list of Books  ===");

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
                                1. Register User
                                2. The list of User

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
                                1. Borrow Books
                                2. Return Books
                                """);
                        System.out.print("Input pilihan: ");

                        String transaction;
                        transaction = scanner.nextLine();
                        switch (transaction) {
                            case "1":
                                System.out.println("Borrow Books");
                                break;
                            case "2":
                                System.out.println("return book");
                                break;

                            default:

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
