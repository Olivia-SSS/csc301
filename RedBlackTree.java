import javax.lang.model.util.ElementScanner6;

//RedBlackTree class contains the procedures to create a RedBlackTree, add nodes into the tree, and delete nodes from the tree
//  also contains the helper procedures of above functions
public class RedBlackTree{
    
    /*
    RedBlackTree() -> NA
        no parameter
    Create a RedBlackTree object with a null root
    */
    RedBlackNode root;
    public RedBlackTree ( ) {
       this.root = null; 
    }

    /*
    leftRotate(RBTree T, RBnode x) -> NA
        T: RBTree object specifying the tree function is modefiying
        x: RBNode object specifying the location of left rotate

    Moves node x down to the left. 
    Details: x.right become x.p while x.right.left become x.right
    */
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

    /*
    rightRotate(RBTree T, RBnode y) -> NA
        T: RBTree object specifying the tree function is modefiying
        y: RBNode object specifying the location of right rotate

    Moves node y down to the right. 
    Details: y.left become y.p while y.left.right become y.left
    */
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

    /*
    insert(RBTree T, RBNode z) -> NA
        T: RBTree object specifying the tree which is modefiying
        z: RBNode object which will be inserted into the tree

    Inserts a node into the red black tree according to BST rules. 
    Inserted node is automaticly set to red according to RBT rules.
    */
    public void insert (RedBlackTree T, RedBlackNode z){
        RedBlackNode y = null;
        RedBlackNode x = T.root;
        while (x != null){
            y = x;
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
        z.color = true;
            
        T.insertFixup(z);
        return;
    }

    /*
    insertFixup(RBTree T, RBNode z) -> NA
        T: RBTree object specifying the tree which is modefiying
        z: RBNode object which will be inserted into the tree

    Helper function of insert(). fix the (unbalanced) RBTree from node z up to the root.
    */
    public void insertFixup(RedBlackTree T, RedBlackNode z){
        while ((z != T.root) && (z.p.color)){
            if (z.p == z.p.p.left)
            {   //uncle
                y=z.p.p.right;
                if (y.color){
                    z.p.color = false;
                    y.color = false;
                    z.p.p.color = true;
                    z = z.p.p;
                }
                else {
                    if (z == z.p.right){
                        z = z.p;
                        T.leftRotate(z);
                    }
                    z.p.color = false;
                    z.p.p.color = true;
                    T.rightRotate(z.p.p);
                }
            }

            else{
                //uncle
                y=z.p.p.left;
                if (y.color)
                {
                    z.p.color = false;
                    y.color = false;
                    z.p.p.color = true;
                    z=z.p.p;
                }
                else{
                    if (z == z.p.left){
                        z = z.p;
                        T.rightRotate(z);
                    }
                z.p.color = false;
                z.p.p.color = true;
                T.leftRotate(z.p.p);
                }
                    
            }
            T.root.color = false;
            //print("insertF, root now is: ", self.root.key);
            return;
        }
    }

    /*
    transplant (RedBlackTree T, RedBlackNode u, RedBlackNode v) -> NA
        T: RBTree object specifying the tree which is modefiying
        u: RBNode object which is the original node
        v: RBNode object which would be the node being transplanted to u's position
    
    Transplants node v and all its children to u's position in RBTree T. In other words, replace u with v. 
    */
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
        
    /*
    treeMinimum (RedBlakcTree T, RedBlackNode x) -> RedBlackNode x
        T: RBTree object specifying the tree function is modefiying
        x: RBNode object specifying the location of the start of minimization

    Minimize the node x in tree T by refering x.left to x untill x.left is a NIL node. 
    Returns the finilized node x. 
    */
    public RedBlackNode treeMinimum (RedBlakcTree T, RedBlackNode x){
        if (x == null)
           return x;
        while (x.left != null){
            x = x.left;
        }
        return x;
    }
   
    /*
    delete (RedBlakcTree T, RedBlackNode z) -> NA
        T: RBTree object specifying the tree function is modefiying
        z: RBNode object specifying the node that is going to be deleted

    Delets a node from the red black tree according to BST rules. 
    search the node first, if not find that terminates. if it exists, delete it. 
    */
    public void delete (RedBlakcTree T, RedBlackNode z){

        //check if the node is null or does not exist first. if so, break
        if (z == null)
           return;
        if (T.searchKey (z.key) == false)
           return;
        RedBlackNode y = z;
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

    /*
    deleteFixup (RedBlackTree T, RedBlackNode x) -> NA
        T: RBTree object specifying the tree which is modefiying
        x: RBNode object which will be deleted from the tree

    Helper function of delete(). fix the (unbalanced) RBTree from node x up to the root.
    */
    public void deleteFixup (RedBlackTree T, RedBlackNode x){
        //print("inside deletefixup", type(x));
        while ((x != T.root) && (! x.color)){
            if (x == x.p.left){
                //print("1st branch");
                RedBlackNode w = x.p.right;
                if (w.color){
                    w.color = false;
                    x.p.color = true;
                    T.leftRotate(x.p);
                    w = x.p.right;
                }
                if ((! w.left.color) && (! w.right.color)){
                    w.color = true;
                    x = x.p;
                }
                    
                else{
                    if (! w.right.color){
                        w.left.color = false;
                        w.color = true;
                        T.rightRotate(w);
                        w = x.p.right;
                    }
                    w.color = x.p.color;
                    x.p.color = false;
                    w.right.color = false;
                    T.leftRotate(x.p);
                    x = T.root;
                }
                    
            }

            else{
                //print("2nd branch");
                RedBlackNode w = x.p.left;
                if (w.color){
                    w.color = false;
                    x.p.color = true;
                    T.rightRotate(x.p);
                    w = x.p.left;
                }
                if ((! w.right.c) && (! w.left.c)){
                    w.color = true;
                    x = x.p;
                }
                else{
                    if (! w.left.color){
                        w.right.color = false;
                        w.c = true;
                        self.leftRotate(w);
                        w = x.p.left;
                    }
                   
                    w.color = x.p.color;
                    x.p.color = false;
                    w.left.c = false;
                    T.rightRotate(x.p);
                    x = T.root;
                }
            }
                
             
        }
        x.color = false;
        return;
    }

    /*
    searchKeyHelper (RedBlackTree T, int key, RedBlackNode current) -> False/RBNode
        T: RBTree object specifying the tree which is modefiying
        key: the key value that you want to search
        current: the node you want to look at first with all its children
    
    This is a helper function for searchKey. It uses recursion, and the base cases are either
    current node is null, means this key value does not exist and false would be returned, or 
    current.key == key, which means we have the node. In this case the node is then returned. 
    */
    public RedBlackNode searchKeyHelper (RedBlackTree T, int key, RedBlackNode current){
        if (current == null)
            return false;
        if (current.key == key)
            return current;
        else if (current.key > key)
            return self.searchKeyHelper(key, current.left);
        else    
           return self.searchKeyHelper(key,current.right);      
    }

    /*
    searchKey (RedBlackTree T, int key) -> Boolean
        T: RBTree object specifying the tree which is modefiying
        key: the key value that you want to search
    
    This is the main function that could search if a key is in the tree T and returns the boolean value. 
    It passes the parameters into the helper function for the main part. 
    */
    public Boolean searchKey (RedBlackTree T, int key){
        RedBlackNode current = T.root;
        RedBlackNode temp = T.searchKeyHelper(key, current);
        if (temp == false)
            return temp;
        else       
            return true;
    }

    public void deleteKey(RedBlackTree T, int key){
        RedBlackNode current = T.root;
        RedBlackNode temp = T.searchKeyHelper(key, current);
        if (temp == false){
            
        }
        else       
            T.delete(temp);

        return;
    }

    public void print_tree1 (RedBlackNode node){
        print_tree1_helper(node, 0);
    }

    public void print_tree1_helper (RedBlackNode node, int level){
        if (node.key != "NIL") {
            print_tree1(node.left, level+1);
            for (int i = 0 ; i < 4 * level; i++){
                System.out.println ("-");
            }
            System.out.println ( "> " +
                str(node.key) + ' ');
            if (node.color == true)
                System.out.println ("r");
            else 
                System.out.println ("b");
            
        print_tree1_helper(node.right, level + 1);
        }

        else {
             for (int i = 0 ; i < 4 * level+1; i++){
                System.out.println ("-");
            }
            System.out.println ("> " + str(node.key) + " ");
            if (node.color == true)
            System.out.println ("r");
            else 
            System.out.println ("b");
        }
        
    }



}