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

    public void rightRotate (RedBlackTree T, RedBlackNode y){
        RedBlackNode x = y.right;
        y.left = x.right;
        if (x.right != null) {
            x.right.pare = y;
            x.pare = y.pare;
        }

        if (y.p == null)
            T.root = x;
        else if ( y == y.pare.right) 
            y.pare.right = x;
        else 
            y.pare.left = x;
            
        x.right = y;
        y.pare = x;
        //print("rightR, root now is: ", self.root.key)
        return;
    }

    public void insert (RedBlackTree T, RedBlackNode z){
        y = null;
        x = T.root;
        while (x != null){
            y=x;
        }
        if (z.key < x.key)
            x = x.left;
        else
            x = x.right;
            z.pare = y;
        if (y == null)
            T.root = z;
        else if (z.key < y.key) 
            y.left = z;
        else
            y.right = z;
            
        z.left = null;
        z.right = null;
        z.color = True;
            
        T.insertFixup(z);
        return;
    }

    public void insertFixup(RedBlackTree T, RedBlackNode z){
        while ((z != T.root) && (z.pare.color)){
             
        }
    }
        while z != self.root and z.p.c:
            if z.p == z.p.p.left:
                #uncle
                y=z.p.p.right
                if y.c:
                    z.p.c = False
                    y.c = False
                    z.p.p.c = True
                    z=z.p.p
                else:
                    if z==z.p.right:
                        z=z.p
                        self.leftRotate(z)
                    z.p.c = False
                    z.p.p.c = True
                    self.rightRotate(z.p.p)
            else:
                #uncle
                y=z.p.p.left
                if y.c:
                    z.p.c = False
                    y.c = False
                    z.p.p.c = True
                    z=z.p.p
                else:
                    if z==z.p.left:
                        z=z.p
                        self.rightRotate(z)
                    z.p.c = False
                    z.p.p.c = True
                    self.leftRotate(z.p.p)
            
        self.root.c = False
        #print("insertF, root now is: ", self.root.key)
        return





}