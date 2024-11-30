import java.util.LinkedList;

public class ConnectedComponents {

    //in this code we will see how we can find the number components of the graph

    private int V;                              //for edges count
    private int E;                              //for nodes count
    private LinkedList<Integer>[] adj;          //for the adjacent list

    //creating the constructor
    public ConnectedComponents(int nodes){

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

        boolean[] visited = new boolean[V];                     //for keeping track of visited nodes
        int[] compId = new int[V];                              //for keeping track of the same component nodes
        int count = 0;                                          //for keeping track of different components

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

        ConnectedComponents CCg = new ConnectedComponents(10);
        CCg.addEdge(0,1);
        CCg.addEdge(1,2);
        CCg.addEdge(2,3);
        CCg.addEdge(3,0);
        CCg.addEdge(4,5);
        CCg.addEdge(4,6);
        CCg.addEdge(5,6);
        CCg.addEdge(7,8);
        System.out.println(CCg);
        CCg.dfs();
    }

}
