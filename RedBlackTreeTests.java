import java.util.Random;

public class RedBlackTreeTests {

    public void insert_test (){
        RedBlackTree T = new RedBlackTree();
        int numNode = 10;
        Hashtable<String, RedBlackNode> nodes = new Hashtable <String, RedBlackNode>();
        for  (int i = 0; i < numNode; i++){
            Random rand = new Random();
            int ranNum = rand.nextInt(100);
            nodes.put("Node" + i, RedBlackNode(ranNum));
            T.insert(nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }
        print_tree1(T.root);
        
   
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
            T.insert(nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }

        for (int j = 0; j < 15; j++){
            T.delete(T.root);
            print_tree1(T.root);
            print("");

            print("delete non-existent node");
            T.delete(nodes["Node3"]);
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
            T.insert(nodes.get("Node" + i));
            System.out.println((i+1) + " elements added, value =" + ranNum);
        }

        System.out.println(print("Tree init done"));

        System.out.println(T.searchKey(10));
        System.out.println(T.searchKey(11));
        System.out.println(T.searchKey(45));
        System.out.println(T.searchKey(46));
        T.delete(nodes["Node7"]);
        T.delete(nodes["Node0"]);
        System.out.println(T.searchKey(10));
        System.out.println(T.searchKey(45));
    }
  
    public void prop_test (RedBlackTree T){
        //check property 2
        if (T.root.color == false)
             System.out.println("The root is black, this tree satisfies property 2");
        else 
             System.out.println("The root is not black, this tree doesn't satisfy property 2");

        //check property 4

    }

    
   
    public static void main (String[] args){
       
    }   
}