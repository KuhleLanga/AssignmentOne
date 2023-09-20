/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kuhle Langa
 */
public class Student {
    private int studentID;
    private String studentName;
    private int studentAge;

    public Student(int id, String name, int age) {
        this.studentID = id;
        this.studentName = name;
        this.studentAge = age;
    }


    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }
    
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int nextStudentID = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to ABC College Student Management System");
            System.out.println("1. Capture a New Student");
            System.out.println("2. Search for a Student");
            System.out.println("3. Delete a Student");
            System.out.println("4. View Student Report");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    saveStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent(1);
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    exitStudentApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        public static void saveStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        int age;
        do {
            System.out.print("Enter student age (>= 16): ");
            age = scanner.nextInt();
        } while (age < 16);

        Student newStudent = new Student(nextStudentID, name, age);
        studentList.add(newStudent);
        nextStudentID++;

        System.out.println("Student details saved successfully.");
    }

    public static void searchStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int searchID = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getStudentID() == searchID) {
                System.out.println("Student Found:");
                System.out.println("ID: " + student.getStudentID());
                System.out.println("Name: " + student.getStudentName());
                System.out.println("Age: " + student.getStudentAge());
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent(int par) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to delete: ");
        int deleteID = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getStudentID() == deleteID) {
                System.out.print("Are you sure you want to delete this student? (y/n): ");
                String confirm = scanner.next();

                if (confirm.equalsIgnoreCase("y")) {
                    studentList.remove(student);
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void studentReport() {
        System.out.println("Student Report:");
        for (Student student : studentList) {
            System.out.println("ID: " + student.getStudentID());
            System.out.println("Name: " + student.getStudentName());
            System.out.println("Age: " + student.getStudentAge());
            System.out.println();
        }
    }

    public static void exitStudentApplication() {
        System.out.println("Exiting ABC College Student Management System. Goodbye!");
        System.exit(0);
    }

}

