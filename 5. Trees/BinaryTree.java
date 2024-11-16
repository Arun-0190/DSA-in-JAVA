import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

@SuppressWarnings("ClassEscapesDefinedScope")                   //for just the suppression of defined scope of tree node
public class BinaryTree {

    private TreeNode root;

    private static class TreeNode{

        private final int data;               //generic type - it can store any data type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){

            this.data = data;

        }

    }

    //creating the tree can be done in main function too, we'll do it later
    public void createtree(){

        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(69);
        TreeNode seventh = new TreeNode(79);

        root = first;           //root-->first
        first.left = second;
        first.right = third;
        second.right = fourth;
        third.left = fifth;
        third.right = sixth;
        second.left = seventh;

    }


    //pre-order recursive tree traversal of BT
    public void preOrderR(TreeNode root){

        if(root == null){
            return;     //no tree
        }
        System.out.print(root.data + "  ");
        preOrderR(root.left);
        preOrderR(root.right);

    }


    //pre-order iterative tree traversal of BT
    public void preOrderI(TreeNode root){

        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode temp = stack.pop();
            System.out.print(temp.data + "  ");

            //push the right first so it goes down
            if(temp.right != null) {
                stack.push(temp.right);
            }
            //push left after so it stays at top
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }


    //in-order BT traversing - traverses left node first then the parent node and then right node
    public void inOrder(TreeNode root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);                    //recurses the 3 lines
    }

    //in-order BT iterative traversing
    public void inOrderI(TreeNode root){

        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;

        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;               //pushes the left
            }
            else{
                temp = stack.pop();
                System.out.print(temp.data + "  ");
                temp = temp.right;
            }
        }
    }


    //Post Order recursive Tree traversal in binary tree - traverses left node then right node and then the root node
    public void postOrderR(TreeNode root){

        //base case(to exit the recursive loop
        if(root == null){
            return;
        }

        //calls the left subtree
        postOrderR(root.left);
        //calls the right subtree
        postOrderR(root.right);
        //print the root node at the point
        System.out.print(root.data+"  ");

    }


    //Post Order iterative
    public void postOrderI(TreeNode root){

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        //running the loop if stack is not empty and current is not null
        while(current != null || !stack.isEmpty()) {
            //if current is not null
            if (current != null) {

                stack.push(current);
                current = current.left;
            }
            else{

                //assigning a temp to right
                TreeNode temp = stack.peek().right;
                if(temp == null){//checks if right element is null or not

                    //assigning temp to the top element in the stack i.e. the last left element pushed
                    temp = stack.pop();
                    System.out.print(temp.data + "  ");

                    //if all the node left and right are visited then
                    while(!stack.isEmpty() && temp == stack.peek().right){

                        temp = stack.pop();
                        System.out.print(temp.data+"  ");

                    }

                }
                else{
                    //assigning current to temp if it's not null so that it can be pushed in the next iteration
                    current = temp;

                }

            }

        }

    }


    //Level Order traversal - kind of like bfs level by level
    public void levelOrder(TreeNode root){

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //traversing till the queue gets empty
        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();
            System.out.print(temp.data+"  ");

            //traverses to left firstly
            if(temp.left != null){
                queue.offer(temp.left);
            }
            //traverses to right
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }


    //finding the max value
    public int FindMax(TreeNode root){

        if(root == null){

            return Integer.MIN_VALUE;               //base case

        }
        int result = root.data;
        //recursing the left subtree
        int left = FindMax(root.left);
        //recursing the right subtree
        int right = FindMax(root.right);

        //conditioning
        if(left>result){
            result = left;
        }
        if(right>result){
            result = right;
        }

        return result;

    }


    //finding the min value
    public int FindMin(TreeNode root){

        if(root == null){

            return Integer.MAX_VALUE;               //base case

        }
        int result = root.data;
        //recursing the left subtree
        int left = FindMin(root.left);
        //recursing the right subtree
        int right = FindMin(root.right);

        //conditioning
        if(left<result){
            result = left;
        }
        if(right<result){
            result = right;
        }

        return result;

    }


    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.createtree();
        bt.preOrderR(bt.root);
        System.out.println();
        bt.preOrderI(bt.root);
        System.out.println();
        bt.inOrder(bt.root);
        System.out.println();
        bt.inOrderI(bt.root);
        System.out.println();
        bt.postOrderR(bt.root);
        System.out.println();
        bt.postOrderI(bt.root);
        System.out.println();
        bt.levelOrder(bt.root);
        System.out.println();
        System.out.println("Max value of the Binary Tree is: "+bt.FindMax(bt.root));
        System.out.println("Min value of the Binary Tree is: "+bt.FindMin(bt.root));

    }

}
