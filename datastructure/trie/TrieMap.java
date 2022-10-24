package datastructure.trie;

public class TrieMap<V> {

    private static final int R = 256;
    private int size = 0;

    private static class TrieNode<V> {
        V val;
        TrieNode<V>[] children = new TrieNode[R];
    }

    private TrieNode<V> root;

    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> curNode = node;
        for (int i = 0; i < key.length(); i++) {
            if (curNode == null) {
                return null;
            }
            char c = key.charAt(i);
            curNode = curNode.children[c];
        }

        return curNode;
    }

    public V get(String key) {
        TrieNode<V> node = this.getNode(root, key);
        if (node == null || node.val == null) {
            return null;
        }
        return node.val;
    }

    public boolean containsKey(String key) {
        return this.get(key) != null;
    }

    public boolean hasKeyWithPrefix(String prefix) {
        return this.getNode(root, prefix) != null;
    }

    public int size() {
        return this.size;
    }
}
