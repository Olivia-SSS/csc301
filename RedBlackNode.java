public class RedBlackNode {
   
    //Constructor
    //key should only contain integers
    int key;  // The data/key in the node
    RedBlackNode left;     // Left child
    RedBlackNode right;    // Right child
    Boolean color;  // Node color: True -> Red, False -> Black


    /*
    RedBlackNode(int val) -> NA
        val: an integer that will be stored in the node as the key
    This procedure creates a RBnode with the input as the key value. Assume the input is an integer.
    Left and right children are both init to null and defult color for a new node is red
    */
    RedBlackNode( int val )
    {
        key = val;
        left = right = null;
        color = False; // False is black, while True is red
    }

}


