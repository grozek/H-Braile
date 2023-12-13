import java.io.PrintWriter;

public class BrailleASCII {
  
  public void main(String[] args){
    PrintWriter pen = new PrintWriter (System.out, true);
    BitTree tree = new BitTree(6);
    tree.set("111001", "C");
    pen.print(tree);
  }
}
