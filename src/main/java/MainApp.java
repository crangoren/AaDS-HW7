

public class MainApp {
    public static void main(String[] args) {
//        testGraph();
//        System.out.println("\n");
//        testDfs();
//        System.out.println("\n");
//        testBfs();
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 17);
        graph.addEdge("Москва", "Рязань", 20);
        graph.addEdge("Москва", "Калуга", 20);
        graph.addEdge("Тула", "Липецк", 29);
        graph.addEdge("Рязань", "Тамбов", 29);
        graph.addEdge("Рязань",  "Курск", 54);
        graph.addEdge("Калуга", "Орел", 21);
        graph.addEdge("Калуга",  "Саратов", 86);
        graph.addEdge("Липецк", "Воронеж", 14);
        graph.addEdge("Тамбов", "Саратов", 38);
        graph.addEdge("Орел", "Курск", 16);
        graph.addEdge("Саратов", "Воронеж", 51);
        graph.addEdge("Курск", "Воронеж", 23);

        graph.dfs("Москва");
        graph.display();

    }

//    private static void testBfs() {
//        Graph graph = new GraphImpl(8);
//
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//        graph.addVertex("H");
//
//        graph.addEdge("A", "B", "C", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("E", "H");
//        graph.addEdge("C", "F");
//        graph.addEdge("D", "G");
//
//        graph.bfs("A");
//
//    }

//    private static void testDfs() {
//        Graph graph = new GraphImpl(7);
//
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//
//        graph.addEdge("A", "B", "C", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("D", "F");
//        graph.addEdge("F", "G");
//
//        graph.dfs("A");
//    }

//    public static void testGraph() {
//
//        Graph graph = new GraphImpl(7);
//
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//
//        graph.addEdge("A", "B", "C");
//        graph.addEdge("B", "C", "D");
//        graph.addEdge("C", "A", "B", "D");
//        graph.addEdge("D", "B", "C");
//
//        System.out.println("Size of graph is " + graph.getSize());
//        graph.display();
//
//    }
}
