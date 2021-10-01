public class RedBlackTree{
    
    public RedBlackTree ( ) {
       this.root = null; 
    }

    public void leftRotate (RedBlackTree T, RedBlackNode x){
        RedBlackNode y = x.right;
        x.right=y.left;
        if (y.left != null) {
            y.left.pare = x;
            y.pare = x.pare;
        }

        if (x.p == null)
            T.root = y;
        else if (x == x.pare.left) 
            x.pare.left = y;
        else 
            x.pare.right=y;
            
        y.left = x;
        x.pare = y;
        // print("leftR, root now is: ", self.root.key)
        return;
    }

    




}