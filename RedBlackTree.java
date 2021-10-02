public class RedBlackTree{
    RedBlackNode root;
    public RedBlackTree ( ) {
       this.root = null; 
    }

    public void leftRotate (RedBlackTree T, RedBlackNode x){
        RedBlackNode y = x.right;
        x.right=y.left;
        if (y.left != null) {
            y.left.p = x;
            y.p = x.p;
        }

        if (x.p == null)
            T.root = y;
        else if (x == x.p.left) 
            x.p.left = y;
        else 
            x.p.right=y;
            
        y.left = x;
        x.p = y;
        // print("leftR, root now is: ", self.root.key)
        return;
    }

    public void rightRotate (RedBlackTree T, RedBlackNode y){
        RedBlackNode x = y.right;
        y.left = x.right;
        if (x.right != null) {
            x.right.p = y;
            x.p = y.p;
        }

        if (y.p == null)
            T.root = x;
        else if ( y == y.p.right) 
            y.p.right = x;
        else 
            y.p.left = x;
            
        x.right = y;
        y.p = x;
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
            z.p = y;
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
        while ((z != T.root) && (z.p.color)){
            if (z.p == z.p.p.left)
            {   //uncle
                y=z.p.p.right;
                if (y.color){
                    z.p.color = False;
                    y.color = False;
                    z.p.p.color = True;
                    z = z.p.p;
                }
                else {
                    if (z == z.p.right){
                        z = z.p;
                        T.leftRotate(z);
                    }
                    z.p.color = False;
                    z.p.p.color = True;
                    T.rightRotate(z.p.p);
                }
            }

            else{
                //uncle
                y=z.p.p.left;
                if (y.color)
                {
                    z.p.color = False;
                    y.color = False;
                    z.p.p.color = True;
                    z=z.p.p;
                }
                else{
                    if (z == z.p.left){
                        z = z.p;
                        T.rightRotate(z);
                    }
                z.p.color = False;
                z.p.p.color = True;
                T.leftRotate(z.p.p);
                }
                    
            }
            T.root.color = False;
            //print("insertF, root now is: ", self.root.key);
            return;
        }
    }

    public void transplant (RedBlackTree T, RedBlackNode u, RedBlackNode v){
        if (u.p == self.nil)
            self.root = v;
        else if (u == u.p.left)
            u.p.left = v;
        else
            u.p.right = v;
        v.p = u.p;
        return;
    }
        

    public RedBlackNode treeMinimum (RedBlakcTree T, RedBlackNode x){
        if (x == null)
           return x;
        while (x.left != null){
            x = x.left;
        }
        return x;
    }
   

    public void delete (RedBlakcTree T, RedBlackNode z){
        if (z == null)
           return;
        if (T.searchKey (z.key) == False)
           return;
        y = z;
        Boolean yoc = y.color;
        if (z.left == null){
            x = z.right;
            T.transplant(z, z.right);
        }
        else if (z.right == null){
            x = z.left;
            T.transplant (z, z.left);
        }
        else{
            y = T.treeMinimum (z.right);
            yoc = y.color;
            x = y.right;
            if (y.p == z)
               x.p = y;
            else{
                self.transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            T.transplant(z,y);
            y.left = z.left;
            y.left.p = y;
            y.color = z.color;
        }

        if (!yoc){
            //print("x type", type(x), "x.c", x.c);
            T.deleteFixup(x);
            //print("delete&fixup done");
        }
        //print("one node removed, value =", y.key);
        return;
    }


    public void deleteFixup (RedBlackTree T, RedBlackNode x){
        //print("inside deletefixup", type(x));
        while ((x != T.root) && (! x.color)){
            if (x == x.p.left){
                //print("1st branch");
                RedBlackNode w = x.p.right;
                if (w.color){
                    w.color = False;
                    x.p.color = True;
                    T.leftRotate(x.p);
                    w = x.p.right;
                }
                if ((! w.left.color) && (! w.right.color)){
                    w.color = True;
                    x = x.p;
                }
                    
                else{
                    if (! w.right.color){
                        w.left.color = False;
                        w.color = True;
                        T.rightRotate(w);
                        w = x.p.right;
                    }
                    w.color = x.p.color;
                    x.p.color = False;
                    w.right.color = False;
                    T.leftRotate(x.p);
                    x = T.root;
                }
                    
            }

            else{
                //print("2nd branch");
                RedBlackNode w = x.p.left;
                if (w.color){
                    w.color = False;
                    x.p.color = True;
                    T.rightRotate(x.p);
                    w = x.p.left;
                }
                if ((! w.right.c) && (! w.left.c)){
                    w.color = True;
                    x = x.p;
                }
                else{
                    if (! w.left.color){
                        w.right.color = False;
                        w.c = True;
                        self.leftRotate(w);
                        w = x.p.left;
                    }
                   
                    w.color = x.p.color;
                    x.p.color = False;
                    w.left.c = False;
                    T.rightRotate(x.p);
                    x = T.root;
                }
            }
                
             
        }
        x.color = False;
        return;
    }

    





}