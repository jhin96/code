package leetcode100;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot208_实现Trie_前缀树 {

    /**
     * 字典树，通过26子树（数组与指针）的形式查询
     */
    public hot208_实现Trie_前缀树[] child;

    /**
     * 表示是不是单词的结尾
     */
    public boolean end;

    /**
     * 26代表child最多个数
     *
     */
    public hot208_实现Trie_前缀树() {
        this.child = new hot208_实现Trie_前缀树[26];
        this.end = false;
    }

    /**
     * 相当于每一层从0 - 15代表了a - z
     * 第一层只有一个，字符从第二层开始存储
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        hot208_实现Trie_前缀树 node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new hot208_实现Trie_前缀树();
            }
            node = node.child[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return searchIndex(word) != null && searchIndex(word).end;
    }

    public boolean startsWith(String prefix) {
        return searchIndex(prefix) != null;
    }

    /**
     * 查询单词
     *
     * @return
     */
    public hot208_实现Trie_前缀树 searchIndex(String word) {
        hot208_实现Trie_前缀树 node = this;
        if (word == null || word.isEmpty()) {
            return node;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                return null;
            }
            node = node.child[c - 'a'];
        }
        return node;
    }

}
