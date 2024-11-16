public class BinarySearchTree {

    private TreeNode root;

    public static class TreeNode{
        private final int data;               //generic data type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }


    //insertion

    //provides the root if it's already not given and then proceeds further
    public void insert(int value){

        root = insert(root,value);

    }

    //inserts if the root is also given accordingly
    public TreeNode insert(TreeNode root, int value){

        if(root == null){
            root = new TreeNode(value);
            return root;
        }

        if(value < root.data){
            root.left = insert(root.left, value);
        }

        else{
            root.right = insert(root.right, value);
        }

        return root;

    }


    //printing in ascending order using inorder traversing
    public void inOrder(TreeNode root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);                    //recurses the 3 lines

    }


    //Searching a key using recursion
    public TreeNode search(TreeNode root, int key){

        //condition to return after finding or null
        if(root == null || root.data == key){                   //base case
            return root;
        }

        //otherwise moving according to it's direction
        if(root.data < key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }


    //If a tree is BST or not
    public boolean isValid(TreeNode root, long min, long max){

        if(root == null){
            return true;                //base case at the end of tree
        }

        //checking the boundary condition
        if(root.data <= min || root.data >= max){
            return false;
        }

        //recursing same through the left subtree while changing the max value
        boolean left = isValid(root.left, min, root.data);
        if(left){
            //can be done like this
            // boolean right  = isValid(root.right, root.data, max);
            //or
            return isValid(root.right, root.data, max);
        }
        return false;                   //default if not a BST
    }

    public static void main(String[] args) {

        BinarySearchTree BST = new BinarySearchTree();

        //inserting the values
        BST.root = new TreeNode(50);                //can also be done
        //BST.insert(50);                                //same thing but this will need a function that is made above with only integer as an argument
        BST.insert(BST.root, 40);
        BST.insert(BST.root, 60);
        BST.insert(BST.root, 30);
        BST.insert(BST.root, 70);
        BST.insert(BST.root, 20);
        BST.insert(BST.root, 80);

        BST.inOrder(BST.root);

        System.out.println();

        if(null != BST.search(BST.root, 80)){
            System.out.println("Key found!!");
        }
        else{
            System.out.println("Key not found!!");
        }
        if(BST.isValid(BST.root, Long.MIN_VALUE, Long.MAX_VALUE)){
            System.out.println(("It is a Binary Search Tree."));
        }else{
            System.out.println("It is not a Binary Search Tree.");
        }

    }

}

