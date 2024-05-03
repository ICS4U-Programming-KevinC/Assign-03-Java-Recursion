
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Change me daddy.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-03
 */

// Recursion class
public final class Recursion {

    /** Private constructor to prevent instantiation. */
    private Recursion() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        try {
            // Setup scanner on file.
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            // Setup writer for output file.
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            while (sc.hasNextLine()) {
                // Read the line from file.
                String line = sc.nextLine();

                /// Check if line is valid input.
                try {
                    int intLine = Integer.parseInt(line);
                    // Call method and write to file with a new line.
                    bufferedWriter.write(Integer.toString(recFib(intLine)));
                } catch (Exception e) {
                    bufferedWriter.write("Please input a number!");
                }
                bufferedWriter.newLine();
            }

            // Close all writers and scanner.
            bufferedWriter.close();
            writer.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
