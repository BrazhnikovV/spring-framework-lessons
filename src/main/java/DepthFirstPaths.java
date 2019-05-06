import java.util.LinkedList;

/**
 * DepthFirstPaths - класс реализация алгоритма обхода графа в глубину
 *
 * @version 1.0.1
 * @package lesson7
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class DepthFirstPaths {

    /**
     * @access private
     * boolean[] marked - массив для посещенных вершин
     */
    private boolean[] marked;

    /**
     * @access private
     * int[] edgeTo - массив возврада для нахождения путей
     */
    private int[] edgeTo;

    /**
     * @access private
     * int source - вершина из которой
     */
    private int source;

    /**
     * DepthFirstPaths - конструктор
     * @param g - граф
     * @param source - вершина
     */
    public DepthFirstPaths ( Graph g, int source ) {
        this.source = source;
        this.edgeTo = new int[g.getVertexCount()];
        this.marked = new boolean[g.getVertexCount()];

        this.dfs( g, source );
    }

    /**
     * hasPathTo - узнать есть ли путь от целевой вершины
     * @param dist - вершина про которую мы хотим узнать есть ли у нее путь или нет
     * @return
     */
    public boolean hasPathTo ( int dist ) {
        return this.marked[dist];
    }

    /**
     * pathTo -
     * @param dist - вершина
     * @return LinkedList<Integer>
     */
    public LinkedList<Integer> pathTo ( int dist ) {
        if ( !this.hasPathTo( dist ) ) {
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<Integer>();

        int vertex = dist;

        while ( vertex != this.source ) {
            stack.push( vertex );
            vertex = this.edgeTo[vertex];
        }

        return stack;
    }

    /**
     * dfs - обход графа
     * @param g -
     * @param v -
     */
    private void dfs ( Graph g, int v ) {
        this.marked[v] = true;

        for ( int w : g.getAdjLists(v) ) {

            if ( !this.marked[w] ) {

                this.edgeTo[w] = v;
                this.dfs( g, w );
            }
        }
    }
}
