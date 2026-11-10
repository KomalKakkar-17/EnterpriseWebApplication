// Assignment Question 1

import java.io.*;

public class Main {
    public static void main(String[] args) {

        // PART 1: Copy a binary file using byte streams
        try (
            FileInputStream fin =
                new FileInputStream("student_data.dat");

            FileOutputStream fout =
                new FileOutputStream("student_data_backup.dat")
        ) {
            int ch;

            while ((ch = fin.read()) != -1) {
                fout.write(ch);
            }

            System.out.println("Binary file copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // PART 2: Write student details using FileWriter
        try (FileWriter writer =
                 new FileWriter("students.txt")) {

            writer.write("Roll Number: 101\n");
            writer.write("Name: Rahul\n");
            writer.write("Marks: 89.5\n");

            writer.write("Roll Number: 102\n");
            writer.write("Name: Priya\n");
            writer.write("Marks: 94.0\n");

            System.out.println("Student records written.");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // PART 3: Read student details using FileReader
        try (FileReader reader =
                 new FileReader("students.txt")) {

            int ch;

            System.out.println("\nStudent Records:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}