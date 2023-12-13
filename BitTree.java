import java.io.InputStream;
import java.io.PrintWriter;
import org.w3c.dom.Node;

public class BitTree{

BitTreeNode root;
int n;

  public BitTree(int n){
    if (n > 0) {
      this.n = n;
      this.root = new BitTreeNode();
      }
    }

  public void set(String bits, String value){
    for(int i=0; i <= n; i++){
      if (bits.charAt(i) == '0'){
        this.root.left = (Node) new BitTreeNode();
     }
      else if (bits.charAt(i) == '1'){
        this.root.left = (Node) new BitTreeNode();
     }
    }
  
}
  public String get(String bits){

    return bits;
  }

  public void dump(PrintWriter pen){
    
  }
  public void load(InputStream source){
    
  }
}
