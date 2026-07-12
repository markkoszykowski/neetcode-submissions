/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node clone(final Node node, final AtomicBoolean neww, final Map<Node, Node> dejaVu) {
        if (node == null) {
            return null;
        }
        neww.set(false);
        final Node clone = dejaVu.computeIfAbsent(node, k -> {
            neww.set(true);
            return new Node(k.val, new ArrayList<>(k.neighbors.size()));
        });
        if (!neww.get()) {
            return clone;
        }
        for (final Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor, neww, dejaVu));
        }
        return clone;
    }

    public Node cloneGraph(final Node node) {
        return clone(node, new AtomicBoolean(), new HashMap<>());
    }
}