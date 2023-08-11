import java.util.Scanner;
import model.Person;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();

        System.out.print("Nama Depan :");
        person.setFirstName(scanner.nextLine());
        System.out.print("Nama Belakang :");
        person.setLastName(scanner.nextLine());
        System.out.print("Domisili :");
        person.setDomicile(scanner.nextLine());
        System.out.print("Tahun Lahir :");
        person.setBirthYear(scanner.nextLine());
        System.out.print("Bahasa pemrograman favorite :");
        person.setProgrLangFav(scanner.nextLine());


        // menampilkan hasil dari scanner yang telah diisi diatas 
        System.out.println("Nama Lengkap : " + person.getFullName());
        System.out.println("Domisili : " + person.getDomicile());
        System.out.println("Usia : " + person.getAge());
        System.out.println("Bahasa pemrograman favorite : " + person.getProgrLangFav());
        
        scanner.close();
    }
}
