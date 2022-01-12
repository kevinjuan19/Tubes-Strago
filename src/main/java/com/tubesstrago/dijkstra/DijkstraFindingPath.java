package com.tubesstrago.dijkstra;

import com.tubesstrago.entity.DijkstraAttr;

public class DijkstraFindingPath {
    private DijkstraAttr attr=new DijkstraAttr();

    public DijkstraFindingPath() {
    }

    public DijkstraAttr getAttr() {
        return attr;
    }

    private static final int NO_PARENT = -1;

    public void dijkstra(int[][] adjacencyMatrix, int startVertex,int destination)
    {
        int nVertices = adjacencyMatrix[0].length;

        int[] shortestDistances = new int[nVertices];

        boolean[] added = new boolean[nVertices];

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;

        int[] parents = new int[nVertices];


        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < nVertices; i++)
        {

            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;

                }
            }
        }

        setAttr(startVertex, shortestDistances, parents,destination);
    }

    private void setAttr(int startVertex, int[] distances, int[] parents,int endPoint)
    {
        int[] path=new int[distances.length];
        attr.setStartPoint(startVertex);
        attr.setDestination(endPoint);
        attr.setDistance(distances[endPoint]);
        findPath(endPoint, parents,path,0);

    }
    private void findPath(int currentVertex, int[] parents,int[] path,int idx){
        if (currentVertex == NO_PARENT)
        {
            attr.setPath(path);
            return;
        }
        path[idx]=currentVertex;
        findPath(parents[currentVertex], parents,path,idx+1);
    }
}
