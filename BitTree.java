import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import org.w3c.dom.Node;

public class BitTree {

  /**
   * Fields
   */
  BitTreeNode root;
  BitTreeLeaf leaf;
  String[] sequence;
  int n;
  int index;

  /**
   * BitTree constructor taking in the n - levels of tree
   */
  public BitTree(int n) {
    if (n > 0) {
      this.n = n;
      this.root = new BitTreeNode();
      this.leaf = new BitTreeLeaf();
      this.sequence = new String [100];
      this.index = 0;
    } // if
  } // BitTree(int)

  /**
   * Sets a value at a location in a tree provided by bits
   * @param bits a string of binary encoding letters
   * @param value the string with a character at a given bit address
   * @throws Exception for incorrect length
   */
  public void set(String bits, String value) throws Exception {
    BitTreeNode current = this.root;
    if (bits.length() != n){
      throw new Exception ("Incorrect length exception");
    } // if

    this.sequence[index++] = bits;
    while (!(bits.length() == 1)) {
      if (bits.charAt(0) == '0') {
        if (current.left == null) {
          current.left = new BitTreeNode();
        } // if
        current = current.left;
        bits = bits.substring(1);
      } else if (bits.charAt(0) == '1') {
        if (current.right == null) {
          current.right = new BitTreeNode();
        } // if
        current = current.right;
        bits = bits.substring(1);
      } // else if
    } // while
    if (bits.charAt(0) == '0') {
      if (current.left == null) {
        current.left = new BitTreeLeaf(value);
      } else if (current.left != null) {
        ((BitTreeLeaf)current.left).value = value;
      } // else if
    } // if
    if (bits.charAt(0) == '1') {
      if (current.right == null) {
        current.right = new BitTreeLeaf(value);
      } else if (current.right != null) {
        ((BitTreeLeaf)current.right).value = value;
      } // else if
    } // if
    return;
  } // set(String, String)

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) 
   * and adds or replaces the value at the end
   * @param bits a string of binary encoding letters
   * @param value the string with a character at a given bit address
   * @throws Exception for incorrect length
   */
  public String get(String bits) throws Exception {
    //follows the pat hlike set but then only returns the leaf
    //incorrect length is either 6,7,8
    BitTreeNode current = this.root;
    if (bits.length() != n){
      throw new Exception ("Incorrect length exception");
    } // if
    while (bits.length() != 1) {
      if (bits.charAt(0) == '0') {
        if (current.left == null) {
          throw new Exception("Cannot get down the tree if current.left is null");
        } // if
        current = current.left;
        bits = bits.substring(1);
      } else if (bits.charAt(0) == '1') {
        if (current.right == null) {
           throw new Exception("Cannot get down the tree if current.right is null");
        } // if
        current = current.right;
        bits = bits.substring(1);
      } // else if
    } // while
    if (bits.charAt(0) == '0') {
      if (current.left == null) {
          throw new Exception("No such path exception");
        } else if (current.left != null) {
        return ((BitTreeLeaf)current.left).value;
      } // else if
    } // if
    if (bits.charAt(0) == '1') {
       if (current.right == null) {
         throw new Exception("No such path exception");
        } else if (current.right != null) {
        return ((BitTreeLeaf)current.right).value;
      } // else if
    } // if
    return "";
  } // get(String)

/**
 * prints all the leaves
 * @param tree a tree
 * @param pen penwriter pen
 */
  public void print(BitTreeNode tree, PrintWriter pen){
    if (tree == null){
      return;
    } else if(tree instanceof BitTreeLeaf){
      pen.print(((BitTreeLeaf)tree).value);
    } else{
      print(tree.left, pen);
      print(tree.right, pen);
    } // if
  } // print(BitTreeNode, PenWriter)

  /**
   *  Prints out the contents of the tree in CSV format
   * @param source inputstream
   * @throws Exception for wrong length of input
   */
  public void dump(PrintWriter pen) throws Exception {
    for(int i = 0; this.sequence[i] != null; i++){
      String str = get(this.sequence[i]);
      pen.println(this.sequence[i] + "," + str);
    } // for
  } // dump(PrintWriter)

  /**
   * Reads a series of lines of the form bits,value and stores them in the tree.
   * @param source inputstream
   * @throws Exception for wrong length of input
   */
  public void load(InputStream source) throws Exception {
    Scanner scan = new Scanner(source);
    String tempBits = "";
    String tempValue = "";
    String[] line; 
    while (scan.hasNextLine() == true){
      line = scan.nextLine().split(",");
      tempBits = line[0];
      tempValue = line[1];
      set(tempBits, tempValue);
    } // while 
    scan.close();
  } // load(InputStream)
} // BitTree class