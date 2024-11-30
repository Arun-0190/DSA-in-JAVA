import java.util.LinkedList;

public class ConnectedCheck {

    //in this code we will see how we can check if 2 nodes are connected or not
    //function 3 and 4

    private int V;                              //for edges count
    private int E;                              //for nodes count
    private LinkedList<Integer>[] adj;          //for the adjacent list
    private boolean[] visited;                  //creating instance
    private int[] compId;
    private int count;

    //creating the constructor
    public ConnectedCheck(int nodes){

        this.V = nodes;
        this.E = 0;

        this.adj = new LinkedList[nodes];

        for(int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }

    }

    //for adding an edge
    public void addEdge(int u, int v){

        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;

    }

    //function for components
    public void dfs(){

        visited = new boolean[V];                     //for keeping track of visited nodes
        compId = new int[V];                              //for keeping track of the same component nodes
        count = 0;                                          //for keeping track of different components

        System.out.print("Counting the components:");

        for(int v = 0; v < V; v++){

            if(!visited[v]){

                // Start a new component traversal
                System.out.println("\nStarting new component: " + (count+1));

                //if not visited then calling the different function to visit every node connected and increasing the count
                dfs(v, compId, visited, count);

                count++;

            }
        }
        System.out.println("\nNumber of components: "+(count));               //gives the total number of components in graph
    }

    //the function to visit all the nodes of one component
    private void dfs(int v, int[] compId, boolean[] visited, int count){

        //mark the current node visited
        visited[v] = true;
        //assign the current component count ot the node
        compId[v] = count;

        // Print the node and its component
        System.out.println(v + " is in component: " + count);

        //running the loop for adjacent list
        for(int w : adj[v]){

            //if not visited then recurse
            if(!visited[w]){

                dfs(w, compId, visited, count);
            }
        }
    }


    //to get the count directly without the other method
    public int getCount(){
        System.out.print("The number of component is: ");
        return count;
    }

    //to know if the two nodes are connected or not
    public boolean isConnected(int a, int b){
        System.out.print("Are "+a+" and "+b+" connected: ");
        return compId[a] == compId[b];
    }


    //for printing the adjacent list via tostring
    public String toString(){

        StringBuilder sb = new StringBuilder();

        //sb.append(V+" vertices "+E+" edges."+"\n");               //can be done like this too
        sb.append(V).append(" vertices and ").append(E).append(" edges in the graph.").append("\n");

        //running the loop for adjacent list
        for (int v = 0; v<V; v++){

            sb.append(v).append(": ");

            for(int w : adj[v]){

                sb.append(w).append(" ");

            }
            sb.append("\n");

        }

        return sb.toString();

    }


    public static void main(String[] args) {

        ConnectedCheck CC = new ConnectedCheck(10);
        CC.addEdge(0,1);
        CC.addEdge(1,2);
        CC.addEdge(2,3);
        CC.addEdge(3,0);
        CC.addEdge(4,5);
        CC.addEdge(4,6);
        CC.addEdge(5,6);
        CC.addEdge(7,8);
        System.out.println(CC);
        CC.dfs();
        System.out.println(CC.getCount());
        System.out.println(CC.isConnected(0,1));

    }

}
