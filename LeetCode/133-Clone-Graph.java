/*
// Definition for a Node. (Already provided)
public class Node { ... }
*/

public class Solution {
    private Dictionary<Node, Node> visited = new Dictionary<Node, Node>();
    private Node DFS(Node node) {
        if (visited.ContainsKey(node)) {
            return visited[node];
        }

        Node clone = new Node(node.val);

        visited.Add(node, clone);

        foreach (Node neighbor in node.neighbors) {
            Node clonedNeighbor = DFS(neighbor);
            
            clone.neighbors.Add(clonedNeighbor);
        }

        return clone;
    }

    public Node CloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return DFS(node);
    }
}