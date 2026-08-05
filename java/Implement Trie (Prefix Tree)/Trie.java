class Trie {
    
    // Nested helper class representing each node in the Trie
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26]; // 26 letters in the alphabet ('a' through 'z')
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    /** Initializes the trie object. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts the string word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a'; // Convert character to array index (0 to 25)
            
            // If the child node path doesn't exist, create a new one
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            // Move pointer to the child node
            current = current.children[index];
        }
        // Mark the end of the inserted word
        current.isEndOfWord = true;
    }
    
    /** Returns true if the string word is in the trie, and false otherwise. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            
            // If any character along the path is missing, the word does not exist
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // Return true only if it is marked as a full word, not just a prefix
        return current.isEndOfWord;
    }
    
    /** Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // If we successfully navigated the prefix path, at least one word matching it exists
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
