import java.util.Random;

import RBN.RedBlackNode;
import RBN.RedBlackTree;
import java.util.Hashtable;

public class RedBlackTreeTests {

    public Boolean checkChild(RedBlackNode node){
        return ((node.left.color == false) && (node.right.color == false));
    }
    
    public Boolean prop4helper(RedBlackNode node){
        if (node == null)
            return true;
        if (node.color == true){
            boolean rst = checkChild(node);
            if (!rst)
                return false;
        }
        
        boolean x = prop4helper(node.left);
        boolean y = prop4helper(node.right);
        return (x && y)  ; 
    }
    

    public void prop4(RedBlackTree T){
        boolean rst = prop4helper(T.root);
        if (rst)
            System.out.println ("Property 4 holds");
        else 
            System.out.println ("Property 4 does not hold");

        return;
    }
   

    public void insert_test (){
        RedBlackTree T = new RedBlackTree();
        int numNode = 10;
        Hashtable<String, RedBlackNode> nodes = new Hashtable <String, RedBlackNode>();
        for  (int i = 0; i < numNode; i++){
            Random rand = new Random();
            int ranNum = rand.nextInt(100);
            nodes.put("Node" + i, RedBlackNode.RedBlackNode(ranNum));
            T.insert(T, nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }
        print_tree1(T.root);
        
   
    }

    private RedBlackNode RedBlackNode(int ranNum) {
        return null;
    }

    public void delete_test (){
        int[] intArray = new int[]{10, 80, 92, 42, 28, 26, 73, 45, 41, 97};
        RedBlackTree T = new RedBlackTree();
        int numNode = 10;
        Hashtable<String, RedBlackNode> nodes = new Hashtable <String, RedBlackNode>();
        for  (int i = 0; i < numNode; i++){
            Random rand = new Random();
            int ranNum = rand.nextInt(100);
            nodes.put("Node" + i, RedBlackNode(ranNum));
            T.insert(T, nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }

        for (int j = 0; j < 15; j++){
            T.delete(T, T.root);
            print_tree1(T.root);
            print("");

            print("delete non-existent node");
            T.delete(nodes.get("Node3"));
            rbt.print_tree1(T.root);

        }

    }

    public void search_test(){
        int[] intArray = new int[]{10, 80, 92, 42, 28, 26, 73, 45, 41, 97};
        RedBlackTree T = new RedBlackTree();
        int numNode = intArray.length;
        Hashtable<String, RedBlackNode> nodes = new Hashtable <String, RedBlackNode>();
        for  (int i = 0; i < numNode; i++){
            Random rand = new Random();
            int ranNum = rand.nextInt(100);
            nodes.put("Node" + i, RedBlackNode(ranNum));
            T.insert(T, nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }

        System.out.println ("Tree init done");

        System.out.println(T.searchKey(T,10));
        System.out.println(T.searchKey(T,11));
        System.out.println(T.searchKey(T,45));
        System.out.println(T.searchKey(T,46));
        T.delete(T, nodes.get("Node7"));
        T.delete(T, nodes.get("Node0"));
        System.out.println(T.searchKey(T,10));
        System.out.println(T.searchKey(T,45));
    }
  
    public void prop_test (RedBlackTree T){
        //check property 2
        if (T.root.color == false)
             System.out.println("The root is black, this tree satisfies property 2");
        else 
             System.out.println("The root is not black, this tree doesn't satisfy property 2");


    }

    
   
    public static void main (String[] args){
       
    }   
}