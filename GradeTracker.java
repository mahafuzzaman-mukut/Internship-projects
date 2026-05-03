package bd.mukut.gradetracker;

import java.util.*;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Marks: ");
            int marks = sc.nextInt();

            students.add(new Student(name, marks));
        }

        // Report
        int sum = 0, max = students.get(0).marks, min = students.get(0).marks;

        for (Student s : students) {
            sum += s.marks;
            if (s.marks > max) max = s.marks;
            if (s.marks < min) min = s.marks;
        }

        double avg = (double) sum / students.size();

        System.out.println("\n--- Report ---");
        for (Student s : students) {
            System.out.println(s.name + " : " + s.marks);
        }

        System.out.println("Average: " + avg);
        System.out.println("Highest: " + max);
        System.out.println("Lowest: " + min);
    }
}