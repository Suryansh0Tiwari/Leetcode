import java.util.HashMap;
import java.util.Map;

class MapSum {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int score = 0;
    }

    private Map<String, Integer> map;
    private TrieNode root;

    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) return 0;
        }
        return curr.score;
    }
}
