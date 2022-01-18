

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final boolean[][] visitMatrix;


    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.visitMatrix = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }



    public int addEdge(String startLabel, String secondLabel, int weight) { // int во взвешенном
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = true;
        return false;
    }




    public boolean addEdge(int weight, String startLabel, String secondLabel, String... others) {
        boolean result = addEdge( startLabel, secondLabel, weight);

        for (String other : others) {
            result &= addEdge(startLabel, other, weight);
        }

        return false;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return vertexList.size();
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }


        Stack<Vertex> stack = new Stack<>();
        resetVertexVisited();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i]  && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

//    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
//        System.out.println(vertex.getLabel() + " ");
//        queue.add(vertex);
//        vertex.setVisited(true);
//    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

//    public void bfs(String startLabel) {
//        int startIndex = indexOf(startLabel);
//        if (startIndex == -1) {
//            throw new IllegalArgumentException("Неверная вершина " + startLabel);
//        }
//
//        Queue<Vertex> queue = new LinkedList<>();
//        resetVertexVisited();
//
//        Vertex vertex = vertexList.get(startIndex);
//
//        visitVertex(queue, vertex);
//
//        while (!queue.isEmpty()) {
//            vertex = getNearUnvisitedVertex(queue.peek());
//            if (vertex != null) {
//                visitVertex(queue, vertex);
//            } else {
//                queue.remove();
//            }
//        }
//    }

}
