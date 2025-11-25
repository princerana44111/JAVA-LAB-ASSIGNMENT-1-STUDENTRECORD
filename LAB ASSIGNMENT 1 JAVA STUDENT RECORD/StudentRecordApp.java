import java.util.Scanner;

class Person {
    String name;
}

class Student extends Person {

    int rollNo;
    String course;
    double marks;
    char grade;

    // default constructor
    Student() {
        // nothing here
    }

    // param constructor
    Student(int r, String n, String c, double m) {
        rollNo = r;
        name = n;
        course = c;
        marks = m;
        calculateGrade();
    }

    // taking input from user
    void inputDetails(Scanner sc) {

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();

        calculateGrade();
    }

    // calculating grade
    void calculateGrade() {

        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    // print details
    void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------------");
    }
}

public class StudentRecordApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student arr[] = new Student[100];
        int count = 0;
        int choice = 0;

        while (choice != 3) {

            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // creating a new object
                    arr[count] = new Student();
                    arr[count].inputDetails(sc);
                    count++;
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No records found.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            arr[i].displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
