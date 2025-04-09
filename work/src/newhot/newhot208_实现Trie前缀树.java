package newhot;

public class newhot208_实现Trie前缀树 {

    public newhot208_实现Trie前缀树[] child;

    public boolean end;

    public newhot208_实现Trie前缀树() {
        this.child = new newhot208_实现Trie前缀树[26];
        end = false;
    }

    public void insert(String word) {
        // this相当于一个公共的头节点
        newhot208_实现Trie前缀树 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new newhot208_实现Trie前缀树();
            }
            node = node.child[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        newhot208_实现Trie前缀树 res = searchWord(word);
        return res != null && res.end;
    }

    public boolean startsWith(String prefix) {
        return searchWord(prefix) != null;
    }

    public newhot208_实现Trie前缀树 searchWord(String prefix) {
        newhot208_实现Trie前缀树 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.child[c - 'a'] == null) {
                return null;
            }
            node = node.child[c - 'a'];
        }
        return node;
    }

}