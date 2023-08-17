package OOP;

import java.util.Scanner;

import OOP.classDatar.Lingkaran;
import OOP.classDatar.Persegi;
import OOP.classDatar.PersegiPanjang;
import OOP.classRuang.Balok;
import OOP.classRuang.Kubus;
import OOP.classRuang.Tabung;

public class Main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("=== PROGRAM MENGHITUNG BANGUN ===");
        System.out.println("1. Persegi");
        System.out.println("2. Lingkaran");
        System.out.println("3. Persegi Panjang");
        System.out.println("4. Kubus");
        System.out.println("5. Tabung");
        System.out.println("6. Balok");
        System.out.print("Input pilihan Anda: ");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Persegi persegi = new Persegi();
                System.out.println("");
                System.out.println("=== persegi ===");
                System.out.print("sisi: ");
                persegi.setSisi(scanner.nextDouble());
                persegi.menggambarBangun();
                persegi.karakteristikBangun();

                System.out.println("=== hasil ===");
                System.out.println("keliling: " + persegi.getKeliling());
                System.out.println("luas: " + persegi.getLuas());
                
                break;
            case 2:
                Lingkaran lingkaran = new Lingkaran();
                System.out.println("");
                System.out.println("=== LINGKARAN ===");
                System.out.print("jari-jari: ");
                lingkaran.setJariJari(scanner.nextDouble());
                lingkaran.menggambarBangun();
                lingkaran.karakteristikBangun();

                System.out.println("=== hasil ===");
                System.out.println("keliling: " + lingkaran.getKeliling());
                System.out.println("luas: " + lingkaran.getLuas());
                break;
            case 3:
                PersegiPanjang persegiPanjang = new PersegiPanjang();
                System.out.println("");
                System.out.print("panjang: ");
                persegiPanjang.setLebar(scanner.nextDouble());
                System.out.print("lebar: ");
                persegiPanjang.setPanjang(scanner.nextDouble());
                persegiPanjang.menggambarBangun();
                persegiPanjang.karakteristikBangun();

                System.out.println("=== hasil ===");
                System.out.println("keliling: " + persegiPanjang.getKeliling());
                System.out.println("luas: " + persegiPanjang.getLuas());
                break;
            case 4:
                Kubus kubus = new Kubus();
                System.out.println("");
                System.out.print("sisi: ");
                kubus.setSisi(scanner.nextDouble());

                System.out.println("=== hasil ===");
                System.out.println("Volume: " + kubus.getVolume());
                break;
            case 5:
                Tabung tabung = new Tabung();
                System.out.println("");
                System.out.print("jari jari: ");
                tabung.setJariJari(scanner.nextDouble());
                System.out.print("Tinggi: ");
                tabung.setTinggi(scanner.nextDouble());

                System.out.println(" ");
                System.out.println("=== hasil ===");
                System.out.println("Volume: " + tabung.getVolume());
                break;
            case 6:
                Balok balok = new Balok();
                System.out.println("");
                System.out.print("panjang: ");
                balok.setLebar(scanner.nextDouble());
                System.out.print("lebar: ");
                balok.setPanjang(scanner.nextDouble());
                System.out.print("tinggi: ");
                balok.setTinggi(scanner.nextDouble());

                System.out.println("=== hasil ===");
                System.out.println("Volume: " + balok.getVolume());
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
                return;
    
        }
        scanner.close();
    }
}
