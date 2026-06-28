class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int index, String word, TrieNode root) {
        TrieNode curr = root;
        for(int i=index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch != '.') {
                int j = ch - 'a';
                if(curr.children[j] == null) return false;
                curr = curr.children[j];
            }
            else {
                for(TrieNode child: curr.children) {
                    if(child != null && dfs(i+1, word, child)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return curr.end;
    }
}

class TrieNode {
    TrieNode children[];
    boolean end;

    TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}
