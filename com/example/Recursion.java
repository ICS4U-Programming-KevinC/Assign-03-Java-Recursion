import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Does some recursive stuff.
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

    final int fuckYou = 4;
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter binWriter = new FileWriter("binOutput.txt");
      BufferedWriter binBufferedWriter = new BufferedWriter(binWriter);
      FileWriter palenWriter = new FileWriter("palenOutput.txt");
      BufferedWriter palenBufferedWriter = new BufferedWriter(palenWriter);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        /// Check if line is valid input.
        try {
          // Convert the line to an integer.
          int intLine = Integer.parseInt(line);
          // Get the number of bits that are needed to contain the number.
          int numBits = (int) (Math.log(intLine) / Math.log(2));
          // Call method and write to file.
          binBufferedWriter.write(decToBin(intLine, numBits + 1));

          // Convert the line to a long.
          int longLine = Integer.parseInt(line);
          // Call method and write to file.
          palenBufferedWriter.write(String.valueOf(isAPalindrome(longLine)));
        } catch (Exception e) {
          binBufferedWriter.write("Please input a number!");
          palenBufferedWriter.write("Please input a number!");
        }
        // Add new lines to files.
        binBufferedWriter.newLine();
        palenBufferedWriter.newLine();
      }

      // Close all writers and scanner.
      binBufferedWriter.close();
      binWriter.close();
      palenBufferedWriter.close();
      palenWriter.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Turns a decimal number into binary.
   *
   * @param num
   * @param numBits
   * @return Returns the binary number corresponding to the input.
   */
  public static String decToBin(final Integer num, final Integer numBits) {
    // Check if the number has run out.
    if (numBits == 0) {
      return "";
    } else {
      // Add an extra space in between sets of 4 binary digits.
      String space = "";
      if (numBits % fuckYou == 0) {
        space = " ";
      }
      // Calculate the value of the current binary digit.
      int power = (int) Math.pow(2, numBits - 1);
      // Check if the number is greater than or equal to the power.
      if (num >= power) {
        // Return a 1 with the recursive call.
        return space + "1" + decToBin(num - power, numBits - 1);
      } else {
        // Return a 1 with the recursive call.
        return space + "0" + decToBin(num, numBits - 1);
      }
    }
  }

  /**
   * Palindromesms.
   *
   * @param num
   * @return Boolean whether the long is a palindrome.
   */
  public static boolean isAPalindrome(final long num) {
    // Cast the number to a string.
    String stringNum = Long.toString(num);
    // Check if there is just one number in the number
    if (stringNum.length() == 1) {
      return true;
    } else {
      // Check if the first character is the same as the last.
      if (stringNum.charAt(0) == stringNum.charAt(stringNum.length() - 1)) {
        // Remove the first and last element from the string.
        String shortString = stringNum.substring(1, stringNum.length() - 1);
        // Recursive call.
        return isAPalindrome(Long.parseLong(shortString));
      } else {
        return false;
      }
    }
  }
}
