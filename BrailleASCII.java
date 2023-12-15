/**
 * 
 * Acknowledgements: Used this website: https://www.programiz.com/java-programming/inputstream to
 * find out how to manage inputstream. Also used Java documentation for Scanner for the same
 * purpose.
 */



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public class BrailleASCII {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    try{
     if (args.length != 2){
       pen.println("Please provide proper number of arguments");
       return;
      } // if
    String output = "";
    BrailleASCIITables tables; 
    switch (args[0]){
      case "braille" : 
        tables = new BrailleASCIITables();
        output = tables.toBraille(args[1]);
        pen.println(output);
        break;
      case "ascii" :
        tables = new BrailleASCIITables();
        output = tables.toASCII(args[1]);
        pen.println(output.toLowerCase());
        break;
      case "unicode" :
        tables = new BrailleASCIITables();
        output = tables.toUnicode(args[1]);
        pen.println(output);
        break;
      default : 
        pen.println("boo it doesnt work");
    } // switch 
  } catch (Exception e){
    e.printStackTrace();
  } // catch()
  } // main (String[])
} // BrailleASCII class

    // pen.println("gfdgrsh");
    // if (args[0].equals("braille")){
    //   output = tables.toBraille(args[1]);
    //   pen.print(output);
    //   } 

// PrintWriter pen = new PrintWriter (System.out, true);
// BitTree tree = new BitTree(6);
// //setting 3 random boys
// tree.set("111001", "A");
// tree.set("010110", "B");
// tree.set("010111", "C");
// //checking if they print (they do, its: BCA)
// tree.print(tree.root, pen);
// //Assigning value of get to str and printing str BCA + A(adds A)
// String str = tree.get("111001");
// pen.println(str);
// //Dumps out the latest set: 010111,C
// // tree.dump(pen);
// //loads a tree
// InputStream treeLoad = new FileInputStream("toASCII.txt");
// tree.load(treeLoad);
// // tree.dump(pen);
// //prints the latest tree (the one with many letters) plus new line
// tree.print(tree.root, pen);
// pen.println();

// //testing ascii stuff
// BrailleASCIITables tables = new BrailleASCIITables();
// pen.print(tables.toBraille('H'));
// pen.println(tables.toBraille(' '));
// pen.println(tables.toASCII("101110010111"));
// pen.println();
// pen.println(tables.toBraille("hello"));
// pen.println(tables.toUnicode("hello"));
// pen.flush();
