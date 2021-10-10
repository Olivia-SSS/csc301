package RBN;
//RedBlackNode class contains the basic parameters of a RBnode 
public class RedBlackNode {
   
    //Constructor
    //key should only contain integers
    public int key;  // The data/key in the node
    public RedBlackNode p;     // the parent node
    public RedBlackNode left;     // Left child
    public RedBlackNode right;    // Right child
    public Boolean color;  // Node color: True -> Red, False -> Black


    /*
    RedBlackNode(int val) -> NA
        val: an integer that will be stored in the node as the key

    Creates a RBnode with the input as the key value. Assume the input is an integer.
    Left and right children are both init to null and defult color for a new node is red
    */
    RedBlackNode( int val )
    {
        this.key = val;
        this.left = null;
        this.right = null;
        this.color = false; // False is black, while True is red
        this.p = null;
    }

}


