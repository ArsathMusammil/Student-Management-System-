import java.util.*;
public class Main {
    static class Student {
        int id, age;
        String name, course;
        Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
        }
    }
    static class StudentManager {
        List<Student> students = new ArrayList<>();
        void addStudent(Student s) { students.add(s); }
        List<Student> getAllStudents() { return students; }
        Student findStudentById(int id) {
            for (Student s : students)
                if (s.id == id) return s;
            return null;
        }
        boolean deleteStudentById(int id) {
        return students.removeIf(s -> s.id == id);
        }
    }
    private static StudentManager manager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add  2. View  3. Search  4. Delete  5. Exit");
            System.out.print("Choice: ");
            choice = getInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAll();
                case 3 -> search();
                case 4 -> delete();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
    static void addStudent() {
        System.out.print("ID: "); int id = getInt();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = getInt();
        System.out.print("Course: "); String course = scanner.nextLine();
        manager.addStudent(new Student(id, name, age, course));
        System.out.println("Added!");
    }
    static void viewAll() {
        List<Student> list = manager.getAllStudents();
        if (list.isEmpty()) System.out.println("No students.");
        else list.forEach(System.out::println);
    }
    static void search() {
        System.out.print("Enter ID: "); int id = getInt();
        Student s = manager.findStudentById(id);
        System.out.println(s != null ? s : "Not found.");
    }
    static void delete() {
        System.out.print("Enter ID: "); int id = getInt();
        System.out.println(manager.deleteStudentById(id) ? "Deleted." : "Not found.");
    }
    static int getInt() {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine()); }
            catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}

