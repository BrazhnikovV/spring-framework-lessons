/**
 * Main -
 *
 * @version 1.0.0
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Main {

    public static void main( String[] args ) {
        Graph graph = new Graph( 13 );

        graph.addEdge( 0, 6 );
        graph.addEdge( 0, 1 );
        graph.addEdge( 0, 2 );
        graph.addEdge( 5, 3 );
        graph.addEdge( 5, 4 );
        graph.addEdge( 5, 0 );
        graph.addEdge( 4, 6 );
        graph.addEdge( 4, 3 );

        graph.addEdge( 7, 8 );

        graph.addEdge( 9,  10 );
        graph.addEdge( 9,  12 );
        graph.addEdge( 9,  11 );
        graph.addEdge( 11, 12 );

        DepthFirstPaths dfs = new DepthFirstPaths( graph, 0 );

        // подсчет в глубину
        System.out.println( dfs.pathTo( 5 ) );
        // System.out.println( graph.getAdjLists(5) );
    }
}
