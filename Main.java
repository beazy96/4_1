import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.lang.String;


class WrongStudentName extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                if(ex==10){
                  throw new WrongStudentName();           
                }
                
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {
            System.out.println("Bledny wiek!");
            } catch(WrongStudentName e) {
                System.out.println("Błędna data!");
            }
        }
    }

    public static int menu() {
        System.out.println("Wciśnij:");
        System.out.println("1 - aby dodać studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta po imieniu");
        System.out.println("0 - aby wyjść z programu");
        return scan.nextInt();
    }

    public static String ReadName() throws WrongStudentName {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }

    public static void exercise1() throws IOException, WrongStudentName {
        boolean WrongAge = true;  
        var name = ReadName();
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();
        if (age > 100 || age < 0){
          throw new IOException();
          }
        scan.nextLine();
        System.out.println("Podaj datę urodzenia DD-MM-YYY");
        var date = scan.nextLine();
        int aaa = date.length();
        if(aaa!=10){
          throw new WrongStudentName();           
        }
        char c1=date.charAt(2);
        char c2=date.charAt(5);
        if(c1 !='-'||c2!='-'){
          throw new WrongStudentName();
        }
         
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}