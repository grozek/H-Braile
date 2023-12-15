/**
 * Gabriela Roznawska 
 * CSC207 
 * 12/15/2023 
 * The program takes two command-line parameters, the first of
 * which represents the target character set and the second of which represents the source
 * characters, and that translates the text.
 * 
 * Acknowledgements: Used this website: https://www.programiz.com/java-programming/inputstream to
 * find out how to manage inputstream. Also used Java documentation for Scanner, Character, Integer
 * Character Array, String. Furthermore I used generous help of prof. Rebelsky
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * BrailleASCII Takes two command-line parameters, the first of which represents the target
 * character set and the second of which represents the source characters, and that translates the
 * text. Prints out the "translations"
 */
public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    try {
      if (args.length != 2) {
        pen.println("Please provide proper number of arguments");
        return;
      } // if
      String output = "";
      BrailleASCIITables tables;
      switch (args[0]) {
        case "braille":
          tables = new BrailleASCIITables();
          output = tables.toBraille(args[1]);
          pen.println(output);
          break;
        case "ascii":
          tables = new BrailleASCIITables();
          output = tables.toASCII(args[1]);
          pen.println(output.toLowerCase());
          break;
        case "unicode":
          tables = new BrailleASCIITables();
          output = tables.toUnicode(args[1]);
          pen.println(output);
          break;
        default:
          pen.println("boo it doesnt work");
      } // switch
    } catch (Exception e) {
      e.printStackTrace();
    } // catch()
  } // main (String[])
} // BrailleASCII class
