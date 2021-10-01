public class RedBlackNode {
   
    //Constructor
    //key should only contain integers
    int key;  // The data in the node
    RedBlackNode left;     // Left child
    RedBlackNode right;    // Right child
    Boolean color; 
    RedBlackNode( int val )
    {
        key = val;
        left = right = null;
        color = False; // False is black, while True is red
    }

}


