/**
 * Gabriela Roznawska 
 * CSC207 
 * 12/15/2023
 *
 * This file contains a little class of BitTreeLea(s) that
 * the whole tree is based on.
 * 
 * Acknowledgements: CSC207 instructions for the MP8
 */

public class BitTreeLeaf extends BitTreeNode {

  String value;

  public BitTreeLeaf() {
    this.value = "";
  } // BitTreeLeaf()

  public BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf(String)
} // BitTreeLeaf class
