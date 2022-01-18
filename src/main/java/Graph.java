public interface Graph {

    void addVertex(String label);

//    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel, int weight);

    int getSize();

    void display();

    void dfs(String startLabel); //depth-first search - обход в глубину

//    void bfs(String startLabel); //breadth-first search - обход в ширину



}
