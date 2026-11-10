import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) {

        int total = 0;
        int errors = 0;
        int warnings = 0;

        try (BufferedReader br = new BufferedReader(
                 new FileReader("application.log"));
             BufferedWriter bw = new BufferedWriter(
                 new FileWriter("filtered.log"))) {

            String line;

            while ((line = br.readLine()) != null) {

                total++;

                if (line.contains("ERROR") || line.contains("WARNING")) {

                    bw.write(line);
                    bw.newLine();

                    if (line.contains("ERROR"))
                        errors++;

                    if (line.contains("WARNING"))
                        warnings++;
                }
            }

            System.out.println("Total log entries: " + total);
            System.out.println("ERROR entries: " + errors);
            System.out.println("WARNING entries: " + warnings);
            System.out.println("Filtered logs saved successfully.");

        }
        catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}