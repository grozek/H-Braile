import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

public class BrailleASCIITables {

  /*
   * fields : the trees
   */
  BitTree ASCIITree;
  BitTree brailleTree;
  BitTree unicodeTree;

  /**
   * Simple constructor Creates three different trees, accepts three different input streams, and
   * loads those input streams to according trees
   * 
   * @throws Exception
   */
  BrailleASCIITables() throws Exception {
    this.ASCIITree = new BitTree(6);
    InputStream ASCIIInput = new FileInputStream("toASCII.txt");
    this.ASCIITree.load(ASCIIInput);

    this.brailleTree = new BitTree(8);
    InputStream brailleInput = new FileInputStream("toBraille.txt");
    this.brailleTree.load(brailleInput);

    this.unicodeTree = new BitTree(6);
    InputStream unicodeInput = new FileInputStream("toUnicode.txt");
    this.unicodeTree.load(unicodeInput);
  } // BrailleASCIITables


  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille
   * character
   * 
   * @throws Exception for cases described in get returns the string with bits
   */
  String toBraille(char letter) throws Exception {
    String bits = Integer.toBinaryString(letter);
    String output = "";
    while (bits.length() < 8) {
      bits = ("0").concat(bits);
    } // while
    output = this.brailleTree.get(bits);
    return output;
  } // toBraille(char)

  /**
   * Converts a string to a Braille string
   * 
   * @param str is a string input
   * @return returns a string "translated" to braile
   * @throws Exception
   */
  String toBraille(String str) throws Exception {
    String output = "";
    for (int i = 0; i < str.length(); i++) {
      output += toBraille(str.charAt(i));
    } // for
    return output;
  } // toBrialle(String)


  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII
   * character. returns a string of the bits
   * 
   * @throws Exception
   */
  String toASCII(String bits) throws Exception {
    // load tree
    int i = 0;
    String characters = "";
    while (i + 6 <= bits.length()) {
      characters += this.ASCIITree.get(bits.substring(i, i + 6));
      i = i + 6;
    } // while
    return characters;
  } // toASCI (String)


  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille
   * character for those bits. returns a bit string
   * 
   * @throws Exception
   */
  String toUnicode(String bits) throws Exception {
    String str = "";
    int intRepresentation = 0;
    char[] charArray;
    String output = "";
    for (int i = 0; i < bits.length(); i++) {
      str = this.unicodeTree.get(toBraille(bits.charAt(i)));
      intRepresentation = Integer.parseUnsignedInt(str, 16);
      charArray = Character.toChars(intRepresentation);
      output += String.valueOf(charArray);
    } // for
    return output;
  } // toUnicode(String)
} // BrailleASCIITables class
